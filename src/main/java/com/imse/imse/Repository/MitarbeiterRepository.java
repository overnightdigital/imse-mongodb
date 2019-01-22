package com.imse.imse.Repository;

import com.imse.imse.Model.Mitarbeiter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MitarbeiterRepository extends MongoRepository<Mitarbeiter, Integer> {
}
