package com.generallibrary.CustomViews;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.design.widget.CollapsingToolbarLayout;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.generallibrary.R;

/**
 * 带动画的对话框
 *
 * @author feng
 */
public abstract class LibBaseDialog extends Dialog {
    /**
     * 对话框的布局
     */
    protected ViewGroup mDialogView;
    protected ButtonSureClickListener mButtonSureClickListener;
    protected Context mContext;

    public LibBaseDialog(Context context) {
        super(context, R.style.dialog);
        mContext = context;
        mDialogView = (ViewGroup) View.inflate(context, setLayoutView(), null);
        this.setContentView(mDialogView);
        setOwnerActivity((Activity) context);
    }

    public LibBaseDialog(Context context, boolean isTranseBackGround) {
        super(context, R.style.dialog2);
        mContext = context;
        mDialogView = (ViewGroup) View.inflate(context, setLayoutView(), null);
        this.setContentView(mDialogView);
        setOwnerActivity((Activity) context);
    }

    /**
     * 设置对话框全屏
     */
    public void setWidthFullScreen() {
        // 对话框设置全屏
        WindowManager windowManager = ((Activity) mContext).getWindowManager();
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        int width = (int) (dm.widthPixels * 0.8);
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.width = width; // 设置宽度
    }

    /**
     * 两个按钮
     *
     * @param buttonSureClickListener
     */
    public void setSureClickListener(ButtonSureClickListener buttonSureClickListener) {
        mButtonSureClickListener = buttonSureClickListener;
    }

    public void setWidthFullScreen(double widthFullScreen) {
        // 对话框设置全屏
        WindowManager windowManager = ((Activity) mContext).getWindowManager();
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        int width = (int) (dm.widthPixels * widthFullScreen);
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.width = width; // 设置宽度
    }

    public void setSizeWithPixel(int width, int height) {
        // 对话框设置全屏
        WindowManager windowManager = ((Activity) mContext).getWindowManager();
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT; // 设置宽度
        lp.height = height;
    }

    /**
     * 设置对话框全屏
     */
    public void setWidthFullScreen(double w, double h) {
        // 对话框设置全屏
        WindowManager windowManager = ((Activity) mContext).getWindowManager();
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        int width = (int) (dm.widthPixels * w);
        int high = (int) (dm.heightPixels * h);
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.width = width; // 设置宽度
        lp.height = high;
    }

    /**
     * 设置用哪个布局
     */
    protected abstract int setLayoutView();

    public void show() {
        super.show();
    }

    /**
     * 俩按钮
     */
    public interface ButtonSureClickListener {
        void okClick();

        void cancel();
    }

}