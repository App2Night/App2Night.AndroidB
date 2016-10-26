package com.julianriegraf.app2night;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.julianriegraf.app2night.BackendConnection.BackendTasks;
import com.julianriegraf.app2night.Models.Party;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by robin on 23.10.2016.
 */

public class PartyAdapter extends ArrayAdapter {

    private final LayoutInflater inflator;
    List<Party> partyList;
    ListView listview;

    public PartyAdapter(Context context, int resource, ListView listview) {
        super(context, resource);
        this.listview = listview;
        inflator = LayoutInflater.from(context);
        partyList = new ArrayList<Party>();
        refresh();
    }

    public void refresh() {
        partyList.clear();
        new AsyncTask<List<Party>, Void, Void>() {

            @Override
            protected Void doInBackground(List<Party>... params) {
                Party[] parties = new BackendTasks().getParties();
                params[0].addAll(Arrays.asList(parties));
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                refreshHelper();
            }
        }.execute(partyList);
    }

    private void refreshHelper() {
        this.notifyDataSetChanged();
    }

    static class DataHandler {
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
        partyList.add((Party) object);
    }

    @Override
    public int getCount() {
        return this.partyList.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return this.partyList.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DataHandler handler;

        if (convertView == null) {
            convertView = inflator.inflate(R.layout.row_layout, parent, false);
            handler = new DataHandler();
            handler.Banner = (ImageView) convertView.findViewById(R.id.banner);
            handler.name = (TextView) convertView.findViewById(R.id.veranstaltungsname);
            handler.zeitpunkt = (TextView) convertView.findViewById(R.id.datum);
            handler.ort = (TextView) convertView.findViewById(R.id.ort);
            handler.veranstalter = (TextView) convertView.findViewById(R.id.veranstalter);
            handler.eintritt = (TextView) convertView.findViewById(R.id.preis);
            convertView.setTag(handler);
        } else {
            handler = (DataHandler) convertView.getTag();
        }

        Context context = parent.getContext();
        Party party = (Party) getItem(position);
        handler.Banner.setImageResource(R.drawable.platzhalterbanner);
        try {
            handler.name.setText(party.getPartyName());
        } catch (Exception e) {
            handler.name.setText("not found");
        }
        try {
            handler.eintritt.setText(party.getPrice());
        } catch (Exception e) {
            handler.eintritt.setText("not found");
        }
        try {
            handler.veranstalter.setText(party.getHost().getUsernamen());
        } catch (Exception e) {
            handler.veranstalter.setText("not found");
        }
        try {
            handler.zeitpunkt.setText(party.getPartyDate());
        } catch (Exception e) {
            handler.zeitpunkt.setText("not found");
        }
        try {
            handler.ort.setText(party.getLocation().getCityName());
        } catch (Exception e) {
            handler.ort.setText("not found");
        }
        return convertView;
    }
}
