package com.example.amtrak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button next = findViewById(R.id.btnNext);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText hours = findViewById(R.id.hours);
                final int h = Integer.parseInt(hours.getText().toString());
                final EditText mins = findViewById(R.id.minutes);
                final int m = Integer.parseInt(mins.getText().toString());
                final EditText len = findViewById(R.id.tripLen);
                final int l = Integer.parseInt(len.getText().toString());

                if (h > 23) {
                    Toast.makeText(MainActivity.this, "You can't put more than 23 hours!", Toast.LENGTH_LONG).show();
                } else if (m > 59) {
                    Toast.makeText(MainActivity.this, "You can't put more than 59 minutes!", Toast.LENGTH_LONG).show();
                } else if (l > 1500) {
                    Toast.makeText(MainActivity.this, "You can't have a trip longer than 1,500 minutes!", Toast.LENGTH_LONG).show();
                } else {
                    SharedPreferences sharedPref = getSharedPreferences("myKeys", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putInt("hours", h);
                    editor.putInt("mins", m);
                    editor.putInt("len", l);
                    editor.commit();

                    Intent intent = new Intent(MainActivity.this, Arrival.class);
                    startActivity(intent);
                }
            }
        });
    }
}
