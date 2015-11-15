package com.udacity.gonzalo.popularmoviesapp.utils;

import com.udacity.gonzalo.popularmoviesapp.model.Movie;

import java.util.List;

/**
 * Created by g0ng0n on 11/2/15.
 */
public interface FetchMoviesAsyncResponse {

    void processFinish(List<Movie> output);
}
