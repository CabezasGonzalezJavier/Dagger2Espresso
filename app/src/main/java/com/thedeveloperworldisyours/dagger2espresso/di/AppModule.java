package com.thedeveloperworldisyours.dagger2espresso.di;

import android.app.Application;

import com.thedeveloperworldisyours.dagger2espresso.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by javierg on 05/07/16.
 */
@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return app;
    }
}

