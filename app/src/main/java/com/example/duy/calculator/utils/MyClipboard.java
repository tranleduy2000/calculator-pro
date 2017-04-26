package com.example.duy.calculator.utils;

import android.content.Context;
import android.widget.Toast;

import com.example.duy.calculator.R;

/**
<<<<<<< HEAD
 * uses {@link ClipboardManager} instead of this class
 * Created by DUy on 04-Nov-16.
 */
@Deprecated
=======
 * Created by DUy on 04-Nov-16.
 */

>>>>>>> refs/remotes/origin/master
public class MyClipboard {
    // copy text to clipboard
    public static void setClipboard(Context context, String text) {
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setText(text);
            Toast.makeText(context, R.string.copied, Toast.LENGTH_SHORT).show();
        } else {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", text);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(context, R.string.copied, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * get text from clipboard
     *
     * @param context
     * @return
     */
    public static String getClipboard(Context context) {
        String res = "";
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
        Toast.makeText(context, res, Toast.LENGTH_SHORT).show();
        return res;
    }
}
