package com.imse.imse.Controller;

import com.imse.imse.Model.Rohrstoff;
import com.imse.imse.Service.FirmaService;
import com.imse.imse.Service.RohrstoffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RohrstoffController {

    @Autowired
    RohrstoffService rohrstoffService;

    @Autowired
    FirmaService firmaService;

    @RequestMapping(value = "/rohstoff", params = { "m","p","id", "name" }, method = POST)
    public void createProdukt(@RequestParam("m") float m, @RequestParam("p") float p, @RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("firma_id") int firma_id){
        System.out.println(" !!!!  m: " + m + " p: " + p + " id: " + id + " name: " + name);
        rohrstoffService.createRohrstoff(m, p, id, name, firmaService.getByIdFirma(firma_id));
    }

    @RequestMapping(value = "/rohstoff", method = GET)
    public ArrayList<Rohrstoff> getAllProdukt(){
        ArrayList<Rohrstoff> toReturn = new ArrayList<>();
        Iterable<Rohrstoff> rohstoffe;
        rohstoffe = rohrstoffService.getAllRohrstoff();
        for (Rohrstoff r : rohstoffe) {
            toReturn.add(r);
        }
        return toReturn;
    }

    @RequestMapping(value = "/rohstoff/{id}", method = GET)
    public Rohrstoff getByIdProdukt(@PathVariable int id){
        return rohrstoffService.getByIdRohrstoff(id);
    }

    @RequestMapping(value = "/rohstoff", params = { "m","p","id", "name" }, method = PUT)
    public void updateProdukt(@RequestParam("m") float m, @RequestParam("p") float p, @RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("firma_id") int firma_id){
        rohrstoffService.updateRohrstoff(m, p, id, name);
    }

    @RequestMapping(value = "/rohstoff/{id}", method = DELETE)
    public void deleteProdukt(@PathVariable int id){
        rohrstoffService.deleteRohrstoff(id);
    }

    @RequestMapping(value = "/rohstoff/search/{name}", method = GET)
    public ArrayList<Rohrstoff> searchProdukt(@PathVariable String name) {
        ArrayList<Rohrstoff> toReturn = new ArrayList<>();
        Iterable<Rohrstoff> rohstoffe;
        rohstoffe = rohrstoffService.getAllRohrstoff();
        for (Rohrstoff r : rohstoffe) {
            if (r.getName().equals(name)) {
                toReturn.add(r);
            }
        }
        return toReturn;
    }

}
