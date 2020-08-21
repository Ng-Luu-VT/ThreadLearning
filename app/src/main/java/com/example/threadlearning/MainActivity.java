package com.example.threadlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements CountDownThreadInterface{

    private TextView tvResult;
    private EditText etStart, etStop;
    private Button btnOkStart, btnOkStop, btnCountDown;
    private CountDownThread countDownThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        init(context);
        binEvent();
    }

    private void binEvent() {
        countDownThread.setCountDownThreadInterface(this);
    }

    private void init(final Context context) {
        tvResult = findViewById(R.id.actMain_Result);
        etStart = findViewById(R.id.actMain_etStart);
        etStop = findViewById(R.id.actMain_etStop);
        btnOkStart = findViewById(R.id.actMain_btnOkStart);
        btnOkStop = findViewById(R.id.actMain_btnOkStop);
        btnCountDown = findViewById(R.id.actMain_btnCountDown);

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

        countDownThread = new CountDownThread();
        btnCountDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //countDownThread = new CountDownThread();
                                countDownThread.start();
                            }
                        });
                    }
                });
            }
        });
    }

    @Override
    public void getViewNow(ArrayList<Integer> list) {
        for (int i : list
        ) {
            Toast toast = Toast.makeText(getApplicationContext(),i,Toast.LENGTH_LONG);
            toast.show();
        }
        Toast toast = Toast.makeText(getApplicationContext(),"Hết giờ",Toast.LENGTH_LONG);
        toast.show();
    }
}