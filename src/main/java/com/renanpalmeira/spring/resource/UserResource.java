package com.renanpalmeira.spring.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

@Relation(collectionRelation = "user")
public class UserResource extends ResourceSupport {
    @Getter
    @Setter
    private String name;
}