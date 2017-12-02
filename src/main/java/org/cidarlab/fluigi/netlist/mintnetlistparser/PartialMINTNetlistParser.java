package org.cidarlab.fluigi.netlist.mintnetlistparser;

import org.cidarlab.fluigi.model.Component;
import org.cidarlab.fluigi.model.Connection;
import org.cidarlab.fluigi.model.Terminal;
import org.cidarlab.fluigi.netlist.mintgrammar.mintgrammarParser;
import org.cidarlab.fluigi.netlist.mintgrammar.mintgrammarParser.*;
import org.cidarlab.fluigi.netlist.mintnetlistparser.MINTArbitraryTerminalMap.TargetRecord;
import org.cidarlab.fluigi.netlist.technology.TechEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by krishna on 3/7/17.
 */
public class   PartialMINTNetlistParser extends PartialMINTParamsParser {

    protected List<Component> constraintContextComponents = null;
    protected MINTArbitraryTerminalMap terminalMap = null;
    HashMap<String, Object> gridparamsHashmap;
    HashMap<String, Object> bankparamsHashmap;
    private int spanlimit;

    public PartialMINTNetlistParser(){
        super();
        gridparamsHashmap = new HashMap<>();
        bankparamsHashmap = new HashMap<>();
        constraintContextComponents = new ArrayList<>();
        terminalMap = new MINTArbitraryTerminalMap();
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitPrimitiveStat(mintgrammarParser.PrimitiveStatContext ctx) {
        List<UfnameContext> componentnames = ctx.ufnames().ufname();
        for(UfnameContext componentname : componentnames){

            Component component = createAndVerifyComponentHelper(componentname.getText(), currententity);

            //Add the terminal map
            addAllTerminalsToTerminalMapHelper(component);

            //Add the component to constraint context for applying constraints
            constraintContextComponents.add(component);
            //Adding the component to the device
            device.addComponent(component, currentlayer.getId());
        }
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitGridStat(GridStatContext ctx) {

        super.exitGridStat(ctx);
        int xdim = Integer.parseInt(ctx.xdim.getText());
        int ydim = Integer.parseInt(ctx.ydim.getText());

        String componentname = ctx.ufname().getText();

        Component component;
        int finalterminalnumberiterator = 0;
        int terminalnumberiterator = 0;
        List<Terminal> componentTopEdgeTerminalList;
        List<Terminal> componentRightEdgeTerminalList;
        List<Terminal> componentLeftEdgeTerminalList;
        List<Terminal> componentBottomEdgeTerminalList;

        for (int i = 0; i < xdim; i++) {
            for (int j = 0; j < ydim; j++) {
                component = createAndVerifyComponentHelper(componentname + "_" + i+1 + "_" + j+1, currententity);

                //Add the terminal map records for the edge components
                if(0 == j){//Top row
                    componentTopEdgeTerminalList = component.getTopEdgeTerminals();
                    terminalnumberiterator = 1;
                    for (Terminal terminal : componentTopEdgeTerminalList) {
                        finalterminalnumberiterator =
                                componentTopEdgeTerminalList.size() * i + terminalnumberiterator++;
                        terminalMap.addRecord(
                                componentname,
                                component,
                                Integer.toString(finalterminalnumberiterator),
                                terminal.getLabel()
                                );
                    }
                    
                }

                if (xdim-1 == i){ // Right column
                    componentTopEdgeTerminalList = component.getTopEdgeTerminals();
                    componentRightEdgeTerminalList = component.getRightEdgeTerminals();
                    terminalnumberiterator = 1;
                    for (Terminal terminal : componentRightEdgeTerminalList) {
                        finalterminalnumberiterator =
                                componentTopEdgeTerminalList.size() * xdim
                                        + componentRightEdgeTerminalList.size() * j
                                        + terminalnumberiterator++;
                        terminalMap.addRecord(
                                componentname,
                                component,
                                Integer.toString(finalterminalnumberiterator),
                                terminal.getLabel()
                        );
                    }

                }

                if (ydim - 1 == j){ //Bottom row
                    componentTopEdgeTerminalList = component.getTopEdgeTerminals();
                    componentRightEdgeTerminalList = component.getRightEdgeTerminals();
                    componentBottomEdgeTerminalList = component.getBottomEdgeTerminals();
                    terminalnumberiterator = componentBottomEdgeTerminalList.size()-1;

                    for(Terminal terminal : componentBottomEdgeTerminalList){
                        finalterminalnumberiterator =
                                componentTopEdgeTerminalList.size() * xdim
                                        + componentRightEdgeTerminalList.size() * ydim
                                        + (componentBottomEdgeTerminalList.size()*(xdim-i)
                                        - (terminalnumberiterator--));
                        terminalMap.addRecord(
                                componentname,
                                component,
                                Integer.toString(finalterminalnumberiterator),
                                terminal.getLabel()
                        );

                    }

                }

                if (0 == i){ //Left row
                    componentTopEdgeTerminalList = component.getTopEdgeTerminals();
                    componentRightEdgeTerminalList = component.getRightEdgeTerminals();
                    componentBottomEdgeTerminalList = component.getBottomEdgeTerminals();
                    componentLeftEdgeTerminalList = component.getLeftEdgeTerminals();

                    terminalnumberiterator = componentLeftEdgeTerminalList.size()-1;

                    for(Terminal terminal : componentLeftEdgeTerminalList){
                        finalterminalnumberiterator =
                                componentTopEdgeTerminalList.size() * xdim
                                        + componentRightEdgeTerminalList.size() * ydim
                                        + componentBottomEdgeTerminalList.size() * xdim
                                        + (componentLeftEdgeTerminalList.size() * (ydim - j)
                                        - (terminalnumberiterator--));
                        terminalMap.addRecord(
                                componentname,
                                component,
                                Integer.toString(finalterminalnumberiterator),
                                terminal.getLabel()
                        );

                    }


                }

                //Add the component to constraint context for applying constraints
                constraintContextComponents.add(component);
                //Adding the component to the device
                device.addComponent(component, currentlayer.getId());
            }

        }

    }


    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitBankStat(BankStatContext ctx) {
        super.exitBankStat(ctx);
        int dim = Integer.parseInt(ctx.dim.getText());
        String componentname = ctx.ufname().getText();

        Component component;

        for (int i = 0; i < dim; i++) {
            component = createAndVerifyComponentHelper(componentname + "_" + i+1, currententity);

            //Create terminals that need to be connected with the required alias
            List<Terminal> componenttopedgeterminals = component.getTopEdgeTerminals();
            List<Terminal> componentbottomedgeterminals = component.getBottomEdgeTerminals();

            int terminalitertor = 1;
            int finalterminalcount;
            //Add top
            for(Terminal terminal: componenttopedgeterminals){
                finalterminalcount = componenttopedgeterminals.size() *  i + terminalitertor++;
                terminalMap.addRecord(
                        componentname,
                        component,
                        Integer.toString(finalterminalcount),
                        terminal.getLabel()
                );
            }

            //Add bottom
            for(Terminal terminal : componentbottomedgeterminals){
                finalterminalcount = componenttopedgeterminals.size() * dim +
                        componentbottomedgeterminals.size() * i + terminalitertor++;
                terminalMap.addRecord(
                        componentname,
                        component,
                        Integer.toString(finalterminalcount),
                        terminal.getLabel()
                );
            }

            //Add the component to constraint context for applying constraints
            constraintContextComponents.add(component);
            //Adding the component to the device
            device.addComponent(component, currentlayer.getId());
        }

    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitSpanStat(SpanStatContext ctx) {
        super.exitSpanStat(ctx);
        String invalue = ctx.in.getText();
        String outvalue = ctx.out.getText();

        paramsHashmap.put("in", invalue);
        paramsHashmap.put("out", outvalue);

        spanlimit = Integer.parseInt(outvalue) + Integer.parseInt(invalue);

        List<UfnameContext> componentnames = ctx.ufnames().ufname();
        for(UfnameContext componentname : componentnames){

            Component component = createAndVerifyComponentHelper(componentname.getText(), currententity);

            //Add the terminal map
            addAllTerminalsToTerminalMapHelper(component);

            //Add the component to constraint context for applying constraints
            constraintContextComponents.add(component);
            //Adding the component to the device
            device.addComponent(component, currentlayer.getId());
        }
    }

    /**
     *
     * @param ctx
     */
    @Override
    public void exitValveStat(ValveStatContext ctx) {
        //Set technology to valve
        Component component = createAndVerifyComponentHelper(ctx.ufname().get(0).getText(), currententity);

        //Add the terminal map
        addAllTerminalsToTerminalMapHelper(component);

        addAllTerminalsToTerminalMapHelper(component);

        device.addComponent(component, currentlayer.getId());

        //Add the valve relationship to the flow layer
        Connection flowconnection = device.getConnection(ctx.ufname().get(1).getText());
        device.addValve(component, flowconnection);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitChannelStat(ChannelStatContext ctx) {
        String connection_name = ctx.ufname().getText();
        //Get the source uftarget
        TargetRecord sourcerecord = getArbitraryUFTargetRecordHelper(ctx.source);
        String sourceID = sourcerecord.getComponentID();
        String sourceTerminal = sourcerecord.getTerminalLabel();

        //Get the sink uftarget
        TargetRecord sinkrecord = getArbitraryUFTargetRecordHelper(ctx.sink);
        String sinkID = sinkrecord.getComponentID();
        String sinkTeriminal = sinkrecord.getTerminalLabel();


        //Create the connection (for the channel)
        Connection connection = new Connection(connection_name);
        connection.setTechnology(currententity.getMINTName());
        //Set the layer
        connection.setLayerID(currentlayer.getId());
        //Set the source and sink
        connection.setSourceID(sourceID);
        connection.addSinkID(sinkID);

        //Update the terminalmap for the connection
        connection.updateTerminalMap(sourceID, sourceTerminal);
        connection.updateTerminalMap(sinkID, sinkTeriminal);
        verifyAndAddConnectionParams(connection);
        device.addConnection(connection, currentlayer.getId());

    }


    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitNetStat(NetStatContext ctx) {
        String connection_name = ctx.ufname().getText();
        Connection connection = new Connection(connection_name);
        //Set the layer
        connection.setLayerID(currentlayer.getId());

        TargetRecord sourcerecord = getArbitraryUFTargetRecordHelper(ctx.source);
        String sourceid = sourcerecord.getComponentID();
        String sourceterminal = sourcerecord.getTerminalLabel();
        connection.setSourceID(sourceid);
        connection.updateTerminalMap(sourceid,sourceterminal);

        TargetRecord sinkrecord;
        String sinkid;
        String sinkterminal;
        for(UftargetContext uftargetContext : ctx.sinks.uftarget()){
            //Loop through each of the targets and then add and update the sinks
            sinkrecord = getArbitraryUFTargetRecordHelper(uftargetContext);
            sinkid = sinkrecord.getComponentID();
            sinkterminal = sinkrecord.getTerminalLabel();
            connection.addSinkID(sinkid);
            connection.updateTerminalMap(sinkid,sinkterminal);
        }
        device.addConnection(connection, currentlayer.getId());

    }


    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterEntity(EntityContext ctx) {
        currententity = techLibrary.getMINTEntity(ctx.getText());
        if (null == currententity) {
            System.out.println("Entity does not exist: " + ctx.getText());
            throw new UnsupportedOperationException("Need to implement system to throw error when entity does not exist");
        }
    }

    /*
    Private Helper Methods
     */

    private TargetRecord getArbitraryUFTargetRecordHelper(UftargetContext uftargetContext) {
        //Query things from the new arbitrary terminalmap
        //Note: I'm hoping all the errors get thrown internally
        String componentref = uftargetContext.target_name.getText();
        String terminalref = null;

        if(null != uftargetContext.target_terminal){
            terminalref = uftargetContext.target_terminal.getText();
        }

        TargetRecord ret = terminalMap.queryRecord(componentref, terminalref);
        return ret;
    }

    protected void addAllTerminalsToTerminalMapHelper(Component component) {
        //Add records to terminal map
        if(component.getTerminals().isEmpty()){
            //Add just the component iscase there are no terminals
            terminalMap.addRecord(component.getId(), component, null, null);
        }else {
            for (Terminal terminal : component.getTerminals()) {
                terminalMap.addRecord(component.getId(), component, terminal.getLabel(), terminal.getLabel());
            }
        }
    }

    protected Component createAndVerifyComponentHelper(String id, TechEntity componententity) {
        Component ret = new Component(id);

        //set the correct technology
        //Q. Figure out if this should be the key or the reference to the actual tech entity object.
        //A. We use the string key here instead of the entity object because we might want to include subdevices as
        // modules.
        //TODO: Check if this is an importable component later on
        ret.setXSpan(componententity.getXSpan(paramsHashmap));
        ret.setYSpan(componententity.getYSpan(paramsHashmap));
        ret.setTechnology(componententity.getMINTName());
        ret.setTerminals(componententity.getComponentTerminals(paramsHashmap));
        ret.setType(componententity.getType());
        verifyAndAddParams(ret);
        return ret;
    }


}
