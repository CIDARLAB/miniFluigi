package org.cidarlab.fluigi.manufacturing;

import java.util.UUID;

public class Feature {

    private final String id;
    private String referenceid;

    public Feature(){
        this.id = UUID.randomUUID().toString();
    }

    public Feature(String reference){
        this();
        this.referenceid = reference;
    }


}
