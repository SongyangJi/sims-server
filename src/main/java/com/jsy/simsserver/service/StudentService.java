package com.jsy.simsserver.service;


import com.jsy.simsserver.pojo.Student;

import java.util.List;

public interface StudentService {

    int addStudent(Student student);

    int addStudent(Long sid);

    int addStudents(List<Long> sidList);

    List<Student> queryAllStudents();

    Student queryStudentByID(Long uid);

    List<Student> queryStudentByName(String name);

    void removeStudent(Long sid);

    void updateStudent(Student student);

    boolean studentLogin(Student student);

}
