package com.example.homework8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView secretNumber, source;
    FrameLayout firstContainer, secondContainer;
    SecretNumber fragmentSecretNumber;
    public int number, intSecretNumber, sourceNumber;
    SeekBar seekBar;
    FinishGame finishGame;
    Random random;
    String onWin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        setContentView(R.layout.activity_main);
        secretNumber = findViewById(R.id.secretNumber);
        random = new Random();
        secretNumber.setText(random.nextInt(100) + "");
        intSecretNumber = Integer.valueOf(secretNumber.getText().toString());
        Log.d("lol", intSecretNumber + "");
        source = findViewById(R.id.source);
        firstContainer = findViewById(R.id.container);
        secondContainer = findViewById(R.id.containerSecond);
        fragmentSecretNumber = new SecretNumber();
        seekBar = new SeekBar();
        finishGame = new FinishGame();
        transaction.replace(R.id.container, fragmentSecretNumber);
        transaction.replace(R.id.containerSecond, seekBar);
        transaction.commit();
    }

    public void choiceNumber(int number){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (number == Integer.valueOf(secretNumber.getText().toString())){
        sourceNumber += 100;
        source.setText("Source: " + sourceNumber);
        onWin = "You win!";
    } else onWin = "You lose...";
        transaction.remove(fragmentSecretNumber);
        transaction.replace(R.id.containerSecond, finishGame);
        this.number = number;
        transaction.commit();
    }

    public void replay(){
        seekBar = new SeekBar();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.containerSecond, seekBar);
        transaction.replace(R.id.container, fragmentSecretNumber);
        transaction.commit();
        secretNumber.setText(random.nextInt(100) + "");
        intSecretNumber = Integer.valueOf(secretNumber.getText().toString());
    }

}
