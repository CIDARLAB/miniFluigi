package org.cidarlab.fluigi.netlist.mintnetlistparser;

import org.cidarlab.fluigi.core.ErrorCodes;
import org.cidarlab.fluigi.core.LibraryManager;
import org.cidarlab.fluigi.netlist.*;
import org.cidarlab.fluigi.netlist.mintgrammar.mintgrammarBaseListener;
import org.cidarlab.fluigi.netlist.mintgrammar.mintgrammarParser;
import org.cidarlab.fluigi.netlist.mintgrammar.mintgrammarParser.*;

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

            Component component = new Component(componentname.getText());

            //set the correct technology
            //Q. Figure out if this should be the key or the reference to the actual tech entity object.
            //A. We use the string key here instead of the entity object because we might want to include subdevices as
            // modules.
            component.setTechnology(currententity.getName());

            verifyAndAddParams(component);

            //TODO : Move the computing X,Y spans only during the cell generation stage
            component.setXSpan(currententity.getXSpan(paramsHashmap));
            component.setYSpan(currententity.getYSpan(paramsHashmap));

            //Add the terminal map
            List<Terminal> terminalList = component.getTerminals();
            for (Terminal terminal: terminalList) {
                terminalMap.addRecord(component.getId(), component, terminal.getLabel());
            }
            //Add the component to constraint context for applying constraints
            constraintContextComponents.add(component);
            //Adding the component to the device
            device.addComponent(component);
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
                component = new Component(componentname + "_" + i+1 + "_" + j+1);
                component.setTechnology(currententity.getMINTName());
                verifyAndAddParams(component);

                //Add the terminal map records for the edge components
                if(0 == i){//Top row
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
                    
                }else if (xdim-1 == i){ // Right column
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

                }else if (ydim - 1 == j){ //Bottom row
                    componentTopEdgeTerminalList = component.getTopEdgeTerminals();
                    componentRightEdgeTerminalList = component.getRightEdgeTerminals();
                    componentBottomEdgeTerminalList = component.getBottomEdgeTerminals();
                    terminalnumberiterator = componentBottomEdgeTerminalList.size()-1;

                    for(Terminal terminal : componentBottomEdgeTerminalList){
                        finalterminalnumberiterator =
                                componentTopEdgeTerminalList.size() * xdim
                                        + componentRightEdgeTerminalList.size() * ydim
                                        + componentBottomEdgeTerminalList.size() * (xdim - i)
                                        + (componentBottomEdgeTerminalList.size() - (terminalnumberiterator--));
                        terminalMap.addRecord(
                                componentname,
                                component,
                                Integer.toString(finalterminalnumberiterator),
                                terminal.getLabel()
                        );

                    }

                }else if (0 == j){ //Left row
                    componentTopEdgeTerminalList = component.getTopEdgeTerminals();
                    componentRightEdgeTerminalList = component.getRightEdgeTerminals();
                    componentBottomEdgeTerminalList = component.getBottomEdgeTerminals();
                    componentLeftEdgeTerminalList = component.getLeftEdgeTerminals();

                    terminalnumberiterator = componentLeftEdgeTerminalList.size()-1;

                    for(Terminal terminal : componentBottomEdgeTerminalList){
                        finalterminalnumberiterator =
                                componentTopEdgeTerminalList.size() * xdim
                                        + componentRightEdgeTerminalList.size() * ydim
                                        + componentBottomEdgeTerminalList.size() * xdim
                                        + (componentLeftEdgeTerminalList.size() - (terminalnumberiterator--));
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
                device.addComponent(component);
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
        //TODO: Do the whole bank spiel
        super.exitBankStat(ctx);
        int dim = Integer.parseInt(ctx.dim.getText());
        String componentname = ctx.ufname().getText();

        Component component;

        for (int i = 0; i < dim; i++) {
            component = new Component(componentname + "_" + i);
            component.setTechnology(currententity.getMINTName());
            verifyAndAddParams(component);

            //Add the component to constraint context for applying constraints
            constraintContextComponents.add(component);
            //Adding the component to the device
            device.addComponent(component);
        }

    }

    @Override
    public void exitNodeStat(NodeStatContext ctx) {
        List<UfnameContext> componentnames = ctx.ufnames().ufname();
        for(UfnameContext componentname : componentnames){
            Component component = new Component(componentname.getText());
            component.setTechnology("NODE");
            device.addComponent(component);
        }
    }

    @Override
    public void exitValveStat(ValveStatContext ctx) {
        Component component = new Component(ctx.ufname().get(0).getText());
        Connection connection = device.getConnection(ctx.ufname().get(1).getText());
        String entitytext = ctx.valve_entity.getText();
        component.setTechnology(entitytext);
        verifyAndAddParams(component);

        device.addComponent(component);
        device.addValve(component, connection);
    }

    @Override
    public void enterChannelStat(ChannelStatContext ctx) {
        super.enterChannelStat(ctx);
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
        Component source = getComponent(ctx.source.target_name.getText()); //device.getComponent(ctx.source.target_name.getText());
        int sourceterminal = Integer.parseInt(ctx.source.target_terminal.getText());
        //Get the sink uftarget
        Component sink = getComponent(ctx.sink.target_name.getText());
        int sinkterminal = Integer.parseInt(ctx.sink.target_terminal.getText());

        //Create the connection (for the channel)
        Connection connection = new Connection(connection_name);
        //Set the layer
        connection.setLayerID(currentlayer.getId());
        //Set the source and sink
        connection.setSourceID(source.getId());
        connection.addSinkID(sink.getId());

        //Update the terminalmap for the connection
        connection.updateTerminalMap(source.getId(),sourceterminal);
        connection.updateTerminalMap(sink.getId(),sinkterminal);
        verifyAndAddConnectionParams(connection);
        device.addConnection(connection);

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

        Component source = getComponent(ctx.source.target_name.getText());
        int sourceterminal = Integer.parseInt(ctx.source.target_terminal.getText());
        connection.setSourceID(source.getId());
        connection.updateTerminalMap(source.getId(),sourceterminal);

        Component sink;
        int sinkterminal;
        for(UftargetContext uftargetContext : ctx.sinks.uftarget()){
            //Loop through each of the targets and then add and update the sinks
            sink = getComponent(uftargetContext.target_name.getText());
            sinkterminal = Integer.parseInt(uftargetContext.target_terminal.getText());
            connection.addSinkID(sink.getId());
            connection.updateTerminalMap(sink.getId(),sinkterminal);
        }
        device.addConnection(connection);

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
            System.out.println("Entity does not exist");
            throw new UnsupportedOperationException("Need to implement system to throw error when entity does not exist");
        }
    }

    /*
    Private Helper Methods
     */

    private Component getComponent(String id) {
        //TODO: Convert this into a pretty parsing error
        Component ret = device.getComponent(id);
        if(null==ret){
            throw new UnsupportedOperationException("Need to implement the error when entity is not found");
        }

        return ret;
    }


}
