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

    @Override
    protected List<Movie> doInBackground(String... params) {

        // These two need to be declared outside the try/catch
        // so that they can be closed in the finally block.
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String format = "json";
        String units = "metric";
        int numDays =7;
        String apiKey="";
        // Will contain the raw JSON response as a string.
        String forecastJsonStr = null;

        try {
            final String FORECAST_BASE_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?";
            final String QUERY_PARAM = "q";
            final String FORMAT_PARAM = "mode";
            final String UNITS_PARAM = "units";
            final String DAYS_PARAM = "cnt";
            final String APIKEY_PARAM = "APPID";

            Uri builtUri = Uri.parse(FORECAST_BASE_URL).buildUpon().appendQueryParameter(QUERY_PARAM, params[0])
                    .appendQueryParameter(FORMAT_PARAM, format)
                    .appendQueryParameter(UNITS_PARAM, units)
                    .appendQueryParameter(DAYS_PARAM, Integer.toString(numDays))
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
                //forecastJsonStr = null;
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
                //forecastJsonStr = null;
                return null;

            }


            Log.v(LOG_TAG, "Forecast JSON String:" + forecastJsonStr);


            forecastJsonStr = buffer.toString();
            return null;
        }catch (IOException e) {
            Log.e(LOG_TAG, "Error ", e);
            // If the code didn't successfully get the weather data, there's no point in attempting
            // to parse it.
            //forecastJsonStr = null;
            return null;
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Error ", e);
        } finally{
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
        return null;
    }


    @Override
    protected void onPostExecute(List<Movie> movies) {
        delegate.processFinish(movies);
    }
}