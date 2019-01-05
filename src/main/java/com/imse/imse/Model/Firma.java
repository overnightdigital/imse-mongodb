package com.imse.imse.Model;

public class Firma {

	int ID;
	String name;
	String adresse;
	
	Firma(){}
	Firma(int id, String name, String adresse){
		this.ID = id;
		this.adresse = adresse;
		this.name = name;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
}
