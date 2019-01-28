package com.imse.imse.Model;

import org.springframework.data.annotation.Id;

public class Produkt_des_monats {

    @Id
    private int _id;

	private String Spezifikation;

	private int Bewertung;
	
	public Produkt_des_monats() {}

	public Produkt_des_monats(int Produkt_ID, String s, int b) {
	    this._id = Produkt_ID;
		this.Spezifikation = s;
		this.Bewertung = b;
	}

	public String getSpezifikation() {
		return Spezifikation;
	}
	public void setSpezifikation(String spezifikation) {
		this.Spezifikation = spezifikation;
	}

	public int getBewertung() {
		return Bewertung;
	}
	public void setBewertung(int bewertung) {
		this.Bewertung = bewertung;
	}

    public int getProdukt_ID() {
        return _id;
    }
    public void setProdukt_ID(int produkt_ID) {
        _id = produkt_ID;
    }
}
