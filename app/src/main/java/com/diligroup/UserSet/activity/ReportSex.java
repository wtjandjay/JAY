package com.diligroup.UserSet.activity;

import android.view.KeyEvent;

import com.diligroup.R;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.bean.UserInfoBean;
import com.diligroup.other.ReportUserInfos;
import com.diligroup.utils.NetUtils;
import com.diligroup.utils.ToastUtil;

import butterknife.OnClick;

/**
 * 上报性别
 */
public class ReportSex extends BaseAcitvity {

    private int sexMark;
    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_select_sex;
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
        tv_title.setText("性别");
        title_infos.setText("您的性别?");
    }

    @Override
    protected void initViewAndData() {
        isShowBack(true);

    }


    @OnClick(R.id.ll_boy)
    public void reportBoy(){

            sexMark=1;
        ToastUtil.showShort(this,"男");
    }
    @OnClick(R.id.ll_girl)
    public void reportGirl(){
            sexMark=0;
        ToastUtil.showShort(this,"女");
    }
    @OnClick(R.id.bt_ok_sex)
    public void reportSex(){
        if (sexMark==1||sexMark==0){
            UserInfoBean.getInstance().setSex(sexMark);
            readyGo(ReportBirthday.class);
            return;
        }
        ToastUtil.showShort(ReportSex.this,"请选择性别");

    }
}
