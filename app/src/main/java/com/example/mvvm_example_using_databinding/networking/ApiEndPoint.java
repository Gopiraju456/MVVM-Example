package com.example.mvvm_example_using_databinding.networking;

import com.example.mvvm_example_using_databinding.models.Geonames;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndPoint {
    @GET("wikipediaSearchJSON")
    Call<Geonames>  getgeonames(
            @Query("formatted")  boolean value,
            @Query("q") String q,
            @Query("maxRows")  int maxRows,
            @Query("username")  String username,
            @Query("style")  String style
    );

}
//    ?formatted=true&q=london&maxRows=10&username=srik784&style=full

//  http://api.geonames.org/wikipediaSearchJSON?formatted=true&q=london&maxRows=10&username=srik784&style=full