package com.renanpalmeira.finance.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Map<String, Object> model) {
        model.put("mustache", "this.message");
        return "index";
    }
}