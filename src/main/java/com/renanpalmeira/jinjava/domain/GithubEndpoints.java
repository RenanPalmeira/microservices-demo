package com.renanpalmeira.jinjava.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum GithubEndpoints {
    USER("/users/renanpalmeira");

    @Getter
    private String url = null;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}