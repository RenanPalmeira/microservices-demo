package com.renanpalmeira.spring.service;

import java.util.List;
import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.converter.jackson.JacksonConverterFactory;

import org.springframework.stereotype.Service;

import com.renanpalmeira.spring.client.IGitHubClient;
import com.renanpalmeira.spring.model.User;

@Service
public class UserService {
    public User findAll() throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

        IGitHubClient service = retrofit.create(IGitHubClient.class);
        Call<User> call = service.getUser("renanpalmeira");

        User user = call.execute().body();
        return user;
    }
}