package org.cidarlab.fluigi.manufacturing;

import org.cidarlab.fluigi.model.Device;

import java.util.List;

public class FeatureMapper {

    private final Device device;

    public FeatureMapper(Device device){
        this.device = device;
    }

    public List<Feature> generateFeatureList(){
        //TODO: Implement following algorithm
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

        throw new UnsupportedOperationException("Implement method to generate the list of mapped features");
    }
}
