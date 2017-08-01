package com.evolveback.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by mithun on 7/31/17.
 */

@Controller
public class HomeController {

    @RequestMapping(value ="/", method = GET)
    private String home() {

        return "index";
    }
}
