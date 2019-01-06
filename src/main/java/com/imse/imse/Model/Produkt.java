package com.imse.imse.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Produkt")
public class Produkt {

    @Id
    private int ID_Nummer;

	private String name;

	private String preis;

    @ManyToOne
    private Firma firma;
	
	public Produkt(){}

	public Produkt(int id, String name, String preis){
		this.ID_Nummer = id;
		this.preis = preis;
		this.name = name;
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
		return ID_Nummer;
	}
	public void setID_Nummer(int iD_Nummer) {
		ID_Nummer = iD_Nummer;
	}

    public Firma getFirma() {
        return firma;
    }
    public void setFirma(Firma firma) {
        this.firma = firma;
    }
}
