package com.chaeniiz.colco;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RegisterNickFragment extends Fragment {
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_register_nick, container, false);

        return root;
    }

    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
    }

}
