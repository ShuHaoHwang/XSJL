package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

/**
 * @author ShuHao
 * @version 1.0
 * @date 2020/4/12
 */

@Controller("UserController")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //获取openid 和 刷新sessionkey
    @RequestMapping("/getuserkey")
    @ResponseBody
    public Object GetKey(String code){
        return userService.GetSessionkey(code);
    }

    //获取个人信息
    @RequestMapping("/getprofile")
    @ResponseBody
    public Object GetProfile(@RequestBody String openid){
        System.out.println("openid: " + openid);
        return userService.GetProfile(openid.substring(0,openid.length()-1));
    }

    //对用户信息进行保存
    @RequestMapping("/saveprofile")
    @ResponseBody
    public Object SaveProfile(User u){
        System.out.println("[用户个人信息]" + u);
        return userService.SaveProfile(u);
    }

    @RequestMapping("/deliveryProfile")
    @ResponseBody
    public Object deliveryProfile(String openid,int projectid) {
        System.out.println("投递信息 openid: " + openid + "projectid: " + projectid);
        return userService.SaveDelivery(openid,projectid);
    }

    //
    @RequestMapping("/deliveryStatus")
    @ResponseBody
    public Object deliveryStatus(String openid) {
        System.out.println("获取消息 openid: " + openid);
        return userService.GetMessage(openid);
    }


}
