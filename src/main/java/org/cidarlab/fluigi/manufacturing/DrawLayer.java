package org.cidarlab.fluigi.manufacturing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DrawLayer {
    List<Feature> featureslist;

    HashMap<String, Object> params;

    public DrawLayer(){
        featureslist = new ArrayList<>();
    }

    public void addFeature(Feature feature){
        featureslist.add(feature);
    }

    public List<Feature> getFeatures() {
        return featureslist;
    }

    public Object getParam(String key) {
        return params.get(key);
    }
}
