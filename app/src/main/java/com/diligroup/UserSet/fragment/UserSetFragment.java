package com.diligroup.UserSet.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.TextView;

import com.diligroup.R;
import com.diligroup.UserSet.activity.SettingActivity;
import com.diligroup.UserSet.activity.UserInfoActivity;
import com.diligroup.base.BaseFragment;
import com.diligroup.bean.EventBusBean;
import com.diligroup.utils.CommonUtils;
import com.diligroup.view.CircleImageView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;
import me.nereo.multi_image_selector.MultiImageSelector;

/**
 * Created by Kevin on 2016/7/4.
 */
public class UserSetFragment extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.iv_user_header)
    CircleImageView iv_user_header;
    @Bind(R.id.tv_numb_phone)
    TextView tv_numb_phone;

    private static final int REQUEST_IMAGE = 2;
    private static final int IMAGE_REQUEST_CODE = 3;
    protected static final int REQUEST_STORAGE_READ_ACCESS_PERMISSION = 101;//读权限
    private ArrayList<String> mSelectPath;
    public static final int RESULT_OK = -1;
    @Override
    public int getLayoutXml() {
        return R.layout.fragment_user;
    }

    @Override
    public void setViews() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void setListeners() {
        iv_user_header.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_user_header:
                pickImage();
                break;
        }
    }

    private void pickImage() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN // Permission was added in API Level 16
                && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
//            new CommonUtils(getActivity()).requestPermission(Manifest.permission.READ_EXTERNAL_STORAGE,
//                    getString(R.string.permission_rationale),
//                    REQUEST_STORAGE_READ_ACCESS_PERMISSION);
        } else {
            int maxNum = 12;
            MultiImageSelector selector = MultiImageSelector.create(getActivity());
            selector.showCamera(true);
            selector.count(1);
            selector.single();
            selector.origin(mSelectPath);
            selector.start(getActivity(), REQUEST_IMAGE);
        }
    }

//    public void chageImage(Bitmap pic) {
//        iv_user_header.setImageBitmap(pic);
//    }
    @Subscribe
    public void onEvent(EventBusBean event) {
        switch (event.getCode()){
            case 10:
                iv_user_header.setImageBitmap(event.getBitmap());
                break;
        }
    }
}
