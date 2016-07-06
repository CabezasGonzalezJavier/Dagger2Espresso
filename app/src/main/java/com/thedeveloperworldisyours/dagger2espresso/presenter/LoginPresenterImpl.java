package com.thedeveloperworldisyours.dagger2espresso.presenter;

import com.thedeveloperworldisyours.dagger2espresso.Interact.LoginInteract;
import com.thedeveloperworldisyours.dagger2espresso.ui.LoginView;

/**
 * Created by javierg on 05/07/16.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteract.OnLoginFinishedListener {

    private LoginView mLoginView;
    private LoginInteract mLoginInteract;

    public LoginPresenterImpl(LoginView loginView, LoginInteract interact) {
        this.mLoginView = loginView;
        this.mLoginInteract = interact;
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (mLoginView != null) {
            mLoginView.showProgress();
        }
        mLoginInteract.login(username, password, this);
    }

    @Override
    public void onDestroy() {
        mLoginView = null;
    }

    @Override
    public void onUsernameError() {
        if (mLoginView != null) {
            mLoginView.setUsernameError();
            mLoginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (mLoginView != null) {
            mLoginView.setPasswordError();
            mLoginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (mLoginView != null) {
            mLoginView.navigateToHome();
        }
    }

    @Override
    public void onFail() {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.setErrorServer();
        }
    }
}
