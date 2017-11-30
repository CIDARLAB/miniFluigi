package org.cidarlab.fluigi.model;

public class LayerBlock {
    String id;

    private LogicalLayer flowLayer;
    private LogicalLayer controlLayer;
    private LogicalLayer integrationLayer;

    /**
     * Returns true if layer block sas a control layer
     * @return
     */
    public boolean hasControl(){
        return (null == controlLayer);
    }

    /**
     * Returns true if layer block has an integration layer
     * @return
     */
    public boolean hasIntegration(){
        return (null == integrationLayer);
    }

    public LayerBlock(String id){
        this.id = id;
    }

    /**
     * Returns Flow Layer associated with the layer block
     * @return
     */
    public LogicalLayer getFlowLayer() {
        return flowLayer;
    }

    /**
     * Sets Flow Layer associated with the layer block
     * @return
     */
    public void setFlowLayer(LogicalLayer flowLayer) {
        this.flowLayer = flowLayer;
    }

    /**
     * Returns Flow Layer associated with the layer block
     * @return
     */
    public LogicalLayer getControlLayer() {
        return controlLayer;
    }

    /**
     * Sets Flow Layer associated with the layer block
     * @return
     */
    public void setControlLayer(LogicalLayer controlLayer) {
        this.controlLayer = controlLayer;
    }

    /**
     * Returns Flow Layer associated with the layer block
     * @return
     */
    public LogicalLayer getIntegrationLayer() {
        return integrationLayer;
    }

    /**
     * Sets Flow Layer associated with the layer block
     * @return
     */
    public void setIntegrationLayer(LogicalLayer integrationLayer) {
        this.integrationLayer = integrationLayer;
    }
}
