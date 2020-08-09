package com.studying.bettamovies.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.studying.bettamovies.R;
import com.studying.bettamovies.ui.MainActivity;

public class GlideMovieLoader {
    private final Context context;
    private int transitionDelay = 500;

    public void setTransitionDelay(int transitionDelay) {
        this.transitionDelay = transitionDelay;
    }

    public GlideMovieLoader(Context context) {
        this.context = context;
    }

    @SuppressLint("CheckResult")
    public void loadImage(ImageView intoView, Uri imageUri) {
        intoView.setImageResource(R.drawable.ic_movie_double_white);
        Glide.with(context)
                .load(imageUri)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        intoView.setImageResource(R.drawable.ic_double_movie_err);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        intoView.setImageDrawable(resource);
                        return true;
                    }
                }).submit();
    }
}
