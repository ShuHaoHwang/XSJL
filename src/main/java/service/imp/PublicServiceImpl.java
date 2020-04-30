package service.imp;

import mapper.OpinionMapper;
import model.Opinion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.PublicService;

import java.util.Date;

/**
 * @author ShuHao
 * @version 1.0
 * @date 2020/4/30
 */

@Service
public class PublicServiceImpl implements PublicService {

    @Autowired
    private OpinionMapper opinionMapper;

    @Override
    public Object SaveOpinion(Opinion p) {
        p.setDate(new Date());
        return opinionMapper.insert(p);
    }
}
