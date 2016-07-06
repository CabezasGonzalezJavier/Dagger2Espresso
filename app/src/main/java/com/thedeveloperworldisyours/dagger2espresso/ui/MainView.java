package com.thedeveloperworldisyours.dagger2espresso.ui;

/**
 * Created by javierg on 05/07/16.
 */
public interface MainView {

    void showProgress();

    void hideProgress();

    void showImage(String image);

    void setErrorServer();

}
