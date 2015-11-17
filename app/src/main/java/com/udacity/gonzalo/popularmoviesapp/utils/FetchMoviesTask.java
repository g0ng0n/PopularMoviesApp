package com.udacity.gonzalo.popularmoviesapp.utils;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.udacity.gonzalo.popularmoviesapp.model.Movie;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by g0ng0n on 11/15/15.
 */
public class FetchMoviesTask extends AsyncTask<String, Void, List<Movie>> {

    public FetchMoviesAsyncResponse delegate = null;
    private final String LOG_TAG = FetchMoviesTask.class.getSimpleName();


    /**
     * This methods provides the logic to call the Movie API, I took part of the code from
     * the Sunshine App.
     */
    @Override
    protected List<Movie> doInBackground(String... params) {

        // These two need to be declared outside the try/catch
        // so that they can be closed in the finally block.
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String popularity = params[0];
        String apiKey = "";
        // Will contain the raw JSON response as a string.
        String moviesJsonStr = null;
        List<Movie> movies = null;
        try {
            final String MOVIEAPI_BASE_URL = "http://api.themoviedb.org/3/discover/movie?";
            final String QUERY_PARAM = "q";
            final String SORT_BY = "sort_by";
            final String APIKEY_PARAM = "api_key";

            Uri builtUri = Uri.parse(MOVIEAPI_BASE_URL).buildUpon().appendQueryParameter(SORT_BY, popularity)
                    .appendQueryParameter(APIKEY_PARAM, apiKey).build();

            // Construct the URL for the OpenWeatherMap query
            // Possible parameters are available at OWM's forecast API page, at
            // http://openweathermap.org/API#forecast
            URL url = new URL(builtUri.toString());
            Log.v(LOG_TAG, "URL:" + url);

            // Create the request to OpenWeatherMap, and open the connection
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
                //moviesJsonStr = null;
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                // But it does make debugging a *lot* easier if you print out the completed
                // buffer for debugging.
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                // Stream was empty.  No point in parsing.
                //moviesJsonStr = null;
                return null;

            }


            moviesJsonStr = buffer.toString();

            movies = MovieJsonWrapper.getMoviesDataFromJson(moviesJsonStr);
            Log.v(LOG_TAG, "Movies JSON String:" + moviesJsonStr);

        } catch (IOException e) {
            Log.e(LOG_TAG, "Error ", e);
            // If the code didn't successfully get the weather data, there's no point in attempting
            // to parse it.
            //moviesJsonStr = null;
            return null;
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Error ", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();

            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e(LOG_TAG, "Error closing stream", e);
                }
            }
        }
        return movies;

    }


    @Override
    protected void onPostExecute(List<Movie> movies) {
        delegate.processFinish(movies);
    }
}
