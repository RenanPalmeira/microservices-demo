package com.renanpalmeira.jinjava.client;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface GithubClient {
    @GET
    Call<Object> getEndpoint(@Url String url);
}