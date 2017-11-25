/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.fluigi.route.hadlock;

/**
 *
 * @author krishna
 */
public class GridUtil {
    private static final long N = Integer.MAX_VALUE;

    /**
     *
     * @param x the value of x
     * @param y the value of y
     * @return the long
     */
    public static long hash(int x, int y) {
        return x + (y * N);
    }

    /**
     *
     * @param hash the value of hash
     * @return the int
     */
    public static int decodeY(long hash) {
        return (int) (hash / N);
    }

    /**
     *
     * @param hash the value of hash
     * @return the int
     */
    public static int decodeX(long hash) {
        return (int) (hash % N);
    }
    
}
