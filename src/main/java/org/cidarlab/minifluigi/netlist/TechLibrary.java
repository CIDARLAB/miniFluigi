package org.cidarlab.minifluigi.netlist;

import java.util.HashMap;

/**
 * Created by krishna on 3/7/17.
 */
public class TechLibrary {

    private HashMap<String, TechEntity> library;
    private final String techLibrary;

    public TechLibrary(String libraryname){
        this.techLibrary = libraryname;
        library = new HashMap<>();
    }

    public void addEntity(TechEntity entity){
        library.put(entity.getName(), entity);
    }

}
