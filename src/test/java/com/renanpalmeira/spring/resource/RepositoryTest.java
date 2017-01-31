package com.renanpalmeira.spring.resource;

import java.io.IOException;
import java.util.*;

import org.junit.Test;

import com.renanpalmeira.spring.resource.Repository;
import com.renanpalmeira.spring.repository.GithubRepository;

public class RepositoryTest {

    /**
     * @todo use Mock here
     */
    @Test
    public void getRepositoryTest() throws IOException {
        GithubRepository github = new GithubRepository();
        List<Repository> repos = github.getRepository();

        for(Repository repo : repos) {
            System.out.println(repo.getHtmlUrl());
        }
    }

}
