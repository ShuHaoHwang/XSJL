package mapper;

import java.util.List;
import model.Institute;

public interface InstituteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Institute record);

    Institute selectByPrimaryKey(Integer id);

    List<Institute> selectAll();

    int updateByPrimaryKey(Institute record);
}