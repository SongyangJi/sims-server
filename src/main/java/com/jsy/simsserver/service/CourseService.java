package com.jsy.simsserver.service;

import com.jsy.simsserver.pojo.Course;

import java.util.List;

public interface CourseService {

    int addCourse(Course course);

    // 暂空
    void addCourses(List<Course> courseList);

    void removeCourse(Long cid);

    List<Course> queryAllCourses();

    Course queryCourseByID(Long cid);

    void studentsSelectCourse(Long sid,Long cid);

    List<Course> querySelectedCourses(Long sid);


}
