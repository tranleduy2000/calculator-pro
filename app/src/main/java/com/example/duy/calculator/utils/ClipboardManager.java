package com.example.duy.calculator.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by DUy on 04-Nov-16.
 */

public class ClipboardManager {
<<<<<<< HEAD
    /**
     * copy text to clipboard
     */
    public static void setClipboard(Context context, String text) {
        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", text);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
=======
    // copy text to clipboard
    public static void setClipboard(Context context, String text) {
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setText(text);
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
        } else {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", text);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(context ,text, Toast.LENGTH_SHORT).show();
        }
>>>>>>> refs/remotes/origin/master
    }

    /**
     * get text from clipboard
     *
     * @param context
     * @return
     */
    public static String getClipboard(Context context) {
        String res = "";
<<<<<<< HEAD
        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (clipboard.getText() != null) {
            res = clipboard.getText().toString();
        } else res = "";
=======
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            if (clipboard.getText() != null) {
                res = clipboard.getText().toString();
            } else res = "";
        } else {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            if (clipboard.getText() != null) {
                res = clipboard.getText().toString();
            } else res = "";
        }
>>>>>>> refs/remotes/origin/master
        Toast.makeText(context, res, Toast.LENGTH_SHORT).show();
        return res;
    }
}
