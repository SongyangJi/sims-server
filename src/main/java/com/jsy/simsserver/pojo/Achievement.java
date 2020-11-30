package com.jsy.simsserver.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Achievement {
    private String name;            // 成就名称
    private String description;      // 描述
    private String level;            // 获奖级别
    private String kind;             // 类别： 科研创新、社会服务、文艺活动、体育赛事
    private String time;             // 获奖时间 2019-01-01
    private List<String> urls;       // 图片列表
}

