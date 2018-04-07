package com.example.gonzalomarin.hastensportsmvvm.services.players;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface SportsAndPlayersRestInterface {

    @Headers("Content-Type: application/json")
    @GET("bins/{id}")
    Call<List<SportAndPlayersServiceModel>> getSportsAndPlayersList(@Path("id") String id);
}
