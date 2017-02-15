package com.blogspot.positiveguru;

import com.blogspot.positiveguru.calculator.Rain;
import com.blogspot.positiveguru.calculator.RainCalculator;
import com.blogspot.positiveguru.model.Hills;

/**
 * Console version of app
 */
class Console {
    public static void main(String[] args) {
        Hills hills = new Hills();
        hills.setHillsHeights("4,1,1,0,2,3");
        System.out.println(RainCalculator.calculateRain(hills.getHillsArray()).getCount());
    }
}
