package com.udacity.gonzalo.popularmoviesapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.udacity.gonzalo.popularmoviesapp.R;
import com.udacity.gonzalo.popularmoviesapp.activities.MovieDetailsActivity;
import com.udacity.gonzalo.popularmoviesapp.adapters.MovieAdapter;
import com.udacity.gonzalo.popularmoviesapp.model.Movie;
import com.udacity.gonzalo.popularmoviesapp.utils.FetchMoviesAsyncResponse;
import com.udacity.gonzalo.popularmoviesapp.utils.FetchMoviesTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by g0ng0n on 11/15/15.
 */
public class MovieListFragment extends Fragment implements FetchMoviesAsyncResponse {

    private static final String LOG_TAG = MovieListFragment.class.getSimpleName();

    private FetchMoviesTask fetcher = null;
    private List<Movie> moviesList = new ArrayList<Movie>();

    private RecyclerView mMoviesListRecyclerView;
    private MovieAdapter mAdapter;

    public static MovieListFragment newInstance() {
        return new MovieListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mMoviesListRecyclerView = (RecyclerView) inflater.inflate(R.layout.activity_movie_list, container, false);

        mMoviesListRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        fetcher.execute("popularity.desc");

        return mMoviesListRecyclerView;
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetcher = new FetchMoviesTask();
        fetcher.delegate = this;
        if(savedInstanceState == null || !savedInstanceState.containsKey("movies")) {
            moviesList = new ArrayList<Movie>();
        }
        else {
            moviesList = savedInstanceState.getParcelableArrayList("movies");
        }
        setHasOptionsMenu(true);

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList("movies", (ArrayList<? extends Parcelable>) moviesList);
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_movie_list, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_item_sort_by_pop:
                fetcher = new FetchMoviesTask();
                fetcher.delegate = this;
                fetcher.execute("popularity.desc");
                return true;
            case R.id.menu_item_sort_by_release:
                fetcher = new FetchMoviesTask();
                fetcher.delegate = this;
                fetcher.execute("vote_count.desc");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    /**
     *
     * @param output
     * This method has been created for logging purpose
     * is a post Processor for the asyncTask.
     *
     */
    public void processFinish(List<Movie> output) {
        Log.v(LOG_TAG, "Movies JSON String:" + output);

        mAdapter = new MovieAdapter(output, getActivity());

        mMoviesListRecyclerView.setAdapter(mAdapter);

    }
}
