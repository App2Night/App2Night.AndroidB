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

import com.julianriegraf.app2night.BackendConnection.BackendTasks;
import com.julianriegraf.app2night.GPS.GPSAccess;
import com.julianriegraf.app2night.Models.Party;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created by robin on 15.10.2016.
 */

public class ContactFragment extends Fragment {

    TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.contact, container, false);
        tv = (TextView) v.findViewById(R.id.textView);
        return v;
    }
}
