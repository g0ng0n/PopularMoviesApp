package com.udacity.gonzalo.popularmoviesapp.utils;

import com.udacity.gonzalo.popularmoviesapp.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by g0ng0n on 11/15/15.
 */
public class MovieJsonWrapper {

    private static final String LOG_TAG = MovieJsonWrapper.class.getSimpleName();
    private static final String NODE_RESULTS = "results";
    private static final String BACKDROP_PATH_NODE = "backdrop_path";
    private static final String ID_NODE = "id";
    private static final String ORIGINAL_LANGUAGE_NODE = "original_language";
    private static final String ORIGINAL_TITLE_NODE = "original_title";
    private static final String OVERVIEW_NODE = "overview";
    private static final String POSTER_PATH_NODE = "poster_path";
    private static final String RELEASE_DATE_NODE = "release_date";
    private static final String POPULARITY_NODE = "popularity";
    private static final String TITLE_NODE = "title";
    private static final String VOTE_AVERAGE_NODE = "vote_average";
    private static final String VOTE_COUNT_NODE = "vote_count";
    private static final String URL_POSTER = "http://image.tmdb.org/t/p/w342/";

    /**
     * This methods provides the logic to parse all the json data into a Movie model class
     * and then add that object into a List of Movies
     */
    public static List<Movie> getMoviesDataFromJson(String moviesJsonStr)
            throws JSONException {


        JSONObject moviesJson = new JSONObject(moviesJsonStr);
        JSONArray moviesArray = moviesJson.getJSONArray(NODE_RESULTS);

        List<Movie> movies = new ArrayList<Movie>();
        for (int i = 0; i < moviesArray.length(); i++) {

            JSONObject jsonMovieNode = moviesArray.getJSONObject(i);

            Movie newMovie = new Movie(
                    jsonMovieNode.getString(BACKDROP_PATH_NODE),
                    jsonMovieNode.getString(ID_NODE),
                    jsonMovieNode.getString(ORIGINAL_LANGUAGE_NODE),
                    jsonMovieNode.getString(ORIGINAL_TITLE_NODE),
                    jsonMovieNode.getString(OVERVIEW_NODE),
                    jsonMovieNode.getString(RELEASE_DATE_NODE),
                    jsonMovieNode.getString(POSTER_PATH_NODE),
                    jsonMovieNode.getString(POPULARITY_NODE),
                    jsonMovieNode.getString(TITLE_NODE),
                    jsonMovieNode.getString(VOTE_AVERAGE_NODE),
                    jsonMovieNode.getString(VOTE_COUNT_NODE));

            movies.add(newMovie);
        }

        return movies;
    }


    public static String getPosterUrl(String posterPath) {

        StringBuilder url = new StringBuilder();
        url.append(URL_POSTER).append(posterPath);

        return url.toString();

    }
}
