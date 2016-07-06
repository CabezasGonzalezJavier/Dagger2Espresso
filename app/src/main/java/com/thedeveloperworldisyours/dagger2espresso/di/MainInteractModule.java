package com.thedeveloperworldisyours.dagger2espresso.di;

import com.thedeveloperworldisyours.dagger2espresso.Interact.MainInteract;
import com.thedeveloperworldisyours.dagger2espresso.Interact.MainInteractImpl;
import com.thedeveloperworldisyours.dagger2espresso.service.GetLogo;
import com.thedeveloperworldisyours.dagger2espresso.service.RetrofitServiceLogo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;

/**
 * Created by javierg on 06/07/16.
 */
@Module
public class MainInteractModule {
    @Provides
    public MainInteract provideMainInteract(GetLogo apiService) {
        return new MainInteractImpl(apiService);
    }

    @Provides
    @Singleton
    public RetrofitServiceLogo providesRtetrofitService() {
        return new RetrofitServiceLogo();
    }

    @Provides
    @Singleton
    public GetLogo providesApiService(RetrofitServiceLogo retrofitService) {
        Retrofit retrofit = retrofitService.buildRedditRetrofit();
        return retrofit.create(GetLogo.class);
    }

}
