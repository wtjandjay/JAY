package com.diligroup.Home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.diligroup.After.fragment.AfterFragment;
import com.diligroup.Before.fragment.BeforeFragment;
import com.diligroup.Home.fragment.HomeFragment;
import com.diligroup.R;
import com.diligroup.UserSet.fragment.UserSetFragment;
import com.diligroup.base.BaseActivity;
import com.diligroup.bean.EventBusBean;
import com.diligroup.dialog.RotateShowProgressDialog;
import com.diligroup.net.Action;
import com.diligroup.utils.LogUtils;
import com.diligroup.utils.NetUtils;
import com.diligroup.utils.PictureFileUtils;
import com.diligroup.utils.ToastUtil;
import com.diligroup.utils.UpLoadPhotoUtils;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import me.nereo.multi_image_selector.MultiImageSelector;
import okhttp3.Request;

public class HomeActivity extends BaseActivity {


    private static final int REQUEST_IMAGE = 2;
    private static final int CROP_CODE = 3;
    private ArrayList<String> mSelectPath;
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
    private List<String> titles;
    private String path;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }
    @Override
    protected void initViewAndData() {
        isShowBack(false);
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

    @Override
    public void setTitle() {
        super.setTitle();
        tv_title.setText("首页");
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

    @Override
    public void onError(Request request, Action action, Exception e) {

    }

    @Override
    public void onResponse(Request request, Action action, Object object) {

    }


    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
//        private final List<String> mFragmentTitles = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
//            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_IMAGE:
                if (resultCode == RESULT_OK) {
                    mSelectPath = data.getStringArrayListExtra(MultiImageSelector.EXTRA_RESULT);
                    StringBuilder sb = new StringBuilder();
                    for (String p : mSelectPath) {
                        sb.append(p);
                    }
                    LogUtils.i("onActivityResult方法=", sb.toString());
                    new UpLoadPhotoUtils(this).startPhotoZoom(Uri.fromFile(new File(sb.toString())));
                }
                break;
            case CROP_CODE:
                if (resultCode == RESULT_OK) {
//                    detialPathAndShowImage();  上传图片
                    Bundle extras = data.getExtras();
                    if (extras != null) {
                        Bitmap photo = extras.getParcelable("data");
//                        mViewPager.setCurrentItem(3);
//                        new UserSetFragment().chageImage(photo);
//                        new HomeFragment().chageImage(photo);
                        EventBusBean bean=new EventBusBean();
                        bean.setBitmap(photo);
                        bean.setCode(10);
                        EventBus.getDefault().post(bean);
                    }
                } else {
                    finish();
                }
                break;
        }
    }

    /**
     * 裁剪图片
     *
     * @param uri
     */
//    public void startPhotoZoom(Uri uri) {
//        File file = FileUtils.buildFile(
//                AppUtils.getPath(this, AppUtils.StorageFile.cache) + String.valueOf(System.currentTimeMillis() / 1000) + ".jpg", false);
//        path = file.getPath();
//        Intent intent = new Intent("com.android.camera.action.CROP");
//        intent.setDataAndType(uri, "image/*");
//        intent.putExtra("crop", "true");
//        intent.putExtra("aspectX", 1);
//        intent.putExtra("aspectY", 1);
//        intent.putExtra("outputX", 250);
//        intent.putExtra("outputY", 250);
////        intent.putExtra("output", Uri.fromFile(new File(path)));
////        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
//        intent.putExtra("outputFormat", "JPEG");
//        intent.putExtra("noFaceDetection", true);// ȡ������ʶ��
//        intent.putExtra("return-data", true);// true:������uri��false������uri
//        startActivityForResult(intent, CROP_CODE);
//    }

    /**
     * 选择的图片加入到集合
     */
    private void detialPathAndShowImage() {
        if (!TextUtils.isEmpty(path) && new File(path).exists()) {
            new PictureZoomTask().execute();
        } else {
            this.finish();
        }
    }

    class PictureZoomTask extends AsyncTask<String, Integer, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            RotateShowProgressDialog.ShowProgressOn(HomeActivity.this, false);
        }

        @Override
        protected void onPostExecute(String result) {
            //上传
                /*ToastUtil.showToast(UploadAvatar.this, "上传成功了");
				UploadAvatar.this.finish();*/
            RotateShowProgressDialog.ShowProgressOff();
            if (result == null) {
//                RotateShowProgressDialog.ShowProgressOff();
//                HomeActivity.this.finish();
            } else {
//                CrmUserDetail user = SharePreCache.getUser(UploadAvatar.this);
//                AppApi.upLoadPicture(UploadAvatar.this, user.getId(),path, UploadAvatar.this);
            }
        }

        @Override
        protected String doInBackground(String... arg0) {
            //String path = arg0[0];
            try {
                path = PictureFileUtils.compressImage(HomeActivity.this, path, "", 80);
            } catch (FileNotFoundException e) {
                ToastUtil.showLong(HomeActivity.this, "获取图片失败");
                return null;
            }

            return path;
        }

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
