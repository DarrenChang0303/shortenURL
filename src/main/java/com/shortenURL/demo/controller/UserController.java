package com.shortenURL.demo.controller;


import com.shortenURL.demo.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping
public class UserController {
    @Autowired
    UrlService urlService;

    @PostMapping("/shorten")
    @ResponseBody
    public ResponseEntity<String> shortenURL(@RequestBody String originalURL) {
        //Implement shorten url
//        redirecct(urlService.shortenUrl(originalURL));
        String shortURL = urlService.shortenUrl(originalURL);
        return ResponseEntity.status(HttpStatus.OK).body(shortURL);
    }
    @GetMapping("/redirect/{shortURL}")
    public ResponseEntity<Object> redirect(@PathVariable String shortURL) throws MalformedURLException, URISyntaxException {
        String originalURL = urlService.redirect(shortURL);
//        URI uri = new URI(originalURL);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setLocation(uri);
//        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).location(URI.create(originalURL)).header(HttpHeaders.CONNECTION, "close").build();
    }

    @GetMapping("/check")
    public Map urlID() {
        return urlService.showID();
    }
}
