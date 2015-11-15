package com.udacity.gonzalo.popularmoviesapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udacity.gonzalo.popularmoviesapp.R;

/**
 * Created by g0ng0n on 11/15/15.
 */
public class MovieListFragment extends Fragment {


    private RecyclerView mMoviesListRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_movie_list, container, false);

        mMoviesListRecyclerView = (RecyclerView) view.findViewById(R.id.movies_list_recycler_view);

        mMoviesListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }
}
