package com.example.quanlythuvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.quanlythuvien.dao.DemoDB;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DemoDB demoDB=new DemoDB(getApplicationContext());

    }
}