package controller;

import model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import service.ProjectService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @author ShuHao
 * @version 1.0
 * @date 2020/4/12
 */

@Controller("ProjectController")
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @ResponseBody
    @RequestMapping("/uploadImg")
    public Object uploadImg(@RequestParam("img")CommonsMultipartFile file, HttpSession session)throws IOException{

        ServletContext servletContext = session.getServletContext();    //获取上下文对象
        String Path = servletContext.getRealPath("/uploadImg");       //获取项目的绝对地址

        File uploadPath = new File(Path);                               //对上述目录进行判断是否存在
        if(!uploadPath.exists()){
            uploadPath.mkdirs();
        }

        String fileName = file.getOriginalFilename();                   //获取图片的原始名
        uploadPath = new File(Path+"/"+fileName);              //创建图片临时文件

        file.transferTo(uploadPath);                                    //转换接收到的图片覆盖上面创建的临时文件
        return "/uploadImg/"+fileName;                                  //返回该图片的绝对路径给前端
    }

    @ResponseBody
    @RequestMapping("/deliveryProject")
    public Object DeliveryProject(Project p){
        System.out.println("活动任务已接受到" + p);

        projectService.SaveProject(p);
        return "project is ok!";
    }
}
