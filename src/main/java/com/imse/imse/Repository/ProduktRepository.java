package com.imse.imse.Repository;

import com.imse.imse.Model.Produkt;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProduktRepository extends MongoRepository<Produkt, Integer> {
}
