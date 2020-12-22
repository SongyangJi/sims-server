package com.jsy.simsserver.mapper;

import com.jsy.simsserver.pojo.Score;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Mapper
@Repository
public interface ScoreMapper {


    List<Score> selectScoresByCourseID(Long cid);

    List<Score> selectScoresByStudentID(Long sid);

    void updateStudentScoreOfCourse(Map map);

    void deleteStudentScoreOfCourse(Map map);

    void insertStudentScoreOfCourse(Score score);

}
