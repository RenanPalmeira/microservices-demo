package com.renanpalmeira.spring.resource;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

@Relation(collectionRelation = "timeline")
public class Timeline extends ResourceSupport {
    private final String content;

    public Timeline(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}