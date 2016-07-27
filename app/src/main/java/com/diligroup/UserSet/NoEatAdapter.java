package com.diligroup.UserSet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.diligroup.R;
import com.diligroup.UserSet.activity.ReportTaste;
import com.diligroup.bean.GetTasteBean;
import com.diligroup.bean.NoEatFoodBean;
import com.diligroup.utils.LogUtils;
import com.diligroup.utils.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 *
 * Created by Administrator on 2016/7/26.
 */
public class NoEatAdapter extends BaseAdapter {
    private Context mCon;
    // 用来控制CheckBox的选中状况
    private static HashMap<Integer, Boolean> isSelected;
    private List<NoEatFoodBean.ListBean>  data_list;
    public NoEatAdapter(Context context, List<NoEatFoodBean.ListBean> arrayList){
        mCon=context;
        data_list=arrayList;
        isSelected = new HashMap<>();
        initDate();
    }



    // 初始化isSelected的数据
    private void initDate() {
        for (int i = 0; i <data_list.size(); i++) {
            getIsSelected().put(i, false);
        }
    }
    public static HashMap<Integer, Boolean> getIsSelected() {
        return isSelected;
    }

    public static void setIsSelected(HashMap<Integer, Boolean> isSelected) {
        NoEatAdapter.isSelected = isSelected;
    }

    public  class MyViewHolder {
         public String foodId;
          public  TextView tvName;
          public CheckBox cb;
    }

    @Override
    public int getCount() {
        return data_list.size()>0?data_list.size():0;
    }

    @Override
    public Object getItem(int position) {
        return data_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final MyViewHolder holder;
        LayoutInflater inflater = LayoutInflater.from(mCon);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.noeat_item,null);
            holder = new MyViewHolder();
            holder.cb = (CheckBox) convertView.findViewById(R.id.cb_noeat_item);
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_noeat_item);
            convertView.setTag(holder);
        } else {
            // 取出holder
            holder = (MyViewHolder) convertView.getTag();
        }
        holder.tvName.setText(data_list.get(position).getDictName());
        holder.foodId=data_list.get(position).getCode();
        // 监听checkBox并根据原来的状态来设置新的状态
        holder.cb.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if (isSelected.get(position)) {
                    isSelected.put(position, false);
                    setIsSelected(isSelected);
                    LogUtils.e("unChecked");
                } else {
                    isSelected.put(position, true);
                    setIsSelected(isSelected);
                    LogUtils.e("Checked");
                }

            }
        });
        // 根据isSelected来设置checkbox的选中状况
        holder.cb.setChecked(getIsSelected().get(position));
        return convertView;
    }
}
