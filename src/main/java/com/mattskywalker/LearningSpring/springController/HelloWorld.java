package com.mattskywalker.LearningSpring.springController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/helloWorld")
public class HelloWorld {

    @GetMapping
    @ResponseBody
    public String sayHello(){
        return "HelloWorld";
    }

}
