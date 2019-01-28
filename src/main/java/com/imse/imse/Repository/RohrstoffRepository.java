package com.imse.imse.Repository;

import com.imse.imse.Model.Rohrstoff;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RohrstoffRepository extends MongoRepository<Rohrstoff, Integer> {
	public Rohrstoff findBy_id(int id);
	public void deleteBy_id(int id);
}
