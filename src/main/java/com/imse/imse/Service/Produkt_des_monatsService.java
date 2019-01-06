package com.imse.imse.Service;

import com.imse.imse.Model.Produkt_des_monats;
import com.imse.imse.Repository.Produkt_des_monatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Produkt_des_monatsService {

    @Autowired
    Produkt_des_monatsRepository produkt_des_monatsRepository;

    public Produkt_des_monatsService() {
    }

    public void createProdukt_des_monats(int Produkt_ID, String s, String b) {
        Produkt_des_monats pm = new Produkt_des_monats(Produkt_ID, s, b);
        produkt_des_monatsRepository.save(pm);
    }

    public Iterable<Produkt_des_monats> getAllProdukt_des_monats() {
        return produkt_des_monatsRepository.findAll();
    }

    public Optional<Produkt_des_monats> getByIdProdukt_des_monats(int id) {
        return produkt_des_monatsRepository.findById(id);
    }

    public void updateProdukt_des_monats() {

    }

    public void deleteProdukt_des_monats(int id) {
        produkt_des_monatsRepository.deleteById(id);
    }
}
