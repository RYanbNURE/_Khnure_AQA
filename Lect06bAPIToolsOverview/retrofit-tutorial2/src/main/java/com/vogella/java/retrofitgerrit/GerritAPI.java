package com.vogella.java.retrofitgerrit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

public interface GerritAPI {

    @GET("changes/")
    Call<List<Change>> loadChanges (@Query("q") String status);

    @POST("changesmake/")
    Call<List<Change>> postChanges (@Query("q") String status);
}
