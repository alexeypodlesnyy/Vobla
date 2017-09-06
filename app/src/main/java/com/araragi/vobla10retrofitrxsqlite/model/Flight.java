package com.araragi.vobla10retrofitrxsqlite.model;

import android.database.Cursor;
import android.util.Log;

import com.araragi.vobla10retrofitrxsqlite.database.DBContract;

/**
 * Created by Araragi on 2017-08-27.
 */

public class Flight {



    private String travelOptionId;

    private String departureDateTime;
    private String returnDateTime;
    private String departureCity;
    private String destinationCity;
    private String destinationCityPictureUrl;
    private double finalPrice;
    private String ticketServiceUrl;
    private boolean isDeleted;


    public Flight(){
        this.isDeleted = false;
    }

    public Flight(String travelOptionId, String departureDateTime, String returnDateTime,
                  String departureCity, String destinationCity, String destinationCityPictureUrl,
                  double finalPrice, String ticketServiceUrl) {

        this.travelOptionId = travelOptionId;
        this.departureDateTime = departureDateTime;
        this.returnDateTime = returnDateTime;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.destinationCityPictureUrl = destinationCityPictureUrl;
        this.finalPrice = finalPrice;
        this.ticketServiceUrl = ticketServiceUrl;
        this.isDeleted = false;
    }

    public Flight(Cursor cursor) {
        this.travelOptionId = cursor.getString(DBContract.COL_TRAVEL_OPTION_ID);
        //Log.i("flight", "---- Flight from cursor constructor: travel option id: " + travelOptionId);
        this.departureDateTime = cursor.getString(DBContract.COL_DEPARTURE_DATE_TIME);
        //Log.i("flight", "---- Flight from cursor constructor: departure date " + departureDateTime);
        this.returnDateTime = cursor.getString(DBContract.COL_RETURN_DATE_TIME);
        //Log.i("flight", "---- Flight from cursor constructor: return date: " + returnDateTime);
        this.departureCity = cursor.getString(DBContract.COL_DEPARTURE_CITY);
       // Log.i("flight", "---- Flight from cursor constructor: departure city: " + departureCity);
        this.destinationCity = cursor.getString(DBContract.COL_DESTINATION_CITY);
       // Log.i("flight", "---- Flight from cursor constructor: destination city: " + destinationCity);
        this.destinationCityPictureUrl = cursor.getString(DBContract.COL_DESTINATION_CITY_PICTURE_URL);
       // Log.i("flight", "---- Flight from cursor constructor: destination picture: " + destinationCityPictureUrl);
        this.finalPrice = Double.parseDouble(cursor.getString(DBContract.COL_FINAL_PRICE));
       // Log.i("flight", "---- Flight from cursor constructor: price: " + finalPrice);
        this.ticketServiceUrl = cursor.getString(DBContract.COL_TICKET_SERVICE_URL);
       // Log.i("flight", "---- Flight from cursor constructor: url: " + ticketServiceUrl);
        String isDeletedTemp = cursor.getString(DBContract.COL_IS_DELETED);

       // Log.i("flight", "---- Flight from cursor constructor: isDeleted: " + isDeletedTemp);

        if(isDeletedTemp.equals("1")){
            this.isDeleted = true;
        }else{
            this.isDeleted = false;
        }
    }

    public String getTravelOptionId() {
        return travelOptionId;
    }

    public void setTravelOptionId(String travelOptionId) {
        this.travelOptionId = travelOptionId;
    }

    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public String getReturnDateTime() {
        return returnDateTime;
    }

    public void setReturnDateTime(String returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDestinationCityPictureUrl() {
        return destinationCityPictureUrl;
    }

    public void setDestinationCityPictureUrl(String destinationCityPictureUrl) {
        this.destinationCityPictureUrl = destinationCityPictureUrl;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getTicketServiceUrl() {
        return ticketServiceUrl;
    }

    public void setTicketServiceUrl(String ticketServiceUrl) {
        this.ticketServiceUrl = ticketServiceUrl;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        this.isDeleted = deleted;
    }

    @Override
    public String toString(){
        return "Flight:{from: " + this.getDepartureCity() + " " + this.getDepartureDateTime() +
                ", to: " + this.getDestinationCity() + " " + this.getReturnDateTime() +
                ", final price = " +  this.getFinalPrice() +
                ", isMarkedAsDeleted: " + this.getIsDeleted();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


}
