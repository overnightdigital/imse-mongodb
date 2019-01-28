package com.imse.imse.Controller;

import com.imse.imse.Model.Produkt;
import com.imse.imse.Service.FirmaService;
import com.imse.imse.Service.ProduktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProduktService produktService;

    @Autowired
    FirmaService firmaService;

    @RequestMapping(value = "/produkt", params = { "id","name","preis" }, method = POST)
    public void createProdukt(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("preis") String preis, @RequestParam("firma_id") int firma_id){
        System.out.println(" !!!!  id: " + id + " name: " + name + " preis: " + preis);
        produktService.createProdukt(id, name, preis, firmaService.getByIdFirma(firma_id));
    }

    @RequestMapping(value = "/produkt", method = GET)
    public ArrayList<Produkt> getAllProdukt(){
        ArrayList<Produkt> toReturn = new ArrayList<>();
        Iterable<Produkt> produkte;
        produkte = produktService.getAllProdukt();
        for (Produkt p : produkte) {
            toReturn.add(p);
        }
        return toReturn;
    }

    @RequestMapping(value = "/produkt/{id}", method = GET)
    public Produkt getByIdProdukt(@PathVariable int id){
        return produktService.getByIdProdukt(id);
    }

    @RequestMapping(value = "/produkt", params = { "id","name","preis" }, method = PUT)
    public void updateProdukt(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("preis") String preis){
        produktService.updateProdukt(id, name, preis);
    }

    @RequestMapping(value = "/produkt/{id}", method = DELETE)
    public void deleteProdukt(@PathVariable int id){
        produktService.deleteProdukt(id);
    }

    @RequestMapping(value = "/produkt/search/{name}", method = GET)
    public ArrayList<Produkt> searchProdukt(@PathVariable String name) {
        ArrayList<Produkt> toReturn = new ArrayList<>();
        Iterable<Produkt> produkte;
        produkte = produktService.getAllProdukt();
        for (Produkt p : produkte) {
            if (p.getName().equals(name)) {
                toReturn.add(p);
            }
        }
        return toReturn;
    }
}
