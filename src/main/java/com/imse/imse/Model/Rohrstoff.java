package com.imse.imse.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Rohstoff") // typo in database !!!!!!!!
public class Rohrstoff {

    @Id
    private int ID;

	private float menge;

	private String name;

	private float preis;

    @ManyToOne
    private Firma firma;
	
	public Rohrstoff() {}

	public Rohrstoff(float m, float p, int ID, String name, Firma firma) {
		this.ID = ID;
		this.name = name;
		this.menge = m;
		this.firma = firma;
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
