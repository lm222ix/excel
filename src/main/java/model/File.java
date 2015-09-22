package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class File {

	//Fields
	private InputStream inp;
	private Workbook wb;
	private Sheet sheet;
	private int startingRow;
	private ArrayList<Purchase> purchases;
	
	public File(String filePath, int startingRow) throws InvalidFormatException, IOException {
		this.inp = new FileInputStream(filePath);
		this.wb = WorkbookFactory.create(inp);
		this.sheet = wb.getSheetAt(0);
		this.startingRow = startingRow;
		this.purchases = new ArrayList<Purchase>();
	}
	
	public void readPurchases() {
		Row currentRow = sheet.getRow(startingRow);
		Purchase p = new Purchase();
//		p.setDate(currentRow.getCell(2).getDateCellValue());
		p.setCharger(currentRow.getCell(4).getStringCellValue());
		p.setAmount(currentRow.getCell(6).getNumericCellValue());
		p.setCurrentBalance(currentRow.getCell(8).getNumericCellValue());
		purchases.add(p);
	}
	public void print() {
		for(Purchase p : purchases) {
			System.out.println(p.toString());
		}
	}
	
	public static void main(String[] args) throws InvalidFormatException, IOException {
		File f = new File("src/main/resources/kontotest.xls", 7);
		f.readPurchases();
		f.print();
	}
	
}
