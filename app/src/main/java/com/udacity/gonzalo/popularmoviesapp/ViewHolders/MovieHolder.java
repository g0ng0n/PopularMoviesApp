package com.udacity.gonzalo.popularmoviesapp.ViewHolders;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.udacity.gonzalo.popularmoviesapp.R;
import com.udacity.gonzalo.popularmoviesapp.model.Movie;

/**
 * Created by g0ng0n on 11/15/15.
 */
public class MovieHolder extends RecyclerView.ViewHolder {


        public ImageView mImageView;



        public MovieHolder(View itemView){
            super(itemView);

            mImageView = (ImageView) itemView.findViewById(R.id.movies_list_recycler_view);

        }

}
