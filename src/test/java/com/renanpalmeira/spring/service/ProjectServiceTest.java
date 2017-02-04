package com.renanpalmeira.spring.service;

import java.io.IOException;
import java.util.*;

import org.junit.Test;

import com.renanpalmeira.spring.model.Project;
import com.renanpalmeira.spring.service.ProjectService;

public class ProjectServiceTest {

    /**
     * @todo use Mock here
     */
    @Test
    public void getRepositoryTest() throws IOException {
        ProjectService projects = new ProjectService();
        List<Project> repos = projects.findAll();

        for(Project repo : repos) {
            System.out.println(repo);
        }
    }

}
