package com.imse.imse.Controller;

import com.imse.imse.Service.FillDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FillDataController {

    @Autowired
    FillDataService fillDataService;

    @RequestMapping(value = "/filldata", method = POST)
    public void fillData(){
        try {
            fillDataService.execute();
        } catch (Exception e) {
            System.out.println("Filling Failed");
        }

    }
}
