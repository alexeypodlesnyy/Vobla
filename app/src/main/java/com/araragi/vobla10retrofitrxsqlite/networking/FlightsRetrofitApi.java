package com.araragi.vobla10retrofitrxsqlite.networking;

import com.araragi.vobla10retrofitrxsqlite.model.Flight;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Araragi on 2017-08-27.
 */

public interface FlightsRetrofitApi {


    @GET("poll/")
    Call<List<Flight>> getFlights();


}
