package com.diligroup.UserSet.activity;


import com.diligroup.R;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.utils.NetUtils;
import com.diligroup.utils.ToastUtil;

import butterknife.OnClick;

/**
 * Created by Kevin on 2016/6/14.
 * 用户信息详情
 */
public class UserInfoActivity extends BaseAcitvity {
//    @Bind(R.id.rl_sex)
//    RelativeLayout rl_sex;
//    @Bind(R.id.rl_birthday)
//    RelativeLayout rl_birthday;
//    @Bind(R.id.rl_height)
//    RelativeLayout rl_height;
//    @Bind(R.id.rl_mingzu)
//    RelativeLayout rl_minzu;
//    @Bind(R.id.rl_other)
//    RelativeLayout rl_other;
//    @Bind(R.id.rl_taste)
//    RelativeLayout rl_taste;
//    @Bind(R.id.rl_tsrq)
//    RelativeLayout rl_tsrq;
//    @Bind(R.id.rl_work)
//    RelativeLayout rl_work;
//    @Bind(R.id.rl_ysjj)
//    RelativeLayout rl_ysjj;
//    @Bind(R.id.rl_weight)
//    RelativeLayout rl_weight;
//    @Bind(R.id.rl_where)
//    RelativeLayout rl_where;

    @Override
    protected void onStart() {
        super.onStart();
        isShowBack(true);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.user_info;
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
        tv_title.setText("我的信息");


    }

    @Override
    protected void initViewAndData() {

    }

    @OnClick(R.id.rl_mingzu)
    public void ClickMinzu() {
        ToastUtil.showShort(this,"ClickedMinZU");
        readyGo(ReportMinZu.class);
    }

    @OnClick(R.id.rl_sex)
    public void ClickSex() {
        ToastUtil.showShort(this,"ReportSex");
        readyGo( ReportSex.class);
    }

    @OnClick(R.id.rl_birthday)
    public void ClickBirthday() {
        readyGo( ReportBirthday.class);
    }

    @OnClick(R.id.rl_height)
    public void ClickHeight() {
        readyGo(ReportHeight.class);
    }

    @OnClick(R.id.rl_other)
    public void ClickOther() {
        readyGo(ReportOther.class);
    }

    @OnClick(R.id.rl_tsrq)
    public void ClickTsrq() {
        readyGo(ReportSpecial.class);
    }

    @OnClick(R.id.rl_taste)
    public void ClickTaste() {
        readyGo(ReportTaste.class);
    }

    @OnClick(R.id.rl_where)
    public void ClickWhere() {
        readyGo(ReportWhere.class);
    }

    @OnClick(R.id.rl_weight)
    public void ClickWeight() {
        readyGo(ReportWeight.class);
    }

    @OnClick(R.id.rl_ysjj)
    public void ClickYsjj() {
        readyGo( ReportNoeat.class);
    }

    @OnClick(R.id.rl_work)
    public void ClickWork() {
        readyGo(ReportWork.class);
    }

}
