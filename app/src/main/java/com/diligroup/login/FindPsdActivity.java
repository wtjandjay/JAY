package com.diligroup.login;

import android.text.TextUtils;
import android.widget.EditText;

import com.diligroup.R;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.net.Action;
import com.diligroup.net.Api;
import com.diligroup.net.RequestManager;
import com.diligroup.utils.NetUtils;
import com.diligroup.utils.StringUtils;
import com.diligroup.utils.ToastUtil;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Request;


/**
 * 找回密码
 */
public class FindPsdActivity extends BaseAcitvity implements RequestManager.ResultCallback{

    @Bind(R.id.et_code2)
    EditText et_code;
    @Bind(R.id.input_phone2)
    EditText et_phone;
    @Bind(R.id.et_newpsd2)
    EditText et_psd;

    String phnoeNumber;
    String codeNumber;
    String password;

    @Override
    public void setTitle() {
        super.setTitle();
        tv_title.setText("找回密码");
    }

    //获取验证码
    @OnClick(R.id.bt_getcode2)
    public void getCode() {
        phnoeNumber = et_phone.getText().toString();

        if (!TextUtils.isEmpty(phnoeNumber) && StringUtils.isMobileNumber(phnoeNumber)) {
            Api.getCode(phnoeNumber,this);
        } else {
            ToastUtil.showShort(this, "请检查手机号码");
        }
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_find_psd;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @OnClick(R.id.bt_ok2)
    public void reportModifyPsd() {
        phnoeNumber = et_phone.getText().toString();
        codeNumber = et_code.getText().toString();
        password = et_psd.getText().toString();
        if (!TextUtils.isEmpty(phnoeNumber) && StringUtils.isMobileNumber(phnoeNumber)) {
            if (!TextUtils.isEmpty(codeNumber)) {
                //
                if (password.isEmpty()) {

                }
            } else {
                ToastUtil.showShort(this, "请输入验证码");
            }
        } else {
            ToastUtil.showShort(this, "请检查手机号码");
        }
    }

    @Override
    protected void initViewAndData() {
        isShowBack(true);

    }


    @Override
    public void onError(Request request, Action action, Exception e) {

    }

    @Override
    public void onResponse(Request request, Action action, Object object) {

    }
}
