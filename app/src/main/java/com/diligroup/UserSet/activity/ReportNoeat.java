package com.diligroup.UserSet.activity;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.diligroup.R;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.bean.UserInfoBean;
import com.diligroup.net.Action;
import com.diligroup.net.Api;
import com.diligroup.utils.NetUtils;

import butterknife.Bind;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import okhttp3.Request;

/***
 * 食物禁忌上报
 */
public class ReportNoeat extends BaseAcitvity implements RadioGroup.OnCheckedChangeListener{
//    @Bind(R.id.comm_title)
//    TextView tv_ttle;
//    @Bind(R.id.lv_noeat)
//    ListView lv_noeat;
//    List<String> foodList;
    @Bind(R.id.cb_rangrou)
    CheckBox cb_rangrou;
    @Bind(R.id.cb_zhurou)
    CheckBox cb_zhurou;
    @Bind(R.id.cb_qin)
    CheckBox cb_birds;
    @Bind(R.id.cb_shuichan)
    CheckBox cb_fish;
    @Override
    public void setTitle() {
        super.setTitle();
        tv_title.setText("食物禁忌");
        title_infos.setText("请选择您的饮食禁忌");
//
    }
    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_select_noeat;
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
        Api.getNoEatFood();
    }



    @OnClick(R.id.bt_ok_noeat)
    public void reportNoeat() {

        UserInfoBean.getInstance().setNoEatFood("");
        readyGo(ReportAllergy.class);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.cb_zhurou:
                if (cb_zhurou.isChecked()){
                    cb_zhurou.getText();
                }
                break;
            case R.id.cb_rangrou:

                break;
            case R.id.cb_qin:

                break;
            case R.id.cb_shuichan:

                break;


        }
    }

    @Override
    public void onError(Request request, Action action, Exception e) {

    }

    @Override
    public void onResponse(Request request, Action action, Object object) {
        if (object!=null){

        }
    }
}
