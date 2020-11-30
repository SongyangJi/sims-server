package com.jsy.simsserver.service;

import com.jsy.simsserver.pojo.Score;

import java.util.List;

public interface ScoreService {

    List<Score> queryScoresByCourseID(Long cid);

    List<Score> queryScoresByStudentID(Long sid);

}
