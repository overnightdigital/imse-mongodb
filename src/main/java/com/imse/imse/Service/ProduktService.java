package com.imse.imse.Service;

import com.imse.imse.Model.Firma;
import com.imse.imse.Model.Produkt;
import com.imse.imse.Repository.ProduktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProduktService {

    @Autowired
    ProduktRepository produktRepository;

    public ProduktService() {
    }

    public void createProdukt(int id, String name, String preis, Firma firma) {
        Produkt p = new Produkt(id, name, preis, firma);
        produktRepository.save(p);
    }

    public Iterable<Produkt> getAllProdukt() {
        return produktRepository.findAll();
    }

    public Optional<Produkt> getByIdProdukt(int id) {
        return produktRepository.findById(id);
    }

    public void updateProdukt(int id, String name, String preis) {
        Produkt p = produktRepository.findById(id).get();
        p.setName(name);
        p.setPreis(preis);
        produktRepository.save(p);
    }

    public void deleteProdukt(int id) {
        produktRepository.deleteById(id);
    }
}
