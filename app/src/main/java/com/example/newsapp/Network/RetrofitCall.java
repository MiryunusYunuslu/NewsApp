package com.example.newsapp.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCall {
     private static Retrofit retrofit;

    public static GetApi getApiInterface(){

            retrofit=new Retrofit.Builder().baseUrl(GetApi.getBaseurl).addConverterFactory(GsonConverterFactory.create()).build();

             return retrofit.create(GetApi.class);
    }
}
