package com.thedeveloperworldisyours.dagger2espresso.di.component;

import com.thedeveloperworldisyours.dagger2espresso.ActivityScope;
import com.thedeveloperworldisyours.dagger2espresso.di.MainModule;
import com.thedeveloperworldisyours.dagger2espresso.presenter.MainPresenter;
import com.thedeveloperworldisyours.dagger2espresso.ui.MainActivity;

import dagger.Component;

/**
 * Created by javierg on 06/07/16.
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = MainModule.class
)
public interface MainComponent {
    void inject(MainActivity activity);
    MainPresenter getLoginPresenter();
}
