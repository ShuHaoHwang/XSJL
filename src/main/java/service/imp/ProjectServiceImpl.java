package service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import mapper.InstituteMapper;
import mapper.ProjectMapper;
import model.Institute;
import model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ProjectService;

import java.util.*;

/**
 * @author ShuHao
 * @version 1.0
 * @date 2020/2/27
 */

@Service
public class ProjectServiceImpl implements ProjectService {


    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private InstituteMapper instituteMapper;

//    @Autowired
//    private instituteMapper instituteMapper;
//    private user_deliverystatusMapper user_deliverystatusMapper;


    @Override
    public Map<String, Object> SaveProject(Project project) {

        Map<String, Object> rs = new HashMap<>();
        //初始化三个值
        project.setpAddtime(new Date());
        projectMapper.insert(project);
        rs.put("msg","保存成功");
        return rs;
    }

    @Override
    public List<Project> ListProject(int page,int limit) {

        Page<Project> projects = PageHelper.startPage(page,limit);
        return projectMapper.selectAll();
    }

    @Override
    public List<String> ListInstitute() {
        List<String> Institutes = new ArrayList<>();
        for(Institute s : instituteMapper.selectAll()){
            Institutes.add(s.getInstituteName());
        }
        return Institutes;
    }

//    @Override
//    public List<Map> GetMessage(String openid) {
//        return projectMapper.GetUserMessageByOpenid(openid);
//    }

    @Override
    public Project GetProjectById(long id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public Object loadMessage(String openid){
        return projectMapper.selectUser_projectByOpenid(openid);
    }

//    @Override
//    public Map<String, Object> SaveDelivery(String openid, int projectid) {
//        user_deliverystatusMapper.insert(new user_deliverystatus(openid,projectid,"1"));
//        Map<String,Object> rs = new HashMap<>();
//        rs.put("code",1);
//        rs.put("alertMsg","插入成功");
//        return rs;
//    }
}
