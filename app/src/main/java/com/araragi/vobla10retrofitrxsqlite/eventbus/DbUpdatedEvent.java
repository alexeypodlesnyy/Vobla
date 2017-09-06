package com.araragi.vobla10retrofitrxsqlite.eventbus;

/**
 * Created by Araragi on 2017-09-02.
 */

public class DbUpdatedEvent {

    public static final String DB_UPDATED = "db updated";
    public static final String NO_INTERNET = "no internet";
    public static final String DB_EXCEPTION = "db exception";


    public final String resultOfDbUpdate;

    public DbUpdatedEvent(String message){
        this.resultOfDbUpdate = message;
    }



}
