package com.renanpalmeira.spring.repository;

import java.util.List;
import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;

import com.renanpalmeira.spring.service.IGitHubService;
import com.renanpalmeira.spring.resource.Repository;

public class GithubRepository {
    public List<Repository> getRepository() throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        IGitHubService service = retrofit.create(IGitHubService.class);
        Call<List<Repository>> call = service.listRepos("octocat");

        List<Repository> repos = call.execute().body();
        return repos;
    }
}