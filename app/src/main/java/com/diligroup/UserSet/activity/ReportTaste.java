package com.diligroup.UserSet.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.diligroup.R;
import com.diligroup.UserSet.TasteAdapter;
import com.diligroup.base.BaseActivity;
import com.diligroup.bean.GetTasteBean;
import com.diligroup.bean.UserInfoBean;
import com.diligroup.net.Action;
import com.diligroup.net.Api;
import com.diligroup.utils.LogUtils;
import com.diligroup.utils.NetUtils;
import com.diligroup.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Request;

/**
 * 上报 口味
 */
public class ReportTaste extends BaseActivity {
    @Bind(R.id.lv_taste)
    ListView lv_taste;
    GetTasteBean  tasteBean;
    TasteAdapter  adapter;
    TasteAdapter.ViewHolder  holder;
    private List<String> id_list;
    List<GetTasteBean.ListBean> tasteBean_list;

//    public ReportTaste(List<String> id_list) {
//        this.id_list = id_list;
//    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_select_taste;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    public void setTitle() {
        super.setTitle();
        tv_title.setText("口味");
        title_infos.setText("请选择您的口味喜好");
    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    protected void initViewAndData() {
        isShowBack(true);
        Api.getTaste(this);
        lv_taste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                holder= (TasteAdapter.ViewHolder) view.getTag();
                holder.cb.toggle();
                TasteAdapter.getIsSelected().put(position, holder.cb.isChecked());
                // 调整选定条目
                if (holder.cb.isChecked()){
                    ToastUtil.showShort(ReportTaste.this,"Checked"+holder.foodId);
                    id_list.add(holder.foodId);
                }else {
                    ToastUtil.showShort(ReportTaste.this,"UnChecked"+holder.foodId);
                    removeUnChecked(holder.foodId);
                }
                LogUtils.e("taste====="+id_list.toString());
            }
        });
    }
    public void removeUnChecked(String foodId) {
        if (id_list.size()>0){
            for (int i=0;i<id_list.size();i++){
                if (id_list.get(i).equals(foodId)){
                    id_list.remove(foodId);
                }
            }
        }
    }
    @OnClick(R.id.bt_ok_taste)
    public void ReporTaste() {
        String s=id_list.toString().replaceAll(" ","");
        String s2= s.substring(1,s.length()-1);
        ToastUtil.showShort(ReportTaste.this,s2);
        UserInfoBean.getInstance().setTaste(s2);
//        readyGo(PhysiologicalPeriodActivity.class);

    }
    @Override
    public void onError(Request request, Action action, Exception e) {

    }

    @Override
    public void onResponse(Request request, Action action, Object object) {
        if (object!=null&&action==Action.GET_TASTE){
            tasteBean= (GetTasteBean) object;
            id_list=new ArrayList<>();
            tasteBean_list = tasteBean.getList();
             adapter = new TasteAdapter(this,tasteBean_list);
            lv_taste.setAdapter(adapter);
        }
    }
}
