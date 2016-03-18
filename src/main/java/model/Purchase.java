package model;

import java.util.Date;

public class Purchase {

	//Fields
	private String date;
	private double amount;
	private String chargerName;
	
	//Constructor
	public Purchase(String date, double amount, String charger) {
		this.date = date;
		this.amount = amount;
		this.chargerName = charger;
	}
	
	public double getAmount() {return this.amount;}
	public String getChargerName() {return this.chargerName;}

	public String toString() {
		String s = "";
		s = this.date.toString() + ": " + this.chargerName + " - " + this.getAmount();
		return s;
	}
}
