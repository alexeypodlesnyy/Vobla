package com.araragi.vobla10retrofitrxsqlite.eventbus;

/**
 * Created by Araragi on 2017-09-02.
 */

public class DbUpdatedEvent {

    public final String resultOfDbUpdate;

    public DbUpdatedEvent(String message){
        this.resultOfDbUpdate = message;
    }



}
