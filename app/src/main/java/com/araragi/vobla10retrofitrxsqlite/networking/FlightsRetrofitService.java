package com.araragi.vobla10retrofitrxsqlite.networking;

import com.araragi.vobla10retrofitrxsqlite.model.Flight;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Araragi on 2017-08-27.
 */

public class FlightsRetrofitService implements Callback<List<Flight>> {



    private static FlightsRetrofitService instance;

    private FlightsRetrofitService(){

        if (instance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static FlightsRetrofitService getInstance(){
        if (instance == null){
            instance = new FlightsRetrofitService();
        }

        return instance;
    }


    public Retrofit getService(){

        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson gson = gsonBuilder.create();

        OkHttpClient client = new OkHttpClient.Builder()
                //.connectTimeout(1, TimeUnit.SECONDS)
                //.writeTimeout(1, TimeUnit.SECONDS)
                //.readTimeout(30, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("http://stockreleaser.com/travel/")
                .client(client)
                //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }

    @Override
    public void onResponse(Call<List<Flight>> call, Response<List<Flight>> response) {
        if(response.isSuccessful()) {
            List<Flight> flightsList = response.body();
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Flight>> call, Throwable t) {
        t.printStackTrace();
    }
}


