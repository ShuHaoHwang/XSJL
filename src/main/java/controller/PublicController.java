package controller;

import model.Opinion;
import model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ProjectService;

import java.util.Date;

/**
 * @author ShuHao
 * @version 1.0
 * @date 2020/2/27
 */

@Controller("PublicController")
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private ProjectService service;


    //在网页表单获取对应的项目对象进行数据库封存
    @RequestMapping("/submitProject")
    @ResponseBody
    public Object SubmitProject(Project project) {
        System.out.println("执行写入");
        System.out.println(project);
        return service.SaveProject(project);
    }


    //用来获取数据库目前已有的项目活动
    @RequestMapping("/listProject")
    @ResponseBody
    public Object ListProject(int page,int limit) {
        System.out.println("page: " + page + " limit: " + limit);
        return service.ListProject(page,limit);
    }

    //获取学院列表
    @RequestMapping("/listInstitute")
    @ResponseBody
    public Object ListInstitute() {
        return service.ListInstitute();
    }



    @RequestMapping("/getprojectbyid")
    @ResponseBody
    public Object deliveryStatus(long id) {
        System.out.println("获取点击项信息 id = " + id );
        return service.GetProjectById(id);
    }

    @RequestMapping("/loadmessage")
    @ResponseBody
    public Object loadMessage(String openid) {
        System.out.println("loadMessage"+openid);
        return service.loadMessage(openid);
    }



    @RequestMapping("/retroaction")
    @ResponseBody
    public Object GetOpinion(Opinion opinion) {
        System.out.println("GetOpinion"+opinion);
        return null;
    }

}
