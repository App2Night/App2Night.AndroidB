package com.julianriegraf.app2night;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
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

import com.julianriegraf.app2night.BackendConnection.BackendTasks;
import com.julianriegraf.app2night.Models.Party;

/**
 * Created by robin on 15.10.2016.
 */

public class PartysFragment extends Fragment {
    ListView listView;
    FloatingActionButton fab;
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
                getFragmentManager().beginTransaction().replace(R.id.frame, f).commit();
            }
        });

        // User einloggen und Token setzen
        // TODO: Auslagern in LoginActivity
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    BackendTasks bt = new BackendTasks();
                    String token = bt.login("test", "test");
                    bt.setToken(token);
                    return null;
                } catch (Exception e) {
                    return null;
                }
            }

        }.execute();

        adapter = new PartyAdapter(getActivity(), R.layout.row_layout, listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()

                                        {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                view.setSelected(true);
                                                //TODO:Detail Information von Party's implementieren
                                                Party party = (Party) parent.getItemAtPosition(position);
                                                Toast.makeText(parent.getContext(), party.getPartyName(), Toast.LENGTH_SHORT).show();
                                            }
                                        }
        );
        checkInternetConnection();
        return v;
    }

    private void checkInternetConnection() {
        ConnectivityManager cm = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (!(activeNetwork != null && activeNetwork.isConnectedOrConnecting())) {
            Toast.makeText(getContext(), "Please check internet connection.", Toast.LENGTH_LONG).show();
        }
    }

    public void makeToast(String str) {
        Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
    }

}
