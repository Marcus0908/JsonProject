package com.health.jsonap;


import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;


public interface JsonPlaceHolderApi {

    @GET("pontotel-docs/data.json")
    Call<List<Data>> getPosts();

}




