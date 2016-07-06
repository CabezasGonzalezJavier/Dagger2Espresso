package com.thedeveloperworldisyours.dagger2espresso.Interact;

import com.thedeveloperworldisyours.dagger2espresso.model.Logo;
import com.thedeveloperworldisyours.dagger2espresso.service.GetLogo;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by javierg on 05/07/16.
 */
public class MainInteractImpl implements MainInteract{

    @Inject
    GetLogo mApiService;

    @Inject
    public MainInteractImpl(GetLogo getApi) {
        this.mApiService = getApi;
    }

    @Override
    public void logo(final OnMainFinishedListener listener) {
        mApiService.getLogoCall().enqueue(new Callback<Logo>() {
            @Override
            public void onResponse(Response<Logo> response, Retrofit retrofit) {
                listener.onSuccess(response.body().getLogo());
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onFail();
            }
        });
    }
}
