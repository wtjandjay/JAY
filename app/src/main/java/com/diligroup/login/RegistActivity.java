package com.diligroup.login;


import android.widget.EditText;

import com.diligroup.R;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.bean.CommonBean;
import com.diligroup.net.Action;
import com.diligroup.net.Api;
import com.diligroup.net.RequestManager;
import com.diligroup.utils.LogUtils;
import com.diligroup.utils.NetUtils;
import com.diligroup.utils.StringUtils;
import com.diligroup.utils.ToastUtil;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Request;


/**
 * 注册
 */
public class RegistActivity extends BaseAcitvity implements RequestManager.ResultCallback {
    String phoneNum;
    String registCode;
    String psd;
    @Bind(R.id.input_phone)
    EditText et_phone;
    @Bind(R.id.et_code)
    EditText et_code;
    @Bind(R.id.et_psd)

    EditText et_psd;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_regist;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    public void setTitle() {
        super.setTitle();
        tv_title.setText("注册");

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    protected void initViewAndData() {
        isShowBack(true);
    }

    //获取注册验证码
    @OnClick(R.id.bt_getcode)
    public void getRegistCode() {
        phoneNum = et_phone.getText().toString();
    }

    @OnClick(R.id.bt_regist2)
    public void registUser() {
        phoneNum = et_phone.getText().toString();
        registCode = et_code.getText().toString();
        psd = et_psd.getText().toString();
        if (phoneNum != null && !phoneNum.isEmpty() && StringUtils.isMobileNumber(phoneNum)) {
            if (registCode != null && !registCode.isEmpty()) {
                if (psd != null && !psd.isEmpty()) {
                    Api.register("C0100", "add", phoneNum, psd, this);
                } else {
                    ToastUtil.showShort(this, "请输入密码");

                }
            } else {
                ToastUtil.showShort(this, "请输入验证码");

            }
            return;

        } else {
            ToastUtil.showShort(this, "请输入正确的手机号码");

        }
    }


    @Override
    public void onError(Request request, Action action, Exception e) {

    }

    @Override
    public void onResponse(Request request, Action action, Object object) {
        if (object != null) {
            CommonBean bean = (CommonBean) object;
            //APP_C010002  已经注册
            //000000  注册成功
            LogUtils.e(bean.getMessage());
            if (bean.getCode().equals("000000")) {
                ToastUtil.showShort(this, "注册成功");
                readyGo(LoginActivity.class);
                return;
            }
            if (bean.getCode().equals("APP_C010002")) {
                ToastUtil.showShort(this, "此号码已经注册请直接登录");
                return;
            }
            return;
        }
        ToastUtil.showShort(this, "服务器出问题了 返回 NULL");
    }
}
