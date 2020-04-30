import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import mapper.MessageMapper;
import mapper.ProjectMapper;
import mapper.UserMapper;
import model.Message;
import model.Project;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ShuHao
 * @version 1.0
 * @date 2020/4/11
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/ApplicationContext.xml")
public class CheckTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private MessageMapper messageMapper;



    @Test
    public void Test(){

        Page<Project> page = PageHelper.startPage(1,2);
        List<Project> users = projectMapper.selectAll();
        for (Project user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void Test2(){
        User u = userMapper.selectUserByOpenid("123");
        System.out.println(u);
    }

    @Test
    public void Test3(){
        User u = new User();
        u.setOpenid("o_PGBw3oBvm5tv-uUe9VleM9-ipI");
        u.setContact("13934534534");
        u.setBirthday(new Date());
        u.setUsername("黄舒豪");
        u.setGender(1);
        u.setGrade(1);
        u.setInstituteId(0);
        System.out.println(userMapper.updateByOpenid(u));
    }

    @Test
    public void Test4(){
        List<Message> l = userMapper.selectAllMessageByOpenid("o_PGBw3oBvm5tv-uUe9VleM9-ipI");
        for (Message integer : l) {
            System.out.println(integer);
        }
    }

    @Test
    public void Test5(){
        //messageMapper.updateStatusByOpenid("2","o_PGBw3oBvm5tv-uUe9VleM9-ipI");

    }

}
