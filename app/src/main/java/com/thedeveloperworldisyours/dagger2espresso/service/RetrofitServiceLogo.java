package com.thedeveloperworldisyours.dagger2espresso.service;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by javierg on 06/07/16.
 */
public class RetrofitServiceLogo {
    public Retrofit buildRedditRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://fusion.fusion-universal.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
