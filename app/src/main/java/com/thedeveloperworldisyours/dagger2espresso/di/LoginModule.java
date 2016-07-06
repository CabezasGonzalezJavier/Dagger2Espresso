package com.thedeveloperworldisyours.dagger2espresso.di;

import com.thedeveloperworldisyours.dagger2espresso.Interact.LoginInteract;
import com.thedeveloperworldisyours.dagger2espresso.presenter.LoginPresenter;
import com.thedeveloperworldisyours.dagger2espresso.presenter.LoginPresenterImpl;
import com.thedeveloperworldisyours.dagger2espresso.ui.LoginView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by javierg on 05/07/16.
 */
@Module
public class LoginModule {
    private LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @Provides
    public LoginView provideView() {
        return view;
    }

    @Provides
    public LoginPresenter providePresenter(LoginView loginView, LoginInteract loginInteract) {
        return new LoginPresenterImpl(loginView, loginInteract);
    }


}
