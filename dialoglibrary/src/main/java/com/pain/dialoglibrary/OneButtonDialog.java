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

public class OneButtonDialog extends Dialog {
    public interface OneClickListener extends NormalClickInterface{
        void onCenterClick(View view);
    }

    private Context mContext;
    private TextView buttonTextView;

    private TextView titleTextView;
    private TextView contentTextView;
    private NormalDialogBuilder normalDialogBuilder;



    public OneButtonDialog(@NonNull Context context, NormalDialogBuilder normalDialogBuilder) {
        super(context, R.style.NormalDialog);
        this.mContext = context;
        this.normalDialogBuilder =normalDialogBuilder;
        init();
    }

    private void init() {
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        int width = (int) (dm.widthPixels * 0.8);
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.dialog_one_button, null);
        buttonTextView = rootView.findViewById(R.id.center_text_view);
        titleTextView=rootView.findViewById(R.id.title_text_View);
        contentTextView=rootView.findViewById(R.id.content_text_View);
        buttonTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (normalDialogBuilder !=null&& normalDialogBuilder.getOnClickListener() != null&&normalDialogBuilder.getOnClickListener() instanceof OneClickListener )
                    ((OneClickListener) normalDialogBuilder.getOnClickListener()).onCenterClick(v);
                OneButtonDialog.this.dismiss();

            }
        });
        initSetting();
        setContentView(rootView);
        setCancelable(true);
        getWindow().setGravity(Gravity.CENTER);
        getWindow().setLayout(width, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    private void initSetting() {
        if (normalDialogBuilder !=null){
            if (normalDialogBuilder.getTitleTextColor()!=0){
                titleTextView.setTextColor(normalDialogBuilder.getTitleTextColor());
            }

            if (normalDialogBuilder.getContentTextColor()!=0){
                contentTextView.setTextColor(normalDialogBuilder.getContentTextColor());

            }
            if (normalDialogBuilder.getCenterTextColor()!=0){
                buttonTextView.setTextColor(normalDialogBuilder.getCenterTextColor());

            }


            if (!TextUtils.isEmpty(normalDialogBuilder.getTitleTextContent())){
                titleTextView.setText(normalDialogBuilder.getTitleTextContent());
            }

            if (!TextUtils.isEmpty(normalDialogBuilder.getContentText())){
                contentTextView.setText(normalDialogBuilder.getContentText());
            }

            if (!TextUtils.isEmpty(normalDialogBuilder.getCenterTextContent())){
                buttonTextView.setText(normalDialogBuilder.getCenterTextContent());
            }


        }
    }
}
