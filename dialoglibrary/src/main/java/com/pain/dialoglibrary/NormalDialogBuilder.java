package com.pain.dialoglibrary;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by zty
 * 个人github地址：http://www.github.com/skyshenfu
 * 日期：2017/12/27
 * 版本：1.0.0
 * 描述：使用方法 new NormalDialogBuilder(context,ty).b
 */

public class NormalDialogBuilder implements DialogSetting {

    public static final int ONEBUTTONTYPE = 1;
    public static final int TWOBUTTONTYPE = 2;

    public static final int LEFTTORIGHT = 11;
    public static final int TOPTOBOTTOM = 12;

    private int type = TWOBUTTONTYPE;
    private int animationType;
    private Context context;

    @IntDef({ONEBUTTONTYPE,TWOBUTTONTYPE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DialogType{}

    @IntDef({LEFTTORIGHT,TOPTOBOTTOM})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DialogAnimType{}

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


    //中间按钮文字
    private int centerTextColor;
    private String centerTextContent;


    private NormalClickInterface onClickListener;


    public NormalDialogBuilder(Context context) {
        this.context = context;
        this.type = TWOBUTTONTYPE;
    }

    public NormalDialogBuilder(Context context, @DialogType int type) {
        this.type = type;
        this.context = context;

    }
    public NormalClickInterface getOnClickListener() {
        return onClickListener;
    }

    @Override
    public DialogSetting setTitleTextColor(int titleColor) {
        titleTextColor = titleColor;
        return this;
    }

    @Override
    public DialogSetting setContentTextColor(int contentColor) {
        contentTextColor = contentColor;
        return this;
    }

    @Override
    public DialogSetting setButtonLeftTextColor(int leftColor) {
        leftTextColor = leftColor;
        return this;
    }

    @Override
    public DialogSetting setButtonRightTextColor(int rightColor) {
        rightTextColor = rightColor;
        return this;
    }

    @Override
    public DialogSetting setTitleText(String titleText) {
        titleTextContent = titleText;
        return this;
    }

    @Override
    public DialogSetting setContentText(String contentText) {
        this.contentText = contentText;
        return this;
    }

    @Override
    public DialogSetting setLeftText(String leftText) {
        this.leftTextContent = leftText;
        return this;
    }

    @Override
    public DialogSetting setRightText(String rightText) {
        this.rightTextContent = rightText;
        return this;
    }

    @Override
    public DialogSetting setCenterText(String centerText) {
        this.centerTextContent=centerText;
        return this;
    }

    @Override
    public DialogSetting setCenterTextColor(int centerColor) {
        this.centerTextColor=centerColor;
        return this;
    }

    @Override
    public DialogSetting setAnimation(@DialogAnimType int animationType) {
        this.animationType=animationType;
        return this;
    }

    @Override
    public DialogSetting setListener(NormalClickInterface listener) {
        if (type == ONEBUTTONTYPE) {
            this.onClickListener=listener;

        } else if (type == TWOBUTTONTYPE) {
            this.onClickListener=listener;

        }
        return this;
    }


    @Override
    public Dialog build() {
        if (type==ONEBUTTONTYPE){
            return new OneButtonDialog(context, this);

        }else if (type==TWOBUTTONTYPE){
            return new TwoButtonDialog(context, this);
        }else {
            return null;
        }
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

    public int getCenterTextColor() {
        return centerTextColor;
    }

    public String getCenterTextContent() {
        return centerTextContent;
    }

    public int getAnimationType() {
        return animationType;
    }
}
