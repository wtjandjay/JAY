package com.diligroup.UserSet.activity;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.diligroup.R;
import com.diligroup.UserSet.NoEatAdapter;
import com.diligroup.base.BaseActivity;
import com.diligroup.bean.NoEatFoodBean;
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

/***
 * 食物禁忌上报
 */
public class ReportNoeat extends BaseActivity {

    @Bind(R.id.list_no_eat)
    ListView lv_noeat;
    List<NoEatFoodBean.ListBean> datalist;
    StringBuilder  builder;
    List<String> noeat_list;
    NoEatFoodBean noEatFoodBean;
    private Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    noeat_list=new ArrayList<>();
                    datalist = noEatFoodBean.getList();
                    NoEatAdapter adapter = new NoEatAdapter(ReportNoeat.this, datalist);
                    lv_noeat.setAdapter(adapter);
                    addClicked();
                    break;
            }
        }

        ;
    };

    NoEatAdapter.MyViewHolder holder;

    public void addClicked() {
        lv_noeat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                holder = (NoEatAdapter.MyViewHolder) view.getTag();
                holder.cb.toggle();
                // 点哪个  就改变哪个checkbox 状态
                NoEatAdapter.getIsSelected().put(position, holder.cb.isChecked());
                // 调整选定条目
                    if (holder.cb.isChecked()){
                        ToastUtil.showShort(ReportNoeat.this,"Checked"+holder.foodId);
                        noeat_list.add(holder.foodId);
                    }else {
                        ToastUtil.showShort(ReportNoeat.this,"UnChecked"+holder.foodId);
                        removeUnChecked(holder.foodId);
                    }
                LogUtils.e("NoEatList====="+noeat_list.toString());
            }
        });
    }

    @Override
    public void setTitle() {
        super.setTitle();
        tv_title.setText("饮食禁忌");
        title_infos.setText("请选择您的饮食禁忌");
//
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_select_noeat;
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
        Api.getNoEatFood(this);
        datalist = new ArrayList<>();

    }

    @OnClick(R.id.bt_ok_noeat)
    public void reportNoeat() {

        String s=noeat_list.toString().replaceAll(" ","");
       String s2= s.substring(1,s.length()-1);
        ToastUtil.showShort(ReportNoeat.this,s2);
        UserInfoBean.getInstance().setNoEatFood(s2);
        readyGo(ReportAllergy.class);
    }

    public void removeUnChecked(String foodId) {
        if (noeat_list.size()>0){
            for (int i=0;i<noeat_list.size();i++){
                if (noeat_list.get(i).equals(foodId)){
                    noeat_list.remove(foodId);
                }
            }
        }
    }


    @Override
    public void onError(Request request, Action action, Exception e) {

    }

    @Override
    public void onResponse(Request request, Action action, Object object) {
        if (object != null && action == Action.GET_NO_EAT) {
             noEatFoodBean = (NoEatFoodBean) object;

            mHandler.sendEmptyMessage(1);

        }
    }
}
