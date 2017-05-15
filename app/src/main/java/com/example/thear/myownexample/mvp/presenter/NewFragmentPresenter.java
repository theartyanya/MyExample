package com.example.thear.myownexample.mvp.presenter;

import android.app.Activity;
import android.widget.ArrayAdapter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.thear.myownexample.MyExampleMain;
import com.example.thear.myownexample.R;
import com.example.thear.myownexample.Screens;
import com.example.thear.myownexample.mvp.model.ItemsArray;
import com.example.thear.myownexample.mvp.view.NewFragment;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class NewFragmentPresenter extends MvpPresenter<NewFragment> {
    private Activity parent;
    @Inject
    Router router;

    public NewFragmentPresenter(Activity parent) {
        this.parent = parent;
        MyExampleMain.getComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        getViewState().showText();
        super.onFirstViewAttach();
    }

    public void toMain() {
        router.backTo(Screens.FIRST_SCREEN);
    }

    public void createList() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(parent, R.layout.list_item, ItemsArray.getItems());
        getViewState().setAdapter(arrayAdapter);
    }
}
