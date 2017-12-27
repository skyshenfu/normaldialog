package com.pain.dialoglibrary;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;

/**
 * Created by zty
 * 个人github地址：http://www.github.com/skyshenfu
 * 日期：2017/12/27
 * 版本：1.0.0
 * 描述：
 */

public class NormalDialogBuilder implements DialogSetting{
/*    public static final int ONEBUTTONTYPE=1;
    public static final int TWOBUTTONTYPE=2;
    private int type=0;*/
    private Context context;

    //标题
    private int titleTextColor;
    private String titleTextContent;


    //内容
    private int contentTextColor;
    private String contentText;

    //左边文字
    private int leftTextColor;
    private String leftTextContent;

    //右边文字
    private int rightTextColor;
    private String rightTextContent;

    private NormalDialog.ClickListener onClickListener;



    public NormalDialogBuilder(Context context) {
        this.context=context;
        //this.type = TWOBUTTONTYPE;
    }
/*    public NormalDialogBuilder(Context context, int type) {
        this.type = type;
    }*/



    @Override
    public DialogSetting setTitleTextColor(int titleColor) {
        titleTextColor=titleColor;
        return this;
    }

    @Override
    public DialogSetting setContentTextColor(int contentColor) {
        contentTextColor=contentColor;
        return this;
    }

    @Override
    public DialogSetting setButtonLeftTextColor(int leftColor) {
        leftTextColor=leftColor;
        return this;
    }

    @Override
    public DialogSetting setButtonRightTextColor(int rightColor) {
        rightTextColor=rightColor;
        return this;
    }

    @Override
    public DialogSetting setTitleText(String titleText) {
        titleTextContent=titleText;
        return this;
    }

    @Override
    public DialogSetting setContentText(String contentText) {
        this.contentText=contentText;
        return this;
    }

    @Override
    public DialogSetting setLeftText(String leftText) {
        this.leftTextContent=leftText;
        return this;
    }

    @Override
    public DialogSetting setRightText(String rightText) {
        this.rightTextContent=rightText;
        return this;
    }

    @Override
    public DialogSetting setListener(NormalDialog.ClickListener listener) {
        this.onClickListener=listener;
        return this;
    }

    @Override
    public NormalDialog build() {
        return new NormalDialog(context,this);
    }


    public int getTitleTextColor() {
        return titleTextColor;
    }

    public String getTitleTextContent() {
        return titleTextContent;
    }

    public int getContentTextColor() {
        return contentTextColor;
    }

    public String getContentText() {
        return contentText;
    }

    public int getLeftTextColor() {
        return leftTextColor;
    }

    public String getLeftTextContent() {
        return leftTextContent;
    }

    public int getRightTextColor() {
        return rightTextColor;
    }


    public String getRightTextContent() {
        return rightTextContent;
    }


    public NormalDialog.ClickListener getOnClickListener() {
        return onClickListener;
    }

}
