package com.example.gonzalomarin.hastensportsmvvm.services.players;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SportsAndPlayersService {

    private final String PLAYERS_HOST_URL = "https://api.myjson.com/";

    public void getPlayers(String id, Callback<List<SportAndPlayersServiceModel>> callback) {
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PLAYERS_HOST_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        SportsAndPlayersRestInterface restInterface = retrofit.create(SportsAndPlayersRestInterface.class);
        Call<List<SportAndPlayersServiceModel>> call = restInterface.getSportsAndPlayersList(id);
        call.enqueue(callback);
    }
}
