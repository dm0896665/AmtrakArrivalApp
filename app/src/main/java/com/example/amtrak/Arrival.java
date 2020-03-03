package com.example.amtrak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Arrival extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrival);

        SharedPreferences sharedPref = getSharedPreferences("myKeys", MODE_PRIVATE);
        int h = sharedPref.getInt("hours", 0);
        int m = sharedPref.getInt("mins", 0);
        int l = sharedPref.getInt("len", 0);
        int hlen = l / 60;
        int mlen = l - (hlen * 60);
        if((m + mlen) > 59)
        {
            hlen++;
            mlen-=60;
        }
        while((h + hlen) > 23)
        {
            hlen-=24;
        }
        TextView tv = findViewById(R.id.txtResults);
        tv.setText((h+hlen) + " : " + (m+mlen));

        if((h+hlen) >= 0 && (h+hlen) <= 6)
        {
            TextView tvc = findViewById(R.id.txtComment);
            tvc.setText("Red-Eye Arrival");
            ImageView img = findViewById(R.id.pic);
            img.setImageResource(R.drawable.tired);
        }
    }
}
