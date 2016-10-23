package com.julianriegraf.app2night;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * Created by robin on 15.10.2016.
 */

public class PartysFragment extends Fragment{
    ListView listView;
    int[] location_banner_ressource = {R.drawable.platzhalterbanner}; //weitere Banner dem Array hinzufügen
    String[] Veranstaltungsname;
    String[] Veranstaltungszeitpunkt;
    String[] Veranstaltungsort;
    String[] Veranstalter;
    String[] Veranstaltungseintritt;
    PartyAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.partys, container, false);
        listView = (ListView) v.findViewById(R.id.list_view);
        Veranstaltungsname = getResources().getStringArray(R.array.Veranstaltungsname);
        Veranstaltungszeitpunkt = getResources().getStringArray(R.array.Veranstaltungszeitpunkt);
        Veranstaltungsort = getResources().getStringArray(R.array.Veranstaltungsort);
        Veranstalter = getResources().getStringArray(R.array.Veranstalter);
        Veranstaltungseintritt = getResources().getStringArray(R.array.Veranstaltungseintritt);

        int i = 0;

        adapter = new PartyAdapter(getActivity(),R.layout.row_layout);
        listView.setAdapter(adapter);

        for(String name: Veranstaltungsname)
        {
            PartyDataProvider dataProvider = new PartyDataProvider(location_banner_ressource[0], name, Veranstaltungszeitpunkt[i], Veranstaltungsort[i], Veranstalter[i], Veranstaltungseintritt[i]);
            adapter.add(dataProvider);

            i++;
        }


        return v;
    }
}
