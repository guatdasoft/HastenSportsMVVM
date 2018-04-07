package com.example.gonzalomarin.hastensportsmvvm.recycler.players;

import com.example.gonzalomarin.hastensportsmvvm.R;
import com.example.gonzalomarin.hastensportsmvvm.recycler.generic.BaseRecyclerAdapter;
import com.example.gonzalomarin.hastensportsmvvm.views.players.model.PlayersModel;

import java.util.List;

public class PlayersAdapter extends BaseRecyclerAdapter {

    private static final Integer SEPARATOR = 1;
    private static final Integer PLAYER = 0;

    private List<PlayersModel> players;

    public PlayersAdapter(List<PlayersModel> players) {
        this.players = players;
    }

    @Override
    public Integer getTypeOfViewToDraw(Integer position) {
        if (players.get(position).getSport() == null) {
            return PLAYER;
        }
        return SEPARATOR;
    }

    @Override
    protected Object getCurrentPlayer(Integer position) {
        return players.get(position);
    }

    @Override
    protected Integer getCurrentWorkLayout(Integer viewType) {
        if (viewType.equals(PLAYER)) {
            return R.layout.player_row_layout;
        }
        return R.layout.player_list_separator;
    }

    @Override
    public int getItemCount() {
        return players.size();
    }
}