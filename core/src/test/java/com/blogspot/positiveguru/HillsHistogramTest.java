package com.blogspot.positiveguru;

import com.blogspot.positiveguru.calculator.Rain;
import com.blogspot.positiveguru.calculator.RainCalculator;
import com.blogspot.positiveguru.model.Hills;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Test controllermethods
 */
public class HillsHistogramTest {

    static String[] sa;

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

    }

    @Test
    public void testJSPHistogram() {
        Hills hills = new Hills();
        Rain r;
        for (String variant : sa) {
            hills.setHillsHeights(variant);
            r = RainCalculator.calculateRain(hills.getHillsArray());
            hills.setRainArray(r.getRainHeight());
            hills.setRainCount(r.getCount());
            hills.getHistogramHeights().forEach(System.out::println);

        }

    }


}
