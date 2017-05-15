package com.example.thear.myownexample.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.myownexample.MyExampleMain;
import com.example.thear.myownexample.Screens;
import com.example.thear.myownexample.mvp.view.MyActivityView;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class MyActivityPresenter extends MvpPresenter<MyActivityView> {
    @Inject
    Router router;

    public MyActivityPresenter() {
        MyExampleMain.getComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        router.newRootScreen(Screens.FIRST_SCREEN);
    }
}
