package com.example.homework8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar) findViewById(R.id.testSeekBar);
        seekBar = findViewById(R.id.testSeekBar);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
