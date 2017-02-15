package com.blogspot.positiveguru.model;

import com.blogspot.positiveguru.calculator.Rain;
import com.blogspot.positiveguru.calculator.RainCalculator;
import javax.validation.constraints.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/*Model. model with hills and rain heights*/


@Component
public class Hills {

    private ArrayList<Integer> hillsArray = new ArrayList<>();
    private ArrayList<Integer> rainArray = new ArrayList<>();
    private int rainCount = 0;

    @NotNull
    @Pattern(regexp = "[0-9]+", message = "invalid.amount")
    private String hillsHeights = "";
    private ArrayList<String> histogramHeights = new ArrayList<>();

    /*Generates jstl String for foreach in index.jsp histogram
    */
    public ArrayList<String> getHistogramHeights() {
        Rain rain = RainCalculator.calculateRain(this.getHillsArray());
        this.setRainArray(rain.getRainHeight());
        this.setRainCount(rain.getCount());

        if (rainArray.size() > 0 && hillsArray.size() > 0) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < hillsArray.size(); i++) {
                sb.setLength(0);
                sb.append("['");
                sb.append(hillsArray.get(i));
                sb.append("/");
                sb.append(rainArray.get(i));
                sb.append("', ");
                sb.append(hillsArray.get(i));
                sb.append(", ");
                sb.append(rainArray.get(i));
                sb.append("]");
                if (i != hillsArray.size() - 1) sb.append(",");
                histogramHeights.add(sb.toString());
            }
        }
        return histogramHeights;
    }

    public void setHistogramHeights(ArrayList<String> histogramHeights) {
        this.histogramHeights = histogramHeights;
    }

    public String getHillsHeights() {
        return hillsHeights;
    }

    /*Set height that was taken from user.
    @param  hillsHeights is String like 1,2,3,5,6,7*/
    public void setHillsHeights(String hillsHeights) {
        this.hillsHeights = hillsHeights;
        this.hillsArray.clear();

        for (String hillHeight : hillsHeights.split(",")) {
            this.hillsArray.add(Integer.valueOf(hillHeight));
        }
    }


    public ArrayList<Integer> getHillsArray() {
        return hillsArray;
    }

    public void setHillsArray(ArrayList<Integer> hillsArray) {
        this.hillsArray = hillsArray;
    }

    public ArrayList<Integer> getRainArray() {
        return rainArray;
    }

    public void setRainArray(ArrayList<Integer> rainArray) {
        this.rainArray = rainArray;
    }

    public int getRainCount() {
        return rainCount;
    }

    public void setRainCount(int rainCount) {
        this.rainCount = rainCount;
    }

}
