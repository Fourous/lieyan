package com.lieyan.Service;
import com.lieyan.Service.HttpUtil;

import java.util.HashMap;
import java.util.Map;

public class OpenIdUtil {
//    public static String oauth2GetOpenid(String code,String classify) {
public static String oauth2GetOpenid(String code) {
        Map<String,Object> getdata=new HashMap<String,Object>();
        String appid="wx595a023609bf66e7";
        String appsecret="94b74b779c0188923b62a81ad4c6b228";
        //授权（必填）
        String grant_type = "authorization_code";
        //URL
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        //请求参数
        String params = "appid=" + appid + "&secret=" + appsecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String data = HttpUtil.get(requestUrl, params);
        System.out.println(data);
        System.out.println(code);
        //这边只提供openid
        System.out.println(getdata.get("openid"));
        return data;
    }
}
