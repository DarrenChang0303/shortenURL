package com.shortenURL.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class UrlService {
    long timestamp = System.currentTimeMillis();
    //claim an empty map to store original url and shorten url
    Map urlMap = new HashMap<String, String>();

    //shorten url
    public String shortenUrl(String originalURL) {
        if (!urlMap.containsKey(originalURL)) {
            String uniqueCode = createUniqueCode(originalURL);
            urlMap.put(originalURL, uniqueCode);
            return uniqueCode;
        } else {
            return urlMap.get(originalURL).toString();
        }
    }

    //create unique short code
    private String createUniqueCode(String originalURL) {
        String uniqueCode = "";
        String regex = "(http://|https://|www\\.|\\.com|\\W)";
        String regretURL = originalURL.replaceAll(regex, "");
        char[] urlCharArray = regretURL.toCharArray();
        Random random = new Random();
        String base62String = Long.toString(timestamp, 62);
        int num = 0;
        while (num < 5) {
            uniqueCode = uniqueCode + urlCharArray[random.nextInt(urlCharArray.length)];
            num++;
        }
        uniqueCode = uniqueCode + base62String;
        return uniqueCode;
    }

}
