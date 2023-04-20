package co.edu.uniquindio.ingsoft3.HappyPaws.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping("/index")
    public String helloIndex(){
        return "index";
    }
}
