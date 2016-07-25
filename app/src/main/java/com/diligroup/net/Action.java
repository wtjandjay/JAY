package com.diligroup.net;

import com.diligroup.bean.CommonBean;
import com.diligroup.bean.GetAllergyBean;
import com.diligroup.bean.GetSpecialBean;
import com.diligroup.bean.GetWorkTypeBean;
import com.diligroup.bean.NoEatFoodBean;
import com.diligroup.bean.ProvingCodeBean;
import com.diligroup.bean.UserBeanFromService;

/**
 *
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
    MODIFY(Urls.MODIFYPSD),

    BANNER(Urls.GETBANNER),
    /*登出*/
    LOGINOUT(Urls.LOGINOUT),
    /*上报更新用户信息*/
    REPORT_USERINFOS(Urls.UPDATA_USERINFOS),
    GET_WORK_TYPE(Urls.GET_WORK_TYPE),
    GET_NO_EAT(Urls.GET_NO_EAT),
    GET_ALLERGY(Urls.GET_ALLERGY),
    GET_OTHER(Urls.BASE),
    GET_SPECIAL(Urls.BASE);
    /**
     * 根据Action获取解析类
     *
     * @param action
     * @return
     */
    public static Class getAction(Action action) {
        switch (action) {
            case LOGIN:
                return UserBeanFromService.class;
            case REGISTER:
                return CommonBean.class;
            case SMSCODE:
                return ProvingCodeBean.class;
            case MODIFY:
                return CommonBean.class;
            case BANNER:
                return CommonBean.class;
            case LOGINOUT:
                return CommonBean.class;
            case REPORT_USERINFOS:
                return CommonBean.class;
            case GET_WORK_TYPE:
                return GetWorkTypeBean.class;
            case GET_NO_EAT:
                return NoEatFoodBean.class;
            case GET_ALLERGY:
                return  GetAllergyBean.class;
            case GET_OTHER:
                return  CommonBean.class;
            case GET_SPECIAL:
                return GetSpecialBean.class;
        }
        return null;
    }

    /**
     * 获取枚举的值 url
     *
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
