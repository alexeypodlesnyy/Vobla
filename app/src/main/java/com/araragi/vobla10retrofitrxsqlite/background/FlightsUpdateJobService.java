package com.araragi.vobla10retrofitrxsqlite.background;

import android.content.Intent;

import com.araragi.vobla10retrofitrxsqlite.model.Flight;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

/**
 * Created by Araragi on 2017-09-10.
 */

public class FlightsUpdateJobService extends JobService{
    @Override
    public boolean onStartJob(JobParameters job) {

        Intent intent = new Intent(this, RetrofitSQLiteIntentService.class);
        startService(intent);

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters job) {
        return false;
    }
}
