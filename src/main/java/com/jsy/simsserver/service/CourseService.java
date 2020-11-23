package com.jsy.simsserver.service;

import com.jsy.simsserver.pojo.Course;

import java.util.List;

public interface CourseService {

    void addCourse(Course course);

    // 暂空
    void addCourses(List<Course> courseList);

    List<Course> queryAllCourses();

    Course queryCourseByID(Long cid);

}
