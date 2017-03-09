package org.cidarlab.minifluigi.netlist;

import java.util.ArrayList;

/**
 * Created by krishna on 3/8/17.
 */
public class Composite extends Component {

    ArrayList<Component> components;
    ArrayList<Connection> connections;

    public Composite(String id) {
        super(id);
        this.type = ComponentType.COMPOSITE;
        components = new ArrayList<>();
        connections = new ArrayList<>();
    }


}
