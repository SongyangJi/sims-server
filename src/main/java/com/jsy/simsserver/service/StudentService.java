package com.jsy.simsserver.service;


import com.jsy.simsserver.pojo.Student;

import java.util.List;

public interface StudentService {

    void addStudent(Student student);

    void addStudent(Long sid);

    void addStudents(List<Long> sidList);

    List<Student> queryAllStudents();

    Student queryStudentByID(Long uid);



}
