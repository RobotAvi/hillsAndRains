package com.blogspot.positiveguru;

import com.blogspot.positiveguru.calculator.RainCalculator;
import com.blogspot.positiveguru.model.Hills;
import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Test correct count calculating of rain
 */

public class RainControllerWaterCountTest {

    String[] sa = new String[]{"4,1,5",
            "5,1,4",
            "1,5,1,4",
            "5,1,4,1",
            "2,1,5,1,4",
            "5,1,4,1,2",
            "2,1,5,1,4,1,2",
            "3,2,4,1,2",
            "4,1,1,0,2,3"
    };
    int[] st = new int[]{3, 3, 3, 3, 4, 4, 5, 2, 8};

    @Test
    public void testCounts() {

        Hills hills = new Hills();

        for (int i = 0; i < sa.length; i++) {
            System.out.println(sa[i]);
            hills.setHillsHeights(sa[i]);
            Assert.assertEquals(RainCalculator.calculateRain(hills.getHillsArray()).getCount(), st[i]);
        }
    }


}
