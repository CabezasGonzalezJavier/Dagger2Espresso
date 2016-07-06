package com.thedeveloperworldisyours.dagger2espresso.ui;

/**
 * Created by javierg on 05/07/16.
 */
public interface LoginView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();

    void setErrorServer();
}

