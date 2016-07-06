package com.thedeveloperworldisyours.dagger2espresso.di;

import com.thedeveloperworldisyours.dagger2espresso.Interact.MainInteract;
import com.thedeveloperworldisyours.dagger2espresso.presenter.MainPresenter;
import com.thedeveloperworldisyours.dagger2espresso.presenter.MainPresenterImpl;
import com.thedeveloperworldisyours.dagger2espresso.ui.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by javierg on 06/07/16.
 */
@Module
public class MainModule {
    private MainView mView;

    public MainModule(MainView mainView) {
        mView = mainView;
    }

    @Provides
    public MainView provideView() {
        return mView;
    }

    @Provides
    public MainPresenter providePresenter(MainView mainView, MainInteract mainInteract) {
        return new MainPresenterImpl(mainView, mainInteract);
    }

}
