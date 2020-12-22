package com.jsy.simsserver.service;


import com.jsy.simsserver.pojo.Achievement;

import java.util.List;

public interface AchievementService {

    void addAchievement(Achievement achievement,Long sid);

    List<Achievement> queryAchievement(Long sid);


}
