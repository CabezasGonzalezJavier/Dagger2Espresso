package com.thedeveloperworldisyours.dagger2espresso.service;

import com.thedeveloperworldisyours.dagger2espresso.model.Logo;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by javierg on 06/07/16.
 */
public interface GetLogo {
    @GET("api/v1/company.json")
    Call<Logo> getLogoCall();
}
