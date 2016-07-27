package com.diligroup.UserSet.activity;

import com.diligroup.R;
import com.diligroup.base.BaseActivity;
import com.diligroup.bean.UserInfoBean;
import com.diligroup.net.Action;
import com.diligroup.utils.NetUtils;
import com.diligroup.utils.ToastUtil;
import com.diligroup.view.WheelView;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Request;

/**
 * 上报体重
 */
public class ReportWeight extends BaseActivity {
    @Bind(R.id.wheel_weight)
    WheelView wheelView;
    String select_weight;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_select_weight;
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

        wheelView.setOffset(3);
        wheelView.setItems(Arrays.asList(getResources().getStringArray(R.array.weight)));
        wheelView.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                select_weight = item;
//                Log.d("===========WEIGHT=========", "selectedIndex: " + selectedIndex + ", item: " + item);
            }
        });
    }

    @OnClick(R.id.bt_ok_weight)
    public void reportWeight() {
        ToastUtil.showShort(this, select_weight);
        UserInfoBean.getInstance().setHeight(select_weight);
        readyGo(ReportNoeat.class);
//        String userbirthday=ReportUserInfos.getUserBirthday();
//        LogUtils.e("WEIGHT==========="+select_weight);
    }

    @Override
    public void setTitle() {
        super.setTitle();
        tv_title.setText("体重");
        title_infos.setText("您的体重?");
    }

    @Override
    public void onError(Request request, Action action, Exception e) {

    }

    @Override
    public void onResponse(Request request, Action action, Object object) {

    }
}
