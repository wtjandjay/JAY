package com.diligroup.UserSet.activity;

import com.diligroup.R;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.utils.NetUtils;

public class ServiceCenter extends BaseAcitvity {
    @Override
    public void setTitle() {
        super.setTitle();
        tv_title.setText("服务中心");
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_service_center;
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
}