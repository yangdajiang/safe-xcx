package com.cs.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendBatchSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendBatchSmsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.text.SimpleDateFormat;
import java.util.Date;

//"LTAI6j63DApMawEo"
//"vDMuKuj9YagkRvPaK1NiG9rUQ2mhh0"

/**
 * Created by 15114 on 2018/6/6.
 */
public class SendMessUtil {
    public  static void sendUserMess(String userPhone) throws ClientException {
        //设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化ascClient需要的几个参数
        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
        //替换成你的AK
        final String accessKeyId = "LTAI6j63DApMawEo";//你的accessKeyId,参考本文档步骤2
        final String accessKeySecret = "vDMuKuj9YagkRvPaK1NiG9rUQ2mhh0";//你的accessKeySecret，参考本文档步骤2
        //初始化ascClient,暂时不支持多region（请勿修改）
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为00+国际区号+号码，如“0085200000000”
        request.setPhoneNumbers(userPhone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("safe小程序");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_136388213");
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        int time = 10;
        request.setTemplateParam("{\"time\":\""+time+"\"}");
        //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        //request.setOutId("yourOutId");
        //请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            Date day = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(df.format(day) +
                    "   sendUserMess   " +
                    sendSmsResponse.getCode());
        }
    }

    public static void sendFriendsMess(String userName,
                                     String phone1,String phone2,String phone3,
                                     String place) throws ClientException {
        //设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化ascClient需要的几个参数
        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
        //替换成你的AK
        final String accessKeyId = "LTAI6j63DApMawEo";//你的accessKeyId,参考本文档步骤2
        final String accessKeySecret = "vDMuKuj9YagkRvPaK1NiG9rUQ2mhh0";//你的accessKeySecret，参考本文档步骤2
        //初始化ascClient,暂时不支持多region（请勿修改）
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象
        SendBatchSmsRequest request = new SendBatchSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        //必填:待发送手机号。支持JSON格式的批量调用，批量上限为100个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
        request.setPhoneNumberJson("[\"" + phone1 + "\",\"" + phone2 + "\",\"" + phone3 + "\"]");
        //必填:短信签名-支持不同的号码发送不同的短信签名
        request.setSignNameJson("[\"safe小程序\",\"safe小程序\",\"safe小程序\"]");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_136388006");
        //必填:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        request.setTemplateParamJson("[{\"name\":\"" + userName + "\", \"place\":\"" + place + "\"}," +
                "{\"name\":\"" + userName + "\", \"place\":\"" + place + "\"}," +
                "{\"name\":\"" + userName + "\", \"place\":\"" + place + "\"}]");
        //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCodeJson("[\"90997\",\"90998\"]");
        //请求失败这里会抛ClientException异常
        SendBatchSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        //ResultPojo resultPojo;
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            Date day = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(df.format(day) +
                    "   sendFriendsMess   " +
                    sendSmsResponse.getCode());
        }
    }
}