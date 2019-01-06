package com.imse.imse.Controller;

import com.imse.imse.Service.FirmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FirmaController {

    @Autowired
    FirmaService firmaService;

    @GetMapping("/create")
    public void createFirma(){
        // ToDo
    }

    @GetMapping("/get")
    public String getAllFirma(){
        return "ToDo";
    }

    @GetMapping("/get")
    public String getByIdFirma(){
        return "ToDo";
    }

    @GetMapping("/update")
    public String updateFirma(){
        return "ToDo";
    }

    @GetMapping("/delete")
    public String deleteFirma(){
        return "ToDo";
    }

}
