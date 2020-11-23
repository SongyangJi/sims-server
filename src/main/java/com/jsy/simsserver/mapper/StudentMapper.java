package com.jsy.simsserver.mapper;

import com.jsy.simsserver.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;





@Mapper
@Repository
public interface StudentMapper {

    void insertStudent(Student student);

    Student selectStudent(Long uid);

    List<Student> selectAllStudents();

}
