package com.renanpalmeira.graphql.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.hateoas.Resources;
import org.springframework.cloud.netflix.feign.FeignClient;

import com.renanpalmeira.graphql.model.Activity;

@FeignClient(url="http://localhost:8081", name="example")
public interface ActivityClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/activity")
    Activity getActivity();
}