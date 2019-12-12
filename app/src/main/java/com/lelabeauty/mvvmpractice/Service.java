package com.lelabeauty.mvvmpractice;

import com.lelabeauty.mvvmpractice.model.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface Service {

    String baseUrl = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Person>> getPersonList();


}
