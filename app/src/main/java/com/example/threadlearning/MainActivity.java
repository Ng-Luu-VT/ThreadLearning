package com.example.threadlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    Scanner scanner = new Scanner(System.in);
    private TextView tvResult;
    private EditText etStart, etStop;
    private Button btnOkStart, btnOkStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        init(context);
    }

    private void init(final Context context) {
        tvResult = findViewById(R.id.actMain_Result);
        etStart = findViewById(R.id.actMain_etStart);
        etStop = findViewById(R.id.actMain_etStop);
        btnOkStart = findViewById(R.id.actMain_btnOkStart);
        btnOkStop = findViewById(R.id.actMain_btnOkStop);

        final CountTheNumberThread countTheNumberThread = new CountTheNumberThread();
        btnOkStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countTheNumberThread.start();
            }
        });
        btnOkStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countTheNumberThread.end();
                tvResult.setText("Con số may mắn là: " + countTheNumberThread.getCount());
            }
        });

        CountDownThread countDownThread = new CountDownThread();

    }
}