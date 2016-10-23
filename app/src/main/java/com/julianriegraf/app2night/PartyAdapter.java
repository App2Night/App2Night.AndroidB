package com.julianriegraf.app2night;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 23.10.2016.
 */

public class PartyAdapter extends ArrayAdapter {

    List list = new ArrayList();


    public PartyAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class DataHandler
    {
        ImageView Banner;
        TextView name;
        TextView zeitpunkt;
        TextView ort;
        TextView veranstalter;
        TextView eintritt;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        DataHandler handler;

        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row_layout, parent, false);
            handler = new DataHandler();
            handler.Banner = (ImageView) row.findViewById(R.id.banner);
            handler.name = (TextView) row.findViewById(R.id.veranstaltungsname);
            handler.zeitpunkt = (TextView) row.findViewById(R.id.datum);
            handler.ort = (TextView) row.findViewById(R.id.ort);
            handler.veranstalter = (TextView) row.findViewById(R.id.veranstalter);
            handler.eintritt = (TextView) row.findViewById(R.id.preis);
            row.setTag(handler);
        }else
        {
            handler = (DataHandler) row.getTag();
        }

        PartyDataProvider dataProvider;
        dataProvider = (PartyDataProvider) this.getItem(position);
        handler.Banner.setImageResource(dataProvider.getParty_banner_resource());
        handler.name.setText(dataProvider.getVeranstaltungsname());
        handler.eintritt.setText(dataProvider.getVeranstaltungseintritt());
        handler.veranstalter.setText(dataProvider.getVeranstalter());
        handler.zeitpunkt.setText(dataProvider.getVeranstaltungszeitpunkt());
        handler.ort.setText(dataProvider.getVeranstaltungsort());

        return row;
    }
}
