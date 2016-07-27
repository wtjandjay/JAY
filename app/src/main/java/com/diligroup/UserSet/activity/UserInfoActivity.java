package com.diligroup.UserSet.activity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.diligroup.R;
import com.diligroup.base.BaseActivity;
import com.diligroup.net.Action;
import com.diligroup.utils.LogUtils;
import com.diligroup.utils.NetUtils;
import com.diligroup.utils.ToastUtil;
import com.diligroup.utils.UpLoadPhotoUtils;
import com.diligroup.view.CircleImageView;

import java.io.File;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;
import me.nereo.multi_image_selector.MultiImageSelector;
import okhttp3.Request;

/**
 * Created by Kevin on 2016/6/14.
 * 用户信息详情
 */
public class UserInfoActivity extends BaseActivity {
//    @Bind(R.id.rl_sex)
//    RelativeLayout rl_sex;
//    @Bind(R.id.rl_birthday)
//    RelativeLayout rl_birthday;
//    @Bind(R.id.rl_height)
//    RelativeLayout rl_height;
//    @Bind(R.id.rl_mingzu)
//    RelativeLayout rl_minzu;
//    @Bind(R.id.rl_other)
//    RelativeLayout rl_other;
//    @Bind(R.id.rl_taste)
//    RelativeLayout rl_taste;
//    @Bind(R.id.rl_tsrq)
//    RelativeLayout rl_tsrq;
//    @Bind(R.id.rl_work)
//    RelativeLayout rl_work;
//    @Bind(R.id.rl_ysjj)
//    RelativeLayout rl_ysjj;
//    @Bind(R.id.rl_weight)
//    RelativeLayout rl_weight;
//    @Bind(R.id.rl_where)
//    RelativeLayout rl_where;
    @Bind(R.id.tv_time_of_month)
    TextView tv_time_of_month;
    @Bind(R.id.user_icon)
    CircleImageView userIcon;
    @Bind(R.id.rl_time_of_month)
    RelativeLayout rl_time_of_month;//生理期rl布局
    private ArrayList<String> mSelectPath;
    private static final int REQUEST_IMAGE = 2;
    private static final int CROP_CODE = 3;

    @Override
    protected void onStart() {
        super.onStart();
        isShowBack(true);

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.user_info;
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
        tv_title.setText("我的信息");


    }

    @Override
    protected void initViewAndData() {
        rl_time_of_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readyGoForResult(PhysiologicalPeriodActivity.class, 10);
            }
        });
    }
//
//    @OnClick(R.id.rl_mingzu)
//    public void ClickMinzu() {
//        ToastUtil.showShort(this,"ClickedMinZU");
//        readyGo(ReportMinZu.class);
//    }

    @OnClick(R.id.rl_sex)
    public void ClickSex() {
        ToastUtil.showShort(this, "ReportSex");
        readyGo(ReportSex.class);
    }

    @OnClick(R.id.rl_birthday)
    public void ClickBirthday() {
        readyGo(ReportBirthday.class);
    }

    @OnClick(R.id.rl_height)
    public void ClickHeight() {
        readyGo(ReportHeight.class);
    }

    @OnClick(R.id.rl_other)
    public void ClickOther() {
        readyGo(ReportOther.class);
    }

    @OnClick(R.id.rl_special)
    public void ClickTsrq() {
        readyGo(ReportSpecial.class);
    }

    @OnClick(R.id.rl_taste)
    public void ClickTaste() {
        readyGo(ReportTaste.class);
    }

    @OnClick(R.id.rl_where)
    public void ClickWhere() {
        readyGo(ReportWhere.class);
    }

    @OnClick(R.id.rl_weight)
    public void ClickWeight() {
        readyGo(ReportWeight.class);
    }

    @OnClick(R.id.rl_noeat)
    public void ClickYsjj() {
        readyGo(ReportNoeat.class);
    }

    @OnClick(R.id.rl_work)
    public void ClickWork() {
        readyGo(ReportWork.class);
    }

    @OnClick(R.id.rl_allergy)
    public void ClickAllergy() {
        readyGo(ReportAllergy.class);
    }

//    @OnClick(R.id.rl_time_of_month)//生理期
//    public void ClickCalendar() {
//
//    }

    @OnClick(R.id.user_icon)
    public void ChangeHeadPhoto() {
        new UpLoadPhotoUtils(this).pickImage();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 10:
                if (null != data) {
                    ArrayList<String> selectDate = (ArrayList<String>) data.getSerializableExtra("cycle");
                    if (selectDate.size() > 1) {
                        tv_time_of_month.setText(selectDate.get(0) + "--" + selectDate.get(1));
                    }
                }
                break;

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
                        userIcon.setImageBitmap(photo);
                    }
                } else {
                    finish();
                }
                break;
        }
    }

    @Override
    public void onError(Request request, Action action, Exception e) {

    }

    @Override
    public void onResponse(Request request, Action action, Object object) {

    }
}
