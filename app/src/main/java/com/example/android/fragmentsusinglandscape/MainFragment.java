package com.example.android.fragmentsusinglandscape;

import android.app.usage.ConfigurationStats;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Objects;

public class MainFragment extends Fragment {

    boolean mUsingFragments;
    private TextView textView;
    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_main, container, false);
        textView = view.findViewById(R.id.textView);
        isLandscapeMode(view);
        Toast.makeText(getContext(), "running", Toast.LENGTH_SHORT).show();

        return view;
    }

    private void isLandscapeMode(View view) {
        if (mUsingFragments){
            DetailFragment  fragment = new DetailFragment();
            textView.setText("true");
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2,fragment).commit();
        }else {

            textView.setText("false");
            view.findViewById(R.id.floatingActionButton).setOnClickListener(v -> {
                requireActivity().startActivity(new Intent(requireActivity(),DetailActivity.class));
            });

        }
    }

    @Subscribe
    public void checkDeviceConfig(EventMessage eventMessage){
        mUsingFragments = eventMessage.ismFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }


}