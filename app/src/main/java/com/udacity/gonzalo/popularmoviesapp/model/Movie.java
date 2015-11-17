package com.udacity.gonzalo.popularmoviesapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by g0ng0n on 11/15/15.
 */
public class Movie implements Parcelable {

    private String backdropPath;
    private String id;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private String releaseDate;
    private String posterPath;
    private String popularity;
    private String title;
    private String voteAverage;
    private String voteCount;

    public Movie(String backdropPath, String id, String originalLanguage, String originalTitle, String overview, String releaseDate, String posterPath, String popularity, String title, String voteAverage, String voteCount) {
        this.backdropPath = backdropPath;
        this.id = id;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.posterPath = posterPath;
        this.popularity = popularity;
        this.title = title;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public Movie(){}

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(String voteCount) {
        this.voteCount = voteCount;
    }

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(backdropPath);
        parcel.writeString(id);
        parcel.writeString(originalLanguage);
        parcel.writeString(originalTitle);
        parcel.writeString(overview);
        parcel.writeString(releaseDate);
        parcel.writeString(posterPath);
        parcel.writeString(popularity);
        parcel.writeString(title);
        parcel.writeString(voteAverage);
        parcel.writeString(voteCount);
    }

    public Movie(Parcel parcelIn) {
        this.backdropPath = parcelIn.readString();
        this.id = parcelIn.readString();
        this.originalLanguage = parcelIn.readString();
        this.originalTitle = parcelIn.readString();
        this.overview = parcelIn.readString();
        this.releaseDate = parcelIn.readString();
        this.posterPath = parcelIn.readString();
        this.popularity = parcelIn.readString();
        this.title = parcelIn.readString();
        this.voteAverage = parcelIn.readString();
        this.voteCount = parcelIn.readString();
    }
    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel parcel) {
            return new Movie(parcel);
        }

        @Override
        public Movie[] newArray(int i) {
            return new Movie[i];
        }

    };
}
