package com.example.gonzalomarin.hastensportsmvvm.views.players.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class PlayersModel extends BaseObservable {

    private String date;
    private String image;
    private String name;
    private String surname;
    private String sport;

    public PlayersModel(String sport) {
        this.sport = sport;
    }

    @Bindable
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Bindable
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Bindable
    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}
