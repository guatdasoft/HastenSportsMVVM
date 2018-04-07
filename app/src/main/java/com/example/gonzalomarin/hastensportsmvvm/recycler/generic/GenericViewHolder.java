package com.example.gonzalomarin.hastensportsmvvm.recycler.generic;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import com.android.databinding.library.baseAdapters.BR;

public class GenericViewHolder extends RecyclerView.ViewHolder {

    private final ViewDataBinding binding;

    GenericViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Object obj) {
        binding.setVariable(BR.genericHolderModel, obj);
        binding.executePendingBindings();
    }
}
