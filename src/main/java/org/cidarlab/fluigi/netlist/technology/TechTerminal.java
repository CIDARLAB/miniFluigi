package org.cidarlab.fluigi.netlist.technology;

import org.cidarlab.fluigi.layout.Point;

/**
 * Created by krishna on 8/24/17.
 */
public class TechTerminal extends Point{

    private final String label;
    private String xposexpression;
    private String yposexpression;
    private String layer;
    private String start;
    private String end;

    public TechTerminal(String label) {
        super();
        this.label = label;
    }

    public String getXposexpression() {
        return xposexpression;
    }

    public void setXposexpression(String xposexpression) {
        this.xposexpression = xposexpression;
    }

    public String getYposexpression() {
        return yposexpression;
    }

    public void setYposexpression(String yposexpression) {
        this.yposexpression = yposexpression;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getLabel() {
        return label;
    }

    public String getLayer() {
        return layer;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() { return end; }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end){
        this.end = end;
    }
}
