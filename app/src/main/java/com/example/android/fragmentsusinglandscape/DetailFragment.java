package com.example.android.fragmentsusinglandscape;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DetailFragment extends Fragment {

    EditText fName,lName,age;
    Button add;
    private DetailFragmentListener mListener;
    public DetailFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fName = view.findViewById(R.id.fNameEt);
        lName = view.findViewById(R.id.lNameEt);
        age = view.findViewById(R.id.ageEt);
        add = view.findViewById(R.id.btnAdd);
        add.setOnClickListener(view1 -> {
            Person person = new Person(fName.getText().toString(),lName.getText().toString(), Integer.parseInt(age.getText().toString()));
            Toast.makeText(getContext(), "hi", Toast.LENGTH_SHORT).show();
            if (mListener != null){
                mListener.onDetailFragmentFinished(person);
            }

        });
    }

    public interface DetailFragmentListener{
        void onDetailFragmentFinished(Person person);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof DetailFragmentListener){
            mListener = (DetailFragmentListener) context;
        }
    }
}