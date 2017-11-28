package org.cidarlab.fluigi.manufacturing;

import java.awt.*;

public class Draw {

    public void draw (String macroname, Graphics2D canvas){
        switch (macroname){
            case "Port":
                drawPort(canvas);
                break;
            case "Mixer":
                drawMixer(canvas);
                break;
            default:
                throw new UnsupportedOperationException("Need to implement the drawfunction");
        }
    }

    private void drawMixer(Graphics2D canvas) {
        throw new UnsupportedOperationException();
    }

    private void drawPort(Graphics2D canvas) {
        throw new UnsupportedOperationException();


    }

}
