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

    /**
     *
     * @param student
     * @return 成功插入,返回 0 ; 用户存在,返回 1
     */

    @Override
    public int addStudent(Student student) {
        if(queryStudentByID(student.getSid())!=null) return 1;
        studentMapper.insertStudent(student);
        return 0;
    }


    /**
     *
     * @param sid
     * @return 成功插入,返回 0 ; 用户存在,返回 1
     */

    @Override
    public int addStudent(Long sid) {
        Student student = new Student(sid);
        return addStudent(student);
    }


    /**
     *
     * @param sidList
     * @return 成功插入,返回 0 ; 用户存在,返回 1
     */

    @Override
    public int addStudents(List<Long> sidList) {
        boolean flag = true;
        for(Long sid:sidList){
            if(addStudent(sid)!=0){
                flag = !flag;
                continue;
            }
        }
        return flag?0:1;
    }

    @Override
    public List<Student> queryAllStudents() {
        return studentMapper.selectAllStudents();
    }

    @Override
    public Student queryStudentByID(Long sid) {
        return studentMapper.selectStudent(sid);
    }


    @Override
    public List<Student> queryStudentByName(String name) {
        return studentMapper.selectStudentByName(name);
    }

    @Override
    public void removeStudent(Long sid) {
        studentMapper.deleteStudent(sid);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }



}