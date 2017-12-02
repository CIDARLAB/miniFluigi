package org.cidarlab.fluigi.manufacturing;

import java.util.HashMap;

/**
 * The Feature library is a class holds the information about all the features that are associated with every component
 * that is in the application library
 */
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

    /**
     * Add FeatureEntity to the feature library
     * @param featureEntity
     */
    public void addEntity(FeatureEntity featureEntity) {
        this.entityHashMap.put(featureEntity.getMINTName(), featureEntity);
    }

    /**
     * Returns the Feature entity assocociate with the mint name
     * @param mintname
     * @return
     */
    public FeatureEntity getMINTEntity(String mintname){
        return this.entityHashMap.get(mintname);
    }
}
