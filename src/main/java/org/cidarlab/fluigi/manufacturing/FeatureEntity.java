package org.cidarlab.fluigi.manufacturing;

import org.cidarlab.fluigi.model.Component;
import org.cidarlab.fluigi.model.LayerBlock;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;

public class FeatureEntity {
    private String name;
    private String mintname;

    /**
     * Imports the feature from a json object
     * @param featurejson
     */
    public void importFromJSON(JSONObject featurejson) {
        this.name = (String) featurejson.get("name");
        this.mintname = (String) featurejson.get("mint");
        //TODO: Need to implement the full feature import functionality
    }

    /**
     * Returns the name of the feature that is being
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the mint name of the feature
     * @return
     */
    public String getMINTName() {
        return mintname;
    }

    /**
     * Returns the list of component feature for the specified layerblock
     * TODO: Change definition to accept a list of logical layers for which the feature generator will send out the cooresponding features
     * @param layerblock
     * @param params
     * @return
     */
    public List<Feature> getComponentFeatures(LayerBlock layerblock, HashMap<String, Object> params) {
        throw new UnsupportedOperationException("Implement method to get the component feature");
    }

    /**
     * Returns the connection features for the
     * TODO: Change definition to accept a list of logical layers for which the feature generator will send out the cooresponding features
     * @param layerblock
     * @param params
     * @param intersectingcomponent
     * @return
     */
    public List<Feature> getConnectionFeatures(LayerBlock layerblock, HashMap<String, Object> params, Component intersectingcomponent) {

        if(null == intersectingcomponent){
            //This is simpler if there is no intersecting component
        }else{
            //This becomes more complicated
            //TODO: Figure out how connect intersecting component, this is only necessary if there is any feature in
            //TODO: the flow layer
        }
        throw new UnsupportedOperationException("Implemetnt method to get the connection features");
    }
}
