package com.pain.dialoglibrary;

/**
 * Created by zty
 * 个人github地址：http://www.github.com/skyshenfu
 * 日期：2017/12/27
 * 版本：1.0.0
 * 描述：
 */

public interface DialogSetting {
    DialogSetting setTitleTextColor(int titleColor);
    DialogSetting setContentTextColor(int contentColor);
    DialogSetting setButtonLeftTextColor(int leftColor);
    DialogSetting setButtonRightTextColor(int rightColor);

    DialogSetting setTitleText(String titleText);
    DialogSetting setContentText(String contentText);
    DialogSetting setLeftText(String leftText);
    DialogSetting setRightText(String rightText);

    DialogSetting setListener(NormalDialog.ClickListener listener);

    NormalDialog build();

}
