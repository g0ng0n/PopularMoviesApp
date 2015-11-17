package com.udacity.gonzalo.popularmoviesapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.udacity.gonzalo.popularmoviesapp.R;
import com.udacity.gonzalo.popularmoviesapp.fragments.MovieFragment;
import com.udacity.gonzalo.popularmoviesapp.model.Movie;

import java.util.UUID;

/**
 * Created by g0ng0n on 11/16/15.
 */
public class MovieDetailsActivity extends AppCompatActivity {

    private static final String ARG_MOVIE_ID = "movie_object";

    public static Intent newIntent(Context packageContext, Movie movie){

        Intent intent = new Intent(packageContext, MovieDetailsActivity.class);
        intent.putExtra(ARG_MOVIE_ID, movie);

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
