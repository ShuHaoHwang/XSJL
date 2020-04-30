package mapper;

import java.util.List;
import model.Opinion;

public interface OpinionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Opinion record);

    Opinion selectByPrimaryKey(Integer id);

    List<Opinion> selectAll();

    int updateByPrimaryKey(Opinion record);
}