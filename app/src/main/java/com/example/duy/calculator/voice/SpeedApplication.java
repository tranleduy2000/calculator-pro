package com.example.duy.calculator.voice;

import android.app.Application;

/**
 * @author Aleksandar Gotev
 */
public class SpeedApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MathVoiceManager.initVoice(this, getPackageName());
    }
}
