package com.example.bmicalculator.HomePage1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bmicalculator.MetricUnits.MetricUnitsActivity;
import com.example.bmicalculator.R;
import com.example.bmicalculator.UsUnits.UsUnitActivity;

public class HomePage1Activity extends AppCompatActivity {
Spinner spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page1);
        spinner1=findViewById(R.id.selectunit);
        spinner1.setSelection(0);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1){
                    Intent intent=new Intent(HomePage1Activity.this, UsUnitActivity.class);
                    startActivity(intent);
                    finish();
                }
                if(position==2){
                        Intent intent=new Intent(HomePage1Activity.this, MetricUnitsActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }}