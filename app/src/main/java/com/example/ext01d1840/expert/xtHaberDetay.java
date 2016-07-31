package com.example.ext01d1840.expert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import android.widget.TextView;

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

        final ImageView detayResim =  (ImageView) findViewById(R.id.hdImage);

        final TextView baslik = (TextView) findViewById(R.id.tvBaslik);
        final TextView detay = (TextView) findViewById(R.id.tvDetay);

        detayResim.setImageResource(p_image);
        baslik.setText(p_haber);
        detay.setText(p_detay);

        final ImageView sharedImage  = (ImageView) findViewById(R.id.imageShared);

        sharedImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); //Share intentini oluşturuyoruz
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "EXPERTEAM --"+baslik.getText().toString());//share mesaj konusu
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, detayResim.getImageAlpha() +"\n"+detay.getText().toString() );//share mesaj içeriği
                startActivity(Intent.createChooser(sharingIntent, "Paylaşmak İçin Seçiniz"));//Share intentini başlığı ile birlikte başlatıyoruz

            }
        });

    }
}
