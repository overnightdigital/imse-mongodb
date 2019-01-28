package com.imse.imse.Service;

import com.imse.imse.Model.Firma;
import com.imse.imse.Repository.FirmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class FirmaService {

    @Autowired
    private FirmaRepository firmaRepository;

    public FirmaService() {
    }

    public void createFirma(int id, String name, String adresse) {
        Firma f = new Firma(id, name, adresse);
        firmaRepository.save(f);
    }

    public Iterable<Firma> getAllFirma() {
        return firmaRepository.findAll();
    }

    public Firma getByIdFirma(int id) {
        return firmaRepository.findBy_id(id);
    }

    public void updateFirma(int id, String name, String adresse) {
        Firma f = firmaRepository.findBy_id(id);
        f.setName(name);
        f.setAdresse(adresse);
        firmaRepository.save(f);
    }

    public void deleteFirma(int id) {
        firmaRepository.deleteBy_id(id);
    }
}
