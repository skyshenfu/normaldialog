package com.pain.dialogutil;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pain.dialoglibrary.BottomListAdapter;
import com.pain.dialoglibrary.BottomListDialog;
import com.pain.dialoglibrary.ItemClickListener;
import com.pain.dialoglibrary.OneButtonDialog;
import com.pain.dialoglibrary.TwoButtonDialog;
import com.pain.dialoglibrary.NormalDialogBuilder;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                //简单使用，双按钮
                new NormalDialogBuilder(MainActivity.this).build().show();
                break;
            case R.id.button2:
                //简单使用，单按钮
                new NormalDialogBuilder(MainActivity.this, NormalDialogBuilder.ONEBUTTONTYPE).build().show();
                break;

            case R.id.button3:
                //双按钮自定义内容，颜色、点击事件
                new NormalDialogBuilder(MainActivity.this)
                        .setTitleText("打工是不可能的")
                        .setContentText("这辈子不可能打工")
                        .setLeftText("确定呀")
                        .setRightText("取消么")
                        .setButtonRightTextColor(R.color.color_orange)
                        .setButtonLeftTextColor(R.color.color_green)
                        .setContentTextColor(R.color.color_red)
                        .setTitleTextColor(R.color.color_blue)
                        .setListener(new TwoButtonDialog.TwoClickListener() {
                            @Override
                            public void onLeftClick(View view) {
                                Toast.makeText(MainActivity.this, "点击了左边", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onRightClick(View view) {
                                Toast.makeText(MainActivity.this, "点击了右边", Toast.LENGTH_SHORT).show();

                            }
                        })
                        .build().show();

                break;
            case R.id.button4:
                //单按钮自定义内容、颜色、点击事件
                new NormalDialogBuilder(MainActivity.this,NormalDialogBuilder.ONEBUTTONTYPE)
                        .setTitleText("打工是不可能的")
                        .setContentText("这辈子不可能打工")
                        .setContentTextColor(R.color.color_red)
                        .setTitleTextColor(R.color.color_blue)
                        .setCenterText("Yes,I do")
                        .setCenterTextColor(R.color.color_orange)
                        .setListener(new OneButtonDialog.OneClickListener() {

                            @Override
                            public void onCenterClick(View view) {
                                Toast.makeText(MainActivity.this, "点击了中间", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build().show();

                break;
            case R.id.button5:
                //示范动画左到右
                new NormalDialogBuilder(MainActivity.this,NormalDialogBuilder.ONEBUTTONTYPE)
                        .setTitleText("打工是不可能的")
                        .setContentText("这辈子不可能打工")
                        .setContentTextColor(R.color.color_red)
                        .setTitleTextColor(R.color.color_blue)
                        .setCenterText("Yes,I do")
                        .setCenterTextColor(R.color.color_orange)
                        .setAnimation(NormalDialogBuilder.LEFTTORIGHT)
                        .setListener(new OneButtonDialog.OneClickListener() {

                            @Override
                            public void onCenterClick(View view) {
                                Toast.makeText(MainActivity.this, "点击了中间", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build().show();
                break;
            case R.id.button6:
                //示范动画上到下
                new NormalDialogBuilder(MainActivity.this,NormalDialogBuilder.ONEBUTTONTYPE)
                        .setTitleText("打工是不可能的")
                        .setContentText("这辈子不可能打工")
                        .setContentTextColor(R.color.color_red)
                        .setTitleTextColor(R.color.color_blue)
                        .setCenterText("Yes,I do")
                        .setCenterTextColor(R.color.color_orange)
                        .setAnimation(NormalDialogBuilder.TOPTOBOTTOM)
                        .setListener(new OneButtonDialog.OneClickListener() {

                            @Override
                            public void onCenterClick(View view) {
                                Toast.makeText(MainActivity.this, "点击了中间", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build().show();
                break;
            case R.id.button7:
                //底部默认
                final String [] res={"不知妻美刘强东","悔创阿里杰克马","北大还行撒贝宁","取消"};
                new BottomListDialog(MainActivity.this, res, new ItemClickListener() {
                    @Override
                    public void clickItem(int position) {
                        Toast.makeText(MainActivity.this, "here"+position, Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
            case R.id.button8:
                //底部无间隙
                final String [] res1={"不知妻美刘强东","悔创阿里杰克马","北大还行撒贝宁","取消"};
                new BottomListDialog(MainActivity.this, res1, new ItemClickListener() {
                    @Override
                    public void clickItem(int position) {
                        Toast.makeText(MainActivity.this, "here"+position, Toast.LENGTH_SHORT).show();
                    }
                },false).show();
                break;
            //底部改颜色
            case R.id.button9:
                final String [] res2={"不知妻美刘强东","悔创阿里杰克马","北大还行撒贝宁","取消"};
                new BottomListDialog(MainActivity.this, res2, new ItemClickListener() {
                    @Override
                    public void clickItem(int position) {
                        Toast.makeText(MainActivity.this, "here"+position, Toast.LENGTH_SHORT).show();
                    }
                },R.color.color_orange).show();
                break;
            case R.id.button10:
                //底部无间隙+改颜色
                final String [] res3={"不知妻美刘强东","悔创阿里杰克马","北大还行撒贝宁","取消"};
                new BottomListDialog(MainActivity.this, res3, new ItemClickListener() {
                    @Override
                    public void clickItem(int position) {
                        Toast.makeText(MainActivity.this, "here"+position, Toast.LENGTH_SHORT).show();
                    }
                },false,R.color.color_orange).show();
                break;
        }
    }
}
