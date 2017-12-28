package com.pain.dialogutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.pain.dialoglibrary.OneButtonDialog;
import com.pain.dialoglibrary.TwoButtonDialog;
import com.pain.dialoglibrary.NormalDialogBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NormalDialogBuilder(MainActivity.this,NormalDialogBuilder.ONEBUTTONTYPE)
                        .setTitleText("1234")
                        .setContentText("789")
                        .setLeftText("取消")
                        .setRightText("确定")
                        .setCenterText("我知道了")
                        .setCenterTextColor(0xfff96060)
                        .setListener(new OneButtonDialog.OneClickListener() {
                            @Override
                            public void onCenterClick(View view) {
                                Toast.makeText(MainActivity.this, "here", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build()
                        .show();
            }
        });
    }
}
