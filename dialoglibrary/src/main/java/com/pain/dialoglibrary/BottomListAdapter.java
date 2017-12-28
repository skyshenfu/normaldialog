package com.pain.dialoglibrary;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by zty
 * 个人github地址：http://www.github.com/skyshenfu
 * 日期：2017/12/28
 * 版本：1.0.0
 * 描述：
 */

public class BottomListAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int HEAD=1;
    public static final int BOTTOM=2;
    public static final int NORMAL=3;
    public static final int SINGLE=4;
    public static final int BOTTOM_SPACE=5;

    private  ItemClickListener itemClickListener;

    private String[] items={"1","2","3","4"};
    private boolean needSpace=true;
    private Context mContext;
    private  int itemColor=-1;
    private Dialog dialog;

    public void setItemColor(int itemColor) {
        this.itemColor = itemColor;
    }

    public BottomListAdapter( Context mContext,String[] items, Dialog dialog,boolean needSpace) {
        this.items = items;
        this.needSpace = needSpace;
        this.mContext = mContext;
        this.dialog=dialog;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int resId=0;
        if (viewType==HEAD){
            resId=R.layout.item_top_bottom;
        }else  if (viewType==BOTTOM){
            resId=R.layout.item_bottom_bottom;
        }else  if (viewType==BOTTOM_SPACE){
            resId=R.layout.item_single_bottom_space;
        }else  if (viewType==SINGLE){
            resId=R.layout.item_single_bottom;
        }else {
            resId=R.layout.item_normal_bottom;
        }
        View view= LayoutInflater.from(mContext).inflate(resId,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (itemColor!=-1){
         holder.textView.setTextColor(itemColor);
        }
        holder.textView.setText(items[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (itemClickListener!=null)
                    itemClickListener.clickItem(holder.getAdapterPosition());
                    dialog.dismiss();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    @Override
    public int getItemViewType(int position) {
        if (getItemCount()==1&&position==0){
            return SINGLE;
        }
        if (needSpace&&getItemCount()>2){
            if(position==0){
                return HEAD;
            }else if (position==getItemCount()-1){
                return BOTTOM_SPACE;
            }else if (position==getItemCount()-2){
                return BOTTOM;
            }else {
                return NORMAL;
            }

        }else {
            if(position==0){
                return HEAD;
            }else if (position==getItemCount()-1){
                return BOTTOM;
            }else {
                return NORMAL;
            }

        }
    }
}

class ViewHolder extends RecyclerView.ViewHolder{
    public TextView textView;
    public ViewHolder(View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.text_view);
    }
}
