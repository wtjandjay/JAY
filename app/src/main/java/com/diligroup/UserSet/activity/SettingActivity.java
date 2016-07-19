package com.diligroup.UserSet.activity;


import com.diligroup.R;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.utils.NetUtils;

/**
 * Created by Kevin on 2016/6/21.
 */
public class SettingActivity extends BaseAcitvity {

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.user_setting;
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
    }

    @Override
    public void setTitle() {
        super.setTitle();
        tv_title.setText("设置");
    }
}
