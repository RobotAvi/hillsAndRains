package com.blogspot.positiveguru.calculator;

import java.util.ArrayList;

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
