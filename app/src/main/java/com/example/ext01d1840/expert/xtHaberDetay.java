package com.example.ext01d1840.expert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
<<<<<<< HEAD
import android.widget.TextView;
=======
>>>>>>> origin/master
import android.widget.Toast;

public class xtHaberDetay extends AppCompatActivity {

    String p_haber;
    String p_detay;
    int p_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xt_haber_detay);

        Bundle extras = getIntent().getExtras();
        p_haber = extras.getString("p_haber");
        p_detay = extras.getString("p_detay");
        p_image = extras.getInt("p_image");

        ImageView detayResim =  (ImageView) findViewById(R.id.hdImage);
<<<<<<< HEAD
        TextView baslik = (TextView) findViewById(R.id.tvBaslik);
        TextView detay = (TextView) findViewById(R.id.tvDetay);

        detayResim.setImageResource(p_image);
        baslik.setText(p_haber);
        detay.setText(p_detay);
=======

        detayResim.setImageResource(p_image);
>>>>>>> origin/master

    }
}
