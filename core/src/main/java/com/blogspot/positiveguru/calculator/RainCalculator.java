package com.blogspot.positiveguru.calculator;

import java.util.ArrayList;

/*This class created for calculating water between hills.
* Algorithm is to go from 2 sides.
* If left hill higher than right, so water will be on right level.
* Else water will be on right level.
* It's terrible algorithm because will not pass test with
* 5,2,3,4,1,2,1,4
* for example
* I will change it after adding tests
*
* It has ony 1 method for returning object Rain with water levels and sum*/
public class RainCalculator {


    public static Rain calculateRain(ArrayList<Integer> hills) {
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = hills.size() - 1;
        int rainCount = 0;
        ArrayList<Integer> rainHeight = new ArrayList<>();

        while (left < right)
        {
            if (hills.get(left) > leftMax) {
                leftMax = hills.get(left);
            }
            if (hills.get(right) > rightMax) {
                rightMax = hills.get(right);
            }
            if (leftMax >= rightMax) {
                rainHeight.add(right, rightMax - hills.get(right));
                rainCount += rainHeight.get(right);
                right--;
            } else {
                rainHeight.add(left, leftMax - hills.get(left));
                rainCount += rainHeight.get(left);
                left++;
            }
        }

        return new Rain(rainCount, rainHeight);
    }
}
