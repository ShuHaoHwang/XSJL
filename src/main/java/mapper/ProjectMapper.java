package mapper;

import java.util.List;
import model.Project;

public interface ProjectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Project record);

    Project selectByPrimaryKey(Long id);

    List<Project> selectAll();

    int updateByPrimaryKey(Project record);

    List<Integer> selectUser_projectByOpenid(String openid);
}