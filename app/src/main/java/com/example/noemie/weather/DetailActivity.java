package com.example.noemie.weather;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toast.makeText(this, R.string.app_name,
                Toast.LENGTH_LONG).show();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE", Locale.getDefault());

        LinearLayout ll = (LinearLayout) findViewById(R.id.week_detail);

        for (int i = 0; i<ll.getChildCount(); i++) {
            TextView day = (TextView) ll.getChildAt(i).findViewById(R.id.day_detail);

            calendar.add(Calendar.DAY_OF_MONTH, 1);
            String format = simpleDateFormat.format(calendar.getTimeInMillis());

            day.setText(format);

        }
    }
}
