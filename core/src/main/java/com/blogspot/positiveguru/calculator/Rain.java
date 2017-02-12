package com.blogspot.positiveguru.calculator;

import java.util.ArrayList;

public class Rain {
    private int count;
    private ArrayList<Integer> rainHeight;

    public Rain(int count, ArrayList<Integer> rainHeight) {
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
