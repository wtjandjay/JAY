package com.diligroup.UserSet.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.diligroup.R;
import com.diligroup.UserSet.HistoryAdapter;
import com.diligroup.UserSet.NoEatAdapter;
import com.diligroup.UserSet.TasteAdapter;
import com.diligroup.base.BaseActivity;
import com.diligroup.bean.GetHistoryBean;
import com.diligroup.bean.GetTasteBean;
import com.diligroup.bean.UserInfoBean;
import com.diligroup.net.Action;
import com.diligroup.net.Api;
import com.diligroup.utils.NetUtils;
import com.diligroup.utils.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Request;

/**
 * 上报健康史
 *
 */
public class ReportHistory extends BaseActivity {
    @Bind(R.id.lv_history)
    ListView lv_history;
    GetHistoryBean historyBean;
    HistoryAdapter adapter;
    HistoryAdapter.ViewHolder  holder;
    private List<String> id_list;
    List<GetHistoryBean.ListBean> hisList;

    @OnClick(R.id.bt_history)
    public void ReportHisty(){

    String s=id_list.toString().replaceAll(" ","");
    String s2= s.substring(1,s.length()-1);
    ToastUtil.showShort(ReportHistory.this,s2);
    UserInfoBean.getInstance().setChronicDiseaseCode(s2);
    readyGo(ReportSpecial.class);
    }
    @Override
    public void setTitle() {
        super.setTitle();
        tv_title.setText("健康史");
        title_infos.setText("请选择您的历史健康记录");
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_report_history;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }
    @Override
    protected void initViewAndData() {
        isShowBack(true);
        Api.getHistory(this);
        hisList = new ArrayList<>();
        lv_history.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                holder= (HistoryAdapter.ViewHolder) view.getTag();
                holder.cb.toggle();
                HistoryAdapter.getIsSelected().put(position, holder.cb.isChecked());
                // 调整选定条目
                if (holder.cb.isChecked()){
                    ToastUtil.showShort(ReportHistory.this,"Checked"+holder.foodId);
                    id_list.add(holder.foodId);
                }else {
                    ToastUtil.showShort(ReportHistory.this,"UnChecked"+holder.foodId);
                    removeUnChecked(holder.foodId);
                }
            }
        });
    }

    @Override
    public void onError(Request request, Action action, Exception e) {

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
    @Override
    public void onResponse(Request request, Action action, Object object) {
        if (object!=null&&action==Action.GET_HISTORY){
            historyBean= (GetHistoryBean) object;
            id_list=new ArrayList<>();
            hisList = historyBean.getList();
            adapter = new HistoryAdapter(this,hisList);
            lv_history.setAdapter(adapter);
        }
    }
}
