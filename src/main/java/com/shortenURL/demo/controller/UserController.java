package com.shortenURL.demo.controller;


import com.shortenURL.demo.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping
public class UserController {
    @Autowired
    UrlService urlService;

    @PostMapping("/shorten")
    @ResponseBody
    public ResponseEntity<String> shortenURL(@RequestBody String originalURL){
        //Implement shorten url
        return ResponseEntity.status(HttpStatus.OK).body(urlService.shortenUrl(originalURL));
    }
}
