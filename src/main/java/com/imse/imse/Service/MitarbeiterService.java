package com.imse.imse.Service;

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

    public void createMitarbeiter(String name, String nummer, String e_mail, int sv) {
        Mitarbeiter m = new Mitarbeiter(name, nummer, e_mail, sv);
        mitarbeiterRepository.save(m);
    }

    public Iterable<Mitarbeiter> getAllMitarbeiter() {
        return mitarbeiterRepository.findAll();
    }

    public Optional<Mitarbeiter> getByIdMitarbeiter(int id) {
        return mitarbeiterRepository.findById(id);
    }

    public void updateMitarbeiter() {

    }

    public void deleteMitarbeiter(int id) {
        mitarbeiterRepository.deleteById(id);
    }
}
