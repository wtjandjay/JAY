package com.diligroup.login;

import android.text.TextUtils;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.diligroup.Home.HomeActivity;
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
 * 登录 Activity
 */
public class LoginActivity extends BaseAcitvity implements RequestManager.ResultCallback {
    @Bind(R.id.input_username)
    AutoCompleteTextView phoneNumber;
    @Bind(R.id.input_password)
    EditText et_password;
    @Bind(R.id.login_progress)
    ProgressBar loginProgress;
//    @Bind(R.id.bt_regist)
//    Button bt_regist;
//    @Bind(R.id.bt_login)
//    Button bt_login;


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }


    @Override
    protected void onNetworkDisConnected() {

    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        ButterKnife.bind(this);
//        tv_title.setText("登录");
//    }

    @Override
    protected void initViewAndData() {
        tv_title.setText("登录");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.finish();
    }

    @OnClick(R.id.bt_login)
    public void doLogin() {
        String phoneNum = phoneNumber.getText().toString();
        String passdWord = et_password.getText().toString();
        if (!TextUtils.isEmpty(phoneNum) && StringUtils.isMobileNumber(phoneNum)) {
            if (!TextUtils.isEmpty(passdWord)) {
                Api.login(phoneNum, passdWord, this);
            } else {
                ToastUtil.showShort(this, "密码不能为空");
            }
        } else {
            ToastUtil.showShort(this, "请输入正确的手机号");
        }

    }

    @OnClick(R.id.bt_regist)
    public void doRegist() {
        readyGo(RegistActivity.class);
    }

    @OnClick(R.id.tv_forget)
    public void forgetPsd() {
        readyGo(FindPsdActivity.class);
    }

    @Override
    public void onError(Request request, Action action, Exception e) {

    }

    @Override
    public void onResponse(Request request, Action action, Object object) {
        if (object != null) {
            CommonBean bean = (CommonBean) object;
            LogUtils.e(bean.getCode() + "----------" + bean.getMessage());
            if (bean.getCode().equals("000000")) {
                ToastUtil.showShort(this, "登录成功");
                readyGo(HomeActivity.class);
                return;
            }
            if (bean.getCode().equals("APP_C010005")){
                ToastUtil.showShort(this, "密码不正确");
                return;
            }
            if (bean.getCode().equals("APP_C010005")){
                ToastUtil.showShort(this, "手机号没有注册");

            }


        }
    }
}
