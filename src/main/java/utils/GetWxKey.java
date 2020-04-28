package utils;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ShuHao
 * @version 1.0
 * @date 2020/3/6
 * @do 这边是获取openid的工具类
 */

public class GetWxKey {


    //获取openid
    public static JSONObject getWxUserOpenid(String code) {
        System.out.println("code: " + code);                                        //验证code是否获取
        //拼接url
        StringBuilder url = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?");
        url.append("appid=");                                                        //appid设置
        url.append("wxb6f756ed8a73437e");
        url.append("&secret=");                                                     //secret设置
        url.append("ff6ee66b4d1162e653396f6445aaf9ea");
        url.append("&js_code=");                                                    //code设置
        url.append(code);
        url.append("&grant_type=authorization_code");
        System.out.println("url: "+url);
        Map<String, Object> map = null;
        JSONObject res = null;
        try {
            HttpClient client = HttpClientBuilder.create().build();                 //构建一个Client
            HttpGet get = new HttpGet(url.toString());                              //构建一个GET请求
            HttpResponse response = client.execute(get);                            //提交GET请求
            HttpEntity result = response.getEntity();                               //拿到返回的HttpResponse的"实体"
            String content = EntityUtils.toString(result);
            System.out.println(content);                                            //打印返回的信息
            res = JSONObject.parseObject(content);                                  //把信息封装为json

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
