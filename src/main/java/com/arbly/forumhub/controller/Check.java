package com.arbly.forumhub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("check")
public class Check {

    @GetMapping
    public ResponseEntity check(){
        return ResponseEntity.ok("checked v3");
    }

}
