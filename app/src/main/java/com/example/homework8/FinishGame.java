package com.example.homework8;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FinishGame extends Fragment {
    Button gameContinue;
    TextView onWin;
    public FinishGame() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_finish_game, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gameContinue = view.findViewById(R.id.button_continue);
        onWin = view.findViewById(R.id.onWin);
        final MainActivity mainActivity = (MainActivity) getActivity();
        onWin.setText(mainActivity.onWin);
        MainActivity mainActivity1 = (MainActivity) getActivity();
        gameContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.replay();
            }
        });
    }
}
