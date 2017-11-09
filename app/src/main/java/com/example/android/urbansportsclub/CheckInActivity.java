package com.example.android.urbansportsclub;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.android.urbansportsclub.util.DateTimeStringProvider;

public class CheckInActivity extends AppCompatActivity {

    private TextView mName;
    private TextView mDateTime;
    private TextView mLocation;
    private TextView mLocationArea;
    private TextView mTimer;
    private Handler mHandler;
    private Runnable mTimeRunnable;
    private long mStartTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_close);

        mDateTime = (TextView) findViewById(R.id.datetime_tv);
        mDateTime.setText(DateTimeStringProvider.getDateTimeString());
        mTimer = (TextView) findViewById(R.id.timer_tv);
        mStartTime = System.currentTimeMillis();
        mHandler = new Handler();

        // Timer runnable
        mTimeRunnable = new Runnable() {
            @Override
            public void run() {
                final long start = mStartTime;
                long currentMillis = System.currentTimeMillis() - start;
                int seconds = (int) currentMillis / 1000;
                int minutes = seconds / 60;
                int hours = minutes / 60;
                minutes = minutes % 60;
                seconds = seconds % 60;
                mTimer.setText(String.format("vor %1$1d:%2$02d:%3$02d", hours, minutes, seconds));
                mHandler.postDelayed(this, 100);
            }
        };
        mHandler.postDelayed(mTimeRunnable, 100);

    }
}
