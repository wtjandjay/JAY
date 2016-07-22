package com.diligroup.Home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.diligroup.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hjf on 2016/7/14.
 * x
 */
public class LeftAdapter extends RecyclerView.Adapter {
    Context mContext;
    List<String> mlist;

    public LeftAdapter(Context mContext, List<String> mlist) {
        super();
        this.mContext = mContext;
        this.mlist = mlist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.addlunch_child, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LeftAdapter.MyViewHolder viewHoder = (MyViewHolder) holder;
        Picasso.with(mContext).load(R.drawable.dili_logo).into(viewHoder.dishIcon);
        viewHoder.dishName.setText("哈哈哈哈");
    }

    @Override
    public int getItemCount() {
//        return mlist == null ? 0 : mlist.size();
       return  5;
    }

    class MyViewHolder extends ViewHolder {
        @Bind(R.id.dish_icon)
        ImageView dishIcon;
        @Bind(R.id.dish_name)
        TextView dishName;

        public MyViewHolder(View itemView) {
            super(itemView);
//        ImageView dishName= (ImageView) itemView.findViewById(R.id.dish_icon);
//        TextView tvDishName= (TextView) itemView.findViewById(R.id.dish_name);
            ButterKnife.bind(this, itemView);
        }
    }
}
