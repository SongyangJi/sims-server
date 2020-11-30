package com.jsy.simsserver.service.serviceImpl;

import com.jsy.simsserver.mapper.ScoreMapper;
import com.jsy.simsserver.pojo.Score;
import com.jsy.simsserver.service.ScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {

    @Resource
    ScoreMapper scoreMapper;


    @Override
    public List<Score> queryScoresByCourseID(Long cid) {
        return scoreMapper.selectScoresByCourseID(cid);
    }

    @Override
    public List<Score> queryScoresByStudentID(Long sid) {
        return scoreMapper.selectScoresByStudentID(sid);
    }
}
