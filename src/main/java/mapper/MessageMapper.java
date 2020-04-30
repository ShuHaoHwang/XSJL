package mapper;

import java.util.List;
import model.Message;
import org.apache.ibatis.annotations.Param;

public interface MessageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Message record);

    Message selectByPrimaryKey(Long id);

    List<Message> selectAll();

    int updateByPrimaryKey(Message record);

    int updateStatusByOpenid(@Param("status") String status, @Param("openid") String openid,@Param("p_id")Integer p_id);
}