package com.diligroup.Home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.diligroup.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hjf on 2016/7/19.
 */
public class HomeRighAdapter extends RecyclerView.Adapter implements View.OnClickListener {
    Context mContext;
    List<String> mList;

    public HomeRighAdapter(Context mContext, List<String> mList) {
        super();
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.home_rightlist, null);

        return new MyViewHoder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHoder viewHoder = (MyViewHoder) holder;
//        String name=mList.get(position);
//        Picasso.with(mContext).load(R.drawable.dili_logo).into(viewHoder.addlunchRightIcon);
        viewHoder.homeDishesName.setText("大萝卜");
        viewHoder.homeDishesIngredients.setText("配料：" + "小葱+蘑菇");
        viewHoder.home_evaluate.setText("菜品评价");
        viewHoder.home_evaluate.setTextColor(mContext.getResources().getColor(R.color.red));
        viewHoder.home_evaluate.setOnClickListener(this);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_evaluate:

                break;
        }
    }


    class MyViewHoder extends RecyclerView.ViewHolder {
        @Bind(R.id.home_right_icon)
        ImageView home_right_icon;//右侧icon
        @Bind(R.id.home_dishes_name)
        TextView homeDishesName;//食物名称
        @Bind(R.id.home_dishes_ingredients)
        TextView homeDishesIngredients;//食品配料
        @Bind(R.id.home_evaluate)
        TextView home_evaluate;//菜品评价

        public MyViewHoder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
//            home_right_icon= (ImageView) itemView.findViewById(R.id.home_right_icon);
//            homeDishesName= (TextView) itemView.findViewById(R.id.home_dishes_name);
//            itemView.findViewById(R.id.ad)
        }
    }
}
