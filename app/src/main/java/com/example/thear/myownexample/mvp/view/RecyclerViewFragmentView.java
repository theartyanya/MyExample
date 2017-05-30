package com.example.thear.myownexample.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.example.thear.myownexample.mvp.model.Movie;

import java.util.ArrayList;
import java.util.HashMap;

public interface RecyclerViewFragmentView extends MvpView {
    void initAdapter(HashMap<String, ArrayList<Movie>> movies);
}
