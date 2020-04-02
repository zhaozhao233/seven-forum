package com.seven.forum.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class SendSmsUtil {

    public static String sendSms(String phoneNumber){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "你的key", "你的密码");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", "TheMusic音乐播放");
        request.putQueryParameter("TemplateCode", "SMS_183766139");
        //验证码
        String code = getVerification();
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return code;
    }

    public static String getVerification(){
        String code = String.valueOf((int)((Math.random()*9+1)*100000));
        return code;
    }

    public static void main(String[] args) {
        String code = SendSmsUtil.sendSms("18170686456");
        System.out.println(code);
    }
}