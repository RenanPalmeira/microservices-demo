package com.renanpalmeira.jinjava.controller;

import com.hubspot.jinjava.Jinjava;
import com.renanpalmeira.jinjava.service.RenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private RenderService renderService;

    @RequestMapping("/")
    @ResponseBody
    String index() throws IOException {

        String token = ""; // if exists
        String params = ""; // if exists

        /**
         * entity.field
         * the entities are written in domain.GithubEndpoints
         */
        String template = "<div>Hello, {{ user.name }}!</div>";

        Map<String, Object> variables = renderService.getVariables(token, params, template);

        Jinjava jinjava = new Jinjava();
        return jinjava.render(template, variables);
    }
}
