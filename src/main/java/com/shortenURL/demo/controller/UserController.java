package com.shortenURL.demo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping
public class UserController {

    @PostMapping("/shorten")
    @ResponseBody
    public ResponseEntity<String> shortenURL(@RequestBody String originalURL){
        //Implement shorten url
        return ResponseEntity.status(HttpStatus.OK).body("ShortenURL");
    }
}
