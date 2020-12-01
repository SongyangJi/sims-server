package com.jsy.simsserver.service;

import com.jsy.simsserver.pojo.Score;

import java.util.List;
import java.util.Map;

public interface ScoreService {

    List<Score> queryScoresByCourseID(Long cid);

    List<Score> queryScoresByStudentID(Long sid);

    void updateStudentScoreOfCourse(Map map);

    void removeStudentScoreOfCourse(Map map) ;





}
