package com.example.gonzalomarin.hastensportsmvvm.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.gonzalomarin.hastensportsmvvm.R;
import com.squareup.picasso.Picasso;

public class DataBindingUtils {

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.get().load(imageUrl).placeholder(R.mipmap.ic_launcher_round).fit().centerCrop().into(view);
    }

}
