package com.udacity.gonzalo.popularmoviesapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.udacity.gonzalo.popularmoviesapp.R;
import com.udacity.gonzalo.popularmoviesapp.model.Movie;
import com.udacity.gonzalo.popularmoviesapp.utils.MovieJsonWrapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by g0ng0n on 11/16/15.
 */
public class MovieFragment extends Fragment {


    private static final String LOG_TAG = MovieFragment.class.getSimpleName();

    private Movie mMovie;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

    }


    public MovieFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_movie, container, false);

        Intent intent = getActivity().getIntent();
        if (intent != null) {
            mMovie = (Movie) intent.getSerializableExtra("movie_object");

            getActivity().setTitle(mMovie.getTitle());
            Picasso.with(getActivity()).load(MovieJsonWrapper.getPosterUrl(mMovie.getPosterPath()))
                    .into((ImageView) rootView.findViewById(R.id.imageViewPoster));

            ((TextView) rootView.findViewById(R.id.movieYear))
                    .setText(getYear());

            ((TextView) rootView.findViewById(R.id.voteAverage))
                    .setText(mMovie.getVoteAverage());

            ((TextView) rootView.findViewById(R.id.movieOverview))
                    .setText(mMovie.getOverview());


        }

        return rootView;
    }

    private String getYear() {
        Calendar calendar = Calendar.getInstance();
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");
            calendar.setTime(formatter.parse(mMovie.getReleaseDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return String.valueOf(calendar.get(Calendar.YEAR));
    }


}
