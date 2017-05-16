package com.example.thear.myownexample.mvp.view;

import android.widget.ArrayAdapter;

import com.arellomobile.mvp.MvpView;

/**
 * Created by thear on 5/12/2017.
 */

public interface NewFragment extends MvpView {
    void showText();
    void setAdapter();
}
