package com.diligroup.UserSet.activity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.diligroup.R;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.utils.NetUtils;
import com.diligroup.utils.ToastUtil;
import com.diligroup.view.FlowLayout;
import com.diligroup.view.TagAdapter;
import com.diligroup.view.TagFlowLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 上报 过敏 食材
 */
public class ReportAllergy extends BaseAcitvity {
    //    @Bind(R.id.list_foods_type)
//    ListView catogray_list;
    @Bind(R.id.list_foods_detail)
    ListView food_list;
    String[] food_details;
    FoodAdapter adapter;
    @Bind(R.id.tag_allergy)
    TagFlowLayout taglayout;
    List<String> list_selected;
    TagAdapter tagAdapter;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_report_allergy;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    public void setTitle() {
        super.setTitle();
        tv_title.setText("过敏食材");
//        title_infos.setText("过敏食材");
    }

    @Override
    protected void initViewAndData() {
        isShowBack(true);
        food_details = new String[]{};
        food_details = getResources().getStringArray(R.array.gulei);
        adapter = new FoodAdapter(this, food_details);
        food_list.setAdapter(adapter);
        list_selected = new ArrayList<>();
        final LayoutInflater mInflater = LayoutInflater.from(ReportAllergy.this);
        list_selected.add("Curry");
        list_selected.add("Curry");
        list_selected.add("Curry");
        list_selected.add("Curry");
        list_selected.add("Curry");
        list_selected.add("Curry");

        tagAdapter = new TagAdapter(list_selected) {
            @Override
            public View getView(FlowLayout parent, int position, Object o) {
                TextView tv = (TextView) mInflater.inflate(R.layout.tv,
                        taglayout, false);
                tv.setText(o.toString());
                return tv;
            }

            @Override
            public void setSelectedList(Set set) {
                super.setSelectedList(set);
            }
        };
        taglayout.setAdapter(tagAdapter);
    }

    private class FoodAdapter extends BaseAdapter {
        String[] foodCount;
        private LayoutInflater mInflater = null;

        public FoodAdapter(Context context, String[] array) {
            this.foodCount = array;
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return foodCount.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.item_food_detail, null);
                holder.title = (TextView) convertView.findViewById(R.id.tv_nzw_name);
                holder.food_Check = (CheckBox) convertView.findViewById(R.id.cb_item_check);
                convertView.setTag(holder);
            }
            holder = (ViewHolder) convertView.getTag();
            holder.title.setText(foodCount[position]);
            holder.food_Check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        ToastUtil.showShort(ReportAllergy.this, foodCount[position]);
                        list_selected.add(foodCount[position]);
                    }
                    if (!isChecked) {
                        ToastUtil.showShort(ReportAllergy.this, "你删除了" + foodCount[position]);
                        list_selected.remove(foodCount[position]);
                    }
                }
            });
            return convertView;
        }
    }

    //ViewHolder静态类
    static class ViewHolder {
        public TextView title;
        public CheckBox food_Check;
    }

    @OnClick(R.id.ll_guleis)
    public void clickGulei() {
        if (food_details != null) {

            food_details = getResources().getStringArray(R.array.gulei);
            adapter = new FoodAdapter(this, food_details);
            food_list.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }

    @OnClick(R.id.ll_shucai)
    public void clickShuCai() {
        food_details = getResources().getStringArray(R.array.shucai);
        adapter = new FoodAdapter(this, food_details);
        food_list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.ll_doulei)
    public void clickDoulei() {
        food_details = getResources().getStringArray(R.array.doulei);
        adapter = new FoodAdapter(this, food_details);
        food_list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @OnClick(R.id.ll_fruit)
    public void clickFruit() {
        food_details = getResources().getStringArray(R.array.fruits);
        adapter = new FoodAdapter(this, food_details);
        food_list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.ll_milk)
    public void clickMilk() {
        food_details = getResources().getStringArray(R.array.milks);
        adapter = new FoodAdapter(this, food_details);
        food_list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.ll_jianguo)
    public void clickJianGuo() {
        food_details = getResources().getStringArray(R.array.jianguo);
        adapter = new FoodAdapter(this, food_details);
        food_list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
