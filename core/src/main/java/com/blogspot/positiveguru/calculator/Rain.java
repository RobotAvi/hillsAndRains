package com.blogspot.positiveguru.calculator;

import java.util.ArrayList;

/*This class created for collecting information of water
 * that was filled between hills.
 * <p>It contains 2 variables and getters/setters for them
 * <p> Count - is sum of all water
 * <p> rainHeight - is List of water levels. number of
 * element in array is the same as on histogram*/

public class Rain {

    private int count;
    private ArrayList<Integer> rainHeight;

    Rain(int count, ArrayList<Integer> rainHeight) {
        this.count = count;
        this.rainHeight = rainHeight;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Integer> getRainHeight() {
        return rainHeight;
    }

    public void setRainHeight(ArrayList<Integer> rainHeight) {
        this.rainHeight = rainHeight;
    }
}
