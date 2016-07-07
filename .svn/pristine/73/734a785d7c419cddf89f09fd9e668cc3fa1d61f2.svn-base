package com.diligroup.UserSet.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.diligroup.R;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.utils.NetUtils;
import com.diligroup.utils.ToastUtil;
import com.diligroup.view.FlowLayout;
import com.diligroup.view.TagAdapter;
import com.diligroup.view.TagFlowLayout;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 上报  职业
 * Created by Kevin on 2016/6/16.
 */
public class ReportWork extends BaseAcitvity {

    @Bind(R.id.id_flowlayout)
    TagFlowLayout tag_layout1;
    @Bind(R.id.id_flowlayout2)
    TagFlowLayout tag_layout2;
    @Bind(R.id.id_flowlayout3)
    TagFlowLayout tag_layout3;
    private String[] lightWork;
    private String[] middleWork;
    private String[] heavyWork;
    private String userSelect;


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_select_work;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }
    @Override
    protected void initViewAndData() {

        initData();
        tag_layout1.setAdapter(new TagAdapter<String>(lightWork) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                TextView tv = (TextView) LayoutInflater.from(ReportWork.this).inflate(R.layout.tv, tag_layout1, false);
                tv.setText(o);
                return tv;
            }
        });

        tag_layout1.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Toast.makeText(ReportWork.this, lightWork[position], Toast.LENGTH_SHORT).show();
                userSelect = lightWork[position];
                return true;
            }
        });
        tag_layout2.setAdapter(new TagAdapter<String>(middleWork) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                TextView tv = (TextView) LayoutInflater.from(ReportWork.this).inflate(R.layout.tv, tag_layout2, false);
                tv.setText(o);
                return tv;
            }
        });
        tag_layout2.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Toast.makeText(ReportWork.this, middleWork[position], Toast.LENGTH_SHORT).show();
                //view.setVisibility(View.GONE);
                userSelect = middleWork[position];

                return true;
            }
        });

        tag_layout3.setAdapter(new TagAdapter<String>(heavyWork) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                TextView tv = (TextView) LayoutInflater.from(ReportWork.this).inflate(R.layout.tv, tag_layout3, false);
                tv.setText(o);
                return tv;
            }
        });
        tag_layout3.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Toast.makeText(ReportWork.this, heavyWork[position], Toast.LENGTH_SHORT).show();
                //view.setVisibility(View.GONE);
                userSelect = heavyWork[position];
                return true;
            }
        });
    }

    private void initData() {
        heavyWork = new String[]{"工人", "军人", "运动员", "艺人"};
        middleWork = new String[]{"销售", "采购", "服务", "学生", "司机"};
        lightWork = new String[]{"老板", "教师", "工程师", "设计师", "作家", "文职人员", "其他"};

    }

    @Override
    public void setTitle() {
        super.setTitle();
//        tv_title.setText("职业");
    }

    @OnClick(R.id.bt_commit_work)
    public void reportWorkData() {
        ToastUtil.showLong(this, "You  work ====" + userSelect);
    }
}
