package com.diligroup.Home;

import com.diligroup.R;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.net.Action;
import com.diligroup.utils.NetUtils;

import okhttp3.Request;

/**
 *
 * Created by Administrator on 2016/7/22
 *
 *
 */
public class FoodDetailsActivity extends BaseAcitvity {
    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_food_details;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    protected void initViewAndData() {

    }

    @Override
    public void onError(Request request, Action action, Exception e) {

    }

    @Override
    public void onResponse(Request request, Action action, Object object) {

    }
}
