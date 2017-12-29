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

public class TwoButtonDialog extends Dialog {
    public interface TwoClickListener extends NormalClickInterface{
        void onLeftClick(View view);

        void onRightClick(View view);
    }

    private Context mContext;
    private TextView leftButtonTextView;
    private TextView rightButtonTextView;

    private TextView titleTextView;
    private TextView contentTextView;
    private NormalDialogBuilder normalDialogBuilder;

    public TwoButtonDialog(@NonNull Context context, NormalDialogBuilder normalDialogBuilder) {
        super(context, R.style.NormalDialog);
        this.mContext = context;
        this.normalDialogBuilder =normalDialogBuilder;
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
                if (normalDialogBuilder !=null&& normalDialogBuilder.getOnClickListener()!=null&&normalDialogBuilder.getOnClickListener() instanceof TwoClickListener)
                    ((TwoClickListener) normalDialogBuilder.getOnClickListener()).onLeftClick(v);
                TwoButtonDialog.this.dismiss();

            }
        });
        rightButtonTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (normalDialogBuilder !=null&& normalDialogBuilder.getOnClickListener() != null&&normalDialogBuilder.getOnClickListener() instanceof TwoClickListener)
                ((TwoClickListener) normalDialogBuilder.getOnClickListener()).onRightClick(v);
                TwoButtonDialog.this.dismiss();

            }
        });
        initSetting();
        setContentView(rootView);
        setCancelable(true);
        if (normalDialogBuilder.getAnimationType()==NormalDialogBuilder.LEFTTORIGHT){
            getWindow().setWindowAnimations(R.style.DialogAnimationX);
        }else  if (normalDialogBuilder.getAnimationType()==NormalDialogBuilder.TOPTOBOTTOM){
            getWindow().setWindowAnimations(R.style.DialogAnimationY);
        }
        getWindow().setGravity(Gravity.CENTER);
        getWindow().setLayout(width, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    private void initSetting() {
        if (normalDialogBuilder !=null){
            if (normalDialogBuilder.getTitleTextColor()!=-1){
                titleTextView.setTextColor(normalDialogBuilder.getTitleTextColor());
            }

            if (normalDialogBuilder.getContentTextColor()!=-1){
                contentTextView.setTextColor(normalDialogBuilder.getContentTextColor());

            }

            if (normalDialogBuilder.getLeftTextColor()!=-1){
                leftButtonTextView.setTextColor(normalDialogBuilder.getLeftTextColor());

            }

            if (normalDialogBuilder.getRightTextColor()!=-1){
                rightButtonTextView.setTextColor(normalDialogBuilder.getRightTextColor());
            }

            if (!TextUtils.isEmpty(normalDialogBuilder.getTitleTextContent())){
                titleTextView.setText(normalDialogBuilder.getTitleTextContent());
            }

            if (!TextUtils.isEmpty(normalDialogBuilder.getContentText())){
                contentTextView.setText(normalDialogBuilder.getContentText());
            }

            if (!TextUtils.isEmpty(normalDialogBuilder.getLeftTextContent())){
                leftButtonTextView.setText(normalDialogBuilder.getLeftTextContent());
            }

            if (!TextUtils.isEmpty(normalDialogBuilder.getRightTextContent())){
                rightButtonTextView.setText(normalDialogBuilder.getRightTextContent());
            }

        }
    }
}
