package com.renanpalmeira.graphql.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import com.renanpalmeira.graphql.model.Activity;
import com.renanpalmeira.graphql.client.ActivityClient;

@RestController
class ActivityController {

    private final ActivityClient activityClient;

    ActivityController(ActivityClient activityClient) {
        this.activityClient = activityClient;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/")
    public HttpEntity<Activity> index() {
        return new ResponseEntity(
            activityClient.getActivity(),
            HttpStatus.OK
        );
    }

    public HttpEntity<Activity> fallback(){
        return new ResponseEntity(
            new ArrayList<>(),
            HttpStatus.OK
        );
    }
}