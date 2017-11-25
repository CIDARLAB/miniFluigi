package org.cidarlab.fluigi.layout;

import org.cidarlab.fluigi.model.Device;

import java.util.List;

public class ObstacleMapMapper {

    private final Device layout;

    public ObstacleMapMapper(Device layout){
        this.layout = layout;
    }

    public ObstacleMap generateObstacleMap(){
        throw new UnsupportedOperationException("Implement method to get obstacle map");
    }


}
