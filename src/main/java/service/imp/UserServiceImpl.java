package service.imp;

import mapper.MessageMapper;
import mapper.SubmitMapper;
import mapper.UserMapper;
import model.Message;
import model.Submit;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;
import utils.GetWxKey;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author ShuHao
 * @version 1.0
 * @date 2020/3/6
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private SubmitMapper submitMapper;

    @Override
    public Object GetSessionkey(String Code) {
        //调用请求工具，向微信开放接口获取用户对应的openid 和 sessionKey并返回至前端
        return GetWxKey.getWxUserOpenid(Code);
    }


    @Override
    public Object GetProfile(String openid) {
        User u= userMapper.selectUserByOpenid(openid);          //获取对应的用户信息
        System.out.println("GetProfile: "+ u);
        if (u!=null)return u;
        else return new User();                                       //没有找到就返回null
    }

    @Override
    public Object SaveProfile(User u) {
        System.out.println("SaveProfile"+ u);
        if(userMapper.updateByOpenid(u) == 0){       //如果更新数为0说明为新用户
            u.setWages(0);
            userMapper.insert(u);                              //新用户则把数据进行插入
        }
        return "save,ok!";
    }

    @Override
    public Object SaveDelivery(String openid, int projectid) {
        Map<String,Object> rs = new HashMap<>();
        Message message = new Message();
        message.setAddtime(new Date());
        message.setOpenid(openid);
        message.setpId(projectid);
        message.setStatus("1");
        messageMapper.insert(message);
        rs.put("code",1);
        return rs;
    }

    @Override
    public Object GetMessage(String openid) {
        return userMapper.selectAllMessageByOpenid(openid);
    }

    @Override
    public Object DeliverySubmit(Submit s) {

        submitMapper.insert(s);
        System.out.println("这里的openid接到了吗" + s.getOpenid());
        messageMapper.updateStatusByOpenid("2",s.getOpenid(),s.getpId());

        return "isok";
    }


//    @Override
//    public Object getContact(String encryptedData,String iv,String sessionKey,String openid) {
//
//        String Contact = JSONObject.parseObject(WxKeyDec.decryptData(encryptedData,sessionKey,iv)).getString("phoneNumber");
//        System.out.println("JSONObject: " + Contact);
//        System.out.println("Contact: " + Contact);
//        UserExample userExample = new UserExample();
//
//        userExample.createCriteria()
//                .andOpenidEqualTo(openid);
//        User u = userMapper.selectByExample(userExample).get(0);
//        u.setContact(Contact);
//        userMapper.updateByExampleSelective(u,userExample);
//        return u;
//    }


}
