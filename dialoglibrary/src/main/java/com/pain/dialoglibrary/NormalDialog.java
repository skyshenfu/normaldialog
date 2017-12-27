package com.pain.dialoglibrary;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by zty
 * 个人github地址：http://www.github.com/skyshenfu
 * 日期：2017/12/27
 * 版本：1.0.0
 * 描述：
 */

public class NormalDialog extends Dialog {
    public interface ClickListener {
        void onLeftClick(View view);

        void onRightClick(View view);
    }

    private Context mContext;
    private TextView leftButtonTextView;
    private TextView rightButtonTextView;

    private TextView titleTextView;
    private TextView contentTextView;
    private NormalDialogBuilder painDialogBuilder;



    public void setOnClickListener(ClickListener onClickListener) {
        this.painDialogBuilder.setListener(onClickListener);
    }

    public NormalDialog(@NonNull Context context, NormalDialogBuilder painDialogBuilder) {
        super(context, R.style.NormalDialog);
        this.mContext = context;
        this.painDialogBuilder=painDialogBuilder;
        init();
    }

    private void init() {
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        int width = (int) (dm.widthPixels * 0.8);
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.dialog_two_button, null);
        leftButtonTextView = rootView.findViewById(R.id.left_text_view);
        rightButtonTextView = rootView.findViewById(R.id.right_text_view);
        titleTextView=rootView.findViewById(R.id.title_text_View);
        contentTextView=rootView.findViewById(R.id.content_text_View);
        leftButtonTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (painDialogBuilder!=null&&painDialogBuilder.getOnClickListener()!=null)
                    painDialogBuilder.getOnClickListener().onLeftClick(v);
                NormalDialog.this.dismiss();

            }
        });
        rightButtonTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (painDialogBuilder!=null&&painDialogBuilder.getOnClickListener() != null)
                    painDialogBuilder.getOnClickListener().onRightClick(v);
                NormalDialog.this.dismiss();

            }
        });
        initSetting();
        setContentView(rootView);
        setCancelable(true);
        getWindow().setGravity(Gravity.CENTER);
        getWindow().setLayout(width, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    private void initSetting() {
        if (painDialogBuilder!=null){
            if (painDialogBuilder.getTitleTextColor()!=0){
                titleTextView.setTextColor(painDialogBuilder.getTitleTextColor());
            }

            if (painDialogBuilder.getContentTextColor()!=0){
                contentTextView.setTextColor(painDialogBuilder.getContentTextColor());

            }

            if (painDialogBuilder.getLeftTextColor()!=0){
                leftButtonTextView.setTextColor(painDialogBuilder.getLeftTextColor());

            }

            if (painDialogBuilder.getRightTextColor()!=0){
                rightButtonTextView.setTextColor(painDialogBuilder.getRightTextColor());
            }

            if (!TextUtils.isEmpty(painDialogBuilder.getTitleTextContent())){
                titleTextView.setText(painDialogBuilder.getTitleTextContent());
            }

            if (!TextUtils.isEmpty(painDialogBuilder.getContentText())){
                contentTextView.setText(painDialogBuilder.getContentText());
            }

            if (!TextUtils.isEmpty(painDialogBuilder.getLeftTextContent())){
                leftButtonTextView.setText(painDialogBuilder.getLeftTextContent());
            }

            if (!TextUtils.isEmpty(painDialogBuilder.getRightTextContent())){
                rightButtonTextView.setText(painDialogBuilder.getRightTextContent());
            }

        }
    }
}
