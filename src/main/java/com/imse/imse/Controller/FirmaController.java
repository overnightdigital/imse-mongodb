package com.imse.imse.Controller;

import com.imse.imse.Model.Firma;
import com.imse.imse.Service.FirmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FirmaController {

    @Autowired
    FirmaService firmaService;

    @RequestMapping(value = "/firma", params = { "id","name","adresse" }, method = POST)
    public void createFirma(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("adresse") String adresse){
        System.out.println(" !!!!  id: " + id + " name: " + name + " adresse: " + adresse);
        firmaService.createFirma(id, name, adresse);
    }

    @RequestMapping(value = "/firma", method = GET)
    public ArrayList<Firma> getAllFirma(){
        ArrayList<Firma> toReturn = new ArrayList<>();
        Iterable<Firma> firmen;
        firmen = firmaService.getAllFirma();
        for (Firma firma : firmen) {
            toReturn.add(firma);
        }
        return toReturn;
    }

    @RequestMapping(value = "/firma/{id}", method = GET)
    public Firma getByIdFirma(@PathVariable int id){
        return firmaService.getByIdFirma(id).get();
    }

    @RequestMapping(value = "/firma", params = { "id","name","adresse" }, method = PUT)
    public void updateFirma(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("adresse") String adresse){
        firmaService.updateFirma(id, name, adresse);
    }

    @RequestMapping(value = "/firma/{id}", method = DELETE)
    public void deleteFirma(@PathVariable int id){
        firmaService.deleteFirma(id);
    }

    @RequestMapping(value = "/firma/search/{name}", method = GET)
    public ArrayList<Firma> searchFirma(@PathVariable String name) {
        ArrayList<Firma> toReturn = new ArrayList<>();
        Iterable<Firma> firmen;
        firmen = firmaService.getAllFirma();
        for (Firma firma : firmen) {
            if (firma.getName().equals(name)) {
                toReturn.add(firma);
            }
        }
        return toReturn;
    }
}
