package com.blogspot.positiveguru.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/*Model. model with hills and rain heights*/


@Component
public class Hills {

    private ArrayList<Integer> hillsArray;
    private ArrayList<Integer> rainArray;
    private int rainCount;
    private String hillsHeights;
    private List<String> histogramHeights;

    /*Generates jstl String for foreach in index.jsp histogram
    * TODO:Must be moved to view*/
    public List<String> getHistogramHeights() {
        if (rainArray.size() > 0 && hillsArray.size() > 0) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < hillsArray.size(); i++) {
                sb.setLength(0);
                sb.append("'");
                sb.append(hillsArray.get(i));
                sb.append("','");
                sb.append(rainArray.get(i));
                sb.append("'");

                histogramHeights.add(sb.toString());
            }
        }
        return histogramHeights;
    }

    public void setHistogramHeights(List<String> histogramHeights) {
        this.histogramHeights = histogramHeights;
    }

    public String getHillsHeights() {
        return hillsHeights;
    }

    /*Set height that was taken from user.
    TODO: Functional must be moved to controller*/
    public void setHillsHeights(String hillsHeights) {
        this.hillsHeights = hillsHeights;
        for (String hillHeight : hillsHeights.split(",")) {
            this.hillsArray.clear();
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
