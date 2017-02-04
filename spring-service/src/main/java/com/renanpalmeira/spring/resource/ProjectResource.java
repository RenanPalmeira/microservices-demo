package com.renanpalmeira.spring.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

@Relation(collectionRelation = "project")
public class ProjectResource extends ResourceSupport {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String language;
}