package service;


import model.Project;

import java.util.List;
import java.util.Map;

public interface ProjectService {

    public Map<String, Object> SaveProject(Project project);

    public List<Project> ListProject(int page,int limit);

    public List<String> ListInstitute();


    public Project GetProjectById(long id);

    Object loadMessage(String openid);

}
