package org.cidarlab.fluigi.netlist.technology;

import com.sun.istack.internal.NotNull;
import org.cidarlab.fluigi.layout.Point;

/**
 * Created by krishna on 8/24/17.
 */
public class TechTerminal extends Point{

    private final String label;
    private String labelexpression;
    private String xposexpression;
    private String yposexpression;
    private String layer;
    private String start;
    private String end;

    public TechTerminal(String label) {
        super();
        this.label = label;
    }

    @NotNull
    public String getXposexpression() {
        return xposexpression;
    }

    public void setXposexpression(@NotNull String xposexpression) {
        this.xposexpression = xposexpression;
    }

    @NotNull
    public String getYposexpression() {
        return yposexpression;
    }

    public void setYposexpression(@NotNull String yposexpression) {
        this.yposexpression = yposexpression;
    }

    public void setLayer(@NotNull String layer) {
        this.layer = layer;
    }

    @NotNull
    public String getLabel() {
        return label;
    }

    @NotNull
    public String getLayer() {
        return layer;
    }

    @NotNull
    public String getStart() {
        return start;
    }

    @NotNull
    public String getEnd() { return end; }

    public void setStart(@NotNull String start) {
        this.start = start;
    }

    public void setEnd(@NotNull String end){
        this.end = end;
    }

    @NotNull
    public String getLabelexpression() {
        return labelexpression;
    }

    public void setLabelexpression(@NotNull String labelexpression) {
        this.labelexpression = labelexpression;
    }
}
