package com.diligroup.net;

import com.diligroup.bean.CommonBean;
import com.diligroup.bean.ProvingCodeBean;

/**
 * Created by cwj on 2016/4/5.
 */
public enum Action {
    /*登陆*/
    LOGIN(Urls.LOGIN),
    /*注册*/
    REGISTER(Urls.REGISTER),
    /*获取验证码*/
    SMSCODE(Urls.SMSCODE),
/*修改密码*/
    MODIFY(Urls.MODIFYPSD);
    /**
     * 根据Action获取解析类
     * @param action
     * @return
     */
    public static Class getAction(Action action) {
        switch (action) {
            case LOGIN:
                return CommonBean.class;
            case REGISTER:
                return CommonBean.class;
            case SMSCODE:
                return ProvingCodeBean.class;
            case MODIFY:
                return CommonBean.class;
        }
        return null;
    }

    /**
     * 获取枚举的值 url
     * @param action
     * @return
     */
    public static String getUrl(Action action) {
        return action.getValue();
    }

    private final String value;

    //构造器默认也只能是private, 从而保证构造函数只能在内部使用
    Action(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
