package com.example.gonzalomarin.hastensportsmvvm.services.players;

import com.example.gonzalomarin.hastensportsmvvm.views.players.model.PlayersModel;

import java.util.List;

public class SportAndPlayersServiceModel {

    private String type;

    private String title;

    private List<PlayersModel> players;

    public SportAndPlayersServiceModel(String type, String title, List<PlayersModel> players) {
        this.type = type;
        this.title = title;
        this.players = players;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PlayersModel> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayersModel> players) {
        this.players = players;
    }
}
