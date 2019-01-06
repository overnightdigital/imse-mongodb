package com.imse.imse.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Produkt_des_monats")
public class Produkt_des_monats {

    @Id
    private int Produkt_ID;

	private String spezifikation;

	private String bewertung;
	
	public Produkt_des_monats() {}

	public Produkt_des_monats(int Produkt_ID, String s, String b) {
	    this.Produkt_ID = Produkt_ID;
		this.spezifikation = s;
		this.bewertung = b;
	}

	public String getSpezifikation() {
		return spezifikation;
	}
	public void setSpezifikation(String spezifikation) {
		this.spezifikation = spezifikation;
	}

	public String getBewertung() {
		return bewertung;
	}
	public void setBewertung(String bewertung) {
		this.bewertung = bewertung;
	}

    public int getProdukt_ID() {
        return Produkt_ID;
    }
    public void setProdukt_ID(int produkt_ID) {
        Produkt_ID = produkt_ID;
    }
}
