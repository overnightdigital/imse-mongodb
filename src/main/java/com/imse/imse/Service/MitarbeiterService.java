package com.imse.imse.Service;

import com.imse.imse.Model.Firma;
import com.imse.imse.Model.Mitarbeiter;
import com.imse.imse.Repository.MitarbeiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MitarbeiterService {

    @Autowired
    MitarbeiterRepository mitarbeiterRepository;

    public MitarbeiterService() {
    }

    public void createMitarbeiter(String name, String nummer, String e_mail, int sv, Firma firma) {
        Mitarbeiter m = new Mitarbeiter(name, nummer, e_mail, sv, firma);
        mitarbeiterRepository.save(m);
    }

    public Iterable<Mitarbeiter> getAllMitarbeiter() {
        return mitarbeiterRepository.findAll();
    }

    public Mitarbeiter getByIdMitarbeiter(int id) {
        return mitarbeiterRepository.findBy_id(id);
    }

    public void updateMitarbeiter(String name, String nummer, String e_mail, int sv) {
        Mitarbeiter m = mitarbeiterRepository.findBy_id(sv);
        m.setName(name);
        m.setNummer(nummer);
        m.setE_mail(e_mail);
        mitarbeiterRepository.save(m);
    }

    public void deleteMitarbeiter(int id) {
        mitarbeiterRepository.deleteBy_id(id);
    }
}
