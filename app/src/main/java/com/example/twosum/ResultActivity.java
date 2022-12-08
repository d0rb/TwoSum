package com.example.twosum;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView fianlStringTxtView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle extras = getIntent().getExtras();
        String finalString = extras.getString("finalString");
        fianlStringTxtView = findViewById(R.id.finalStringTxt);
        fianlStringTxtView.setText(finalString);

    }
}