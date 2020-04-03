package com.example.homework8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    TextView secretNumber, source;
    FrameLayout firstContainer, secondContainer;
    SecretNumber fragmentSecretNumber;
    int number;
    SeekBar seekBar;
    FinishGame finishGame;
    Random random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        secretNumber = findViewById(R.id.secretNumber);
        secretNumber.setText(random.nextInt(100));
        source = findViewById(R.id.source);
        firstContainer = findViewById(R.id.container);
        secondContainer = findViewById(R.id.containerSecond);
        fragmentSecretNumber = new SecretNumber();
        seekBar = new SeekBar();
        transaction.replace(R.id.container, fragmentSecretNumber);
        transaction.replace(R.id.containerSecond, seekBar);
        transaction.commit();
    }

    public void choiceNumber(int number){
        transaction.replace(R.id.containerSecond, finishGame);
        transaction.replace(R.id.container, null);
        this.number = number;
        transaction.commit();
    }

}
