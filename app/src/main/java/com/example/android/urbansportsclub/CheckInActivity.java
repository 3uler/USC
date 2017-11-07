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
    private Handler mHandler = new Handler();
    private long mStartTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_close);

        mDateTime = (TextView) findViewById(R.id.datetime_tv);
        mDateTime.setText(DateTimeStringProvider.getDateTimeString());
        mStartTime = System.currentTimeMillis();

    }
}
