package com.renanpalmeira.spring.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.core.Relation;

@Relation(collectionRelation = "repository")
public class Repository {   
    private String name;
    private String language;
    private String html_url;
    
    public Repository(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    @JsonIgnore
    public String getUrl() {
        return html_url;
    }
}