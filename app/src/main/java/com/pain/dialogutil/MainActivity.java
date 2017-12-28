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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
   /*     findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog a= new NormalDialogBuilder(MainActivity.this,NormalDialogBuilder.ONEBUTTONTYPE)
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
                a.show();
               final String [] a={"第一个","第二个","第三个","第四个"};
               new BottomListDialog(MainActivity.this, a, new ItemClickListener() {
                   @Override
                   public void clickItem(int position) {
                       Toast.makeText(MainActivity.this, "here"+position, Toast.LENGTH_SHORT).show();
                   }
               },false).show();
            }
        });*/
    }

    private void initView() {
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        button8=findViewById(R.id.button8);

    }

    public void onClick(View view){
        switch (view.getId()){
            case  R.id.button1:
                new NormalDialogBuilder(MainActivity.this).build().show();
                break;
            case  R.id.button2:

                break;
            case  R.id.button3:

                break;
            case  R.id.button4:

                break;
            case  R.id.button5:

                break;
            case  R.id.button6:
                break;
            case  R.id.button7:
                break;
            case  R.id.button8:
                break;
        }
    }
}
