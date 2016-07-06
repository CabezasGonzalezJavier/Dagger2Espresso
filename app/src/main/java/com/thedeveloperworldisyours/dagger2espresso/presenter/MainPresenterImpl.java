package com.thedeveloperworldisyours.dagger2espresso.presenter;

import com.thedeveloperworldisyours.dagger2espresso.Interact.MainInteract;
import com.thedeveloperworldisyours.dagger2espresso.ui.MainView;

/**
 * Created by javierg on 05/07/16.
 */
public class MainPresenterImpl implements MainPresenter, MainInteract.OnMainFinishedListener{

    private MainView mMainView;
    private MainInteract mMainInteract;

    public MainPresenterImpl(MainView mainView, MainInteract mainInteract) {
        this.mMainView = mainView;
        this.mMainInteract = mainInteract;
    }

    @Override
    public void getLogo() {
        mMainView.showProgress();
        mMainInteract.logo(this);
    }

    @Override
    public void onDestroy() {
        mMainView = null;
    }

    @Override
    public void onSuccess(String image) {
        mMainView.hideProgress();
        mMainView.showImage(image);
    }

    @Override
    public void onFail() {
        mMainView.hideProgress();
        mMainView.setErrorServer();
    }

}
