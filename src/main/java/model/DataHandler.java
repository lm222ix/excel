package model;


import org.apache.poi.ss.usermodel.Row;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by Ludde on 2015-10-21.
 */
public class DataHandler {

    private ArrayList<Purchase> m_purchases;
    private ArrayList<Charger> m_chargers;
    private BankDataDocument m_document;

    final DecimalFormat df = new DecimalFormat("####0.00");

    public DataHandler(BankDataDocument doc) {
        this.m_purchases = new ArrayList<Purchase>();
        this.m_chargers = new ArrayList<Charger>();
        this.m_document = doc;
    }

    public void mergeChargers() {
        for(Purchase p : m_purchases) {
            Charger tempCharger = getChargerByName(p.getChargerName());
            if(tempCharger == null) {
                Charger c = new Charger(p.getChargerName());
                c.addPurchase(p);
                m_chargers.add(c);
            } else {
                //System.out.println("Charger exists already, adding in and outcome to it!");
                tempCharger.addPurchase(p);
            }
        }
    }

    private Charger getChargerByName(String chargerName) {
        for(Charger c : m_chargers) {
            if (c.getChargerName().equals(chargerName)) {
                return c;
            }
        }
        return null;
    }

    private boolean chargersContainCharger(String chargerName) {
        for(Charger c : m_chargers) {
            if(c.getChargerName().equals(chargerName)) {
                return false;
            }
        }
        return true;
    }

    public void readPurchasesFromFile() {
        Iterator<Row> rowIterator = m_document.getSheet().iterator();

        String date;
        String chargerName;
        double amount;
        double balance;

        while(rowIterator.hasNext()) {
            Row currentRow = rowIterator.next();
            try {

                try {
                    date = currentRow.getCell(2).getStringCellValue().trim();
                    chargerName = currentRow.getCell(4).getStringCellValue().trim();
                    amount = currentRow.getCell(6).getNumericCellValue();
                    balance = currentRow.getCell(8).getNumericCellValue();
                    if (date != null && chargerName != null && !date.isEmpty() && !chargerName.isEmpty()) {
                        Purchase p = new Purchase(date, amount, chargerName, balance);
                        m_purchases.add(p);
                    }
                } catch (NullPointerException e) {
                    // System.out.println(e.getMessage());
                }

            } catch(IllegalStateException ex) {
                // System.out.println(ex.getMessage());
            }


        }

    }

    public void printPurchases() {
        for(Purchase p : m_purchases) {
            System.out.println(p.toString());
        }
    }


    public void print() {
        Collections.sort(m_chargers);
        for(Charger c : m_chargers) {
            System.out.println(c.getChargerName() + ": " + "In: " + df.format(c.getChargerIncome())+ " - " + "out: " + df.format(c.getChargerOutcome())+ " - total: " + df.format(c.getChargerTotal()));
        }
    }

}
