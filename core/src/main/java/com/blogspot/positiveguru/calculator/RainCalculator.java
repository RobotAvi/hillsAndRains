package com.blogspot.positiveguru.calculator;

import java.util.ArrayList;
import java.util.Arrays;

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
        int[] rainHeight = new int[hills.size()];

        while (left < right) {
            if (hills.get(left) > leftMax) {
                leftMax = hills.get(left);
            }
            if (hills.get(right) > rightMax) {
                rightMax = hills.get(right);
            }
            if (leftMax >= rightMax) {
                rainHeight[right] = rightMax - hills.get(right);
                rainCount += rainHeight[right];
                right--;
            } else {
                rainHeight[left] = leftMax - hills.get(left);
                rainCount += rainHeight[left];
                left++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.stream(rainHeight).forEach(list::add);
        return new Rain(rainCount, list);
    }
}
