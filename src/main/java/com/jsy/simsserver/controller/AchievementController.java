package com.jsy.simsserver.controller;


import com.jsy.simsserver.pojo.Achievement;
import com.jsy.simsserver.service.AchievementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class AchievementController {

    @Resource(name = "achievementService")
    AchievementService achievementService;


    @PostMapping("achievement/{sid}")
    public ResponseEntity<Void> addAchievement(@RequestBody Achievement achievement,@PathVariable Long sid){
        achievementService.addAchievement(achievement,sid);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("achievement/{sid}")
    public ResponseEntity<List<Achievement>> addAchievement(@PathVariable Long sid){
        return ResponseEntity.ok(achievementService.queryAchievement(sid));
    }

}
