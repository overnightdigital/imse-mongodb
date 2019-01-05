package com.imse.imse.Model;

public class Produkt {
	
	String name;
	String preis;
	int ID_Nummer;
	
	Produkt(){}
	Produkt(int id, String name, String preis){
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
	
	
}
