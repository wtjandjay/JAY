package com.diligroup.UserSet.fragment;

import com.diligroup.R;
import com.diligroup.UserSet.activity.SettingActivity;
import com.diligroup.UserSet.activity.UserInfoActivity;
import com.diligroup.base.BaseFragment;

import butterknife.OnClick;

/**
 *
 * Created by Kevin on 2016/7/4.
 */
public class UserSetFragment extends BaseFragment {


//    @Override
//    public void setTv(TextView tv_fg) {
//
//    }

    @Override
    public int getLayoutXml() {
        return R.layout.fragment_user;
    }


    @OnClick(R.id.rl_go_userinfo)
    public void jumpUserInfo() {
       GoActivity(UserInfoActivity.class);

    }

    @OnClick(R.id.rl_go_setting)
    public void jumpSetView() {
        GoActivity(SettingActivity.class);

    }

    @OnClick(R.id.rl_go_service)
    public void jumpService() {
        GoActivity(SettingActivity.class);
    }
}
