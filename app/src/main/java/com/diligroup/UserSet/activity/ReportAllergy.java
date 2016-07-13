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
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.diligroup.R;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.utils.NetUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    String[]  guleiArray;
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
        title_infos.setText("过敏食材");
    }

    @Override
    protected void initViewAndData() {
        isShowBack(true);

        getData();
        guleiArray=getResources().getStringArray(R.array.gulei);
        SimpleAdapter adapter = new SimpleAdapter(this, getData(), R.layout.item_allergy, new String[]{"image", "name"}, new int[]{R.id.iv_allergy_icon, R.id.tv_allergy_name});
//        catogray_list.setAdapter(adapter);
//        catogray_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ImageView iv_icon= (ImageView) view.findViewById(R.id.iv_allergy_icon);
//                TextView tv_name= (TextView) view.findViewById(R.id.tv_allergy_name);
//                switch (position){
//
//                    case 0:
////                        Drawable drawableTop = ContextCompat.getDrawable(ReportAllergy.this, R.drawable.iv_gulei_pressed);
////                        view.findViewById(R.id.iv_allergy_icon).setBackgroundResource(R.drawable.iv_gulei_pressed);
////                        view.findViewById(R.id.iv_allergy_icon).setBackground(drawableTop);
//
//                        tv_name.setTextColor(R.color.title_color);
//                        iv_icon.setImageResource(R.drawable.iv_gulei_pressed);
//                        view.setBackgroundColor(R.color.white);
//                        food_list.setAdapter(new foodAdapter(ReportAllergy.this,guleiArray));
//                        break;
//                    case 1:
//                        tv_name.setTextColor(R.color.title_color);
//                        iv_icon.setImageResource(R.drawable.iv_dou_pressed);
//                        view.setBackgroundColor(R.color.white);
//                        break;
//                    case 2:
//                        break;
//                    case 3:
//                        break;
//                    case 4:
//                        break;
//                    case 5:
//                        break;
//                    case 6:
//                        break;
//
//                }
//            }
//        });
    }

    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("image", R.drawable.iv_gulei_normal);
        map.put("name", "谷类");
        list.add(map);
        map = new HashMap<>();
        map.put("image", R.drawable.iv_dou_normal);
        map.put("name", "豆类");
        list.add(map);
        map = new HashMap<>();
        map.put("image", R.drawable.iv_shucai_normal);
        map.put("name", "蔬菜类");
        list.add(map);
        map = new HashMap<>();
        map.put("image", R.drawable.iv_fruit_normal);
        map.put("name", "水果类");
        list.add(map);
        map = new HashMap<>();
        map.put("image", R.drawable.iv_jianguo_normal);
        map.put("name", "坚果类");
        list.add(map);
        map = new HashMap<>();
        map.put("image", R.drawable.iv_milk_normal);
        map.put("name", "乳制品类");
        list.add(map);
        map = new HashMap<>();

        map.put("image", R.drawable.iv_egg_normal);
        map.put("name", "蛋类");
        list.add(map);
//        map = new HashMap<>();
//        map.put("image", R.drawable.iv_dou_normal);
//        map.put("name", "鱼类");
//        list.add(map);
//        map = new HashMap<>();
//        map.put("image", R.drawable.iv_dou_normal);
//        map.put("name", "海鲜类");
//        list.add(map);
//        map = new HashMap<>();
//        map.put("image", R.drawable.iv_dou_normal);
//        map.put("name", "调料类");
//        list.add(map);
        return list;
    }

    @OnClick(R.id.bt_class_gu)
    public void ClickGu() {
        Button bt_gu = (Button) findViewById(R.id.bt_class_gu);
        assert bt_gu != null;
        bt_gu.setBackgroundColor(Color.parseColor("#FFFFFF"));
//        bt_gu.setTextColor(Color.parseColor("#67A129"));
        Drawable drawableTop = ContextCompat.getDrawable(this, R.drawable.iv_gulei_pressed);
        bt_gu.setCompoundDrawablesWithIntrinsicBounds(null, drawableTop, null, null);
    }
private class foodAdapter extends BaseAdapter{
    String [] foodCount;
    private LayoutInflater mInflater = null;

    public  foodAdapter(Context context,String []array){
        this.foodCount=array;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null){
            holder=new ViewHolder();
            convertView=mInflater.inflate(R.layout.item_food_detail,null);
            holder.title= (TextView) convertView.findViewById(R.id.tv_nzw_name);
            holder.food_Check= (CheckBox) convertView.findViewById(R.id.cb_item_check);
            convertView.setTag(holder);
        }
        holder= (ViewHolder) convertView.getTag();
        holder.title.setText(foodCount[position]);
        return convertView;
    }
}
    //ViewHolder静态类
    static class ViewHolder
    {
        public TextView title;
        public CheckBox  food_Check;
    }
}
