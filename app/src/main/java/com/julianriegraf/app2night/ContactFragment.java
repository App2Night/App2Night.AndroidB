package com.julianriegraf.app2night;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

    FloatingActionButton fab_plus, fab_facebook, fab_twitter, fab_googleplus, fab_vimeo, fab_instagram;
    Animation FabOpen,FabClose,FabRClockwise, FabRAntiClockwise;
    boolean isOpen = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.contact, container, false);



        fab_plus = (FloatingActionButton) v.findViewById(R.id.fab_plus);
        fab_facebook = (FloatingActionButton) v.findViewById(R.id.fab_facebook);
        fab_twitter = (FloatingActionButton) v.findViewById(R.id.fab_twitter);
        fab_googleplus = (FloatingActionButton) v.findViewById(R.id.fab_googleplus);
        fab_vimeo = (FloatingActionButton) v.findViewById(R.id.fab_vimeo);
        fab_instagram = (FloatingActionButton) v.findViewById(R.id.fab_instagram);

        FabOpen = AnimationUtils.loadAnimation(getContext(), R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getContext(), R.anim.fab_close);
        FabRClockwise = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_clockwise);
        FabRAntiClockwise = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_anticlockwise);

        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isOpen)
                {
                    fab_facebook.startAnimation(FabClose);
                    fab_twitter.startAnimation(FabClose);
                    fab_googleplus.startAnimation(FabClose);
                    fab_vimeo.startAnimation(FabClose);
                    fab_instagram.startAnimation(FabClose);
                    fab_plus.startAnimation(FabRAntiClockwise);
                    fab_facebook.setClickable(false);
                    fab_twitter.setClickable(false);
                    fab_googleplus.setClickable(false);
                    fab_vimeo.setClickable(false);
                    fab_instagram.setClickable(false);
                    isOpen = false;

                }else
                {
                    fab_facebook.startAnimation(FabOpen);
                    fab_twitter.startAnimation(FabOpen);
                    fab_googleplus.startAnimation(FabOpen);
                    fab_vimeo.startAnimation(FabOpen);
                    fab_instagram.startAnimation(FabOpen);
                    fab_plus.startAnimation(FabRClockwise);
                    fab_facebook.setClickable(true);
                    fab_twitter.setClickable(true);
                    fab_googleplus.setClickable(true);
                    fab_vimeo.setClickable(true);
                    fab_instagram.setClickable(true);
                     isOpen = true;
                }
            }
        });

        return v;
    }
}
