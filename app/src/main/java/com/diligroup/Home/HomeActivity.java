package com.diligroup.Home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.diligroup.After.fragment.AfterFragment;
import com.diligroup.Before.fragment.BeforeFragment;
import com.diligroup.Home.fragment.HomeFragment;
import com.diligroup.R;
import com.diligroup.UserSet.fragment.UserSetFragment;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.utils.NetUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends BaseAcitvity {
    public static final int HOME = 0;
    public static final int BEFORE = 1;
    public static final int AFTER = 2;
    public static final int USER = 3;
    @Bind(R.id.viewpager)
    ViewPager mViewPager;
    @Bind(R.id.tab_layout)
    TabLayout mTablayout;
    private int[] tabIcons = {
            R.drawable.selector_tab1,
            R.drawable.selector_tab2,
            R.drawable.selector_tab3,
            R.drawable.selector_tab4
    };
    private  List<String> titles;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
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
        tv_title.setText("首页");
    }

    @Override
    protected void initViewAndData() {
        mViewPager.setOffscreenPageLimit(4);
        setupViewPager(mViewPager);

        titles = new ArrayList<>();
        titles.add("首页");
        titles.add("餐前指导");
        titles.add("餐后评价");
        titles.add("我的");

        mTablayout.addTab(mTablayout.newTab());
        mTablayout.addTab(mTablayout.newTab());
        mTablayout.addTab(mTablayout.newTab());
        mTablayout.addTab(mTablayout.newTab());

        mTablayout.setupWithViewPager(mViewPager);

        setupTabIcons();
        mViewPager.setCurrentItem(1);
        mViewPager.setCurrentItem(0);
        mViewPager.addOnPageChangeListener(changeListener);
    }

    @SuppressWarnings("ConstantConditions")
    private void setupTabIcons() {

        mTablayout.getTabAt(0).setCustomView(getTabView(0));
        mTablayout.getTabAt(1).setCustomView(getTabView(1));
        mTablayout.getTabAt(2).setCustomView(getTabView(2));
        mTablayout.getTabAt(3).setCustomView(getTabView(3));
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_tab, null);
        TextView txt_title = (TextView) view.findViewById(R.id.txt_title);
        txt_title.setText(titles.get(position));
        ImageView img_title = (ImageView) view.findViewById(R.id.img_title);
        img_title.setImageResource(tabIcons[position]);
        return view;
    }

    private void setupViewPager(ViewPager mViewPager) {
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), getString(R.string.home));
        adapter.addFragment(new BeforeFragment(), getString(R.string.before));
        adapter.addFragment(new AfterFragment(), getString(R.string.after));
        adapter.addFragment(new UserSetFragment(), getString(R.string.user));
        mViewPager.setAdapter(adapter);

    }




    public  class MyPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {

            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

//        @Override
//        public CharSequence getPageTitle(int position) {
//            return mFragmentTitles.get(position);
//        }
    }
    ViewPager.OnPageChangeListener  changeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position){
                case 0:
                    tv_title.setText(titles.get(0));
                    break;
                case 1:
                    tv_title.setText(titles.get(1));
                    break;
                case 2:
                    tv_title.setText(titles.get(2));
                    break;
                case 3:
                    tv_title.setText(titles.get(3));
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
