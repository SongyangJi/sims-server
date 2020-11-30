package com.jsy.simsserver.controller;

import com.jsy.simsserver.pojo.Course;
import com.jsy.simsserver.pojo.Score;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<Map> get(){
        System.out.println("测试");
        Map<String,Object> map = new HashMap<>();
        map.put("name","吉松阳");
        map.put("age",11L);
        Course course = new Course();
        course.setCid(1231241L);
        course.setCname("数据结构");
        map.put("course",course);
        return ResponseEntity.ok(map);
    }

}
