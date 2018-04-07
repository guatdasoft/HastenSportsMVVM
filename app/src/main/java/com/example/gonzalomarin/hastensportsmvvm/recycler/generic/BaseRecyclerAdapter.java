package com.example.gonzalomarin.hastensportsmvvm.recycler.generic;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class BaseRecyclerAdapter extends RecyclerView.Adapter<GenericViewHolder> {

    @NonNull
    @Override
    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, getCurrentWorkLayout(viewType), parent, false);
        return new GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int position) {
        holder.bind(getCurrentPlayer(position));
    }

    @Override
    public int getItemViewType(int position) {
        return getTypeOfViewToDraw(position);
    }

    public abstract Integer getTypeOfViewToDraw(Integer position);

    protected abstract Object getCurrentPlayer(Integer position);

    protected abstract Integer getCurrentWorkLayout(Integer viewType);

}