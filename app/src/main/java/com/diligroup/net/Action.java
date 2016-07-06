package com.diligroup.net;
/**
 * Created by cwj on 2016/4/5.
 */
public enum Action {
    /*登陆*/
    LOGIN(Urls.LOGIN),
    /*注册*/
    REGISTER(Urls.REGISTER),
    ;

    /**
     * 根据Action获取解析类
     * @param action
     * @return
     */
    public static Class getAction(Action action){
        switch (action){
            case LOGIN:
//                return LoginResponse.class;
                return null;
            case REGISTER:
                return null;
        }
        return  null;
    }

    /**
     * 获取枚举的值 url
     * @param action
     * @return
     */
    public static String getUrl(Action action){
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
