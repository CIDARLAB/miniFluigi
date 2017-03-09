package org.cidarlab.minifluigi.place.naive;

import org.cidarlab.minifluigi.layout.Cell;
import org.cidarlab.minifluigi.layout.Placement;
import org.cidarlab.minifluigi.netlist.Component;
import org.cidarlab.minifluigi.netlist.Device;
import org.cidarlab.minifluigi.place.Annotator;

/**
 * Created by krishna on 3/9/17.
 */
public class NaiveAnnotator implements Annotator {
    @Override
    public void annotatePlacement(Placement placement, Device device) {
        Cell celltoannotate;
        for (Component c : device.getComponents()){
            if(c.getTechnology().equals("Port") ||
                    c.getTechnology().equals("PortBank") ||
                    c.getTechnology().equals("TDroplet") ||
                    c.getTechnology().equals("FFDroplet")
                    ){
                //Check if placement has the component first
                celltoannotate = placement.getCell(c.getId());
                if(null==celltoannotate){continue;} //Skip this annotation because the placement does not contain it
                placement.getCell(c.getId()).addAnnotation("isterminalcomponent", true);
            }
        }
    }
}
