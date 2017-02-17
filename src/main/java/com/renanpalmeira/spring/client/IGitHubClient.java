package com.renanpalmeira.spring.client;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import com.renanpalmeira.spring.model.*;

public interface IGitHubClient {
    @GET("users/{user}")
    Call<User> getUser(@Path("user") String user);

    @GET("users/{user}/repos")
    Call<List<Project>> listRepos(@Path("user") String user);
}