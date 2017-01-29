package com.renanpalmeira.spring.repository;

import java.io.IOException;

import org.junit.Test;

import com.renanpalmeira.spring.repository.GithubRepository;

public class GithubRepositoryTest {

    @Test
    public void getRepositoryTest() throws IOException {
        GithubRepository repos = new GithubRepository();
        repos.getRepository();
    }

}
