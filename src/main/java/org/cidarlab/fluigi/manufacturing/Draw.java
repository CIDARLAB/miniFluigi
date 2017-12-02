package org.cidarlab.fluigi.manufacturing;

import java.awt.*;
import java.util.HashMap;

public class Draw {

    private HashMap<String, Object> drawparams;

    public void draw(String macroname, Graphics2D canvas, HashMap<String, Object> params){
        this.drawparams = params;
        switch (macroname){
            case "Port":
                drawPort(canvas);
                break;
            case "Mixer":
                drawMixer(canvas);
                break;
            default:
                drawDummyComponent(canvas);
        }
    }

    private void drawMixer(Graphics2D canvas) {
        drawDummyComponent(canvas);
    }

    private void drawPort(Graphics2D canvas) {
        drawDummyComponent(canvas);

    }

    private void drawDummyComponent(Graphics2D canvas){
        //TODO: Draw dummy component
        throw new UnsupportedOperationException("Figure out dummy draw");
    }

}
