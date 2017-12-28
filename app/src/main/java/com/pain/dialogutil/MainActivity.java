package com.pain.dialogutil;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.pain.dialoglibrary.BottomListAdapter;
import com.pain.dialoglibrary.BottomListDialog;
import com.pain.dialoglibrary.ItemClickListener;
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
               /* Dialog a= new NormalDialogBuilder(MainActivity.this,NormalDialogBuilder.ONEBUTTONTYPE)
                        .setTitleText("1234")
                        .setContentText("789")
                        .setLeftText("取消")
                        .setRightText("确定")
                        .setCenterText("我知道了")
                        .setAnimation(NormalDialogBuilder.TOPTOBOTTOM)
                        .setCenterTextColor(0xfff96060)
                        .setListener(new OneButtonDialog.OneClickListener() {
                            @Override
                            public void onCenterClick(View view) {
                                Toast.makeText(MainActivity.this, "here", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build();
                a.setCanceledOnTouchOutside(true);
                a.show();*/
               final String [] a={"第一个","第二个","第三个","第四个"};
               new BottomListDialog(MainActivity.this, a, new ItemClickListener() {
                   @Override
                   public void clickItem(int position) {
                       Toast.makeText(MainActivity.this, "here"+position, Toast.LENGTH_SHORT).show();
                   }
               },false).show();
            }
        });
    }
}
