package com.udacity.gonzalo.popularmoviesapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udacity.gonzalo.popularmoviesapp.R;
import com.udacity.gonzalo.popularmoviesapp.adapters.MovieAdapter;
import com.udacity.gonzalo.popularmoviesapp.model.Movie;
import com.udacity.gonzalo.popularmoviesapp.utils.FetchMoviesAsyncResponse;
import com.udacity.gonzalo.popularmoviesapp.utils.FetchMoviesTask;

import java.util.List;

/**
 * Created by g0ng0n on 11/15/15.
 */
public class MovieListFragment extends Fragment implements FetchMoviesAsyncResponse {

    private FetchMoviesTask fetcher = new FetchMoviesTask();

    private RecyclerView mMoviesListRecyclerView;
    private MovieAdapter mAdapter;

    public static MovieListFragment newInstance() {
        return new MovieListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_movie_list, container, false);

        mMoviesListRecyclerView = (RecyclerView) view.findViewById(R.id.movies_list_recycler_view);

        mMoviesListRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        updateUI();

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        fetcher.delegate = this;

    }


    private void updateUI() {
// TODO add the asyncTask to call the movieDB
        // List<Movie> crimes = asynctask
        List<Movie> moviesList = fetcher.execute("94043");

        if (mAdapter == null) {
            mAdapter = new MovieAdapter(moviesList, getActivity());

        } else {
            mAdapter.notifyDataSetChanged();
        }

        mMoviesListRecyclerView.setAdapter(mAdapter);
    }



    public void processFinish(List<Movie> output) {
        if (output != null) {
            mAdapter.getmMoviesList().clear();
            for (String dayForecastStr : output) {
                mAdapter.add(dayForecastStr);
            }
        }
    }
}
