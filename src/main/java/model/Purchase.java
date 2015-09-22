package model;

import java.util.Date;

public class Purchase {

	//Fields
	private Date date;
	private double amount;
	private String charger;
	private double currentBalance;
	private boolean isIncome;
	
	//Constructor
	public Purchase(Date date, int amount, String charger, int currentBalance) {
		this.date = date;
		this.amount = amount;
		this.charger = charger;
		this.currentBalance = currentBalance;
	}
	public Purchase() {
		this.date = null;
		this.amount = 0;
		this.charger = null;
		this.currentBalance = 0;
	}
	
	
	//get&set
	
	public double getAmount() {return this.amount;}
	public void setAmount(double amount) {this.amount = amount;
		}
	
	public String getCharger() {return this.charger;}
	public void setCharger(String charger) {this.charger = charger;}
	
	public double getCurrentBalance() {return this.currentBalance;}
	public void setCurrentBalance(double currentBalance) {this.currentBalance = currentBalance;}
	
	public Date getDate() { return this.date;}
	public void setDate(Date date) {this.date = date;}
	
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
		s = this.date.toString() + ": " + this.charger + " - " + this.getAmount();
		return s;
	}
}
