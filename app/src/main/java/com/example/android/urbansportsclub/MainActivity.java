package com.example.android.urbansportsclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.example.android.urbansportsclub.barcode.BarcodeCaptureActivity;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final int BARCODE_READER_REQUEST_CODE = 1;

    private Button mCheckInButton;
    private Button mScanButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCheckInButton = (Button) findViewById(R.id.check_in_btn);
        mCheckInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCheckIn();
            }
        });
        mScanButton = (Button) findViewById(R.id.qr_scan_btn);
        mScanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BarcodeCaptureActivity.class);
                startActivityForResult(intent, BARCODE_READER_REQUEST_CODE);
            }
        });
    }

    // inflates a menu bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    // handles refresh button click
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId) {
            case R.id.action_settings:
                Intent openSettingsIntent = new Intent(this, SettingsActivity.class);
                startActivity(openSettingsIntent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openCheckIn() {
        //Intent openCheckInIntent = new Intent(this, CheckInActivity.class);
        //startActivity(openCheckInIntent);
        Intent main = new Intent(this, Main2Activity.class);
        startActivity(main);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == BARCODE_READER_REQUEST_CODE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    openCheckIn();
                }
            } else Log.e(LOG_TAG, String.format(getString(R.string.barcode_error_format),
                    CommonStatusCodes.getStatusCodeString(resultCode)));
        } else super.onActivityResult(requestCode, resultCode, data);
    }
}
