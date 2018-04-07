package com.example.gonzalomarin.hastensportsmvvm.views.players.viewmodel;

import android.databinding.BaseObservable;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.gonzalomarin.hastensportsmvvm.R;
import com.example.gonzalomarin.hastensportsmvvm.services.players.SportAndPlayersServiceModel;
import com.example.gonzalomarin.hastensportsmvvm.services.players.SportsAndPlayersService;
import com.example.gonzalomarin.hastensportsmvvm.views.players.model.PlayersModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportsAndPlayersViewModel extends BaseObservable implements Callback<List<SportAndPlayersServiceModel>> {

    private static final String FIXED_ID = "66851";

    private OnDataReceived onDataReceived;

    public SportsAndPlayersViewModel(OnDataReceived onDataReceived) {
        new SportsAndPlayersService().getPlayers(FIXED_ID, this);
        this.onDataReceived = onDataReceived;
    }

    @Override
    public void onResponse(@NonNull Call<List<SportAndPlayersServiceModel>> call, @NonNull Response<List<SportAndPlayersServiceModel>> response) {
        if (response.isSuccessful()) {
            List<SportAndPlayersServiceModel> playerListFromService = response.body();
            if (playerListFromService != null && !playerListFromService.isEmpty()) {
                onDataReceived.onReceiveDataSuccess(manageResponse(playerListFromService));
            } else {
                onDataReceived.onReceiveDataFailure(R.string.internal_server_failure);
            }
        }
    }

    @Override
    public void onFailure(@NonNull Call<List<SportAndPlayersServiceModel>> call, @NonNull Throwable t) {
        onDataReceived.onReceiveDataFailure(t.getMessage());
    }

    private List<PlayersModel> manageResponse(List<SportAndPlayersServiceModel> playerListFromService) {
        List<PlayersModel> playersList = new ArrayList<>();
        String currentSport = null;
        for (SportAndPlayersServiceModel sportAndPlayersServiceModel : playerListFromService) {
            if (TextUtils.isEmpty(currentSport) || !currentSport.equals(sportAndPlayersServiceModel.getTitle())) {
                currentSport = sportAndPlayersServiceModel.getTitle();
                playersList.add(new PlayersModel(currentSport));
            }
            playersList.addAll(sportAndPlayersServiceModel.getPlayers());
        }
        return playersList;
    }

    public interface OnDataReceived {

        void onReceiveDataSuccess(List<PlayersModel> players);

        void onReceiveDataFailure(String error);

        void onReceiveDataFailure(Integer stringResourceId);
    }
}