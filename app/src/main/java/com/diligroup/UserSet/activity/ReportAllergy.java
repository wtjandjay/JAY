package com.diligroup.UserSet.activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.widget.Button;

import com.diligroup.R;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.utils.NetUtils;

import butterknife.OnClick;

/**
 * 上报 过敏
 */
public class ReportAllergy extends BaseAcitvity {

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_report_allergy;
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
        tv_title.setText("过敏食材");
        title_infos.setText("过敏食材");
    }

    @Override
    protected void initViewAndData() {

    }

    @OnClick(R.id.bt_class_gu)
    public void ClickGu(){
        Button bt_gu= (Button) findViewById(R.id.bt_class_gu);
        bt_gu.setBackgroundColor(Color.parseColor("#FFFFFF"));
        bt_gu.setTextColor(Color.parseColor("#67A129"));
        Drawable  drawableTop=ContextCompat.getDrawable(this,R.drawable.iv_gulei_pressed);
        bt_gu.setCompoundDrawablesWithIntrinsicBounds(null,drawableTop,null,null);
    }
}
