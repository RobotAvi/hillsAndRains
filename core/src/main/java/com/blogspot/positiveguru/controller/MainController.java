package com.blogspot.positiveguru.controller;


import com.blogspot.positiveguru.calculator.Rain;
import com.blogspot.positiveguru.calculator.RainCalculator;
import com.blogspot.positiveguru.model.Hills;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*This class is just controller (MVC)
* It will get requests with mappings and will recreate model
* for rebuilding histogram with hills and waiter*/

@Controller
public class MainController {

    /*Start point. It will ask for values of hills heights.*/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hills", new Hills());
        modelAndView.setViewName("index");

        return modelAndView;
    }

    /*The same as index, but will create histogram with water and hills*/
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
