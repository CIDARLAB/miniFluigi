package org.cidarlab.fluigi.layout.PlacementCellMapper;

import org.cidarlab.fluigi.layout.Placement;
import org.cidarlab.fluigi.model.Device;

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

    /**
     * Applies the placement information to the device associated with the cell mapper
     * @param placement
     */
    public abstract void importLayout(Placement placement);

    /**
     * Generate the Placement objects that are associated with the device.
     * @return
     */
    public abstract List<Placement> generateLayouts();

}
