package com.example.newsapp.Network;

import com.example.newsapp.Model.getMainObj;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetApi {
   String getBaseurl ="https://newsapi.org/v2/";
    @GET("top-headlines")
    Call <getMainObj> getmainobj(
            @Query("country") String country,
            @Query("apikey") String apikey

    );
    @GET("top-headlines")
    Call <getMainObj> getcategoryobj(
            @Query("country") String country,
            @Query("category") String category,
            @Query("apikey") String apikey
    );

}
