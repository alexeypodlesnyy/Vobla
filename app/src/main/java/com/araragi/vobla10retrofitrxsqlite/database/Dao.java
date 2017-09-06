package com.araragi.vobla10retrofitrxsqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.araragi.vobla10retrofitrxsqlite.model.Flight;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Araragi on 2017-08-27.
 */

public class Dao {

    private final Context context;

    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public Dao(Context ctx){
        this.context = ctx;
        dbHelper = DatabaseHelper.getInstance(context);
    }

    public Dao open(){
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }



    public Flight getFlight(String uuid){

        String where = DBContract.KEY_TRAVEL_OPTION_ID + "=?";
        String[] whereArgs = {uuid};

        Cursor c = 	database.query(
                DBContract.DATABASE_TABLE_FLIGHTS,
                DBContract.ALL_KEYS_FLIGHTS,
                where,
                whereArgs,
                null, null, null, null);
        if (c != null && c.getCount()>0) {
            c.moveToFirst();
            return new Flight(c);
        }else {
            return null;
        }
    }



    public long insertFlight(Flight flight){

        ContentValues values = new ContentValues();

        values.put(DBContract.KEY_TRAVEL_OPTION_ID, flight.getTravelOptionId());
        values.put(DBContract.KEY_DEPARTURE_DATE_TIME, flight.getDepartureDateTime());
        values.put(DBContract.KEY_RETURN_DATE_TIME, flight.getReturnDateTime());
        values.put(DBContract.KEY_DEPARTURE_CITY, flight.getDepartureCity());
        values.put(DBContract.KEY_DESTINATION_CITY, flight.getDestinationCity());
        values.put(DBContract.KEY_DESTINATION_CITY_PICTURE_URL, flight.getDestinationCityPictureUrl());
        values.put(DBContract.KEY_FINAL_PRICE, flight.getFinalPrice());
        values.put(DBContract.KEY_TICKET_SERVICE_URL, flight.getTicketServiceUrl());
        values.put(DBContract.KEY_IS_DELETED, flight.getIsDeleted()?"1":"0");

        return database.insert(DBContract.DATABASE_TABLE_FLIGHTS, null, values);

    }
    public long insertFlightIfNotExist(Flight flight){

        String uuId = flight.getTravelOptionId();
        if(getFlight(uuId) == null) {

            ContentValues values = new ContentValues();
            values.put(DBContract.KEY_TRAVEL_OPTION_ID, flight.getTravelOptionId());
            values.put(DBContract.KEY_DEPARTURE_DATE_TIME, flight.getDepartureDateTime());
            values.put(DBContract.KEY_RETURN_DATE_TIME, flight.getReturnDateTime());
            values.put(DBContract.KEY_DEPARTURE_CITY, flight.getDepartureCity());
            values.put(DBContract.KEY_DESTINATION_CITY, flight.getDestinationCity());
            values.put(DBContract.KEY_DESTINATION_CITY_PICTURE_URL, flight.getDestinationCityPictureUrl());
            values.put(DBContract.KEY_FINAL_PRICE, flight.getFinalPrice());
            values.put(DBContract.KEY_TICKET_SERVICE_URL, flight.getTicketServiceUrl());
            values.put(DBContract.KEY_IS_DELETED, flight.getIsDeleted() ? "1" : "0");

            return database.insert(DBContract.DATABASE_TABLE_FLIGHTS, null, values);
        }else{
            return -1;
        }

    }

    public int deleteFlight(Flight flight){

        String where = DBContract.KEY_TRAVEL_OPTION_ID + "=?";
        String[] whereArgs = {flight.getTravelOptionId()};

        return database.delete(DBContract.DATABASE_TABLE_FLIGHTS, where, whereArgs);

    }
    public int deleteFlight(String travelOptionId){

        String where = DBContract.KEY_TRAVEL_OPTION_ID + "=?";
        String[] whereArgs = {travelOptionId};


        return database.delete(DBContract.DATABASE_TABLE_FLIGHTS, where, whereArgs);

    }



    public boolean deleteAll(){

        String where = "1";

        return database.delete(DBContract.DATABASE_TABLE_FLIGHTS, where, null) != 0;

    }



    public boolean updateFlight(String travelOptionId, Flight flight){

        String where = DBContract.KEY_TRAVEL_OPTION_ID + "=?";
        String[] whereArgs = {travelOptionId};

        ContentValues newValues = new ContentValues();

        newValues.put(DBContract.KEY_DEPARTURE_DATE_TIME, flight.getDepartureDateTime());
        newValues.put(DBContract.KEY_RETURN_DATE_TIME, flight.getReturnDateTime());
        newValues.put(DBContract.KEY_DEPARTURE_CITY, flight.getDepartureCity());
        newValues.put(DBContract.KEY_DESTINATION_CITY, flight.getDestinationCity());
        newValues.put(DBContract.KEY_DESTINATION_CITY_PICTURE_URL, flight.getDestinationCityPictureUrl());
        newValues.put(DBContract.KEY_FINAL_PRICE, flight.getFinalPrice());
        newValues.put(DBContract.KEY_TICKET_SERVICE_URL, flight.getTicketServiceUrl());
        newValues.put(DBContract.KEY_IS_DELETED, flight.getIsDeleted()?"1":"0");

        return database.update(DBContract.DATABASE_TABLE_FLIGHTS, newValues, where, null) != 0;
    }
    public int markAsDeleted(String travelOptionId){
        String where = DBContract.KEY_TRAVEL_OPTION_ID + "=?";
        String[] whereArgs = {travelOptionId};
        ContentValues newValues = new ContentValues();
        newValues.put(DBContract.KEY_IS_DELETED, "1");

        return database.update(DBContract.DATABASE_TABLE_FLIGHTS, newValues, where, whereArgs);
    }

    public LinkedList<Flight> getAllFlights(){

        String where = null;
        LinkedList<Flight> flightList = new LinkedList<>();
        Cursor c = database.query(true, DBContract.DATABASE_TABLE_FLIGHTS, DBContract.ALL_KEYS_FLIGHTS,
                where, null, null, null,
                DBContract.KEY_DEPARTURE_DATE_TIME, null);
        if(c != null && c.getCount()>0){
            c.moveToFirst();
            do {
                flightList.add(new Flight(c));
            }while(c.moveToNext());
        }
        return flightList;

    }
    public LinkedList<Flight> getAllFlightsNotDeleted(){

        String where = DBContract.KEY_IS_DELETED + "=?";
        String[] whereArgs = {"0"};
        LinkedList<Flight> flightList = new LinkedList<>();
        Cursor c = database.query(true, DBContract.DATABASE_TABLE_FLIGHTS, DBContract.ALL_KEYS_FLIGHTS,
                where, whereArgs, null, null,
                DBContract.KEY_DEPARTURE_DATE_TIME, null);
        if(c != null && c.getCount()>0){
            c.moveToFirst();
            do {
                flightList.add(new Flight(c));
            }while(c.moveToNext());
        }
        return flightList;



    }





}


