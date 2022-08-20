package com.example.android.fragmentsusinglandscape;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements DetailFragment.DetailFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle("detail activity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toast.makeText(this, "run", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDetailFragmentFinished(Person person) {

        Intent intent = new Intent(this,MainActivity.class);
        intent.putParcelableArrayListExtra("s", person);
        startActivity(intent);

        DetailActivity.this.finish();
    }
}