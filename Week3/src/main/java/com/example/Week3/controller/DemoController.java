package com.example.Week3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/demo")
    public ResponseEntity<String> demo(){
        return ResponseEntity.ok("CHÚC MỪNG BẠN ĐÃ ĐĂNG NHẬP THÀNH CÔNG");
    }
    @GetMapping("/adminonly")
    public ResponseEntity<String> adminOnly(){
        return ResponseEntity.ok("Bạn Đã Login Với Tư Cách Admin");
    }
}
