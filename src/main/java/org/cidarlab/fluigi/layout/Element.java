package org.cidarlab.fluigi.layout;

/**
 * Created by krishna on 7/25/17.
 *
 * The element is the fundamental primitive that makes up each of the layout cells i.e. straight lines on each
 * of the sides. This will only be used for the layout intersection and validation schemes. DRC will have a different
 * set of elements that will become the fundamental primitives for checking the spacings, etc. Essentially we map a
 * given device in different ways in each of the stages. Placement - like a rectangle , Routing - thin rectangles,
 * DRC - whatever we deem fit for effective DRC.
 */
public class Element {
    int startx;
    int starty;
    int endx;
    int endy;
}
