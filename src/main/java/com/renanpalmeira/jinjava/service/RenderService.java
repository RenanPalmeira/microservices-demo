package com.renanpalmeira.jinjava.service;

import java.io.IOException;
import java.util.*;

import com.renanpalmeira.jinjava.client.GithubClient;
import com.renanpalmeira.jinjava.domain.GithubEndpoints;
import com.renanpalmeira.jinjava.utility.IdentityEntitiesTemplateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import com.google.common.collect.Maps;

@Service
public class RenderService {

    @Autowired
    private IdentityEntitiesTemplateUtility templateEntityHelper;

    private final static String BASE_URL = "https://api.github.com/;

    public Map<String, Object> getVariables(String token, String params, String template) throws IOException {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request request = chain.request()
                    .newBuilder()
                    .addHeader("Authorization", token)
                    .build();

            return chain.proceed(request);
        });

        OkHttpClient client = httpClient.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client)
                .build();

        GithubClient endpoint = retrofit.create(GithubClient.class);

        Map<String, Object> context = Maps.newHashMap();

        List<String> entities = templateEntityHelper.getEntitiesTemplate(template);

        Arrays.stream(GithubEndpoints.values())
                .filter(entity -> entities.contains(entity.toString()))
                .forEach(item -> {
                    Call<Object> request = endpoint.getEndpoint(item.getUrl() + "?" + params);

                    Object response = null;
                    try {
                        response = request.execute().body();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    context.put(item.toString(), response);
                });

        return context;
    }
}
