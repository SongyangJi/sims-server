package com.jsy.simsserver.service.serviceImpl;


import com.jsy.simsserver.mapper.AchievementMapper;
import com.jsy.simsserver.pojo.Achievement;
import com.jsy.simsserver.service.AchievementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("achievementService")
public class AchievementServiceImpl implements AchievementService {

    @Resource
    AchievementMapper achievementMapper;

    @Override
    public void addAchievement(Achievement achievement,Long sid) {
        achievementMapper.insertAchievement(achievement,sid);

        for(String url:achievement.getUrls()){
            achievementMapper.insertAchievementURL(achievement.getAchievement_id(),url);
        }

    }

    @Override
    public List<Achievement> queryAchievement(Long sid) {
        List<Achievement> achievements = achievementMapper.selectAchievementByStudentId(sid);
        for(Achievement achievement:achievements){
            achievement.setUrls(achievementMapper.selectUrlsByAchievementID(achievement.getAchievement_id()));
        }
        return achievements;
    }
}
