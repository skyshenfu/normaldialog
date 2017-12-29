package com.pain.dialoglibrary;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.IntDef;
import android.support.v4.content.ContextCompat;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by zty
 * 个人github地址：http://www.github.com/skyshenfu
 * 日期：2017/12/27
 * 版本：1.0.0
 * 描述：使用方法 new NormalDialogBuilder(context,type).build直接生成一个dialog默认生成两个按钮的dialog,文字颜色及内容、均可以自定义
 * 由于可选属性较多，所以这里使用适配器模式
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
    private int titleTextColor=-1;
    private String titleTextContent;


    //内容
    private int contentTextColor=-1;
    private String contentText;

    //左边文字
    private int leftTextColor=-1;
    private String leftTextContent;

    //右边文字
    private int rightTextColor=-1;
    private String rightTextContent;


    //中间按钮文字
    private int centerTextColor=-1;
    private String centerTextContent;


    private NormalClickInterface onClickListener;

    /**
     * 默认使用此方法，即生成一个含两个按钮的dialog
     * @param context
     */
    public NormalDialogBuilder(Context context) {
        this.context = context;
        this.type = TWOBUTTONTYPE;
    }
    /**
     * 想生成一个按钮的dialog时使用这个方法 将type指定为ONEBUTTONTYPE
     * @param context
     */
    public NormalDialogBuilder(Context context, @DialogType int type) {
        this.type = type;
        this.context = context;

    }
    public NormalClickInterface getOnClickListener() {
        return onClickListener;
    }

    @Override
    public DialogSetting setTitleTextColor(@ColorRes int titleColor) {
        titleTextColor = ContextCompat.getColor(context,titleColor);
        return this;
    }

    @Override
    public DialogSetting setContentTextColor(@ColorRes int contentColor) {
        contentTextColor = ContextCompat.getColor(context,contentColor);
        return this;
    }

    @Override
    public DialogSetting setButtonLeftTextColor(@ColorRes int leftColor) {
        leftTextColor = ContextCompat.getColor(context,leftColor);
        return this;
    }

    @Override
    public DialogSetting setButtonRightTextColor(@ColorRes int rightColor) {
        rightTextColor = ContextCompat.getColor(context,rightColor);
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
    public DialogSetting setCenterTextColor(@ColorRes int centerColor) {
        this.centerTextColor=ContextCompat.getColor(context,centerColor);
        return this;
    }

    /**
     *
     * @param animationType 动画类型，有左->右,上->下两种 LEFTTORIGHT，TOPTOBOTTOM
     * @return
     */
    @Override
    public DialogSetting setAnimation(@DialogAnimType int animationType) {
        this.animationType=animationType;
        return this;
    }

    /**
     *
     * @param listener 点击事件监听器的接口
     * @return
     */
    @Override
    public DialogSetting setListener(NormalClickInterface listener) {
            this.onClickListener=listener;
            return this;
    }

    /**
     * 根据type自动生成Dialog 默认生成TWOBUTTONTYPE即含有两个按钮的dialog
     * @return
     */
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
