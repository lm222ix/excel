package Controller;

import model.BankDataDocument;
import model.Purchase;
import org.apache.poi.ss.usermodel.*;

import java.util.ArrayList;

/**
 * Created by ludde on 2015-10-15.
 */
public class User {



    public void readPurchasesFromFile(BankDataDocument document) {
        ArrayList<Purchase> purchases = document.getPurchases();
        Row currentRow = document.getSheet().getRow(document.getStartingRow());

    }

    public void readPurchases() {
        Row currentRow = sheet.getRow(startingRow);
        model.Purchase p = new model.Purchase();
//		p.setDate(currentRow.getCell(2).getDateCellValue());
        p.setCharger(currentRow.getCell(4).getStringCellValue());
        p.setAmount(currentRow.getCell(6).getNumericCellValue());
        p.setCurrentBalance(currentRow.getCell(8).getNumericCellValue());
        purchases.add(p);
    }

    public void print() {
        for(model.Purchase p : model.BankDataDocument.) {
            System.out.println(p.toString());
        }
    }
}
