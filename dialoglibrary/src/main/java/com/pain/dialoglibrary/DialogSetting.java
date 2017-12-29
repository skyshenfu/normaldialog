package com.pain.dialoglibrary;

import android.app.Dialog;
import android.support.annotation.ColorRes;

/**
 * Created by zty
 * 个人github地址：http://www.github.com/skyshenfu
 * 日期：2017/12/27
 * 版本：1.0.0
 * 描述：
 */

public interface DialogSetting {
    DialogSetting setTitleTextColor(@ColorRes int titleColor);
    DialogSetting setContentTextColor(@ColorRes int contentColor);
    DialogSetting setButtonLeftTextColor(@ColorRes int leftColor);
    DialogSetting setButtonRightTextColor(@ColorRes int rightColor);
    DialogSetting setCenterTextColor(@ColorRes int centerColor);


    DialogSetting setTitleText(String titleText);
    DialogSetting setContentText(String contentText);


    DialogSetting setListener(NormalClickInterface listener);

    DialogSetting setLeftText(String leftText);
    DialogSetting setRightText(String rightText);

    DialogSetting setCenterText(String centerText);
    DialogSetting setAnimation(int animationType);


    Dialog build();

}
