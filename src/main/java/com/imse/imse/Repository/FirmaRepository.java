package com.imse.imse.Repository;

import com.imse.imse.Model.Firma;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FirmaRepository extends MongoRepository<Firma, Integer> {
}
