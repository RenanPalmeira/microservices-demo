package com.renanpalmeira.jinjava.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class GithubEndpoints {
    USER("/users/list/");

    @Getter
    private String url = null;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}