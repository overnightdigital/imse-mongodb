package com.imse.imse.Controller;

import com.imse.imse.Service.RefillDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RefillDataController {

    @Autowired
    RefillDataService refillDataService;

    @RequestMapping(value = "/refilldata", method = POST)
    public void fillData(){
        try {
        	refillDataService.execute();
        	System.out.println("Refilling Done");
        } catch (Exception e) {
            System.out.println("Refilling Failed");
        }

    }
}
