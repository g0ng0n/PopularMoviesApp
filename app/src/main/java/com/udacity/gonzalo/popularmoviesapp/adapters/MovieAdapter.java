package com.udacity.gonzalo.popularmoviesapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.udacity.gonzalo.popularmoviesapp.R;
import com.udacity.gonzalo.popularmoviesapp.ViewHolders.MovieHolder;
import com.udacity.gonzalo.popularmoviesapp.model.Movie;

import java.util.List;

/**
 * Created by g0ng0n on 11/15/15.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieHolder>{
    private List<Movie> mMoviesList;
    private Context mContext;

    public MovieAdapter(List<Movie> movies, Context context){
        this.mContext = context;
        this.mMoviesList = movies;

    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType){

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.list_item_crime,
                parent,false);


        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapter holder, int position){
        Movie movie = mMoviesList.get(position);

        //Download image using picasso library
        Picasso.with(mContext).load(movie.getPosterPath())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(customViewHolder.imageView);


        holder.bindCrime(crime);
    }

    @Override
    public int getItemCount(){
        return mCrimes.size();
    }

    public List<Movie> getmMoviesList() {
        return mMoviesList;
    }


}




