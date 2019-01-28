package com.imse.imse.Model;

import org.springframework.data.annotation.Id;

public class Firma {

    @Id
	private int _id;

	private String name;

	private String adresse;
	
	public Firma(){}

	public Firma(int id, String name, String adresse){
		this._id = id;
		this.adresse = adresse;
		this.name = name;
	}

	public int getID() {
		return _id;
	}
	public void setID(int iD) {
		_id = iD;
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
                "ID=" + _id +
                ", name='" + name + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
