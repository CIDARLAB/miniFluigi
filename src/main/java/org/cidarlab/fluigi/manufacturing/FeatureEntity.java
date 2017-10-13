package org.cidarlab.fluigi.manufacturing;

import org.json.simple.JSONObject;

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
}
