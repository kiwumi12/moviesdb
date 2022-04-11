package com.example.moviesdb.response;

import com.example.moviesdb.models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieResponse {

    //finding a single movie
    @SerializedName("results")
    @Expose
    private MovieModel movie;
    public MovieModel getMovie(){
        return movie;
    }

    @Override
    public String toString() {
        return "MoviesResponse{" +
                "movie=" + movie +
                '}';
    }
}
