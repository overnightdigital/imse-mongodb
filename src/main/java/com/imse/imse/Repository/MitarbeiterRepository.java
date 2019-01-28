package com.imse.imse.Repository;

import com.imse.imse.Model.Mitarbeiter;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MitarbeiterRepository extends MongoRepository<Mitarbeiter, Integer> {
	public Mitarbeiter findBy_id(int id);
	public void deleteBy_id(int id);
}
