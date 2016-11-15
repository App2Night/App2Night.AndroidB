package com.julianriegraf.app2night;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.Button;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by robin on 15.11.2016.
 */

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hour, minute, true);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {

        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);

        SimpleDateFormat sdf = new SimpleDateFormat("HH-mm");
        String formattedDate = sdf.format(c.getTime());

        Button timepicker = (Button) getActivity().findViewById(R.id.party_time);
        timepicker.setText(formattedDate);

    }
}
