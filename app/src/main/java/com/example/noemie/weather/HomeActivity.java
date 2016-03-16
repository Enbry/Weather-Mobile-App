package com.example.noemie.weather;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toast.makeText(this, R.string.app_name,
                Toast.LENGTH_LONG).show();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE", Locale.getDefault());

        LinearLayout ll = (LinearLayout) findViewById(R.id.week);

        for (int i = 0; i<ll.getChildCount(); i++) {
            TextView day = (TextView) ll.getChildAt(i).findViewById(R.id.view1);

            calendar.add(Calendar.DAY_OF_MONTH, 1);
            String format = simpleDateFormat.format(calendar.getTimeInMillis()).toUpperCase();

            day.setText(format);

            // Bouton Retour Action Bar

           // getSupportActionBar().SetDisplayHomeAsUpEnabled(true);

        }
    }


    /*@Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()) == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }*/
}

