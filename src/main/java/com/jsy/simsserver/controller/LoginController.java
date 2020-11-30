package com.jsy.simsserver.controller;

import com.jsy.simsserver.pojo.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody Admin admin){
        if(admin.getAid()==123 && admin.getPwd().equals("123")){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.ok().build();
    }
}
