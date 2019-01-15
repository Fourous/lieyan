package com.lieyan.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lieyan.Entity.User;
import com.lieyan.Service.*;
//import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.lieyan.Service.WxPayConfig.appid;

//接口层
@RestController
@SpringBootApplication

public class UserController {
    @Autowired
    private UserService userService;
    private OpenIdUtil openIdUtil;
    //这里insert的时候会出现问题，header类型为json类型，不然无法插入
    @PostMapping("userinsert")
    public Map<String,Object> userwechatlogin(@RequestBody User user){
        Map<String ,Object> userwedetail=new HashMap<>();
        userwedetail.put("userwxdetail",userService.userwechatlogin(user));
        return userwedetail;
    }

    //查询所有用户信息接口，这里是保密的，只在后台管理者可以看到
    @PostMapping("userquery")
    public Map<String,Object> userquery(){
        Map<String,Object> userquery=new HashMap<>();
        List<User> list=userService.userquery();
        userquery.put("usertable",list);
        return userquery;
    }
//通过openid请求数据，如果没有这个用户，则返回0
    @PostMapping("userqueryByid")
    public Map<String,Object> userqueryByid(String openid){
        Map<String,Object> userquerybyid =new HashMap<>();
        User user=userService.useropenid(openid);
        userquerybyid.put("userbyid",user);//查询用户权限信息
        if(userquerybyid.get("userbyid")==null){
            userquerybyid.put("userbyid",0);
        }
        return userquerybyid;
    }
    //这里是删除用户的接口，是测试成功的
//    @PostMapping("userdelete")
//    public Map<String,Object> userdelete(String openid){
//        Map<String ,Object> deleteuser = new HashMap<>();
//        deleteuser.put("deleuser",userService.userdelete(openid));
//        return deleteuser;
//    }

    @PostMapping("code")
    public String getuseropen(String code){
//        Map<String,Object> openid=new HashMap<>();
//        openid.put("openid",openIdUtil.oauth2GetOpenid(code));
        return openIdUtil.oauth2GetOpenid(code);
    }

//    /**
//     * @Description: 发起微信支付
//     * @param request
//     */
    @PostMapping("wxPay")
    public Map<String, Object> wxPay(String openid,Integer money,String body, HttpServletRequest request){
        try{
            String appid="wx595a023609bf66e7";
            //生成的随机字符串
            String nonce_str = StringUtils.getRandomStringByLength(32);
            //商品名称
            String pay=money.toString();
//            String body = "测试商品名称";
            //获取客户端的ip地址
            String spbill_create_ip = IpUtil.getIpAddr(request);
            //组装参数，用户生成统一下单接口的签名
            Map<String, String> packageParams = new HashMap<String, String>();
            packageParams.put("appid", WxPayConfig.appid);
            packageParams.put("mch_id", WxPayConfig.mch_id);
            packageParams.put("nonce_str", nonce_str);
            packageParams.put("body", body);
            packageParams.put("out_trade_no", nonce_str);//商户订单号
            packageParams.put("total_fee", pay);//支付金额，这边需要转成字符串类型，否则后面的签名会失败
            packageParams.put("spbill_create_ip", spbill_create_ip);
            packageParams.put("notify_url", WxPayConfig.notify_url);//支付成功后的回调地址
            packageParams.put("trade_type", WxPayConfig.TRADETYPE);//支付方式
            packageParams.put("openid", openid);

            String prestr = PayUtil.createLinkString(packageParams); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串

            //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
            String mysign = PayUtil.sign(prestr, WxPayConfig.key, "utf-8").toUpperCase();

            //拼接统一下单接口使用的xml数据，要将上一步生成的签名一起拼接进去
            String xml = "<xml>" + "<appid>" + WxPayConfig.appid + "</appid>"
                    + "<body><![CDATA[" + body + "]]></body>"
                    + "<mch_id>" + WxPayConfig.mch_id + "</mch_id>"
                    + "<nonce_str>" + nonce_str + "</nonce_str>"
                    + "<notify_url>" + WxPayConfig.notify_url + "</notify_url>"
                    + "<openid>" + openid + "</openid>"
                    + "<out_trade_no>" + nonce_str + "</out_trade_no>"
                    + "<spbill_create_ip>" + spbill_create_ip + "</spbill_create_ip>"
                    + "<total_fee>" + pay + "</total_fee>"
                    + "<trade_type>" + WxPayConfig.TRADETYPE + "</trade_type>"
                    + "<sign>" + mysign + "</sign>"
                    + "</xml>";

            System.out.println("调试模式_统一下单接口 请求XML数据：" + xml);

            //调用统一下单接口，并接受返回的结果
            String result = PayUtil.httpRequest(WxPayConfig.pay_url, "POST", xml);

            System.out.println("调试模式_统一下单接口 返回XML数据：" + result);

            // 将解析结果存储在HashMap中
            Map map = PayUtil.doXMLParse(result);

            String return_code = (String) map.get("return_code");//返回状态码

            Map<String, Object> response = new HashMap<String, Object>();//返回给小程序端需要的参数
            if(return_code.equals("SUCCESS")){
                String prepay_id = (String) map.get("prepay_id");//返回的预付单信息
                response.put("nonceStr", nonce_str);
                response.put("package", "prepay_id=" + prepay_id);
                Long timeStamp = System.currentTimeMillis() / 1000;
                response.put("timeStamp", timeStamp + "");//这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误
                //拼接签名需要的参数
                String stringSignTemp = "appId=" + WxPayConfig.appid + "&nonceStr=" + nonce_str + "&package=prepay_id=" + prepay_id+ "&signType=MD5&timeStamp=" + timeStamp;
                //再次签名，这个签名用于小程序端调用wx.requesetPayment方法
                String paySign = PayUtil.sign(stringSignTemp, WxPayConfig.key, "utf-8").toUpperCase();

                response.put("paySign", paySign);
            }

            response.put("appid", WxPayConfig.appid);

            return response;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

//    /**
//     * @Description:微信支付
//     * @return
//     * @throws Exception
//     */
//
//    @RequestMapping(value="/wxNotify")
//    @ResponseBody
    @RequestMapping("wxNotify")
    public void wxNotify(HttpServletRequest request,HttpServletResponse response) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream)request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine()) != null){
            sb.append(line);
        }
        br.close();
        //sb为微信返回的xml
        String notityXml = sb.toString();
        String resXml = "";
        System.out.println("接收到的报文：" + notityXml);
        Map map = PayUtil.doXMLParse(notityXml);
        String returnCode = (String) map.get("return_code");
        if("SUCCESS".equals(returnCode)){
            //验证签名是否正确
            Map<String, String> validParams = PayUtil.paraFilter(map);
            //回调验签时需要去除sign和空值参数
            String validStr = PayUtil.createLinkString(validParams);
            //把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
            String sign = PayUtil.sign(validStr, WxPayConfig.key, "utf-8").toUpperCase();
            //拼装生成服务器端验证的签名
            //根据微信官网的介绍，此处不仅对回调的参数进行验签，还需要对返回的金额与系统订单的金额进行比对等
            if(sign.equals(map.get("sign"))){
                /**此处添加自己的业务逻辑代码start**/


                /**此处添加自己的业务逻辑代码end**/
                //通知微信服务器已经支付成功
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            }
        }else{
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                    + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
        }
        System.out.println(resXml);
        System.out.println("微信支付回调数据结束");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        out.write(resXml.getBytes());
        out.flush();
        out.close();
    }

    //报名的入口，传入openid和报名的类别
    @PostMapping("signitem")
    public boolean signitem(String openid,Integer  signitem){
        return userService.usersign(openid,signitem);
    }

    //这里绑定教练的接口
//    不仅要更新用户表绑定，也要插入预约表
//    @PostMapping("bindteacher")
//    public boolean bindteacher(String openid,Integer tid){
//        return userService.bindteacher(openid,tid);
//    }

@PostMapping("changeusername")
    public boolean changeusername(String openid,String name){
        return userService.userchangename(openid,name);
}
}


