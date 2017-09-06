package com.araragi.vobla10retrofitrxsqlite.database;

/**
 * Created by Araragi on 2017-08-27.
 */

public class DBContract {


    public static final String KEY_TRAVEL_OPTION_ID = "travelOptionId";
    public static final String KEY_DEPARTURE_DATE_TIME = "departureDateTime";
    public static final String KEY_RETURN_DATE_TIME = "returnDateTime";
    public static final String KEY_DEPARTURE_CITY = "departureCity";
    public static final String KEY_DESTINATION_CITY = "destinationCity";
    public static final String KEY_DESTINATION_CITY_PICTURE_URL = "destinationCityPictureUrl";
    public static final String KEY_FINAL_PRICE = "finalPrice";
    public static final String KEY_TICKET_SERVICE_URL = "ticketServiceUrl";
    public static final String KEY_IS_DELETED = "isDeleted";

    public static final int COL_TRAVEL_OPTION_ID = 0;
    public static final int COL_DEPARTURE_DATE_TIME = 1;
    public static final int COL_RETURN_DATE_TIME = 2;
    public static final int COL_DEPARTURE_CITY = 3;
    public static final int COL_DESTINATION_CITY = 4;
    public static final int COL_DESTINATION_CITY_PICTURE_URL = 5;
    public static final int COL_FINAL_PRICE = 6;
    public static final int COL_TICKET_SERVICE_URL = 7;
    public static final int COL_IS_DELETED = 8;




    public static final String[] ALL_KEYS_FLIGHTS = new String[]{
            KEY_TRAVEL_OPTION_ID,
            KEY_DEPARTURE_DATE_TIME,
            KEY_RETURN_DATE_TIME,
            KEY_DEPARTURE_CITY,
            KEY_DESTINATION_CITY,
            KEY_DESTINATION_CITY_PICTURE_URL,
            KEY_FINAL_PRICE,
            KEY_TICKET_SERVICE_URL,
            KEY_IS_DELETED
    };


    public static final String DATABASE_NAME = "vobla10.db";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_TABLE_FLIGHTS = "flights";


    public static final String DATABASE_CREATE_SCRIPT = "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE_FLIGHTS +
            " (" + KEY_TRAVEL_OPTION_ID + " TEXT NOT NULL, " +
            KEY_DEPARTURE_DATE_TIME + " TEXT NOT NULL, " +
            KEY_RETURN_DATE_TIME + " TEXT NOT NULL, " +
            KEY_DEPARTURE_CITY + " TEXT NOT NULL, " +
            KEY_DESTINATION_CITY + " TEXT NOT NULL," +
            KEY_DESTINATION_CITY_PICTURE_URL + " TEXT NOT NULL, " +
            KEY_FINAL_PRICE + " TEXT NOT NULL, " +
            KEY_TICKET_SERVICE_URL + " TEXT NOT NULL, " +
            KEY_IS_DELETED + " TEXT NOT NULL);";



}
