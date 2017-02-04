package com.renanpalmeira.spring.resource;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.renanpalmeira.spring.model.Project;
import com.renanpalmeira.spring.resource.ProjectResource;
import com.renanpalmeira.spring.controller.ProjectController;

public class ProjectResourceAssembler extends ResourceAssemblerSupport<Project, ProjectResource> {

    public ProjectResourceAssembler() {
        super(ProjectController.class, ProjectResource.class);
    }

    @Override
    public ProjectResource toResource(Project project) {
        ProjectResource resource = instantiateResource(project);
        resource.setName(project.getName());
        resource.setLanguage(project.getLanguage());
        resource.add(new Link(project.getHtmlUrl()));

        return resource;
    }
}