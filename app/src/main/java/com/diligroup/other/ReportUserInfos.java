package com.diligroup.other;

import com.diligroup.bean.UserInfoBean;

/**
 * Created by Administrator on 2016/7/21.
 */
public class ReportUserInfos {
    public static ReportUserInfos  reportUserInfos=null;
    public static ReportUserInfos getInstance(){
        if (reportUserInfos==null){
            return new ReportUserInfos();
        }
        return reportUserInfos;
    }
    public static UserInfoBean  userInfo;
     public  ReportUserInfos(){
       userInfo=new UserInfoBean();
    }
    public static void setUserSex(int sex){
         userInfo.setSex(sex);
    }
    public static  int getUserSex(){
        return userInfo.getSex();
    }
    public static void setUserBirthday(String data){
        userInfo.setBirthday(data);
    }
    public static String getUserBirthday(){
       return userInfo.getBirthday();
    }
    public static void setUserWork(String work){
        userInfo.setJob(work);
    }
    public static String getUserWork(){
        return userInfo.getJob();
    }
    public static  String getUserHeight(){
        return userInfo.getHeight();
    }
    public static  String getUserWeight(){
        return userInfo.getWeight();
    }
    public static void setUserHeight(String selectHeight) {
         userInfo.setHeight(selectHeight);
    }
    public static void setUserWeight(String weight){
        userInfo.setWeight(weight);
    }

}
