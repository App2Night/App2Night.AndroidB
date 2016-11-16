package com.julianriegraf.app2night;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by robin on 24.10.2016.
 */

public class AddPartyFragment extends Fragment {

    Button pickDate ;
    Button pickTime;
    Button einreichen;
    ImageView location;
    Spinner eintritt;
    Spinner musikrichtung;
    String item;
    int spinner_position;


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

        location = (ImageView) v.findViewById(R.id.location_view);
        location.setClickable(true);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Die Location ist der derzeitige Aufenthaltsort", Toast.LENGTH_LONG).show();
                //TODO: Implementieren des automatischen Ausfüllens des Textfeldes aufgrund der derzeitigen GPS Location
            }
        });

        eintritt = (Spinner) v.findViewById(R.id.party_price);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.EuroBeträge, android.R.layout.simple_spinner_dropdown_item);


        eintritt.setAdapter(adapter);

        eintritt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int postition, long id) {

                item = eintritt.getSelectedItem().toString();
                if (!item.equals("Eintritt wählen"))
                {
                    spinner_position = adapter.getPosition(item);
                    eintritt.setSelection(spinner_position);
                    Toast.makeText(getContext(),eintritt.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();

                }else
                {
                    //nothing
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        musikrichtung = (Spinner) v.findViewById(R.id.party_music);
        final ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(), R.array.Musikrichtungen, android.R.layout.simple_spinner_dropdown_item);
        musikrichtung.setAdapter(adapter2);

        musikrichtung.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                item = musikrichtung.getSelectedItem().toString();
                if (!item.equals("Musikrichtung wählen"))
                {
                    spinner_position = adapter2.getPosition(item);
                    musikrichtung.setSelection(spinner_position);
                    Toast.makeText(getContext(),musikrichtung.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();

                }else
                {
                    //nothing
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        einreichen = (Button) v.findViewById(R.id.einreichen);
        einreichen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Implementieren des Einreichens
            }
        });

        return v;
    }
}
