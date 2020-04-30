package mapper;

import java.util.List;
import model.Submit;

public interface SubmitMapper {
    int deleteByPrimaryKey(String openid);

    int insert(Submit record);

    Submit selectByPrimaryKey(String openid);

    List<Submit> selectAll();

    int updateByPrimaryKey(Submit record);
}