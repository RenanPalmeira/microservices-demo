package com.renanpalmeira.spring.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.hateoas.core.Relation;

@ToString
@Relation(collectionRelation = "repository")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String language;

    @Getter
    @JsonProperty("html_url")
    private String htmlUrl;
}