package com.example.thear.myownexample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.myownexample.R;
import com.example.thear.myownexample.mvp.model.Movie;
import com.example.thear.myownexample.mvp.presenter.RecyclerViewFragmentPresenter;
import com.example.thear.myownexample.mvp.view.RecyclerViewFragmentView;
import com.example.thear.myownexample.ui.adapters.MoviesAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerViewFragment extends MvpAppCompatFragment implements RecyclerViewFragmentView {
    RecyclerView recyclerView;

    @InjectPresenter
    RecyclerViewFragmentPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_view_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL));

        mPresenter.setAdapter();
    }

    @Override
    public void initAdapter(HashMap<String, ArrayList<Movie>> movies) {
        recyclerView.setAdapter(new MoviesAdapter(movies));
    }
}
