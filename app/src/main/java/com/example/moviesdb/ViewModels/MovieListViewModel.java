package com.example.moviesdb.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviesdb.models.MovieModel;
import com.example.moviesdb.repositories.MovieRepository;

import java.util.List;

public class MovieListViewModel extends ViewModel {

    //this class is used for VIEWMODEL

        private MovieRepository movieRepository;

    //Constructor


    public MovieListViewModel() {
        movieRepository = MovieRepository.getInstance();

    }


    public LiveData<List<MovieModel>> getMovies(){
        return movieRepository.getMovies();
    }



    //Calling method in view-model
    public void searchMovieApi(String query, int pageNumber){
        movieRepository.searchMovieApi(query,pageNumber);
    }



}
