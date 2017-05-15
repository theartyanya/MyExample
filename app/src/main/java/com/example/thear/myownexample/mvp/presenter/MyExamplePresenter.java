package com.example.thear.myownexample.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.myownexample.MyExampleMain;
import com.example.thear.myownexample.Screens;
import com.example.thear.myownexample.mvp.view.MyExample;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class MyExamplePresenter extends MvpPresenter<MyExample> {
    private String s;
    @Inject
    Router router;

    public MyExamplePresenter(String s) {
        this.s = s;
        MyExampleMain.getComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void onButtonClick() {
        getViewState().showText(s);
    }

    public void swapFragment() {
        router.navigateTo(Screens.SECOND_SCREEN);
    }
}
