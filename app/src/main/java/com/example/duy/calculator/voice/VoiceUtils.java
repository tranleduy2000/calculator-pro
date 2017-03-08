package com.example.duy.calculator.voice;

import java.util.ArrayList;

/**
 * @Author Mr. Duy
 * Created by Duy on 28-Oct-16.
 */

public class VoiceUtils {
    private static ArrayList<ItemReplace> mReplace = new ArrayList<>();

    public static void init() {
        mReplace.clear();
        mReplace.add(new ItemReplace("không", "0"));
        mReplace.add(new ItemReplace("một", "1"));
        mReplace.add(new ItemReplace("hai", "2"));
        mReplace.add(new ItemReplace("ba", "3"));
        mReplace.add(new ItemReplace("bốn", "4"));
        mReplace.add(new ItemReplace("năm", "5"));
        mReplace.add(new ItemReplace("lăm", "5"));
        mReplace.add(new ItemReplace("sáu", "6"));

        mReplace.add(new ItemReplace("bảy", "7"));
        mReplace.add(new ItemReplace("bẩy", "7"));
        mReplace.add(new ItemReplace("tám", "8"));

        mReplace.add(new ItemReplace("chín", "9"));
        mReplace.add(new ItemReplace("chính", "9"));
        mReplace.add(new ItemReplace("mười", "10"));

        mReplace.add(new ItemReplace("cộng", "+"));
        mReplace.add(new ItemReplace("trừ", "-"));
        mReplace.add(new ItemReplace("chừ", "-"));
        mReplace.add(new ItemReplace("nhân", "*"));
        mReplace.add(new ItemReplace("chia", "/"));

        mReplace.add(new ItemReplace("mũ", "^"));
        mReplace.add(new ItemReplace("mủ", "^"));
        mReplace.add(new ItemReplace("mẫu", "^"));

        mReplace.add(new ItemReplace("giai thừa", "!"));

        mReplace.add(new ItemReplace("căn bậc hai", "sqrt("));
        mReplace.add(new ItemReplace("căn bậc 2", "sqrt("));
        mReplace.add(new ItemReplace("căn bậc 3", "cbrt("));
        mReplace.add(new ItemReplace("căn bậc ba", "cbrt("));
    }

    public static String replace(String res) {
        init();
        //to lower case input
        res = res.toLowerCase();
        //replace text to number and operator
        for (int i = 0; i < mReplace.size(); i++) {
            res = res.replace(mReplace.get(i).getText(), mReplace.get(i).getMath());
        }
        return res;
    }

    public String toString(String math) {
        init();
        for (int i = 0; i < mReplace.size(); i++) {
            math = math.replace(mReplace.get(i).getMath(), mReplace.get(i).getText());
        }
        return math;
    }

    private static class ItemReplace {
        private String text;
        private String math;

        ItemReplace(String text, String math) {
            this.text = text;
            this.math = math;
        }

        String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        String getMath() {
            return math;
        }

        public void setMath(String math) {
            this.math = math;
        }
    }
}
