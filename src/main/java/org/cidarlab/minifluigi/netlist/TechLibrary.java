package org.cidarlab.minifluigi.netlist;

import java.util.HashMap;

/**
 * Created by krishna on 3/7/17.
 */
public class TechLibrary {

    private HashMap<String, TechEntity> library;
    private HashMap<String, TechEntity> mintlibrary;
    private final String techLibraryName;

    public TechLibrary(String libraryname){
        this.techLibraryName = libraryname;
        library = new HashMap<>();
        mintlibrary = new HashMap<>();
    }

    public void addEntity(TechEntity entity){
        library.put(entity.getName(), entity);
        mintlibrary.put(entity.getMINTName(), entity);
    }

    public TechEntity getEntity(String entityname) {
        if(!library.containsKey(entityname)) {
            return null;
        }
        return library.get(entityname);
    }

    public TechEntity getMINTEntity(String entityname) {

        //This is because of antlr's thing and because I cant figure out how to make a good grammar
        for(String key: mintlibrary.keySet()){
            String keywithoutspaces = key.replaceAll("\\s+","");
            if(keywithoutspaces.equals(entityname)) {
                return mintlibrary.get(key);
            }

        }

        return null;

    }
}
