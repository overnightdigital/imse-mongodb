package com.imse.imse.Service;

import com.imse.imse.Model.Firma;
import com.imse.imse.Model.Rohrstoff;
import com.imse.imse.Repository.RohrstoffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RohrstoffService {

    @Autowired
    RohrstoffRepository rohrstoffRepository;

    public RohrstoffService() {
    }

    public void createRohrstoff(float m, float p, int id, String name, Firma firma) {
        Rohrstoff r = new Rohrstoff(m, p, id, name, firma);
        rohrstoffRepository.save(r);
    }

    public Iterable<Rohrstoff> getAllRohrstoff() {
        return rohrstoffRepository.findAll();
    }

    public Rohrstoff getByIdRohrstoff(int id) {
        return rohrstoffRepository.findBy_id(id);
    }

    public void updateRohrstoff(float m, float p, int ID, String name) {
        Rohrstoff r = rohrstoffRepository.findBy_id(ID);
        r.setName(name);
        r.setPreis(p);
        r.setMenge(m);
        rohrstoffRepository.save(r);
    }

    public void deleteRohrstoff(int id) {
        rohrstoffRepository.deleteBy_id(id);
    }
}
