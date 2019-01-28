package com.imse.imse.Repository;

import com.imse.imse.Model.Produkt_des_monats;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Produkt_des_monatsRepository extends MongoRepository<Produkt_des_monats, Integer> {
	public Produkt_des_monats findBy_id(int id);
	public void deleteBy_id(int id);
}
