package com.renanpalmeira.spring.controller;

import java.util.*;
import java.io.IOException;

import org.springframework.hateoas.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import com.renanpalmeira.spring.model.Project;
import com.renanpalmeira.spring.service.ProjectService;
import com.renanpalmeira.spring.resource.ProjectResource;
import com.renanpalmeira.spring.resource.ProjectResourceAssembler;

@RestController
public class ProjectController {

    private ProjectService projectService = new ProjectService();
    private ProjectResourceAssembler assembler = new ProjectResourceAssembler();

    /**
     * @see http://stackoverflow.com/questions/25858698/spring-hateoas-embedded-resource-support
     */
    @RequestMapping(value = "/projects", produces = MediaType.APPLICATION_JSON_VALUE)
    Resources<ProjectResource> getProjects() throws IOException {

        Iterable<Project> projects = this.projectService.findAll();

        List<ProjectResource> resources = this.assembler.toResources(projects);

        return new Resources<ProjectResource>(
            resources
        );
    }
}