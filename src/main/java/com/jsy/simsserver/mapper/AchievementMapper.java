package com.jsy.simsserver.mapper;

import com.jsy.simsserver.pojo.Achievement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AchievementMapper {

    void insertAchievement(@Param("a")Achievement achievement,@Param("sid") Long sid);

    List<Achievement> selectAchievementByStudentId(Long sid);

    void insertAchievementURL(Long achievement_id,String url);

    List<String> selectUrlsByAchievementID(Long achievement_id);

}
