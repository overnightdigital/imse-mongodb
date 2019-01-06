package com.imse.imse.Controller;

import com.imse.imse.Service.Produkt_des_monatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Produkt_des_monatsController {

    @Autowired
    Produkt_des_monatsService produkt_des_monatsService;
}
