package com.thedeveloperworldisyours.dagger2espresso.service;

import com.thedeveloperworldisyours.dagger2espresso.model.Example;
import com.thedeveloperworldisyours.dagger2espresso.model.Logo;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by javierg on 04/07/16.
 */
public interface GetUser {
    @GET("key/value/one/two")
    Call<Example> getExampleCall();

}
