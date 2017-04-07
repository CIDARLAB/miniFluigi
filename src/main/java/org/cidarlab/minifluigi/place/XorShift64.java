/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.minifluigi.place;

import java.util.Random;

/**
 *
 * @author krishna
 */
public class XorShift64 extends Random {

    private long x;
    private double randdouble;
    static final double maxvalue = Long.MAX_VALUE/1.0;

    public XorShift64() {
        x = System.nanoTime();
    }

    public XorShift64(long seed) {
        this.x = seed;
    }

    public long xorshift() {
        x ^= (x << 21);
        x ^= (x >>> 35);
        x ^= (x << 4);
        return x;
    }

    @Override
    public int next(int bits) {
        return (int) (xorshift() >>> (Long.SIZE - bits));
    }

    @Override
    public long nextLong() {
        return xorshift();
    }
    
    @Override
    public double nextDouble() {
        xorshift();
        randdouble = x/maxvalue;
        if(randdouble<0){
           return randdouble*=-1;
        } else {
            return randdouble;
        }
    }

    @Override
    public void setSeed(long seed) {
        x = seed;
    }
}
