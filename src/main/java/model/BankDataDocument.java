package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class BankDataDocument {

	//Fields
	private InputStream inp;
	private Workbook wb;
	private Sheet sheet;
	private int startingRow;
	private ArrayList<Purchase> purchases;
	
	public BankDataDocument(String filePath, int startingRow) throws InvalidFormatException, IOException {
		this.inp = new FileInputStream(filePath);
		this.wb = WorkbookFactory.create(inp);
		this.sheet = wb.getSheetAt(0);
		this.startingRow = startingRow;
		this.purchases = new ArrayList<Purchase>();
	}



	//SET & GET
	public InputStream getInp() {
		return inp;
	}

	public void setInp(InputStream inp) {
		this.inp = inp;
	}

	public Workbook getWb() {
		return wb;
	}

	public void setWb(Workbook wb) {
		this.wb = wb;
	}

	public Sheet getSheet() {
		return sheet;
	}

	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}

	public int getStartingRow() {
		return startingRow;
	}

	public void setStartingRow(int startingRow) {
		this.startingRow = startingRow;
	}

	public ArrayList<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(ArrayList<Purchase> purchases) {
		this.purchases = purchases;
	}
}
