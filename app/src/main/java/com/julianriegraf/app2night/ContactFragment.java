package com.julianriegraf.app2night;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.julianriegraf.app2night.BackendConnection.BackendConnector;
import com.julianriegraf.app2night.BackendConnection.BackendTasks;
import com.julianriegraf.app2night.Models.Party;

/**
 * Created by robin on 15.10.2016.
 */


public class ContactFragment extends Fragment {

    TextView tv;
    Button btn;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.contact, container, false);
        tv = (TextView) v.findViewById(R.id.textView);
        btn = (Button) v.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new AsyncTask<Void, Void, Party>() {

                    @Override
                    protected Party doInBackground(Void... params) {
                        BackendTasks bt = new BackendTasks();
                        try {
                            return bt.getParty("50db0c93-b3f0-463c-e9b7-08d3fcc1f196");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Party result) {
                        if(result != null){
                            setText(result.getName());
                        }

                    }

                }.execute();
            }
        });
        return v;
    }


    private void setText(String s) {
        tv.setText(s);
    }


}
