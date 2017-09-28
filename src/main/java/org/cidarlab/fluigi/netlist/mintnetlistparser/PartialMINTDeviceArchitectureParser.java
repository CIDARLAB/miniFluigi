package org.cidarlab.fluigi.netlist.mintnetlistparser;

import org.cidarlab.fluigi.netlist.Device;
import org.cidarlab.fluigi.netlist.LayerBlock;
import org.cidarlab.fluigi.netlist.LogicalLayer;
import org.cidarlab.fluigi.netlist.mintgrammar.mintgrammarBaseListener;
import org.cidarlab.fluigi.netlist.mintgrammar.mintgrammarParser;

public class PartialMINTDeviceArchitectureParser extends mintgrammarBaseListener {
    Device device;
    LogicalLayer currentlayer;
    int layercount = 0;
    int layerblockcount = 0;
    LayerBlock currentLayerBlock;

    public PartialMINTDeviceArchitectureParser() {
        device = new Device();
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterNetlist(mintgrammarParser.NetlistContext ctx) {
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
    public void enterHeader(mintgrammarParser.HeaderContext ctx) {
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
    public void enterLayerBlock(mintgrammarParser.LayerBlockContext ctx) {
        currentLayerBlock = new LayerBlock(Integer.toString(layerblockcount++));
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitLayerBlock(mintgrammarParser.LayerBlockContext ctx) {
        device.addLayerBlock(currentLayerBlock);
        currentLayerBlock = null;
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterFlowBlock(mintgrammarParser.FlowBlockContext ctx) {
        currentlayer = new LogicalLayer(Integer.toString(layercount++));
        device.addLayer(currentlayer);
        currentlayer.setLayerType(LogicalLayer.LogicalLayerType.FLOW);
        currentLayerBlock.setFlowLayer(currentlayer);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterControlBlock(mintgrammarParser.ControlBlockContext ctx) {
        currentlayer = new LogicalLayer(Integer.toString(layercount++));
        device.addLayer(currentlayer);
        currentlayer.setLayerType(LogicalLayer.LogicalLayerType.CONTROL);
        currentLayerBlock.setControlLayer(currentlayer);
    }

    /**
     *
     * @param ctx
     */
    @Override
    public void enterIntegrationBlock(mintgrammarParser.IntegrationBlockContext ctx) {
        currentlayer = new LogicalLayer(Integer.toString(layercount++));
        device.addLayer(currentlayer);
        currentlayer.setLayerType(LogicalLayer.LogicalLayerType.EXT_INTEGRATION);
        currentLayerBlock.setIntegrationLayer(currentlayer);
    }

    public Device getDevice() {
        return device;
    }
}
