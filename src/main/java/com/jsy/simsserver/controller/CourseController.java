package com.jsy.simsserver.controller;

import com.jsy.simsserver.reponse.ErrorMessage;
import com.jsy.simsserver.reponse.Message;
import com.jsy.simsserver.reponse.SuccessMessage;
import com.jsy.simsserver.pojo.Course;
import com.jsy.simsserver.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CourseController {

    @Resource(name = "courseService")
    CourseService courseService;

    @GetMapping("all-courses")
    public ResponseEntity<List<Course>> queryAllCourses(){
        return ResponseEntity.ok(courseService.queryAllCourses());
    }

    @GetMapping("course/{cid}")
    public ResponseEntity<Course> queryCourseByID(@PathVariable Long cid){
        return ResponseEntity.ok(courseService.queryCourseByID(cid));
    }

    @PostMapping("course")
    public ResponseEntity<Message> addCourse(@RequestBody Course course){
        int code = courseService.addCourse(course);
        if(code==0) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessMessage("添加课程成功！"));
        }
        if(code==1){
            return ResponseEntity.accepted().body(new ErrorMessage("课程已存在"));
        }
        return ResponseEntity.badRequest().body(new ErrorMessage("内部错误"));
    }

    @DeleteMapping("course/{cid}")
    public ResponseEntity<Void> removeCourse(@PathVariable Long cid){
        courseService.removeCourse(cid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
