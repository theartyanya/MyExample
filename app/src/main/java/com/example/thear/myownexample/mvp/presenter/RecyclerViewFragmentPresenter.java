package com.example.thear.myownexample.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.myownexample.mvp.model.Movie;
import com.example.thear.myownexample.mvp.model.Movies;
import com.example.thear.myownexample.mvp.view.RecyclerViewFragmentView;

import java.util.ArrayList;
import java.util.HashMap;

@InjectViewState
public class RecyclerViewFragmentPresenter extends MvpPresenter<RecyclerViewFragmentView> {
    public void setAdapter() {
        HashMap<String, ArrayList<Movie>> movies = Movies.getMovies();
        getViewState().initAdapter(movies);
    }
}
