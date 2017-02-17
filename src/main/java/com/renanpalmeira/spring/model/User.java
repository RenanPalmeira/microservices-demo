package com.renanpalmeira.spring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Getter
    @Setter
    private String name;

    @Getter
    @JsonProperty("repos_url")
    private String reposUrl;
}