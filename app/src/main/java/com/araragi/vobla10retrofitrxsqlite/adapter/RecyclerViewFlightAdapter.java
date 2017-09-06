package com.araragi.vobla10retrofitrxsqlite.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.araragi.vobla10retrofitrxsqlite.R;
import com.araragi.vobla10retrofitrxsqlite.model.Flight;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Araragi on 2017-09-02.
 */

public class RecyclerViewFlightAdapter  extends RecyclerView.Adapter<RecyclerViewFlightAdapter.FlightViewHolder> {


    private LinkedList<Flight> flightsDataSet;
    private int rowLayoutId;
    private Context localContext;

    public RecyclerViewFlightAdapter(LinkedList<Flight> flights, int layoutID){
        this.flightsDataSet = flights;
        this.rowLayoutId = layoutID;
    }


    @Override
    public FlightViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row, parent, false);

        localContext = parent.getContext();

        return new FlightViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FlightViewHolder holder, int position) {

        Flight flight = flightsDataSet.get(position);
        holder.title.setText(flight.getDestinationCity() + "  " + flight.getFinalPrice() +
            "\n" + flight.getDepartureDateTime());
       // holder.imageView.setImageBitmap(null);
        Picasso.with(localContext)
                .load("http://stockreleaser.com" + flight.getDestinationCityPictureUrl())
                .placeholder(R.drawable.androidapple)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount(){
        return flightsDataSet.size();
    }


    public static class FlightViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;

        FlightViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.picture_city);
            title = (TextView) itemView.findViewById(R.id.flight_info);
        }
    }

}