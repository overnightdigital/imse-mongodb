package com.imse.imse.Controller;

import com.imse.imse.Model.Produkt;
import com.imse.imse.Model.Produkt_des_monats;
import com.imse.imse.Service.ProduktService;
import com.imse.imse.Service.Produkt_des_monatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class Produkt_des_monatsController {

    @Autowired
    Produkt_des_monatsService produkt_des_monatsService;

    @Autowired
    ProduktService produktService;

    @RequestMapping(value = "/produkt_des_monats", params = { "produkt_id","s","b" }, method = POST)
    public void createProdukt_des_monats(@RequestParam("produkt_id") int produkt_id, @RequestParam("s") String s, @RequestParam("b") String b){
        System.out.println(" !!!!  produkt_id: " + produkt_id + " s: " + s + " b: " + b);
        produkt_des_monatsService.createProdukt_des_monats(produkt_id, s, b);
    }

    @RequestMapping(value = "/produkt_des_monats", method = GET)
    public ArrayList<Produkt_des_monats> getAllProdukt_des_monats(){
        ArrayList<Produkt_des_monats> toReturn = new ArrayList<>();
        Iterable<Produkt_des_monats> produkte_des_monats;
        produkte_des_monats = produkt_des_monatsService.getAllProdukt_des_monats();
        for (Produkt_des_monats pm : produkte_des_monats) {
            toReturn.add(pm);
        }
        return toReturn;
    }

    @RequestMapping(value = "/produkt_des_monats/{id}", method = GET)
    public Produkt_des_monats getByIdProdukt_des_monats(@PathVariable int id){
        return produkt_des_monatsService.getByIdProdukt_des_monats(id).get();
    }

    @RequestMapping(value = "/produkt_des_monats", params = { "produkt_id","s","b" }, method = PUT)
    public void updateProdukt_des_monats(@RequestParam("produkt_id") int produkt_id, @RequestParam("s") String s, @RequestParam("b") String b){
        produkt_des_monatsService.updateProdukt_des_monats(produkt_id, s, b);
    }

    @RequestMapping(value = "/produkt_des_monats/{id}", method = DELETE)
    public void deleteProdukt_des_monats(@PathVariable int id){
        produkt_des_monatsService.deleteProdukt_des_monats(id);
    }

    @RequestMapping(value = "/produkt_des_monats/search/{bewertung}", method = GET)
    public ArrayList<Produkt_des_monats> searchProdukt_des_monats(@PathVariable String bewertung) {
        ArrayList<Produkt_des_monats> toReturn = new ArrayList<>();
        Iterable<Produkt_des_monats> produkte_des_monats;
        produkte_des_monats = produkt_des_monatsService.getAllProdukt_des_monats();
        for (Produkt_des_monats pm: produkte_des_monats) {
            if (pm.getBewertung().equals(bewertung)) {
                toReturn.add(pm);
            }
        }
        return toReturn;
    }

    @RequestMapping(value = "/produkt_des_monats/produkt/{id}", method = GET)
    public Produkt getProductfromProdukt_des_monats(@PathVariable int id) {
        return produktService.getByIdProdukt(id).get();
    }
}
