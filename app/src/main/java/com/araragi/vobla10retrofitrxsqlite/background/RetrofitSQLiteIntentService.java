package com.araragi.vobla10retrofitrxsqlite.background;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.araragi.vobla10retrofitrxsqlite.database.Dao;
import com.araragi.vobla10retrofitrxsqlite.eventbus.DbUpdatedEvent;
import com.araragi.vobla10retrofitrxsqlite.model.Flight;
import com.araragi.vobla10retrofitrxsqlite.networking.FlightsRetrofitApi;
import com.araragi.vobla10retrofitrxsqlite.networking.FlightsRetrofitService;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by Araragi on 2017-08-31.
 */

public class RetrofitSQLiteIntentService extends IntentService {
    public RetrofitSQLiteIntentService() {
        super("RetrofitSQLiteIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.i("intent", "----intent service has started----");

//        Dao dao = new Dao(this);
//        dao.open();


        //String extras = intent.getStringExtra()

        List<Flight> flights = new LinkedList<>();

        Retrofit retrofit = FlightsRetrofitService.getInstance().getService();
        FlightsRetrofitApi apiService = retrofit.create(FlightsRetrofitApi.class);
        Call<List<Flight>> call = apiService.getFlights();
        try {
            flights = call.execute().body();
        }catch (Exception e){
            e.printStackTrace();
            EventBus.getDefault().post(new DbUpdatedEvent(DbUpdatedEvent.NO_INTERNET));

        }
        try {

            Dao dao = new Dao(this);
            dao.open();
           // dao.
            for (Flight flight : flights) {


                dao.insertFlightIfNotExist(flight);
                Log.i("service", "----- From inet: " + flight.toString());

            }
            dao.close();
            EventBus.getDefault().post(new DbUpdatedEvent(DbUpdatedEvent.DB_UPDATED));

        }catch (Exception e){
            e.printStackTrace();
            EventBus.getDefault().post(new DbUpdatedEvent(DbUpdatedEvent.DB_EXCEPTION));

        }

    }
}

