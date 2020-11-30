package com.jsy.simsserver.controller;

import com.jsy.simsserver.service.CourseService;
import com.jsy.simsserver.service.ScoreService;
import com.jsy.simsserver.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ScoreController {

    @Resource(name = "scoreService")
    ScoreService scoreService;

    @Resource(name = "studentService")
    StudentService studentService;

    @Resource(name = "courseService")
    CourseService courseService;



    @GetMapping("/scores-by-student/{sid}")
    public ResponseEntity<Map> queryScoresByStudentID(@PathVariable Long sid){
        Map<String,Object> map = new HashMap<>();
        map.put("student",studentService.queryStudentByID(sid));
        map.put("scores",scoreService.queryScoresByStudentID(sid));
        return ResponseEntity.ok(map);
    }



    @GetMapping("/scores-by-course/{cid}")
    public ResponseEntity<Map> queryScoresByCourseID(@PathVariable Long cid) {

        Map<String,Object> map = new HashMap<>();

        map.put("course",courseService.queryCourseByID(cid));

        map.put("scores",scoreService.queryScoresByCourseID(cid));

        return ResponseEntity.ok(map);
    }

}
