package mapper;

import java.util.List;
import java.util.Map;

import model.Message;
import model.Project;
import model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectUserByOpenid(String openid);

    int updateByOpenid(User record);

    int insertDelivery(@Param("openid") String openid, @Param("projectid") int projectid, @Param("status") String status);

    List<Message> selectAllMessageByOpenid(String openid);
}