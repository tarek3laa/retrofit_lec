package com.example.retrofit0;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    @GET("posts")
    Call<List<Post>> getAll();
    @GET("posts/{id}")
    Call<Post> getById(@Path("id") int id);
    @GET("posts")
    Call<List<Post>> get(@Query("country") String s,@Query("apiKey") String s1);
}
