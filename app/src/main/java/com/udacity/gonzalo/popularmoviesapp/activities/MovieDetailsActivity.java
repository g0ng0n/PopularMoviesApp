package com.udacity.gonzalo.popularmoviesapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.udacity.gonzalo.popularmoviesapp.R;
import com.udacity.gonzalo.popularmoviesapp.fragments.MovieFragment;
import com.udacity.gonzalo.popularmoviesapp.model.Movie;


/**
 * Created by g0ng0n on 11/16/15.
 */
public class MovieDetailsActivity extends AppCompatActivity {

    private static final String ARG_MOVIE_ID = "movie_object";

    public static Intent newIntent(Context packageContext, Movie movie) {

        Intent intent = new Intent(packageContext, MovieDetailsActivity.class);

        Bundle mBundle = new Bundle();
        mBundle.putParcelable(ARG_MOVIE_ID, movie);
        intent.putExtras(mBundle);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.movie_detail, new MovieFragment())
                    .commit();
        }
    }


}
