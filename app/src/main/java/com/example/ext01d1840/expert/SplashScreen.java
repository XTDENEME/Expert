package com.example.ext01d1840.expert;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by EXT01D1840 on 6/8/2016.
 */
public class SplashScreen extends ActionBarActivity{

    private ImageView img;

    public void onCreate(Bundle bambam){
        super.onCreate(bambam);
        setContentView(R.layout.girisekrani);
        //ImageView gif = (ImageView)findViewById(R.id.imageView2);
        //Ion.with(gif).load("https://giphy.com/gifs/l41YuVJCXM9FEkwDe/html5");

        img = (ImageView) findViewById(R.id.img);

        img.post(new Runnable() {
            @Override
            public void run() {
                ((AnimationDrawable) img.getBackground()).start();
            }
        });

      /*  final ImageView imageView = (ImageView) findViewById(R.id.img);
        final AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.start();
*/


        Thread zamanlayıcı = new Thread(){
            public void run(){
                try {
                    sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                    Log.i("tago","zamanlayici calismadi");
                }finally {
                    Intent i = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(i);
                }
            }
        };
        zamanlayıcı.start();
    }
}
