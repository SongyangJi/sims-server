package com.jsy.simsserver.controller;

import com.jsy.simsserver.service.CourseService;
import com.jsy.simsserver.service.ScoreService;
import com.jsy.simsserver.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @PutMapping("/scores/{cid}/{sid}/{score}")
    public ResponseEntity<Void> updateStudentScoreOfCourse(@PathVariable Long cid,@PathVariable Long sid,@PathVariable Double score){
        Map<String,Object> map = new HashMap<>();
        map.put("sid",sid);
        map.put("cid",cid);
        map.put("score",score);
        scoreService.updateStudentScoreOfCourse(map);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @DeleteMapping("/scores/{cid}/{sid}")
    public ResponseEntity<Void> updateStudentScoreOfCourse(@PathVariable Long cid,@PathVariable Long sid){
        Map<String,Object> map = new HashMap<>();
        map.put("sid",sid);
        map.put("cid",cid);
        scoreService.removeStudentScoreOfCourse(map);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
