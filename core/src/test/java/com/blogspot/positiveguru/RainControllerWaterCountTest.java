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

    String[] sa;
    int[] st;

    @Before
    public void init() {
        ClassLoader classLoader = getClass().getClassLoader();

        //Load hills. First number is the size off massive
        File file = new File(classLoader.getResource("sa.txt").getFile());
        try (Scanner sc = new Scanner(file)) {

            int size = sc.nextInt();
            sa = new String[size];
            int i = 0;

            while (sc.hasNext()) {
                sa[i] = sc.next();
                i++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("ERROR can't find file:" + e);
        }


        //Load water count for test. First number is the size off massive

        file = new File(classLoader.getResource("st.txt").getFile());
        try (Scanner sc = new Scanner(file)) {

            int size = sc.nextInt();
            st = new int[size];
            int i = 0;

            while (sc.hasNext()) {
                st[i] = sc.nextInt();
                i++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("ERROR can't find file:" + e);
        }
    }


    @Test
    public void testCounts() {

        Hills hills = new Hills();

        for (int i = 0; i < sa.length; i++) {
            hills.setHillsHeights(sa[i]);
            Assert.assertEquals(RainCalculator.calculateRain(hills.getHillsArray()).getCount(), st[i]);
        }
    }


}
