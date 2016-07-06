package com.thedeveloperworldisyours.dagger2espresso.di.component;

import com.thedeveloperworldisyours.dagger2espresso.ActivityScope;
import com.thedeveloperworldisyours.dagger2espresso.di.LoginModule;
import com.thedeveloperworldisyours.dagger2espresso.ui.LoginActivity;
import com.thedeveloperworldisyours.dagger2espresso.presenter.LoginPresenter;

import dagger.Component;

/**
 * Created by javierg on 05/07/16.
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = LoginModule.class
)
public interface LoginComponent {
    void inject(LoginActivity activity);
    LoginPresenter getLoginPresenter();
}
