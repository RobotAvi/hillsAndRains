package com.blogspot.positiveguru.controller;


import com.blogspot.positiveguru.calculator.Rain;
import com.blogspot.positiveguru.calculator.RainCalculator;
import com.blogspot.positiveguru.model.Hills;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hills", new Hills());
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @RequestMapping(value = "/getWater")
    public ModelAndView getWater(@ModelAttribute("hills") Hills hills) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        Rain rain = RainCalculator.calculateRain(hills.getHillsArray());
        hills.setRainArray(rain.getRainHeight());
        hills.setRainCount(rain.getCount());


        modelAndView.addObject("hills", hills);
        return modelAndView;

    }
}
