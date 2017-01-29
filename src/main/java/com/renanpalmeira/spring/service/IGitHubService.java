package com.renanpalmeira.spring.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import com.renanpalmeira.spring.resource.Repository;

public interface IGitHubService {
    @GET("users/{user}/repos")
    Call<List<Repository>> listRepos(@Path("user") String user);
}