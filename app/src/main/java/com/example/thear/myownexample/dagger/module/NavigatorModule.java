package com.example.thear.myownexample.dagger.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@Module
public class NavigatorModule {
    private Cicerone<Router> cicerone;

    public NavigatorModule() {
        cicerone = Cicerone.create();
    }

    @Provides
    @Singleton
    public Router provideRouter() {
        return cicerone.getRouter();
    }

    @Provides
    @Singleton
    public NavigatorHolder provideNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }
}
