package com.diligroup.Home;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.ViewPager;
import android.view.WindowManager;

import com.diligroup.Home.adapter.AddLunchAdapter;
import com.diligroup.R;
import com.diligroup.base.BaseActivity;
import com.diligroup.net.Action;
import com.diligroup.utils.NetUtils;
import com.diligroup.view.PagerSlidingTabStrip;

import butterknife.Bind;
import okhttp3.Request;

/**
 * Created by hjf on 2016/7/13.
 * 添加午餐
 */
public class AddLunchActivity extends BaseActivity {

    @Bind(R.id.pst_tabstrip)
    PagerSlidingTabStrip pstTabstrip;
    @Bind(R.id.vPager)
    ViewPager vPager;
    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_add_lunch;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
         getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);// 默认软键盘不弹出
    }

    @Override
    public void setTitle() {
        super.setTitle();
        tv_title.setText("添加午餐");
        isShowBack(true);
    }

    @Override
    protected void initViewAndData() {

        pstTabstrip.setTextColor(R.color.common_green);
        pstTabstrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        AddLunchAdapter adapter=new AddLunchAdapter(getSupportFragmentManager(),this);
        vPager.setAdapter(adapter);
        pstTabstrip.setViewPager(vPager);
        vPager.setCurrentItem(0);

    }

    @Override
    public void onError(Request request, Action action, Exception e) {

    }

    @Override
    public void onResponse(Request request, Action action, Object object) {

    }
}
