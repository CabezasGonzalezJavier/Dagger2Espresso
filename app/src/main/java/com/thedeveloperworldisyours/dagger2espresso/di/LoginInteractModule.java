package com.thedeveloperworldisyours.dagger2espresso.di;

import com.thedeveloperworldisyours.dagger2espresso.Interact.LoginInteract;
import com.thedeveloperworldisyours.dagger2espresso.Interact.LoginInteractImpl;
import com.thedeveloperworldisyours.dagger2espresso.service.GetUser;
import com.thedeveloperworldisyours.dagger2espresso.service.RetrofitServiceUser;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;

/**
 * Created by javierg on 05/07/16.
 */
@Module
public class LoginInteractModule {

    @Provides
    public LoginInteract provideLoginInteract(GetUser myApi) {
        return new LoginInteractImpl(myApi);
    }

    @Provides
    @Singleton
    public RetrofitServiceUser providesRetrofitService() {
        return new RetrofitServiceUser();
    }

    @Provides
    @Singleton
    public GetUser providesApiService(RetrofitServiceUser retrofitService) {
        Retrofit retrofit = retrofitService.buildRedditRetrofit();
        return retrofit.create(GetUser.class);
    }

}
