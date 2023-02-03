package com.mohibul.projectweather;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Toaster {
    public static void successToast(Context context, String msg) {
        Toasty.custom(
                context,
                msg,
                R.drawable.ic_baseline_check_24,
                "#454B54",
                14,
                "#EEEEEE");
    }

    public static void errorToast(Context context, String msg) {
        Toasty.custom(
                context,
                msg,
                R.drawable.ic_baseline_error_outline_24,
                "#454B54",
                14,
                "#EEEEEE");
    }
}

class Toasty {
    private static Toast toast;
    @SuppressLint("StaticFieldLeak")
    private static View view;
    @SuppressLint("StaticFieldLeak")
    private static LinearLayout toastyLinearLayout;
    @SuppressLint("StaticFieldLeak")
    private static ImageView toastyImageView;
    @SuppressLint("StaticFieldLeak")
    private static TextView toastyTextView;

    private static void createToast(Context context) {
        toast = new Toast(context);
    }

    @SuppressLint("InflateParams")
    private static void createView(Context context) {
        view = LayoutInflater.from(context).inflate(com.mohibul.projectweather.R.layout.toasty_layout, null, false);
        findViews(view);
    }

    private static void setUpTextView(int textSize, String textColor) {
        toastyTextView.setTextSize(textSize);
        toastyTextView.setTextColor(Color.parseColor(textColor));
    }

    private static void setUpToast(int duration) {
        toast.setView(view);
        toast.setDuration(duration);
        toast.show();
    }

    private static void findViews(View view) {
        toastyLinearLayout = view.findViewById(R.id.toasty_LinearLayout);
        toastyImageView = view.findViewById(R.id.toasty_imageView);
        toastyTextView = view.findViewById(R.id.toasty_textView);
    }

    private static void basicSetup(String message, int drawable, String backgroundColor) {
        toastyLinearLayout.setBackgroundColor(Color.parseColor(backgroundColor));
        toastyImageView.setBackgroundResource(drawable);
        toastyTextView.setText(message);
    }
    public static void custom(Context context, String message, int drawable, String backgroundColor, int textSize, String textColor) {
        createToast(context);
        createView(context);
        basicSetup(message, drawable, backgroundColor);
        setUpTextView(textSize, textColor);
        setUpToast(0);
    }
}
