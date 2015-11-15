package com.udacity.gonzalo.popularmoviesapp.ViewHolders;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.udacity.gonzalo.popularmoviesapp.R;
import com.udacity.gonzalo.popularmoviesapp.model.Movie;

/**
 * Created by g0ng0n on 11/15/15.
 */
public class MovieHolder extends RecyclerView.ViewHolder {

        private Movie mMovie;

        private TextView mTitleTextView;

        private TextView mDateTextView;

        private CheckBox mSolvedCheckBox;


        public MovieHolder(View itemView){
            super(itemView);

            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_crime_title_text_view);

            mDateTextView = (TextView) itemView.findViewById(R.id.list_item_crime_date_text_view);

            mSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.list_item_crime_solved_check_box);

        }

        public void bindMovie(Movie movie){
             mMovie = movie;

            mTitleTextView.setText(mMovie.getTitle());

        }

}
