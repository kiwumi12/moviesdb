package com.example.moviesdb.utils;

import com.example.moviesdb.MovieListActivity;
import com.example.moviesdb.models.MovieModel;
import com.example.moviesdb.models.MoviesData;
import com.example.moviesdb.response.MovieSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {

    //search for movies

    @GET("3/search/movie")
    Call<MovieSearchResponse> searchMovie(
            @Query("api_key") String key,
            @Query("query") String query,
            @Query("page") int page

    );


    //making search with ID
    //https://api.themoviedb.org/3/movie/550?api_key=2a76a3cffb3cffbdd8e193f6c4e27142

    @GET("3/movie/{movie_id}?")
    Call<MoviesData> getMovie(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key
    );
}
