package org.cidarlab.fluigi.netlist.mintnetlistparser;

import org.cidarlab.fluigi.core.LibraryManager;
import org.cidarlab.fluigi.netlist.Device;
import org.cidarlab.fluigi.netlist.LayerBlock;
import org.cidarlab.fluigi.netlist.LogicalLayer;
import org.cidarlab.fluigi.netlist.TechLibrary;
import org.cidarlab.fluigi.netlist.mintgrammar.mintgrammarBaseListener;
import org.cidarlab.fluigi.netlist.mintgrammar.mintgrammarParser;

public class PartialMINTDeviceArchitectureParser extends mintgrammarBaseListener {
    Device device;
    LogicalLayer currentlayer;
    int layercount = 0;
    int layerblockcount = 0;
    LayerBlock currentLayerBlock;
    TechLibrary techLibrary = LibraryManager.techLibrary;

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
    public void exitImportStat(mintgrammarParser.ImportStatContext ctx) {
        super.exitImportStat(ctx);
        //TODO: Implement importing into the parser
        /**
         * ALG:
         * - Create a techentity for each of the imports and add them to the tech library
         * This way when the modules are created, we can use the same exact techlibrary matching
         */
        throw new UnsupportedOperationException("The v2 parser does not support importing of subdevices at the moment");
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
        if(null == currentLayerBlock.getControlLayer()){
            currentlayer = new LogicalLayer(Integer.toString(layercount++));
            device.addLayer(currentlayer);
            currentlayer.setLayerType(LogicalLayer.LogicalLayerType.CONTROL);
            currentLayerBlock.setControlLayer(currentlayer);
        }else {
            currentlayer = currentLayerBlock.getControlLayer();
        }
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
