package org.cidarlab.fluigi.manufacturing;

import java.util.ArrayList;
import java.util.List;

public class DrawLayer {
    List<Feature> featureslist;

    public DrawLayer(){
        featureslist = new ArrayList<>();
    }

    public void addFeature(Feature feature){
        featureslist.add(feature);
    }

    public List<Feature> getFeatures() {
        return featureslist;
    }
}
