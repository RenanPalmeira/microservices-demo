package com.renanpalmeira.spring.service;

import java.util.List;
import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.converter.jackson.JacksonConverterFactory;

import com.renanpalmeira.spring.client.IGitHubClient;
import com.renanpalmeira.spring.model.Project;

public class ProjectService {
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
}