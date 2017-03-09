package org.cidarlab.minifluigi.place;

import org.cidarlab.minifluigi.layout.Placement;
import org.cidarlab.minifluigi.netlist.Device;

/**
 * Created by krishna on 3/9/17.
 */
public interface Annotator {

     void annotatePlacement(Placement placement, Device device);
}
