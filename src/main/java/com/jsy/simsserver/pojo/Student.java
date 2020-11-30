package com.jsy.simsserver.pojo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Long sid;           // 学号
    private String pwd;         // 密码
    private String sname;       // 姓名
    private String gender;      // 数据库用枚举类型
    private String birth;       // 格式为：1999-09-05
    private String profession;  // 专业
    private String faculty;     // 院系
    private String s_class;     //班级
    private String grade;       // 年级
    private String phone;       // 电话
    private String politics_status; // 政治面貌
    private String address;     //籍贯
    private String head_url;         //学生照片的URL


    public Student(Long sid) {
        this.sid = sid;
        this.pwd = "123";
    }
}