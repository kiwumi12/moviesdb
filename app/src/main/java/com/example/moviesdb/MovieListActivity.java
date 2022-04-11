package com.example.moviesdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.moviesdb.ViewModels.MovieListViewModel;
import com.example.moviesdb.adapters.MovieRecyclerView;
import com.example.moviesdb.adapters.OnMovieListener;
import com.example.moviesdb.models.MovieModel;
import com.example.moviesdb.request.Service;
import com.example.moviesdb.response.MovieSearchResponse;
import com.example.moviesdb.utils.Credentials;
import com.example.moviesdb.utils.MovieApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListActivity extends AppCompatActivity implements OnMovieListener {

    //Recyclerview
    private RecyclerView recyclerView;
    private MovieRecyclerView movieRecyclerAdapter;






    //ViewModel
    private MovieListViewModel movieListViewModel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);



        movieListViewModel= new ViewModelProvider(this).get(MovieListViewModel.class);
        ConfigureRecyclerView();
        //Calling the observers
        ObserveAnyChange();
        searchMovieApi("fast",2);



        //testing the method
        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Displaying only the results of page 1
                searchMovieApi("Fast",2);
            }
        });*/



//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                GetRetrofitResponseAccoringToID();
//            }
//        });

    }


    //Observing any data change
    private  void ObserveAnyChange(){
        movieListViewModel.getMovies().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                //Observing for any data change

                if(movieModels !=null){
                    for(MovieModel movieModel: movieModels){
                        //Get tha data in log
                        Log.v("Tag","onChanged: "+movieModel.getTitle());
                        movieRecyclerAdapter.setmMovies(movieModels);

                    }
                }




            }
        });




    }


        //Calling method in Main Activity
    private void searchMovieApi(String query, int pageNumber){
        movieListViewModel.searchMovieApi(query,pageNumber);
    }


    //5 - initializing recyclerView & adding data to it
    private void ConfigureRecyclerView(){
        movieRecyclerAdapter=new MovieRecyclerView( this);
        recyclerView.setAdapter(movieRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onMovieClick(int position) {

    }

    @Override
    public void onCategoryClick(String category) {

    }





    /*private void GetRetrofitResponse(){
        MovieApi movieApi =Service.createService();
        Call<MovieSearchResponse> responseCall=movieApi
                .searchMovie(
                        Credentials.API_KEY,
                        "Jack Reacher",
                        1);
        responseCall.enqueue(new Callback<MovieSearchResponse>() {
            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                if(response.code()==200){
                   // Log.v("TAG","the response"+response.body().toString());

                    List<MovieModel> movies = new ArrayList<>(response.body().getMovies());

                    for (MovieModel movie: movies){
                        Log.v("Tag","Name: " +movie.getRelease_date());
                    }
                }
                else{
                    try {
                        Log.v("Tag","Error"+response.errorBody().string());
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }



            }

            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {

            }
        });


    }

    private void GetRetrofitResponseAccoringToID(){
        MovieApi movieApi=Service.createService();
        Call<MovieModel> responseCall = movieApi.getMovie(
                343611,
                Credentials.API_KEY);
        responseCall.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                if(response.code() ==200){
                    MovieModel movie = response.body();
                    Log.v("Tag","The Response " +movie.getTitle());
                }
                else{
                    try {
                        Log.v("Tag","Error"+response.errorBody().string());
                    } catch (IOException e){
                        e.printStackTrace();
                    }

                }

            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });


    }*/



}




