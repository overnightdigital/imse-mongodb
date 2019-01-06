package com.imse.imse.Controller;

import com.imse.imse.Model.Firma;
import com.imse.imse.Service.FirmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class FirmaController {

    @Autowired
    FirmaService firmaService;

    @PostMapping(value = "/firma", params = { "id","name","adresse" })
    public void createFirma(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("adresse") String adresse){
        System.out.println("id: " + id + " name: " + name + " adresse: " + adresse);
    }

    @GetMapping(value = "/firma")
    public ArrayList<Firma> getAllFirma(){
        ArrayList<Firma> toReturn = new ArrayList<>();
        Iterable<Firma> firmen;
        firmen = firmaService.getAllFirma();
        for (Firma firma : firmen) {
            toReturn.add(firma);
        }
        return toReturn;
    }

    @GetMapping(value = "/firma/{id}")
    public Firma getByIdFirma(@PathVariable int id){
        return firmaService.getByIdFirma(id).get();
    }

    @PutMapping(value = "/update", params = { "id","name","adresse" })
    public void updateFirma(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("adresse") String adresse){
        firmaService.updateFirma(id, name, adresse);
    }

    @DeleteMapping(value = "/firma/{id}")
    public void deleteFirma(@PathVariable int id){
        firmaService.deleteFirma(id);
    }

}
