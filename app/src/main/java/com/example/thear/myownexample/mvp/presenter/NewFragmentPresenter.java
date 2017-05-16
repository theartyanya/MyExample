package com.example.thear.myownexample.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.myownexample.MyExample;
import com.example.thear.myownexample.Screens;
import com.example.thear.myownexample.mvp.view.NewFragment;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class NewFragmentPresenter extends MvpPresenter<NewFragment> {
    @Inject
    Router router;

    public NewFragmentPresenter() {
        MyExample.getComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        getViewState().showText();
        super.onFirstViewAttach();
    }

    public void toMain() {
        router.backTo(Screens.FIRST_SCREEN);
    }

    public void onListButtonClick() {
        getViewState().setAdapter();
    }
}
