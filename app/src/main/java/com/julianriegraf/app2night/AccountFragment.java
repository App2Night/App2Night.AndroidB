package com.julianriegraf.app2night;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by robin on 15.10.2016.
 */

public class AccountFragment extends android.support.v4.app.Fragment {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.account, container, false);
            return v;
        }
}
