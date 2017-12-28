package com.pain.dialoglibrary;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by zty
 * 个人github地址：http://www.github.com/skyshenfu
 * 日期：2017/12/28
 * 版本：1.0.0
 * 描述：此类直接生产一个从底部滑出，类似ios底部列表对话框的dialog，不使用builder
 */

public class BottomListDialog extends Dialog {


    private Context mContext;
    private RecyclerView recyclerView;
    private BottomListAdapter adapter;
    private String[] items;
    private ItemClickListener itemClickListener;
    private int itemColor=-1;
    private boolean needSpace=true;




    /**
     * 不需要设置字体颜色，以及最后一项间距是使用此构造方法
     * @param context 上下文
     * @param items 数组，每一项都为对应的条目的文字
     * @param itemClickListener 每一项的点击事件
     */
    public BottomListDialog(@NonNull Context context, String[] items, ItemClickListener itemClickListener) {
        super(context, R.style.NormalDialog);
        this.mContext = context;
        this.items=items;
        this.itemClickListener=itemClickListener;
        init();
    }

    /**
     * 需要去除最后一项间距时调用此方法
     *@param context 上下文
     * @param items 数组，每一项都为对应的条目的文字
     * @param itemClickListener 每一项的点击事件
     * @param needSpace 是否设置和最后一项的间隔（模仿ios）默认为是
     */
    public BottomListDialog(@NonNull Context context, String[] items, ItemClickListener itemClickListener,Boolean needSpace) {
        super(context, R.style.NormalDialog);
        this.mContext = context;
        this.items=items;
        this.itemClickListener=itemClickListener;
        this.needSpace=needSpace;
        init();
    }

    /**
     *需要设置文字颜色时调用此方法
     *@param  context 上下文
     * @param items 数组，每一项都为对应的条目的文字
     * @param itemClickListener 每一项的点击事件
     * @param itemColor 目标颜色对应的资源文件
     */
    public BottomListDialog(@NonNull Context context, String[] items, ItemClickListener itemClickListener, @ColorRes int itemColor) {
        super(context, R.style.NormalDialog);
        this.mContext = context;
        this.items=items;
        this.itemClickListener=itemClickListener;
        this.itemColor=itemColor;
        init();
    }

    /**
     *需要设置文字颜色,和去除底部间距时调用此方法
     *@param  context 上下文
     * @param items 数组，每一项都为对应的条目的文字
     * @param itemClickListener 每一项的点击事件
     * @param needSpace 是否设置和最后一项的间隔（模仿ios）默认为是
     * @param itemColor 目标颜色对应的资源文件
     */
    public BottomListDialog(@NonNull Context context, String[] items, ItemClickListener itemClickListener,Boolean needSpace, @ColorRes int itemColor) {
        super(context, R.style.NormalDialog);
        this.mContext = context;
        this.items=items;
        this.itemClickListener=itemClickListener;
        this.needSpace=needSpace;
        this.itemColor=itemColor;
        init();
    }
    private void init() {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.dialog_bottom, null);
        recyclerView=rootView.findViewById(R.id.dialog_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
        adapter=new BottomListAdapter(mContext,items,this,needSpace);
        adapter.setItemClickListener(itemClickListener);
        if (itemColor!=-1){
            adapter.setItemColor(ContextCompat.getColor(mContext,itemColor));
        }
        recyclerView.setAdapter(adapter);
        setContentView(rootView);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        getWindow().setWindowAnimations(R.style.DialogAnimationBottom);
        getWindow().setLayout( WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        getWindow().setGravity(Gravity.BOTTOM);
    }

}