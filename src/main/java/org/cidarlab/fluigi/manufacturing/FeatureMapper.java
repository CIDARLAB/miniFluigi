package org.cidarlab.fluigi.manufacturing;

import org.cidarlab.fluigi.model.*;

import java.util.ArrayList;
import java.util.List;

public class FeatureMapper {

    private final Device device;
    private FeatureLibrary featureLibrary;

    public FeatureMapper(Device device){
        this.device = device;
        this.featureLibrary = FeatureLibrary.instance;
    }

    public List<Feature> generateFeatureList(){
        //TODO: Implement following algorithm
        //TODO: Update the algorithm to take into account the new feature entity defintion and also associate the features with each draw layer
        /*
        Step 1: Get the layerblocks of the device
        Step 2: Get the respective featureEntity for the component
        Step 3: For each of the component get the features from the featureEntity
        Step 4: Map the component's features to the logicalLayers inside the layerblock
        Step 5: For each connection: Check if connection is part of a valvemap. If it is:
                Step 5.1: Create features from the source to the intersecting of the valve
                Step 5.2: Create features from the intersection of the valve to the target
        Step 6: return the total list of features
         */

        List<Feature> ret = new ArrayList<>();
        List<LayerBlock> layerblocks = device.getLayerBlocks();
        LogicalLayer flowlayer, controllayer;
        FeatureEntity featureEntity;
        List<Feature> featureList;
        for (LayerBlock block : layerblocks){

            flowlayer = block.getFlowLayer();
            controllayer = block.getControlLayer();
            //TODO: Include integration layer into this algorithm. There's a whole lot more I need to do there but this
            //TODO: will work for whats already defined.

            //Deal with the components of the flow layer
            for (Component component : flowlayer.getComponents()){
                featureEntity = featureLibrary.getMINTEntity(component.getTechnology());
                featureList = featureEntity.getComponentFeatures(
                        block,
                        component.getParams()
                );
                ret.addAll(featureList);
            }

            //Deal with the components of the control layer
            for (Component component : controllayer.getComponents()){
                featureEntity = featureLibrary.getMINTEntity(component.getTechnology());
                featureList = featureEntity.getComponentFeatures(
                        block,
                        component.getParams()
                );
                ret.addAll(featureList);
            }

            //Deal with the connections of the flow layer

            Component intersectingcomponent = null;

            for (Connection connection : flowlayer.getConnections()){



                intersectingcomponent = device.getValveComponent(connection);

                featureEntity = featureLibrary.getMINTEntity(connection.getTechnology());
                featureList = featureEntity.getConnectionFeatures(
                        block,
                        connection.getParams(),
                        intersectingcomponent
                );
                ret.addAll(featureList);
                intersectingcomponent = null;
            }

            //Now to finally deal with the control layer connections
            for (Connection connection : controllayer.getConnections()){
                featureEntity = featureLibrary.getMINTEntity(connection.getTechnology());
                featureList = featureEntity.getConnectionFeatures(
                        block,
                        connection.getParams(),
                        null
                );
                ret.addAll(featureList);
            }
        }

        return ret;
    }
}
