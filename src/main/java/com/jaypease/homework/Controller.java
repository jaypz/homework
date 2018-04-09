package com.jaypease.homework;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;



@RestController
@RequestMapping("/")
public class Controller {


    @RequestMapping(produces={"text/html"}, headers = "Accept=*")
    public String textRoute()  {
        return "<p>Hello, World</p>";
    }

    @RequestMapping(headers = "Accept=application/json", produces= MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> jsonRoute() {
        return Collections.singletonMap("message","Good morning");
    }

}
