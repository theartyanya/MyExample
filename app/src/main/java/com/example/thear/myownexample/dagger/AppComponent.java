package com.example.thear.myownexample.dagger;

import com.example.thear.myownexample.dagger.module.NavigatorModule;
import com.example.thear.myownexample.mvp.presenter.MyActivityPresenter;
import com.example.thear.myownexample.mvp.presenter.MyExamplePresenter;
import com.example.thear.myownexample.mvp.presenter.NewFragmentPresenter;
import com.example.thear.myownexample.ui.activity.MyActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = NavigatorModule.class)
public interface AppComponent {
    void inject(MyActivity activity);
    void inject(MyActivityPresenter presenter);
    void inject(MyExamplePresenter presenter);
    void inject(NewFragmentPresenter presenter);
}
