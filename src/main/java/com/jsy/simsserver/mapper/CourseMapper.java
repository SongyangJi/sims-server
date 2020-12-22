package com.jsy.simsserver.mapper;

import com.jsy.simsserver.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {

    void insertCourse(Course course);

    List<Course> selectAllCourses();

    Course selectCourse(Long cid);

    void deleteCourse(Long cid);

    void insertRecordOfStudentSelectingCourse(@Param("sid") Long sid,@Param("cid") Long cid);

    List<Course> selectCoursesOfStudents(Long sid);

}
