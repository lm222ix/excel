import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;

import Controller.User;
import model.BankDataDocument;
import model.DataHandler;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		BankDataDocument doc = new BankDataDocument("src/main/resources/kontotest.xls", 8);


        DataHandler dataHandler = new DataHandler(doc);
        dataHandler.readPurchasesFromFile();
        dataHandler.mergeChargers();
        dataHandler.print();

		//user.print();
	}

}

