package com.shortenURL.demo.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UrlService {
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
        long timestamp = System.currentTimeMillis();
        String uniqueCode = "";
        String regex = "(http://|https://|www\\.|\\.com|\\W)";
        String regretURL = originalURL.replaceAll(regex, "");
        char[] urlCharArray = regretURL.toCharArray();
        Random random = new Random();
//        String base62String = Long.toString(timestamp, 62);
        byte[] encodeTimestamp = Base64.getEncoder().encode(String.valueOf(timestamp).getBytes());
        int num = 0;
        while (num < 5) {
            uniqueCode = uniqueCode + urlCharArray[random.nextInt(urlCharArray.length)];
            num++;
        }
        uniqueCode = uniqueCode + new String(encodeTimestamp);
//        uniqueCode = uniqueCode + encodeTimestamp.toString();
        return uniqueCode;
    }

}
