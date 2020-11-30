package com.jsy.simsserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private Long cid;            // 课程号
    private String cname;        // 课程名称
    private double credit;       // 学分
    private String prop;         // 课程属性
    private String faculty;      // 开课学院
    private String teacher_name; // 任课老师，可拓展为对象
    private int begin;
    private int end;
}