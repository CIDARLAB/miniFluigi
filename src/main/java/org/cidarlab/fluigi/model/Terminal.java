package org.cidarlab.fluigi.model;

import org.cidarlab.fluigi.layout.Point;

import java.util.HashMap;

/**
 * Created by krishna on 8/24/17.
 */
public class Terminal extends Point {
    private String label;
    private String layer;

    /**
     * Returns the label of the terminal
     * @return
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the label of the terminal
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Sets the X value of the terminal position relative to the component position
     * @param XOffSet
     */
    public void setXOffset(int XOffSet) {
        this.setX(XOffSet);
    }

    /**
     * Sets the logical layer to which the terminal belongs to
     * @param layer
     */
    public void setLayer(String layer) {
        this.layer = layer;
    }

    /**
     * Sets the Y value of the terminal position relative to the component position
     * @param YOffset
     */
    public void setYOffset(int YOffset) {
        this.setY(YOffset);
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * The {@code equals} method implements an equivalence relation
     * on non-null object references:
     * <ul>
     * <li>It is <i>reflexive</i>: for any non-null reference value
     * {@code x}, {@code x.equals(x)} should return
     * {@code true}.
     * <li>It is <i>symmetric</i>: for any non-null reference values
     * {@code x} and {@code y}, {@code x.equals(y)}
     * should return {@code true} if and only if
     * {@code y.equals(x)} returns {@code true}.
     * <li>It is <i>transitive</i>: for any non-null reference values
     * {@code x}, {@code y}, and {@code z}, if
     * {@code x.equals(y)} returns {@code true} and
     * {@code y.equals(z)} returns {@code true}, then
     * {@code x.equals(z)} should return {@code true}.
     * <li>It is <i>consistent</i>: for any non-null reference values
     * {@code x} and {@code y}, multiple invocations of
     * {@code x.equals(y)} consistently return {@code true}
     * or consistently return {@code false}, provided no
     * information used in {@code equals} comparisons on the
     * objects is modified.
     * <li>For any non-null reference value {@code x},
     * {@code x.equals(null)} should return {@code false}.
     * </ul>
     * <p>
     * The {@code equals} method for class {@code Object} implements
     * the most discriminating possible equivalence relation on objects;
     * that is, for any non-null reference values {@code x} and
     * {@code y}, this method returns {@code true} if and only
     * if {@code x} and {@code y} refer to the same object
     * ({@code x == y} has the value {@code true}).
     * <p>
     * Note that it is generally necessary to override the {@code hashCode}
     * method whenever this method is overridden, so as to maintain the
     * general contract for the {@code hashCode} method, which states
     * that equal objects must have equal hash codes.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     * @see #hashCode()
     * @see HashMap
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Terminal){
            return ((Terminal)obj).label.equals(this.label);
        }else{
            return false;
        }
    }
}
