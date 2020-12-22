package com.jsy.simsserver.mapper;

import com.jsy.simsserver.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;


@Mapper
@Repository
public interface StudentMapper {

    void insertStudent(Student student);

    Student selectStudent(Long sid);

    List<Student> selectStudentByName(String name);

    List<Student> selectAllStudents();

    void deleteStudent(Long sid);

    void updateStudent(Student student);

    Student checkStudent(Student student);
}

