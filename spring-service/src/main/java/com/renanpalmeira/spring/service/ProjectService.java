package com.renanpalmeira.spring.service;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.converter.jackson.JacksonConverterFactory;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import com.renanpalmeira.spring.client.IGitHubClient;
import com.renanpalmeira.spring.model.Project;

@Service
public class ProjectService {

    @HystrixCommand(fallbackMethod = "fallbackFindAll")
    public List<Project> findAll() throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

        IGitHubClient service = retrofit.create(IGitHubClient.class);
        Call<List<Project>> call = service.listRepos("octocat");

        List<Project> repos = call.execute().body();
        return repos;
    }

    public List<Project> fallbackFindAll() {
        List<Project> repos = new ArrayList<Project>();

        Project project = new Project();
        project.setId(1L);
        project.setName("Fallback project");
        project.setLanguage("Java");
        project.setHtmlUrl("https://netflix.com");

        repos.add(project);

        return repos;
    }
}