package com.imse.imse.Model;

import org.springframework.data.annotation.Id;

public class Produkt {

    @Id
    private int _id;

	private String name;

	private String preis;

    private Firma firma;
	
	public Produkt(){}

	public Produkt(int id, String name, String preis, Firma firma){
		this._id = id;
		this.preis = preis;
		this.name = name;
		this.firma = firma;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPreis() {
		return preis;
	}
	public void setPreis(String preis) {
		this.preis = preis;
	}

	public int getID_Nummer() {
		return _id;
	}
	public void setID_Nummer(int iD_Nummer) {
		_id = iD_Nummer;
	}

    public Firma getFirma() {
        return firma;
    }
    public void setFirma(Firma firma) {
        this.firma = firma;
    }
}
