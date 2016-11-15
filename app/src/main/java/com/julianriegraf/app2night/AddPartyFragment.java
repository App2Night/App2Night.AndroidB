package com.julianriegraf.app2night;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by robin on 24.10.2016.
 */

public class AddPartyFragment extends Fragment {

    Button pickDate ;
    Button pickTime;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.addparty, container, false);

        pickDate = (Button) v.findViewById(R.id.party_date);
        pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment picker = new DatePickerFragment();
                picker.show(getFragmentManager(), "datePicker");
            }
        });

        pickTime = (Button) v.findViewById(R.id.party_time);
        pickTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getFragmentManager(),"TimePicker");
            }
        });
        return v;
    }
}
