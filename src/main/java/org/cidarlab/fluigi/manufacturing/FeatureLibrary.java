package org.cidarlab.fluigi.manufacturing;

import java.util.HashMap;

public class FeatureLibrary {

    /**
     * Singleton Instance of the feature library
     */
    public static FeatureLibrary instance;
    private final String name;
    private HashMap<String, FeatureEntity> entityHashMap;

    public FeatureLibrary(String libraryname){
        this.name = libraryname;
        this.entityHashMap = new HashMap<>();
    }

    public void addEntity(FeatureEntity featureEntity) {
        this.entityHashMap.put(featureEntity.getMINTName(), featureEntity);
    }

    public FeatureEntity getMINTEntity(String mintname){
        return this.entityHashMap.get(mintname);
    }
}
