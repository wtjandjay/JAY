package com.diligroup.net;

import com.diligroup.utils.DigestUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hjf on 2016/6/27.
 */
public class Api {

    /**
     * 验证登陆后接口
     *
     * @param callback
     */
    public static void login(String mobileNum, String password, RequestManager.ResultCallback callback) {
        //密码md5加密
//        String encryptPassword = HashEncrypt.encode(HashEncrypt.CryptType.MD5, password);
        Map<String, String> map = new HashMap<>();
        map.put("transCode", TransCode.LoginCode);
        map.put("type", "app_login");
        map.put("mobileNum", mobileNum);
        map.put("password", DigestUtils.stringMD5(password));
        RequestManager.getInstance().postAsync(Action.LOGIN, map, callback);
    }

    /**
     * 注册接口
     * 交易码transCode: C0100
     * 交易类型type：add
     *
     * @param callback
     */
    public static void register(String transCode, String type, String mobileNum, String password, RequestManager.ResultCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("transCode", transCode);
        map.put("type", type);
        map.put("mobileNum", mobileNum);
        map.put("password", password);
        RequestManager.getInstance().getAsync(Action.REGISTER, map, callback);
    }

    /**
     * 获取手机验证码
     *  找回密码的验证码
     * @param phoneNum
     */
    public static void getCode(String phoneNum, RequestManager.ResultCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("transCode", TransCode.SMSCode);
        map.put("type", "sendPhoneMes");
        map.put("mobileNum", phoneNum);
        map.put("mesType","1");
        map.put("bizType","2");
        RequestManager.getInstance().getAsync(Action.SMSCODE,map,callback);
    }
    /**
     * 修改密码
     *
     */
    public static void modifyPsd(){

    }
}
