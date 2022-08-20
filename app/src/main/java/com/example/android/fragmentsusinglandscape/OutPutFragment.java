package com.example.android.fragmentsusinglandscape;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OutPutFragment extends Fragment {

    public void setPerson(Person person) {
        textView.setText(person.toString());
    }

    TextView textView;
    public OutPutFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_out_put, container, false);

        textView = view.findViewById(R.id.textView11);
        return view;
    }

}