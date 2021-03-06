package com.jsy.simsserver.service.serviceImpl;

import com.jsy.simsserver.mapper.CourseMapper;
import com.jsy.simsserver.pojo.Course;
import com.jsy.simsserver.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Resource
    CourseMapper courseMapper;

    @Override
    public int addCourse(Course course) {
        if(courseMapper.selectCourse(course.getCid())!=null) return 1;
        courseMapper.insertCourse(course);
        return 0;
    }

    @Override
    public void addCourses(List<Course> courseList) {

    }

    @Override
    public void removeCourse(Long cid) {
        courseMapper.deleteCourse(cid);
    }

    @Override
    public List<Course> queryAllCourses() {
        return courseMapper.selectAllCourses();
    }

    @Override
    public Course queryCourseByID(Long cid) {
        return courseMapper.selectCourse(cid);
    }

    @Override
    public void studentsSelectCourse(Long sid, Long cid) {
        courseMapper.insertRecordOfStudentSelectingCourse(sid,cid);
    }

    @Override
    public List<Course> querySelectedCourses(Long sid) {
        return courseMapper.selectCoursesOfStudents(sid);
    }
}
