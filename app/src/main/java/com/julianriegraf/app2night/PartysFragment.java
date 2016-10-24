package com.julianriegraf.app2night;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


/**
 * Created by robin on 15.10.2016.
 */

public class PartysFragment extends Fragment{
    ListView listView;
    FloatingActionButton fab;
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

        fab = (FloatingActionButton) v.findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() { //Hier fehlt noch der korrektw aufruf
                @Override
                public void onClick(View v) {
                    AddPartyFragment f = new AddPartyFragment();
                    getFragmentManager().beginTransaction().replace(R.id.frame,f).commit();
                }
            });

        Veranstaltungsname = getResources().getStringArray(R.array.Veranstaltungsname);
        Veranstaltungszeitpunkt = getResources().getStringArray(R.array.Veranstaltungszeitpunkt);
        Veranstaltungsort = getResources().getStringArray(R.array.Veranstaltungsort);
        Veranstalter = getResources().getStringArray(R.array.Veranstalter);
        Veranstaltungseintritt = getResources().getStringArray(R.array.Veranstaltungseintritt);

        int i = 0;

        adapter = new PartyAdapter(getActivity(),R.layout.row_layout);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), Veranstaltungsname[position]+ " selected", Toast.LENGTH_SHORT).show();
                view.setSelected(true);


                //Detail Information von Party's implementieren



            }
        });

        for(String name: Veranstaltungsname)
        {
            PartyDataProvider dataProvider = new PartyDataProvider(location_banner_ressource[0], name, Veranstaltungszeitpunkt[i], Veranstaltungsort[i], Veranstalter[i], Veranstaltungseintritt[i]);
            adapter.add(dataProvider);

            i++;
        }


        return v;
    }
}
