package com.diligroup.UserSet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.diligroup.R;
import com.diligroup.bean.GetTasteBean;
import com.diligroup.utils.LogUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 *
 * Created by Administrator on 2016/7/26.
 */
public class TasteAdapter extends BaseAdapter {
    Context mContext;
    List<GetTasteBean.ListBean> list;
    private static HashMap<Integer, Boolean> isSelected;
    public TasteAdapter(Context cts,List<GetTasteBean.ListBean> dataList){
        this.mContext=cts;
        list=dataList;
        isSelected = new HashMap<>();
        initDate();
    }
    public static HashMap<Integer, Boolean> getIsSelected() {
        return isSelected;
    }

    public static void setIsSelected(HashMap<Integer, Boolean> isSelected) {
        TasteAdapter.isSelected = isSelected;
    }
    private void initDate() {
        for (int i = 0; i <list.size(); i++) {
            getIsSelected().put(i, false);
        }
    }

   public  class ViewHolder{
        public String foodId;
        public TextView tvName;
        public CheckBox cb;
    }
    @Override
    public int getCount() {
        return list.size()>0?list.size():0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        LayoutInflater inflater = LayoutInflater.from(mContext);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.noeat_item,null);
            holder = new ViewHolder();
            holder.cb = (CheckBox) convertView.findViewById(R.id.cb_noeat_item);
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_noeat_item);
            convertView.setTag(holder);
        } else {
            // 取出holder
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvName.setText(list.get(position).getDictName());
        holder.foodId=list.get(position).getCode();
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
