package com.imse.imse.Controller;

import com.imse.imse.Service.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class InputController {

    @Autowired
    InputService inputService;

    @GetMapping("/example")
    public String getExample(){

        return inputService.doSmth();
    }

}
