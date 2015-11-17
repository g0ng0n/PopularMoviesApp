package com.udacity.gonzalo.popularmoviesapp.ViewHolders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.udacity.gonzalo.popularmoviesapp.R;
import com.udacity.gonzalo.popularmoviesapp.activities.MovieDetailsActivity;
import com.udacity.gonzalo.popularmoviesapp.fragments.MovieFragment;
import com.udacity.gonzalo.popularmoviesapp.model.Movie;

import java.util.UUID;

/**
 * Created by g0ng0n on 11/15/15.
 */
public class MovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    private Movie mMovie;

        public ImageView mImageView;



        public MovieHolder(View itemView){
            super(itemView);

            mImageView = (ImageView) itemView.findViewById(R.id.imageView1);
            itemView.setOnClickListener(this);

        }

    public void bindMovie(Movie movie) {
        mMovie = movie;
    }

    @Override
    public void onClick(View v) {
        Context context = itemView.getContext();
        Intent intent = MovieDetailsActivity.newIntent(context, mMovie);
        context.startActivity(intent);
    }


}

