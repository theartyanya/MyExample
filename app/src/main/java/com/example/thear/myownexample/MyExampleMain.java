package com.example.thear.myownexample;

import android.app.Application;

import com.example.thear.myownexample.dagger.AppComponent;
import com.example.thear.myownexample.dagger.DaggerAppComponent;

public class MyExampleMain extends Application {
    private static AppComponent component;

    public static AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.create();
    }
}
