package com.example.mvvm_example_using_databinding.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiResponse {

    public static String BasePoint="http://api.geonames.org/";
    public  static Retrofit retrofit(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BasePoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit;
    }
}
