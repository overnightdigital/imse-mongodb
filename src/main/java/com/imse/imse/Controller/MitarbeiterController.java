package com.imse.imse.Controller;

import com.imse.imse.Model.Mitarbeiter;
import com.imse.imse.Repository.FirmaRepository;
import com.imse.imse.Service.FirmaService;
import com.imse.imse.Service.MitarbeiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MitarbeiterController {

    @Autowired
    MitarbeiterService mitarbeiterService;

    @Autowired
    FirmaService firmaService;

    @RequestMapping(value = "/mitarbeiter", params = { "name","nummer","e_mail", "sv", "firma_id" }, method = POST)
    public void createMitarbeiter(@RequestParam("name") String name, @RequestParam("nummer") String nummer, @RequestParam("e_mail") String e_mail, @RequestParam("sv") int sv, @RequestParam("firma_id") int firma_id){
        System.out.println(" !!!!  name: " + name + " nummer: " + nummer + " e_mail: " + e_mail + " sv: " + sv);
        mitarbeiterService.createMitarbeiter(name, nummer, e_mail, sv, firmaService.getByIdFirma(firma_id));
    }

    @RequestMapping(value = "/mitarbeiter", method = GET)
    public ArrayList<Mitarbeiter> getAllMitarbeiter(){
        ArrayList<Mitarbeiter> toReturn = new ArrayList<>();
        Iterable<Mitarbeiter> mitarbeiter;
        mitarbeiter = mitarbeiterService.getAllMitarbeiter();
        for (Mitarbeiter Mitarbeiter : mitarbeiter) {
            toReturn.add(Mitarbeiter);
        }
        return toReturn;
    }

    @RequestMapping(value = "/mitarbeiter/{id}", method = GET)
    public Mitarbeiter getByIdMitarbeiter(@PathVariable int id){
        return mitarbeiterService.getByIdMitarbeiter(id);
    }

    @RequestMapping(value = "/mitarbeiter", params = { "name","nummer","e_mail", "sv" }, method = PUT)
    public void updateMitarbeiter(@RequestParam("name") String name, @RequestParam("nummer") String nummer, @RequestParam("e_mail") String e_mail, @RequestParam("sv") int sv){
        mitarbeiterService.updateMitarbeiter(name, nummer, e_mail, sv);
    }

    @RequestMapping(value = "/mitarbeiter/{id}", method = DELETE)
    public void deleteMitarbeiter(@PathVariable int id){
        mitarbeiterService.deleteMitarbeiter(id);
    }

    @RequestMapping(value = "/mitarbeiter/search/{name}", method = GET)
    public ArrayList<Mitarbeiter> searchMitarbeiter(@PathVariable String name) {
        ArrayList<Mitarbeiter> toReturn = new ArrayList<>();
        Iterable<Mitarbeiter> mitarbeiter;
        mitarbeiter = mitarbeiterService.getAllMitarbeiter();
        for (Mitarbeiter m : mitarbeiter) {
            if (m.getName().equals(name)) {
                toReturn.add(m);
            }
        }
        return toReturn;
    }

}
