/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.fluigi.model;

import java.util.*;

import org.cidarlab.fluigi.layout.Point;
import org.cidarlab.fluigi.netlist.json.JSONKeyWords;
import org.cidarlab.fluigi.netlist.technology.TechEntity;
import org.json.simple.JSONObject;

/**
 *
 * @author krishna
 */
public class Component {

    private String id;
    private String technology;
    private HashMap<String, Object> params;
    private int x,y,w,h;
    private TechEntity.TechEntityType type;
    private float rotation;

    private HashMap<String, Terminal> terminalsHashMap;

    public Component(String id) {
        params = new HashMap<>();
        terminalsHashMap = new HashMap<>();
        this.id = id;
    }

    public void importFromJSON(JSONObject jsoncomponent) {
        this.setTechnology((String) jsoncomponent.get(JSONKeyWords.TECHNOLOGY));
        JSONObject paramsoObject = (JSONObject) jsoncomponent.get(JSONKeyWords.PARAMETERS);
        for(Object key : paramsoObject.keySet()){
            Object value  = jsoncomponent.get(key);
            getParams().put((String)key, (String)value);
        }
    }



    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the technology
     */
    public String getTechnology() {
        return technology;
    }

    /**
     * @param technology the technology to set
     */
    public void setTechnology(String technology) {
        this.technology = technology;
    }

    /**
     * @return the params
     */
    public HashMap<String, Object> getParams() {
        return params;
    }

    /**
     * @param params the params to set
     */
    public void setParams(HashMap<String, Object> params) {
        this.params = params;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the w
     */
    public int getXSpan() {
        return w;
    }

    /**
     * @param w the w to set
     */
    public void setXSpan(int w) {
        this.w = w;
    }

    /**
     * @return the h
     */
    public int getYSpan() {
        return h;
    }

    /**
     * @param h the h to set
     */
    public void setYSpan(int h) {
        this.h = h;
    }

    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Component)) {
            return false;
        }
        return this.id.equals(((Component) o).getId());
    }

    public void addParam(String key, String o) {
        params.put(key, o);
    }


    //WARNING ! All these methods should return the terminals ordered clockwise
    private List<Terminal> clockwiselist, topedgelist, leftedgelist, rightedgelist, bottomedgelist;

    /**
     * Returns the clockwise list of all the terminals in the component
     * @return
     */
    public List<Terminal> getTerminals() {
        if(null == clockwiselist){
            throw new UnsupportedOperationException("Terminal list is null for component: " + this.technology);
        }
        return clockwiselist;
    }

    /**
     * Returns the clockwise list for the terminals on the topedge
     * @return
     */
    public List<Terminal> getTopEdgeTerminals() {
        return topedgelist;
    }

    /**
     * Returns the clockwise list for the terminals on the rightedge
     * @return
     */
    public List<Terminal> getRightEdgeTerminals() {
        return rightedgelist;
    }

    /**
     * Returns the clockwise list for the terminals on the leftedge
     * @return
     */
    public List<Terminal> getLeftEdgeTerminals() {
        return leftedgelist;
    }

    /**
     * Returns the clockwise list for the terminals on the bottom edge
     * @return
     */
    public List<Terminal> getBottomEdgeTerminals() {
        return bottomedgelist;
    }


    //----------------Terminal Variables--------------------
    int xmax = 0, xmin= 0, ymin = 0, ymax = 0;

    /**
     * Allows you to associate a list of terminals to the component
     * @param terminalList
     */
    public void setTerminals(List<Terminal> terminalList) {

        xmin = this.getX();
        ymin = this.getY();
        xmax = this.getX() + this.getXSpan();
        ymax = this.getY() + this.getYSpan();

        //Arrange all the terminals in clockwise direction and then add them to top, bottom, left and right

        /*
        Algorithm :
        - Create 4 linked lists
        - For every terminal check what edge it falls on
        -----> Based on the edge add it to the respective linked list
        -----> Make sure its ordered on the linked list
        - Stitch together all the linked lists
         */

        topedgelist = new ArrayList<>();
        rightedgelist = new ArrayList<>();
        leftedgelist = new ArrayList<>();
        bottomedgelist = new ArrayList<>();

        //Simplifying this to catch weird edge case
        for(Terminal terminal: terminalList){
            //Check which edge the terminal falls on
            if(ymin == terminal.getY()){ //Top Edge
                //if x:increasing -> terminal:increasing
                //Go through list and add accordingly
                insertIncreasingXOrder(terminal, topedgelist);
                continue;

            }else if(xmax == terminal.getX()){ //Right Edge
                //if y:increasing -> terminal:increasing
                insertIncreasingYOrder(terminal, rightedgelist);
                continue;

            }else if(ymax == terminal.getY()){ //Bottom Edge
                //if x:increasing -> terminal:decreasing
                insertIncreasingXOrder(terminal, bottomedgelist);
                continue;

            }else if(xmin == terminal.getX()){ //Left Edge
                //if y:increasing -> terminal:decreasing
                insertIncreasingYOrder(terminal, leftedgelist);
                continue;

            }else{
                /*
                For non-fence terminals we need to first figure out which is the closest side

                We do this by dividing the rectangle into 4 triangles and then check and if its on
                the triangle line, then push it to anticlockwise quadrant
                 */

                /*
                Generate the component rectangle/triangle points
                 */
                Point topleft = new Point(this.getX(), this.getY());
                Point topright = new Point(this.getX() + this.getXSpan(), this.getY());
                Point bottomright = new Point(this.getX() + this.getXSpan(), this.getY() + this.getYSpan());
                Point bottomleft = new Point(this.getX(), this.getY() + this.getYSpan());

                Point center = new Point(this.getX() + this.getXSpan()/2, this.getY() + this.getYSpan()/2);
                /*
                Check if its in the top triangle
                 */
                if (terminal.isPointInTriangle(topleft, topright, center)){
                    //Add it to the top list
                    insertIncreasingXOrder(terminal, topedgelist);
                    continue;
                }else if (terminal.isPointInTriangle(topright, bottomright, center)){
                    //Add it to the right list
                    insertIncreasingYOrder(terminal, rightedgelist);
                    continue;
                }else if (terminal.isPointInTriangle(bottomright, bottomleft, center)){
                    //Add it to the bottom list
                    insertIncreasingXOrder(terminal, bottomedgelist);
                    continue;
                }else if (terminal.isPointInTriangle(bottomleft, topleft, center)){
                    //Add it to the left list
                    insertIncreasingYOrder(terminal, leftedgelist);
                    continue;
                }else{
                    throw new UnsupportedOperationException("Non-fence terminal found on quadrant edges");
                }
            }
        }
        Collections.reverse(bottomedgelist);
        Collections.reverse(leftedgelist);
        //Final stitching of the linked lists
        clockwiselist = new LinkedList<>();
        clockwiselist.addAll(topedgelist);
        clockwiselist.addAll(rightedgelist);
        clockwiselist.addAll(bottomedgelist);
        clockwiselist.addAll(leftedgelist);


    }

    private static void insertIncreasingXOrder(Terminal terminal, List<Terminal> edgelist) {
        int lowindex= edgelist.size();
        Terminal terminal2;
        for(int i = 0; i < edgelist.size(); i++){
            terminal2 = edgelist.get(i);
            if(terminal.getX()<=terminal2.getX()){
                lowindex = i;
            }
        }
        edgelist.add(lowindex, terminal);
    }

    private static void insertIncreasingYOrder(Terminal terminal, List<Terminal> edgelist) {
        int lowindex=edgelist.size();
        Terminal terminal2;
        for(int i = 0; i < edgelist.size(); i++){
            terminal2 = edgelist.get(i);
            if(terminal.getY()<=terminal2.getY()){
                lowindex = i;
            }
        }
        edgelist.add(lowindex, terminal);
    }

    /**
     * Sets the component type : PRIMITIVE | COMPOSITE | FEATURE | SCALING.
     * This step is important for subsequent steps when we do feature generation and other technology related operations
     * @param type
     */
    public void setType(TechEntity.TechEntityType type) {
        this.type = type;
    }
}
