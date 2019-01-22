package com.imse.imse.Model;

import org.springframework.data.annotation.Id;

public class Produkt {

    @Id
    private int ID;

	private String name;

	private String preis;

    private Firma firma;
	
	public Produkt(){}

	public Produkt(int id, String name, String preis, Firma firma){
		this.ID = id;
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
		return ID;
	}
	public void setID_Nummer(int iD_Nummer) {
		ID = iD_Nummer;
	}

    public Firma getFirma() {
        return firma;
    }
    public void setFirma(Firma firma) {
        this.firma = firma;
    }
}
