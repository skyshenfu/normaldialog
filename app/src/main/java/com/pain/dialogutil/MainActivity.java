package com.pain.dialogutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.pain.dialoglibrary.NormalDialog;
import com.pain.dialoglibrary.NormalDialogBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NormalDialogBuilder(MainActivity.this)
                        .setTitleText("1234")
                        .setContentText("789")
                        .setLeftText("取消")
                        .setRightText("确定")
                        .setButtonLeftTextColor(0xfff96060)
                        .setListener(new NormalDialog.ClickListener() {
                            @Override
                            public void onLeftClick(View view) {
                                Toast.makeText(MainActivity.this, "123", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onRightClick(View view) {
                                Toast.makeText(MainActivity.this, "456", Toast.LENGTH_SHORT).show();

                            }
                        })
                        .build()
                        .show();
            }
        });
    }
}
