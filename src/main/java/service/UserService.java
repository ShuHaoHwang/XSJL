package service;


import model.Submit;
import model.User;

public interface UserService {
    Object GetSessionkey(String s);
    Object GetProfile(String openid);
    Object SaveProfile(User u);
    Object SaveDelivery(String openid,int projectid);
    Object GetMessage(String openid);
    Object DeliverySubmit(Submit s);
}
