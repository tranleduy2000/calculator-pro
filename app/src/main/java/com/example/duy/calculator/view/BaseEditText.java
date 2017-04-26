package com.example.duy.calculator.view;

import android.content.Context;
import android.util.AttributeSet;

<<<<<<< HEAD
import static com.example.duy.calculator.userinterface.FontManager.getInstance;
=======
import static com.example.duy.calculator.userinterface.FontManager.loadTypefaceFromAsset;
>>>>>>> refs/remotes/origin/master

/**
 * Base Edit Text
 * Created by DUy on 21-Jan-17.
 */

public class BaseEditText extends AutoCompleteFunctionEditText {
    public BaseEditText(Context context) {
        super(context);
        setup(context);
    }

    public BaseEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup(context);

    }

    public BaseEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(context);
    }

    private void setup(Context context) {
        if (!isInEditMode())
<<<<<<< HEAD
            setTypeface(getInstance(context));
=======
            setTypeface(loadTypefaceFromAsset(context));
>>>>>>> refs/remotes/origin/master
    }
}
