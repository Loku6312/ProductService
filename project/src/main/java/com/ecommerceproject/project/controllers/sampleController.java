package com.ecommerceproject.project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/sample")
public class sampleController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello lokesh";
    }
    @GetMapping("/Hi/{name}")
    public String Hi(@PathVariable("name") String name) {
        return "Hi "+name;
    }
    @GetMapping("/Hi/{name}/{times}")
    public String Hi(@PathVariable("name") String name,@PathVariable("times") int x) {
        String s="";
        for(int i=0;i<x;i++){
            s+="Hi "+name+" ! <br>";
        }
        return s;
    }
    
    
}
