package com.imse.imse.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Rohrstoff")
public class Rohrstoff {

	private float menge;

	private String name;

	private float preis;

	private int ID_Nummer;
	
	public Rohrstoff() {}

	public Rohrstoff(float m, float p, int id, String name) {
		this.ID_Nummer = id;
		this.name = name;
		this.menge = m;
		this.preis = p;
	}

	public float getMenge() {
		return menge;
	}
	public void setMenge(float menge) {
		this.menge = menge;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public float getPreis() {
		return preis;
	}
	public void setPreis(float preis) {
		this.preis = preis;
	}

	public int getID_Nummer() {
		return ID_Nummer;
	}
	public void setID_Nummer(int iD_Nummer) {
		ID_Nummer = iD_Nummer;
	}
	
	
}
