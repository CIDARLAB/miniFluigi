package org.cidarlab.fluigi.netlist.mintnetlistparser;

import org.cidarlab.fluigi.netlist.*;
import org.cidarlab.fluigi.netlist.constraints.BankConstraint;
import org.cidarlab.fluigi.netlist.constraints.Constraint;
import org.cidarlab.fluigi.netlist.constraints.GridConstraint;
import org.cidarlab.fluigi.netlist.constraints.OrientationConstraint;
import org.cidarlab.fluigi.netlist.mintgrammar.mintgrammarParser;
import org.cidarlab.fluigi.netlist.technology.TechEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartialMINTConstraintParser extends PartialMINTNetlistParser {

    protected Enumerations.HorizontalDirection constraintContextHorizontalDirection = null;
    protected Enumerations.VerticalDirection constraintContextVerticalDirection = null;
    protected Enumerations.Orientation constriantContextOrientaiton = null;
    protected Integer constraintContextLength = null;

    private HashMap<String, String> gridParamsHashmap;


    public PartialMINTConstraintParser() {
        super();
        gridParamsHashmap = new HashMap<>();
    }

    @Override
    public void enterFlowStat(mintgrammarParser.FlowStatContext ctx) {
        super.enterFlowStat(ctx);
        constraintContextComponents.clear();
        clearConstraintFlags();
    }


    @Override
    public void enterControlStat(mintgrammarParser.ControlStatContext ctx) {
        super.enterControlStat(ctx);
        constraintContextComponents.clear();
        clearConstraintFlags();
    }

    @Override
    public void enterIntegrationStat(mintgrammarParser.IntegrationStatContext ctx) {
        super.enterIntegrationStat(ctx);
        constraintContextComponents.clear();
        clearConstraintFlags();
    }

    @Override
    public void exitPrimitiveWithOrientationConstraintStat(mintgrammarParser.PrimitiveWithOrientationConstraintStatContext ctx) {
        super.exitPrimitiveWithOrientationConstraintStat(ctx);

        // Finally set the rotation value for the component
        /*
        1. Figure out what the final rotation/orientation is
        2. Apply it to all the components
         */

        float rotation = 0;

        if(null == constriantContextOrientaiton){
            throw new UnsupportedOperationException("Need to implement error throwing mechanism for bad constraints");
        }

        if(Enumerations.Orientation.HORIZONTAL == constriantContextOrientaiton){
            if(null == constraintContextHorizontalDirection){
                //Check if there's a default parameter for the techentity
                String direction = currententity.getDefaultParamValue("direction");
                if(null == direction) {
                    rotation = 0;
                } else {
                    switch (direction) {
                        case "RIGHT":
                            rotation = 180;
                            break;
                        case "LEFT":
                            rotation = 0;
                            break;
                        default:
                            throw new UnsupportedOperationException("Need to implement error throwing mech for error in tech file");
                    }
                }
            }else {

                switch (constraintContextVerticalDirection) {
                    case RIGHT:
                        rotation = 180;
                        break;
                    case LEFT:
                        rotation = 0;
                        break;
                }
            }

        }else{
            if(null == constraintContextVerticalDirection){
                String direction = currententity.getDefaultParamValue("direction");
                if(null == direction) {
                    rotation = 0;
                }else {
                    switch (direction) {
                        case "UP":
                            rotation = 90;
                            break;
                        case "DOWN":
                            rotation = 270;
                            break;
                        default:
                            throw new UnsupportedOperationException("Need to implement error throwing mech for error in tech file");
                    }
                }
            }else {

                switch (constraintContextHorizontalDirection) {
                    case UP:
                        rotation = 270;
                        break;
                    case DOWN:
                        rotation = 90;
                        break;
                }
            }

        }

        OrientationConstraint constraint = new OrientationConstraint(rotation, constraintContextComponents);
        this.device.addConstraint(constraint);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterGridParam(mintgrammarParser.GridParamContext ctx) {
        gridParamsHashmap.put(ctx.gridParamKey().getText(), ctx.gridParamValue().getText());
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitGridStat(mintgrammarParser.GridStatContext ctx) {
        super.exitGridStat(ctx);

        int horizontalspacing = 0;
        int verticalspacing = 0;

        int xdim = Integer.parseInt(ctx.xdim.getText());
        int ydim = Integer.parseInt(ctx.ydim.getText());
        String name = ctx.ufname().getText();

        if(gridParamsHashmap.containsKey("horizontalSpacing")){
            horizontalspacing = Integer.parseInt(gridParamsHashmap.get("horizontalSpacing"));
        }

        if(gridParamsHashmap.containsKey("verticalSpacing")){
            verticalspacing = Integer.parseInt(gridParamsHashmap.get("verticalSpacing"));
        }

        if(gridParamsHashmap.containsKey("horizontalConnect")){
            if(("YES").equals(gridParamsHashmap.get("horizontalConnect"))){

                //Loop through all the components and then based on the algorithm generate the connections
                //Refer https://github.com/CIDARLAB/miniFluigi/wiki/Algorithms#grid-connections for details of algorithm

                Component samplecomponent  = constraintContextComponents.get(0);

                List<Terminal> leftterminalslist = samplecomponent.getLeftEdgeTerminals();
                List<Terminal> rightterminalslist = samplecomponent.getRightEdgeTerminals();

                List<Terminal> smalllist;
                List<Terminal> biglist;
                List<Connection> connectionList = null;

                Component sourcecomponent;
                Component sinkcomponent;

                if(leftterminalslist.size() <= rightterminalslist.size()){
                    smalllist = leftterminalslist;
                    biglist = rightterminalslist;
                }else{
                    biglist = leftterminalslist;
                    smalllist = rightterminalslist;
                }

                //Get the source and sink components
                for(int x = 0; x < xdim - 1; x++){
                    for(int y = 0; y < ydim; y++){
                        int sourceindex = x*xdim + y%ydim;
                        int sinkindex = (x+1)*xdim + y%ydim;
                        sourcecomponent = constraintContextComponents.get(sourceindex);
                        sinkcomponent = constraintContextComponents.get(sinkindex);

                        connectionList = createGridChannelConnectionHelper(name, smalllist, biglist, sourcecomponent, sinkcomponent, x, y);

                    }
                }

                if(paramsHashmap.containsKey("horizontalValves")){
                    if(("YES").equals(gridParamsHashmap.get("horizontalValves"))){
                        //TODO: for each item in the connetion list create and add a valve
                        if(null == connectionList){
                            throw new UnsupportedOperationException("The connection list should not be null");
                        }
                        for(Connection conn : connectionList){
                            //Get Default Valve technology
                            TechEntity valveEntity = techLibrary.getMINTEntity(DefaultSettings.DEFAULT_VALVE_TECHNOLOGY);
                            Component valvecomponent = createAndVerifyComponentHelper("valve_"+conn.getId(), valveEntity);
                            addAllTerminalsToTerminalMapHelper(valvecomponent);
                            device.addComponent(valvecomponent, currentLayerBlock.getControlLayer().getId());
                        }
                    }
                }

            }
        }

        if(gridParamsHashmap.containsKey("verticalConnect")){
            if(("YES").equals(gridParamsHashmap.get("verticalConnect"))){

                //Loop through all the components and then based on the algorithm generate the connections
                //Refer https://github.com/CIDARLAB/miniFluigi/wiki/Algorithms#grid-connections for details of algorithm

                Component samplecomponent  = constraintContextComponents.get(0);

                List<Terminal> leftterminalslist = samplecomponent.getLeftEdgeTerminals();
                List<Terminal> rightterminalslist = samplecomponent.getRightEdgeTerminals();

                List<Terminal> smalllist;
                List<Terminal> biglist;
                List<Connection> connectionList;

                Component sourcecomponent;
                Component sinkcomponent;

                if(leftterminalslist.size() <= rightterminalslist.size()){
                    smalllist = leftterminalslist;
                    biglist = rightterminalslist;
                }else{
                    biglist = leftterminalslist;
                    smalllist = rightterminalslist;
                }

                //Get the source and sink components
                for(int x = 0; x < xdim ; x++){
                    for(int y = 0; y < ydim -1 ; y++){
                        int sourceindex = x*xdim + y%ydim;
                        int sinkindex = (x)*xdim + (y)%ydim + 1 ;
                        sourcecomponent = constraintContextComponents.get(sourceindex);
                        sinkcomponent = constraintContextComponents.get(sinkindex);

                        connectionList = createGridChannelConnectionHelper(name, smalllist, biglist, sourcecomponent, sinkcomponent, x, y);

                    }
                }

                if(gridParamsHashmap.containsKey("verticalValves")){
                    if(("YES").equals(gridParamsHashmap.get("verticalValves"))){
                        throw new UnsupportedOperationException("Need to implement code to increase spacing for a valve");
                    }
                }

            }
        }

        Constraint constraint = new GridConstraint(horizontalspacing, verticalspacing, constraintContextComponents);

        device.addConstraint(constraint);

        gridParamsHashmap.clear();
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitSpanStat(mintgrammarParser.SpanStatContext ctx) {
        super.exitSpanStat(ctx);
        //TODO: We need to check if the span is of Type Tree/Fan and then generate the respective cells
        throw new UnsupportedOperationException();

    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitBankStat(mintgrammarParser.BankStatContext ctx) {
        super.exitBankStat(ctx);
        //Implement the constraint for bank

        int spacing = 0;
        if(paramsHashmap.containsKey("spacing")){
            spacing = Integer.parseInt(paramsHashmap.get("spacing"));
        }
        Constraint constraint = new BankConstraint(spacing, constraintContextComponents);

        device.addConstraint(constraint);
    }

    //------------------- Constraint Params ---------------------


    @Override
    public void enterIntParam(mintgrammarParser.IntParamContext ctx) {
        super.enterIntParam(ctx);

        //Capture the length constraint

        String paramkey = ctx.param_element().getText();
        String value = ctx.value().getText();

        if(paramkey.equals("length")){
            constraintContextLength = Integer.parseInt(value);
        }
    }

    @Override
    public void exitOrientation(mintgrammarParser.OrientationContext ctx) {
        super.exitOrientation(ctx);

        //Set the orientation flag that is used later on

        switch (ctx.getText()){
            case "V":
                constriantContextOrientaiton = Enumerations.Orientation.VERTICAL;
                break;
            case "H":
                constriantContextOrientaiton = Enumerations.Orientation.HORIZONTAL;
                break;
        }

    }

    @Override
    public void enterVerticalDirectionParam(mintgrammarParser.VerticalDirectionParamContext ctx) {
        super.enterVerticalDirectionParam(ctx);

        //Set the current vertical direction flag

        switch (ctx.getText()){
            case "LEFT":
                constraintContextVerticalDirection = Enumerations.VerticalDirection.LEFT;
                break;
            case "RIGHT":
                constraintContextVerticalDirection = Enumerations.VerticalDirection.RIGHT;
                break;
        }


    }

    @Override
    public void enterHorizontalDirectionParam(mintgrammarParser.HorizontalDirectionParamContext ctx) {
        super.enterHorizontalDirectionParam(ctx);

        //Set the current horizontal direction flag

        switch (ctx.getText()){
            case "UP":
                constraintContextHorizontalDirection = Enumerations.HorizontalDirection.UP;
                break;
            case "DOWN":
                constraintContextHorizontalDirection = Enumerations.HorizontalDirection.DOWN;
                break;
        }

    }



    //------------------ Private Helper Methods -------------------

    /**
     * Clears all of the flags that are being set by the constriant params
     */
    private void clearConstraintFlags() {
        constriantContextOrientaiton = null;
        constraintContextHorizontalDirection = null;
        constraintContextVerticalDirection = null;
        constraintContextLength = null;
    }

    private List<Connection> createGridChannelConnectionHelper(String name, List<Terminal> smalllist, List<Terminal> biglist, Component sourcecomponent, Component sinkcomponent, int x, int y) {

        List<Connection> ret = new ArrayList<>();

        //Loop through the terminals
        for(int i = 0; i < smalllist.size(); i++){
            Terminal smallterminal = smalllist.get(i);
            Terminal bigterminal = biglist.get(i);

            //Create the connection (for the channel)
            Connection connection = new Connection("ch_" + name + "_h_" + x +"_"+ y + "_" + i);
            //Set the layer
            connection.setLayerID(currentlayer.getId());

            //Set the source and sink
            connection.setSourceID(sourcecomponent.getId());

            connection.addSinkID(sinkcomponent.getId());

            //Update the terminalmap for the connection
            connection.updateTerminalMap(sourcecomponent.getId(), null);
            connection.updateTerminalMap(sinkcomponent.getId(), null);
            verifyAndAddConnectionParams(connection);

            ret.add(connection);

            device.addConnection(connection, currentlayer.getId());
        }

        return ret;
    }

}
