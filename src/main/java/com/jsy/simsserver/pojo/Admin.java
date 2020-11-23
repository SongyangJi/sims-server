package com.jsy.simsserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Long aid;
    private String pwd;

    @Override
    public String toString() {
        return "Admin{" +
                "aid=" + aid +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}