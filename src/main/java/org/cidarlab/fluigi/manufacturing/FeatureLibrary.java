package org.cidarlab.fluigi.manufacturing;

import com.sun.istack.internal.NotNull;

import java.util.HashMap;

public class FeatureLibrary {

    /**
     * Singleton Instance of the feature library
     */
    public static FeatureLibrary instance;
    private final String name;
    private HashMap<String, FeatureEntity> entityHashMap;

    public FeatureLibrary(@NotNull String libraryname){
        this.name = libraryname;
        this.entityHashMap = new HashMap<>();
    }

    public void addEntity(@NotNull FeatureEntity featureEntity) {
        this.entityHashMap.put(featureEntity.getMINTName(), featureEntity);
    }

    public FeatureEntity getMINTEntity(@NotNull String mintname){
        return this.entityHashMap.get(mintname);
    }
}
