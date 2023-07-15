package com.lega.atstaff.ui.util;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lega.atstaff.R;


public class CustomToast extends Toast {

    public static int PRIMARY = 1;

    public static int SUCCESS = 2;

    public static int WARNING = 3;

    public static int DANGER = 4;

    public static int INFO = 5;

    public static int DEFAULT = 6;

    public CustomToast(Context context) {
        super(context);
    }

    public static Toast makeText(@NonNull Context context, int duration, int type, @Nullable String message) {
        Toast toast = new Toast(context);
        toast.setDuration(duration);

        View customLayout = LayoutInflater.from(context).inflate(R.layout.customtoast,null, false);
        LinearLayout llToastBg = customLayout.findViewById(R.id.custom_toast);
        ImageView imgType = customLayout.findViewById(R.id.imgType);
        TextView tvMessage = customLayout.findViewById(R.id.toastMessage);
        boolean isEmpty = TextUtils.isEmpty(message);

        if (!isEmpty)
            tvMessage.setText(message);
            GradientDrawable bgShape = (GradientDrawable) llToastBg.getBackground();

        if (type == PRIMARY) {

            bgShape.setColor(context.getResources().getColor(R.color.primary));
            tvMessage.setTextColor(context.getResources().getColor(R.color.white));
            imgType.setVisibility(View.VISIBLE);
            imgType.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_info));

            if (isEmpty)
                tvMessage.setText("Primary");

        }else if (type == SUCCESS) {

            bgShape.setColor(context.getResources().getColor(R.color.success));
            tvMessage.setTextColor(context.getResources().getColor(R.color.white));
            imgType.setVisibility(View.VISIBLE);
            imgType.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_success));

            if (isEmpty)
                tvMessage.setText("Success");


        } else if (type == DANGER) {

            bgShape.setColor(context.getResources().getColor(R.color.danger));
            tvMessage.setTextColor(context.getResources().getColor(R.color.white));
            imgType.setVisibility(View.VISIBLE);
            imgType.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_error));

            if (isEmpty)
                tvMessage.setText("error");

        } else if (type == WARNING) {

            bgShape.setColor(context.getResources().getColor(R.color.warning));
            tvMessage.setTextColor(context.getResources().getColor(R.color.white));
            imgType.setVisibility(View.VISIBLE);
            imgType.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_warning));

            if (isEmpty)
                tvMessage.setText("warning");

        } else if (type == INFO) {

            bgShape.setColor(context.getResources().getColor(R.color.info));
            tvMessage.setTextColor(context.getResources().getColor(R.color.white));
            imgType.setVisibility(View.VISIBLE);
            imgType.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_info));

            if (isEmpty)
                tvMessage.setText("information");


        } else if (type == DEFAULT) {

            bgShape.setColor(context.getResources().getColor(R.color.black));
            tvMessage.setTextColor(context.getResources().getColor(R.color.white));
            imgType.setVisibility(View.GONE);

            if (isEmpty)
                tvMessage.setText("Default");

        }

        toast.setView(customLayout);
        return toast;
    }

    public  static Toast makeText(@NonNull Context context, int duration, int type, @Nullable String message, boolean shouldShowIcon) {
        Toast toast = new Toast(context);
        toast.setDuration(duration);

        View customLayout = LayoutInflater.from(context).inflate(R.layout.customtoast, (ViewGroup) null, false);
        LinearLayout llToastBg = customLayout.findViewById(R.id.custom_toast);
        ImageView imgType = customLayout.findViewById(R.id.imgType);
        TextView tvMessage = customLayout.findViewById(R.id.toastMessage);
        boolean isEmpty = TextUtils.isEmpty(message);

        if (!isEmpty)
            tvMessage.setText(message);
        GradientDrawable bgShape = (GradientDrawable) llToastBg.getBackground();

        int visibility = shouldShowIcon?View.VISIBLE:View.GONE;

            if (type == PRIMARY) {

                bgShape.setColor(context.getResources().getColor(R.color.primary));
                tvMessage.setTextColor(context.getResources().getColor(R.color.white));
                imgType.setVisibility(visibility);
                imgType.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_info));

                if (isEmpty)
                    tvMessage.setText("Success");

            }else if (type == SUCCESS) {

            bgShape.setColor(context.getResources().getColor(R.color.success));
            tvMessage.setTextColor(context.getResources().getColor(R.color.white));
            imgType.setVisibility(visibility);
            imgType.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_success));

            if (isEmpty)
                tvMessage.setText("Success");

        } else if (type == DANGER) {

            bgShape.setColor(context.getResources().getColor(R.color.danger));
            tvMessage.setTextColor(context.getResources().getColor(R.color.white));
            imgType.setVisibility(visibility);
            imgType.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_error));

            if (isEmpty)
                tvMessage.setText("error");

        } else if (type == WARNING) {

            bgShape.setColor(context.getResources().getColor(R.color.warning));
            tvMessage.setTextColor(context.getResources().getColor(R.color.white));
            imgType.setVisibility(visibility);
            imgType.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_warning));

            if (isEmpty)
                tvMessage.setText("warning");

        } else if (type == INFO) {

            bgShape.setColor(context.getResources().getColor(R.color.info));
            tvMessage.setTextColor(context.getResources().getColor(R.color.white));
            imgType.setVisibility(visibility);
            imgType.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_info));

            if (isEmpty)
                tvMessage.setText("information");


        } else if (type == DEFAULT) {

            bgShape.setColor(context.getResources().getColor(R.color.black));
            tvMessage.setTextColor(context.getResources().getColor(R.color.white));
            imgType.setVisibility(View.GONE);

            if (isEmpty)
                tvMessage.setText("Default");

        }

        toast.setView(customLayout);
        return toast;
    }

    public static Toast Default(@NonNull Context context, @NonNull String message) {
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_LONG);

        View customLayout = LayoutInflater.from(context).inflate(R.layout.customtoast, (ViewGroup) null, false);
        LinearLayout llToastBg = customLayout.findViewById(R.id.custom_toast);
        ImageView imgType = customLayout.findViewById(R.id.imgType);
        imgType.setVisibility(View.GONE);
        TextView tvMessage = customLayout.findViewById(R.id.toastMessage);
        GradientDrawable bgShape = (GradientDrawable) llToastBg.getBackground();
        tvMessage.setText(message);

        bgShape.setColor(context.getResources().getColor(R.color.black));
        tvMessage.setTextColor(context.getResources().getColor(R.color.white));
        imgType.setVisibility(View.GONE);

        toast.setView(customLayout);
        return toast;
    }

    public static Toast Success(@NonNull Context context, @NonNull String message, int shouldShowIcon) {
        final Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_LONG);

        View customLayout = LayoutInflater.from(context).inflate(R.layout.customtoast, (ViewGroup) null, false);
        LinearLayout llToastBg = customLayout.findViewById(R.id.custom_toast);
        ImageView imgType = customLayout.findViewById(R.id.imgType);
        TextView tvMessage = customLayout.findViewById(R.id.toastMessage);
        GradientDrawable bgShape = (GradientDrawable) llToastBg.getBackground();
        tvMessage.setText(message);

        bgShape.setColor(context.getResources().getColor(R.color.success));
        tvMessage.setTextColor(context.getResources().getColor(R.color.white));
        imgType.setVisibility(shouldShowIcon);
        imgType.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_success));

        toast.setView(customLayout);

        return toast;
    }

    public static Toast Danger(@NonNull Context context, @NonNull String message, int shouldShowIcon) {
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_LONG);

        View customLayout = LayoutInflater.from(context).inflate(R.layout.customtoast, (ViewGroup) null, false);
        LinearLayout llToastBg = customLayout.findViewById(R.id.custom_toast);
        ImageView imgType = customLayout.findViewById(R.id.imgType);
        TextView tvMessage = customLayout.findViewById(R.id.toastMessage);
        tvMessage.setTextColor(R.color.txt_danger);
        GradientDrawable bgShape = (GradientDrawable) llToastBg.getBackground();
        tvMessage.setText(message);

        bgShape.setColor(context.getResources().getColor(R.color.danger));
        tvMessage.setTextColor(context.getResources().getColor(R.color.white));
        imgType.setVisibility(shouldShowIcon);
        imgType.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_error));

        toast.setView(customLayout);

        return toast;
    }

    public static Toast Warning(@NonNull Context context,@NonNull String message, int shouldShowIcon) {
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_LONG);

        View customLayout = LayoutInflater.from(context).inflate(R.layout.customtoast, (ViewGroup) null, false);
        LinearLayout llToastBg = customLayout.findViewById(R.id.custom_toast);
        ImageView imgType = customLayout.findViewById(R.id.imgType);
        imgType.setVisibility(shouldShowIcon);
        TextView tvMessage = customLayout.findViewById(R.id.toastMessage);
        GradientDrawable bgShape = (GradientDrawable) llToastBg.getBackground();
        tvMessage.setText(message);


        bgShape.setColor(context.getResources().getColor(R.color.warning));
        tvMessage.setTextColor(context.getResources().getColor(R.color.white));
        imgType.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_warning));

        toast.setView(customLayout);
        return  toast;
    }

    public static Toast Info(@NonNull Context context, @NonNull String message, int shouldShowIcon) {
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_LONG);

        View customLayout = LayoutInflater.from(context).inflate(R.layout.customtoast, (ViewGroup) null, false);
        LinearLayout llToastBg = customLayout.findViewById(R.id.custom_toast);
        ImageView imgType = customLayout.findViewById(R.id.imgType);
        imgType.setVisibility(shouldShowIcon);
        TextView tvMessage = customLayout.findViewById(R.id.toastMessage);
        GradientDrawable bgShape = (GradientDrawable) llToastBg.getBackground();
        tvMessage.setText(message);

        bgShape.setColor(context.getResources().getColor(R.color.info));
        tvMessage.setTextColor(context.getResources().getColor(R.color.white));
        imgType.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_info));

        toast.setView(customLayout);
        return toast;
    }
}
