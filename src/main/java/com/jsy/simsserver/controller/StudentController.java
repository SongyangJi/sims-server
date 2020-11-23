package com.jsy.simsserver.controller;

import com.jsy.simsserver.pojo.Student;
import com.jsy.simsserver.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class StudentController {
    @Resource(name = "studentService")
    StudentService studentService;


    /**
     *
     * @param student 完整User对象
     * @return
     */
    @PostMapping("/student")
    public ResponseEntity<Void> addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     *
     * @param sid 学生的学号, 密码默认为 123
     * @return
     */

    @PostMapping("/student/{sid}")
    public ResponseEntity<Void> addStudent(@PathVariable Long sid){
        studentService.addStudent(sid);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    /**
     *
     * @param students  Student数组
     * @return
     */
    @PostMapping("/students")
    public ResponseEntity<Void> addStudents(@RequestBody List<Student> students){
        for(Student student:students){
            student.setPwd("123");
            studentService.addStudent(student);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }




    @GetMapping("/student/{sid}")
    public ResponseEntity<Student> queryStudentByID(@PathVariable Long sid){
        return ResponseEntity.ok(studentService.queryStudentByID(sid));
    }


    @GetMapping("/all-students")
    public ResponseEntity<List<Student>> queryAllStudents(){
        return ResponseEntity.ok(studentService.queryAllStudents());
    }

}
