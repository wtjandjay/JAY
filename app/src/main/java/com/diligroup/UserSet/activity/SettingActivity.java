package com.diligroup.UserSet.activity;


import com.diligroup.R;
import com.diligroup.base.BaseActivity;
import com.diligroup.net.Action;
import com.diligroup.utils.NetUtils;

import okhttp3.Request;

/**
 * Created by Kevin on 2016/6/21.
 */
public class SettingActivity extends BaseActivity {

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

    @Override
    public void onError(Request request, Action action, Exception e) {

    }

    @Override
    public void onResponse(Request request, Action action, Object object) {

    }
}
