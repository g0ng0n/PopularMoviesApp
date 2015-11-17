package com.udacity.gonzalo.popularmoviesapp.activities;


import android.support.v4.app.Fragment;


import com.udacity.gonzalo.popularmoviesapp.fragments.MovieListFragment;

public class MovieListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new MovieListFragment();
    }

}
