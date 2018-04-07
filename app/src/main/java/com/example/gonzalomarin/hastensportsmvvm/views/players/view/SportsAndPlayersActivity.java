package com.example.gonzalomarin.hastensportsmvvm.views.players.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.example.gonzalomarin.hastensportsmvvm.R;
import com.example.gonzalomarin.hastensportsmvvm.databinding.SportsAndPlayersActivityBinding;
import com.example.gonzalomarin.hastensportsmvvm.recycler.players.PlayersAdapter;
import com.example.gonzalomarin.hastensportsmvvm.views.players.model.PlayersModel;
import com.example.gonzalomarin.hastensportsmvvm.views.players.viewmodel.SportsAndPlayersViewModel;

import java.util.List;

public class SportsAndPlayersActivity extends AppCompatActivity implements SportsAndPlayersViewModel.OnDataReceived {

    private SportsAndPlayersActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.sports_and_players_activity);
        SportsAndPlayersViewModel model = new SportsAndPlayersViewModel(this);
        binding.setModel(model);
    }

    @Override
    public void onReceiveDataSuccess(List<PlayersModel> response) {
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        PlayersAdapter adapater = new PlayersAdapter(response);
        binding.recycler.setAdapter(adapater);
    }

    @Override
    public void onReceiveDataFailure(String error) {
        showSnackBar(error);
    }

    @Override
    public void onReceiveDataFailure(Integer stringResourceId) {
        showSnackBar(this.getString(R.string.internal_server_failure));
    }

    private void showSnackBar(String message) {
        Snackbar.make(binding.recycler, message, Snackbar.LENGTH_LONG).show();
    }
}
