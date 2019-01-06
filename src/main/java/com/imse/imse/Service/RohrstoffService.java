package com.imse.imse.Service;

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

    public void createRohrstoff(float m, float p, int id, String name) {
        Rohrstoff r = new Rohrstoff(m, p, id, name);
        rohrstoffRepository.save(r);
    }

    public Iterable<Rohrstoff> getAllRohrstoff() {
        return rohrstoffRepository.findAll();
    }

    public Optional<Rohrstoff> getByIdRohrstoff(int id) {
        return rohrstoffRepository.findById(id);
    }

    public void updateRohrstoff() {

    }

    public void deleteRohrstoff(int id) {
        rohrstoffRepository.deleteById(id);
    }
}
