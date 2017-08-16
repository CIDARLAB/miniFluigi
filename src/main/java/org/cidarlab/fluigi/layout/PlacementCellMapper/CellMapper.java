package org.cidarlab.fluigi.layout.PlacementCellMapper;

import org.cidarlab.fluigi.layout.Placement;
import org.cidarlab.fluigi.netlist.Device;

import java.util.List;

/**
 * Created by krishna on 7/24/17.
 */
public abstract class CellMapper {

    protected Device device;

    public CellMapper(Device device){
        this.device = device;
    }

    public abstract Placement generateLayout();

    public abstract void importLayout(Placement placement);

    public abstract List<Placement> generateLayouts();

}
