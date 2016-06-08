package com.example.ext01d1840.expert;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by EXT01D1840 on 6/8/2016.
 */
public class SplashScreen extends Activity{
    public void onCreate(Bundle bambam){
        super.onCreate(bambam);
        setContentView(R.layout.girisekrani);

        Thread zamanlayıcı = new Thread(){
            public void run(){
                try {
                    sleep(3000);
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
