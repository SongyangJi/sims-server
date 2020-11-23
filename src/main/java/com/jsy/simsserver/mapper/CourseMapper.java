package com.jsy.simsserver.mapper;

import com.jsy.simsserver.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {

    void insertCourse(Course course);

    List<Course> selectAllCourses();

    Course selectCourse(Long cid);

}
