package com.example.duy.calculator.voice;

import android.content.Context;

import net.gotev.speech.GoogleVoiceTypingDisabledException;
import net.gotev.speech.Logger;
import net.gotev.speech.Speech;
import net.gotev.speech.SpeechDelegate;
import net.gotev.speech.SpeechRecognitionNotAvailable;
import net.gotev.speech.ui.SpeechProgressView;

import java.util.List;
import java.util.Locale;

/**
 * Created by DUy on 12-Jan-17.
 */

public class MathVoiceManager implements SpeechDelegate {
    private MathVoiceCallback callback = null;

    /**
     * setup voice
     *
     * @param context     - Context of app
     * @param callPackage - package from init
     */
    public static void initVoice(Context context, String callPackage) {
        Speech.init(context, callPackage);
        Speech.getInstance().setLocale(new Locale("vi"));
        Logger.setLogLevel(Logger.LogLevel.OFF);
    }

    /**
     * release voice input
     */
    public static void onDestroy() {
        Speech.getInstance().unregisterDelegate();
    }

    /**
     * return state of voice engine
     *
     * @return - boolean
     */
    public static boolean isRunning() {
        return Speech.getInstance().isListening();
    }

    /**
     * stop voice engine
     */
    public static void stop() {
        Speech.getInstance().stopListening();
    }

    public static void Say(String msg) {
        Speech.getInstance().say(msg);

    }

    public boolean isVNLocale() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage().equals("vi");
    }

    public void startInput(SpeechProgressView progress) {
        Speech.getInstance().stopTextToSpeech();
        try {
            Speech.getInstance().startListening(progress, this);
        } catch (SpeechRecognitionNotAvailable | GoogleVoiceTypingDisabledException speechRecognitionNotAvailable) {
            speechRecognitionNotAvailable.printStackTrace();
        }

    }

    @Override
    public void onStartOfSpeech() {

    }

    @Override
    public void onSpeechRmsChanged(float value) {

    }

    @Override
    public void onSpeechPartialResults(List<String> results) {
        if (callback == null) return;
        String finalResult = "";
        for (String partial : results) {
            finalResult += VoiceUtils.replace(partial) + " ";
        }
        callback.onSpeechPartialResults(results, finalResult);
    }

    @Override
    public void onSpeechResult(String result) {
        if (callback != null) {
            callback.onSpeechResult(VoiceUtils.replace(result));

        }
    }

    public void setCallback(MathVoiceCallback callback) {
        this.callback = callback;
    }

    public interface MathVoiceCallback {
        void onSpeechResult(String result);

        void onSpeechPartialResults(List<String> results, String finalResult);
    }
}
