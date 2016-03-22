package model;

public class Charger implements Comparable<Charger>{

    //Fields
    private String chargerName;
    private double chargerIncome;
    private double chargerOutcome;

    //Constructor
    public Charger(String chargerName) {
        this.chargerName = chargerName;
        this.chargerIncome = 0;
        this.chargerOutcome = 0;
    }

    //Add purchase info
    public void addPurchase(Purchase p) {
        if(p.getAmount()>=0) {
            setChargerIncome(chargerIncome + p.getAmount());
        } else if(p.getAmount()<0){
            setChargerOutcome(chargerOutcome + p.getAmount());
        } else {
            System.out.println("invalid amount in purchase p");
        }

    }

    //GetSet
    public double getChargerIncome() {
        return chargerIncome;
    }

    public void setChargerIncome(double chargerIncome) {
        this.chargerIncome = chargerIncome;
    }

    public double getChargerOutcome() {
        return chargerOutcome;
    }

    public void setChargerOutcome(double chargerOutcome) {
            this.chargerOutcome = chargerOutcome;
    }

    public double getChargerTotal() {
        return getChargerIncome() + getChargerOutcome();
    }

    public int compareTo(Charger c) {
        return (int) (this.getChargerTotal()- c.getChargerTotal());
    }

    public String getChargerName() {
        return chargerName;
    }

    public void setChargerName(String chargerName) {
        this.chargerName = chargerName;
    }

}
