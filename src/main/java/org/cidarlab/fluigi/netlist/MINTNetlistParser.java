package org.cidarlab.fluigi.netlist;

import org.cidarlab.fluigi.core.ErrorCodes;
import org.cidarlab.fluigi.core.LibraryManager;
import org.cidarlab.fluigi.netlist.mintgrammar.mintgrammarBaseListener;
import org.cidarlab.fluigi.netlist.mintgrammar.mintgrammarParser;
import org.cidarlab.fluigi.netlist.mintgrammar.mintgrammarParser.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by krishna on 3/7/17.
 */
public class MINTNetlistParser extends mintgrammarBaseListener {

    Device device;
    LogicalLayer currentlayer;
    TechLibrary techLibrary = LibraryManager.techLibrary;
    int layercount = 0;
    HashMap<String, String> paramsHashmap;
    TechEntity currententity;
    HashMap<String, Object> gridparamsHashmap;
    HashMap<String, Object> bankparamsHashmap;
    Component.Orientation currentOrientation;

    public MINTNetlistParser(){
        device = new Device();
        paramsHashmap = new HashMap<>();
        gridparamsHashmap = new HashMap<>();
        bankparamsHashmap = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterNetlist(NetlistContext ctx) {
        super.enterNetlist(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterHeader(HeaderContext ctx) {
        String name = ctx.device_name.getText();
        device = new Device(name);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterLayerBlock(LayerBlockContext ctx) {
        //TODO: Figure out how having multiple sections of logical layers can affect the PAR
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterFlowBlock(FlowBlockContext ctx) {
        currentlayer = new LogicalLayer(Integer.toString(layercount++));
        device.addLayer(currentlayer);
        currentlayer.setLayerType(LogicalLayer.LogicalLayerType.FLOW);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterControlBlock(ControlBlockContext ctx) {
        currentlayer = new LogicalLayer(Integer.toString(layercount++));
        device.addLayer(currentlayer);
        currentlayer.setLayerType(LogicalLayer.LogicalLayerType.CONTROL);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitLayerBlock(LayerBlockContext ctx) {
        currentlayer = null;
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
            //TODO: Q. Figure out if this should be the key or the reference to the actual tech entity object.
            //A. We use the string key here instead of the entity object because we might want to include subdevices as
            // modules.
            component.setTechnology(currententity.getName());

            verifyAndAddParams(component);

            component.setXSpan(currententity.getXSpan(paramsHashmap));
            component.setYSpan(currententity.getYSpan(paramsHashmap));

            //Adding the component to the device
            device.addComponent(component);
        }
    }

    @Override
    public void exitPrimitiveWithOrientationStat(PrimitiveWithOrientationStatContext ctx) {
        List<UfnameContext> componentnames = ctx.ufnames().ufname();
        for(UfnameContext componentname : componentnames){
            Component component = new Component(componentname.getText());

            //set the correct technology
            //TODO: Q. Figure out if this should be the key or the reference to the actual tech entity object.
            //A. We use the string key here instead of the entity object because we might want to include subdevices as
            // modules.
            component.setTechnology(currententity.getName());

            verifyAndAddParams(component);
            component.addParam("orientation", currentOrientation);

            component.setXSpan(currententity.getXSpan(paramsHashmap));
            component.setYSpan(currententity.getYSpan(paramsHashmap));

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
    public void enterParamsStat(ParamsStatContext ctx) {
        paramsHashmap.clear();
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterIntParam(IntParamContext ctx) {
        String paramkey = ctx.param_element().getText();
        String value = ctx.value().getText();
        paramsHashmap.put(paramkey,value);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterBoolParam(BoolParamContext ctx) {
        String paramkey = ctx.param_element().getText();
        String value = ctx.boolvalue().getText();
        paramsHashmap.put(paramkey,value);
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
    public void exitGridStat(GridStatContext ctx) {
        //TODO: Do the whole spiel

        int xdim = Integer.parseInt(ctx.xdim.getText());
        int ydim = Integer.parseInt(ctx.ydim.getText());

        throw new UnsupportedOperationException("Implement the grid statement");

    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterBankStat(BankStatContext ctx) {
        //TODO: Do the whole bank spiel
        throw new UnsupportedOperationException("Implement the bank statement");
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
            System.exit(ErrorCodes.ENTITY_NOT_EXIST);
        }
    }

    @Override
    public void enterOrientation(OrientationContext ctx) {
        switch (ctx.getText()){
            case "V":
                currentOrientation = Component.Orientation.VERTICAL;
                break;
            case "H":
                currentOrientation = Component.Orientation.HORIZONTAL;
                break;
        }
    }

    public Device getDevice() {
        return device;
    }


    /*
    Private Helper Methods
     */

    private Component getComponent(String id) {
        //TODO: Convert this into a pretty parsing error
        Component ret = device.getComponent(id);
        if(null==ret){
            System.exit(ErrorCodes.COMPONENT_NOT_FOUND);
        }

        return ret;
    }

    private void verifyAndAddParams(Component component) {
        for(String key: paramsHashmap.keySet()){
            TechEntity.ParamVerification verification = currententity.verifyParam(key, paramsHashmap.get(key));
            switch (verification){
                case VALID:
                    component.addParam(key, paramsHashmap.get(key));
                    break;
                case INVALID_NAME:
                    //TODO: Add the error thing
                    throw new UnsupportedOperationException("Component: Create error mechanism for invalid names");
                case INVALID_TYPE:
                    //TODO: Add the error thing
                    throw new UnsupportedOperationException("Component: Create error mechanism for invalid type");
                case INVALID_VALUE:
                    throw new UnsupportedOperationException("Component: Create error mechanism for invalid value");
            }
        }
    }


    private void verifyAndAddConnectionParams(Connection connection) {
        for(String key : paramsHashmap.keySet()){
            TechEntity entity = techLibrary.getMINTEntity("CHANNEL");
            if(null == entity){
                throw new UnsupportedOperationException("Connection: Could not find the channel entity file");
            }
            TechEntity.ParamVerification verification = entity.verifyParam(key, paramsHashmap.get(key));
            switch (verification){
                case VALID:
                    connection.addParam(key, paramsHashmap.get(key));
                    break;
                case INVALID_NAME:
                    //TODO: Add the error thing
                    throw new UnsupportedOperationException("Connection: Create error mechanism for invalid names");
                case INVALID_TYPE:
                    //TODO: Add the error thing
                    throw new UnsupportedOperationException("Connection: Create error mechanism for invalid type");
                case INVALID_VALUE:
                    throw new UnsupportedOperationException("Connection: Create error mechanism for invalid value");
            }


        }
    }



}
