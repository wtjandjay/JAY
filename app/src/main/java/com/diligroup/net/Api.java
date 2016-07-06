package com.diligroup.net;
/**
 * Created by hjf on 2016/6/27.
 */
public class Api {

    /**
     * 验证登陆后接口
     *
     * @param callback
     */
    public static void login(String username, String password, RequestManager.ResultCallback callback) {
        //密码md5加密
//        String encryptPassword = HashEncrypt.encode(HashEncrypt.CryptType.MD5, password);
//        Map<String, String> map = getUnAuthParams();
//        map.put("userName", username);
//        map.put("password", encryptPassword);

//        RequestManager.getInstance().postAsync(Action.LOGIN, map, callback);
    }

    /**
     * 注册接口
     *
     * @param phoneNum
     * @param callback
     */
    public static void register(String phoneNum, String code,String umeng, RequestManager.ResultCallback callback) {

//        Map<String, String> map = getUnAuthParams();
//        map.put("phoneNum", phoneNum);
//        map.put("code", code);
//        map.put("umeng",umeng);
//
//        RequestManager.getInstance().postAsync(Action.REGISTER, map, callback);
    }
}
