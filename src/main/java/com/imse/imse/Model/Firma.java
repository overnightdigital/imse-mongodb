package com.imse.imse.Model;

import org.springframework.data.annotation.Id;

public class Firma {

    @Id
	private int ID;

	private String name;

	private String adresse;
	
	public Firma(){}

	public Firma(int id, String name, String adresse){
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

    @Override
    public String toString() {
        return "Firma{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
