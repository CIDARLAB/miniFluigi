package org.cidarlab.fluigi.netlist;

import java.util.ArrayList;

public class LayerBlock {
    String id;

    private LogicalLayer flowLayer;
    private LogicalLayer controlLayer;
    private LogicalLayer integrationLayer;

    public boolean hasControl(){
        return (null == controlLayer);
    }

    public boolean hasIntegration(){
        return (null == integrationLayer);
    }

    public LayerBlock(String id){
        this.id = id;
    }

    public LogicalLayer getFlowLayer() {
        return flowLayer;
    }

    public void setFlowLayer(LogicalLayer flowLayer) {
        this.flowLayer = flowLayer;
    }

    public LogicalLayer getControlLayer() {
        return controlLayer;
    }

    public void setControlLayer(LogicalLayer controlLayer) {
        this.controlLayer = controlLayer;
    }

    public LogicalLayer getIntegrationLayer() {
        return integrationLayer;
    }

    public void setIntegrationLayer(LogicalLayer integrationLayer) {
        this.integrationLayer = integrationLayer;
    }
}
