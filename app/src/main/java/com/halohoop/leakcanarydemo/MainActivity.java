package com.halohoop.leakcanarydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View viewById = findViewById(R.id.tv);
        viewById.setOnClickListener(this);
        SingleInstance instance = SingleInstance.getInstance();
        instance.addActivity(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, Main2Activity.class));
    }
}
