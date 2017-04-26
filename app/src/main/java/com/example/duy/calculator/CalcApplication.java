package com.example.duy.calculator;

import android.support.multidex.MultiDexApplication;

import com.example.duy.calculator.userinterface.FontManager;
import com.example.duy.calculator.voice.MathVoiceManager;


public class CalcApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //init font from asset file
<<<<<<< HEAD
        FontManager.getInstance(this);
=======
        FontManager.loadTypefaceFromAsset(this);
>>>>>>> refs/remotes/origin/master

        MathVoiceManager.initVoice(this, getPackageName());
    }

}