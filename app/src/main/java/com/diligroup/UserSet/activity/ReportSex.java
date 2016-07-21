package com.diligroup.UserSet.activity;

import android.view.KeyEvent;

import com.diligroup.R;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.other.ReportUserInfos;
import com.diligroup.utils.NetUtils;
import com.diligroup.utils.ToastUtil;

import butterknife.OnClick;

/**
 * 上报性别
 */
public class ReportSex extends BaseAcitvity {
//    @Bind(R.id.rb_boy)
//    RadioButton rb_boy;
//    @Bind(R.id.rb_girl)
//    RadioButton rb_girl;
//    @Bind(R.id.rg_sex)
//    RadioGroup  rg_sex;
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            readyGo(UserInfoActivity.class);
//            this.finish();
        }
        return true;
    }

    @OnClick(R.id.ll_boy)
    public void reportBoy(){
            sexMark=1;
    }
    @OnClick(R.id.ll_girl)
    public void reportGirl(){
            sexMark=0;
    }
    @OnClick(R.id.bt_ok_sex)
    public void reportSex(){
        if (sexMark==1||sexMark==0){
            ReportUserInfos.setUserSex(sexMark);
            readyGo(ReportBirthday.class);
            return;
        }
        ToastUtil.showShort(ReportSex.this,"请选择性别");

    }
}
