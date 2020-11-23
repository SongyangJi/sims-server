package com.jsy.simsserver.service.serviceImpl;

import com.jsy.simsserver.mapper.StudentMapper;
import com.jsy.simsserver.pojo.Student;
import com.jsy.simsserver.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Resource
    StudentMapper studentMapper;

    @Override
    public void addStudent(Student student) {
        studentMapper.insertStudent(student);
    }

    @Override
    public void addStudent(Long sid) {
        Student student = new Student(sid);
        studentMapper.insertStudent(student);
    }

    @Override
    public void addStudents(List<Long> sidList) {
        for(Long sid:sidList){
            addStudent(sid);
        }
    }

    @Override
    public List<Student> queryAllStudents() {
        return studentMapper.selectAllStudents();
    }

    @Override
    public Student queryStudentByID(Long uid) {
        return studentMapper.selectStudent(uid);
    }
}
