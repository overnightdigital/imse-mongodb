package com.imse.imse.Repository;

import com.imse.imse.Model.Firma;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FirmaRepository extends MongoRepository<Firma, Integer> {
	public Firma findBy_id(int id);
	public void deleteBy_id(int id);
}
