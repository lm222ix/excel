package model;

import java.util.Date;

public class Purchase {

	//Fields
	private String date;
	private double amount;
	private String chargerName;
	private double currentBalance;
	private boolean isIncome;
	
	//Constructor
	public Purchase(String date, double amount, String charger, double currentBalance) {
		this.date = date;
		this.amount = amount;
		this.chargerName = charger;
		this.currentBalance = currentBalance;
	}
	/*public Purchase() {
		this.date = null;
		this.amount = 0;
		this.charger = null;
		this.currentBalance = 0;
	}*/
	
	
	//get&set
	
	public double getAmount() {return this.amount;}
	public void setAmount(double amount) {this.amount = amount;
		}
	
	public String getChargerName() {return this.chargerName;}
	public void setChargerName(String chargerName) {this.chargerName = chargerName;}
	
	public double getCurrentBalance() {return this.currentBalance;}
	public void setCurrentBalance(double currentBalance) {this.currentBalance = currentBalance;}
	
	public String getDate() { return this.date;}
	public void setDate(String date) {this.date = date;}
	
	public boolean IsIncome() {
		if(this.amount>0) {
			return true;
		} else {
			return false;
		}
	}
	
	//
	
	public String toString() {
		String s = "";
		s = this.date.toString() + ": " + this.chargerName + " - " + this.getAmount();
		return s;
	}
}
