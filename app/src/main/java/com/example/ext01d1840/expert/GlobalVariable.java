package com.example.ext01d1840.expert;

import android.app.Application;

/**
 * Created by EXT01D1840 on 7/25/2016.
 */
public class GlobalVariable extends Application {

    boolean checkLogin ;

    public boolean getCheckLogin (){

        return checkLogin;
    }

    public void setCheckLogin (boolean checkLogin){

        this.checkLogin = checkLogin;
    }




}
