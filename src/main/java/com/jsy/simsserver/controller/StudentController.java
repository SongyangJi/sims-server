package com.jsy.simsserver.controller;

import com.jsy.simsserver.reponse.ErrorMessage;
import com.jsy.simsserver.reponse.Message;
import com.jsy.simsserver.reponse.SuccessMessage;
import com.jsy.simsserver.pojo.Student;
import com.jsy.simsserver.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RestController
public class StudentController {

    @Resource(name = "studentService")
    StudentService studentService;


    @PostMapping("student-login")
    public ResponseEntity<Void> studentLogin(@RequestBody Map map){
        Long sid = Long.valueOf((String)map.get("sid"));
        String pwd = (String)map.get("pwd");
        Student student = new Student();
        student.setSid(sid);
        student.setPwd(pwd);
        if(studentService.studentLogin(student)==false){
//            202
            return ResponseEntity.accepted().build();
        }
//        200
        return ResponseEntity.ok().build();
    }


    /**
     *
     * @param student 完整User对象
     * @return
     */
    @PostMapping("/student")
    public ResponseEntity<Message> addStudent(@RequestBody Student student){
        int code = studentService.addStudent(student);
        if(code==0){
            return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessMessage("成功添加一个用户"));
        }
        if(code==1){
            return ResponseEntity.accepted().body(new ErrorMessage("用户已经存在"));
        }
        return ResponseEntity.badRequest().body(new ErrorMessage("内部错误"));
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

    @GetMapping("/student-name/{name}")
    public ResponseEntity<List<Student>> queryStudentByName(@PathVariable String name){
        return ResponseEntity.ok(studentService.queryStudentByName(name));
    }

    @GetMapping("/all-students")
    public ResponseEntity<List<Student>> queryAllStudents(){
        return ResponseEntity.ok(studentService.queryAllStudents());
    }

    @DeleteMapping("/student/{sid}")
    public ResponseEntity<Void> removeStudent(@PathVariable Long sid){
        studentService.removeStudent(sid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @PutMapping("/student")
    public ResponseEntity<Void> updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
