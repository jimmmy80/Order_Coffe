package com.example.admin.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    TextView textview;
    Switch bswitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = (TextView) findViewById(R.id.result_text);
        textview.setVisibility(View.INVISIBLE);
        bswitch = (Switch) findViewById(R.id.switchOn);
        bswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                  if(isChecked){
                      textview.setText("Wifi is on");
                      textview.setVisibility(View.VISIBLE);
                  }
                else
                      textview.setText("Wifi is Off");
                      textview.setVisibility(View.VISIBLE);
            }
        });
    }

    public void changeVibrateState(View view) {
        boolean checked = ((ToggleButton) view).isChecked();
        if (checked) {
            textview.setText("Vibrate on");
            textview.setVisibility(View.VISIBLE);
        } else {
            textview.setText("Vibrate Off");
        }
    }
}