package com.renanpalmeira.spring.controller;

import java.util.*;
import java.io.IOException;

import org.springframework.hateoas.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renanpalmeira.spring.resource.Timeline;
import com.renanpalmeira.spring.resource.Repository;
import com.renanpalmeira.spring.repository.GithubRepository;

@RestController
public class TimelineController {

    @RequestMapping("/projects")
    Resources<Resource> getProjects() throws IOException {

        GithubRepository github = new GithubRepository();
        List<Repository> repos = github.getRepository();

        List<Resource> resources = new ArrayList<Resource>();

        for(Repository repo : repos) {
            resources.add(new Resource<Repository>(repo, new Link(repo.getUrl())));
        }

        Link link = new Link("http://example.com/products/1");
        return new Resources<Resource>(
            resources,
            link
        );
    }

    /**
     * @see http://stackoverflow.com/questions/25858698/spring-hateoas-embedded-resource-support
     */
    @RequestMapping("/timelines")
    Resources<Resource<Timeline>> getAllTimeline() {

        Timeline firstTimeline = new Timeline("Step 1");
        Timeline secondTimeline = new Timeline("Step 2");

        Resource<Timeline> resource1 = new Resource<>(firstTimeline, new Link("http://example.com/products/1"));
        Resource<Timeline> resource2 = new Resource<>(secondTimeline, new Link("http://example.com/products/2"));

        Link link = new Link("http://example.com/products/1");
        Resources<Resource<Timeline>> resources = new Resources<>(Arrays.asList(resource1, resource2), link);

        return resources;
    }
}