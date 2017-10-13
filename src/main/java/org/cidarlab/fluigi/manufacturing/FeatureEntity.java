package org.cidarlab.fluigi.manufacturing;

import org.cidarlab.fluigi.model.Component;
import org.cidarlab.fluigi.model.LayerBlock;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;

public class FeatureEntity {
    private String name;
    private String mintname;

    public void importFromJSON(JSONObject featurejson) {
        this.name = (String) featurejson.get("name");
        this.mintname = (String) featurejson.get("mint");

    }

    public String getName() {
        return name;
    }

    public String getMINTName() {
        return mintname;
    }

    public List<Feature> getComponentFeatures(LayerBlock layerblock, HashMap<String, Object> params) {
        throw new UnsupportedOperationException("Implement method to get the component feature");
    }

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
