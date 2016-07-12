package com.diligroup.Home.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diligroup.R;
import com.diligroup.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by Kevin on 2016/7/4.
 */
public class HomeFragment extends BaseFragment {
    //    @Override
//    public void setTv(TextView tv_fg) {
//        tv_fg.setText("首页");
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public int getLayoutXml() {
        return R.layout.fragment_home;
    }

    @Override
    public void setViews() {

    }

    @Override
    public void setListeners() {

    }
}
