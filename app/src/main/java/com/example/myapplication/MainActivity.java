package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button jBtnWeightIncrement, jBtnWtDecrement, jBtnAgeIncrement, jBtnAgeDecrement, jBtnCalculateBmi;
    SeekBar heightSeekBar;
    TextView jHtTextView, jWtTextView;

    private final View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int current_id = view.getId();
            if (current_id == R.id.WeightAdd)
                addWeight();
            else if (current_id == R.id.WeightLess) {
                lessWeight();
            }
        }
    };

    public void addWeight() {
//        Log.d("addweight", "addWeight: called");
        jWtTextView = findViewById(R.id.WeightValue);
        int weight = Integer.parseInt(jWtTextView.getText().toString());
        weight += 1;
        jWtTextView.setText(String.valueOf(weight));
    }

    public void lessWeight() {
//        Log.d("lessWeight", "lessWeight: called");
        jWtTextView = findViewById(R.id.WeightValue);
        int weight = Integer.parseInt(jWtTextView.getText().toString());
        weight -= 1;
        jWtTextView.setText(String.valueOf(weight));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jBtnWeightIncrement = findViewById(R.id.WeightAdd);
        jBtnWtDecrement = findViewById(R.id.WeightLess);
        jBtnWeightIncrement.setOnClickListener(clickListener);
        jBtnWtDecrement.setOnClickListener(clickListener);


        jBtnAgeIncrement = findViewById(R.id.AgeAdd);
        jBtnAgeDecrement = findViewById(R.id.AgeLess);

        heightSeekBar = findViewById(R.id.HeightSeekBar);
        jHtTextView = findViewById(R.id.heightValue);

        jBtnCalculateBmi = findViewById(R.id.Calculate);

        jBtnCalculateBmi.setOnClickListener(clickListener);


//        Button[] buttons = {
//                jBtnCalculateBmi, jBtnWeightIncrement, jBtnAgeIncrement,
//                jBtnAgeIncrement, jBtnWtDecrement
//        };
//        ClickEventListener clickEventListener = new ClickEventListener();
//        try {
//            for (Button b : buttons) {
//                b.setOnClickListener(clickEventListener);
//            }
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }

        heightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                jHtTextView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

//    static class ClickEventListener implements View.OnClickListener {
//        @Override
//        public void onClick(View view) {
//            Log.d("", "User tapped a button");
//        }
//    }
}