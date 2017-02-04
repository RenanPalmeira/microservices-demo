package com.renanpalmeira.spring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
    @Getter
    @Setter
    private Long id;

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