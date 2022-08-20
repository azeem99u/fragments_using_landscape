package com.example.android.fragmentsusinglandscape;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DetailFragment.DetailFragmentListener{

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ViewGroup viewGroup = findViewById(R.id.fragmentContainerView2);
//        boolean mUsingFragments = (viewGroup!= null);
//        EventBus.getDefault().post(new EventMessage(mUsingFragments));
//        if (getIntent().hasExtra("s") && getIntent().getStringExtra("s")!= "null"){
//            ArrayList<Parcelable> s = getIntent().getParcelableArrayListExtra("s");
//            Toast.makeText(this, s.toString(), Toast.LENGTH_SHORT).show();
//            getIntent().putExtra("s","null");
//            return;
//        }



        findViewById(R.id.button).setOnClickListener(view -> {
            OutPutFragment fragment = new OutPutFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerViewM,fragment,"mytag").commit();

        });


    }

    @Override
    public void onDetailFragmentFinished(Person person) {
        OutPutFragment outputFragment = (OutPutFragment) getSupportFragmentManager().findFragmentByTag("mytag");
        outputFragment.setPerson(person);
        Toast.makeText(this, person.toString(), Toast.LENGTH_SHORT).show();
    }
}