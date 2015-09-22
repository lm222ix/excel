package excelJsonTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;

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
		InputStream inp = new FileInputStream("src/main/resources/kontotest.xls");
		Workbook wb = WorkbookFactory.create(inp);
		Sheet sheet = wb.getSheetAt(0);
		
		ArrayList stringArr = new ArrayList();
		ArrayList intArr = new ArrayList();
		
		Row row0 = sheet.getRow(7);
		
		
			
			for ( Iterator<Cell> firstRowIterator = row0.cellIterator(); firstRowIterator.hasNext(); )
	        {
	            Cell cell = firstRowIterator.next();
	            stringArr.add( cell.toString() );
	        }
			
//			for ( Iterator<Cell> secondRowIterator = row0.cellIterator(); secondRowIterator.hasNext(); )
//	        {
//	            Cell cell = secondRowIterator.next();
//	           System.out.println(cell.getNumericCellValue());
//	        }
		
		
		for(int i = 0; i<stringArr.size(); i++ ) {
			if(!stringArr.get(i).equals("")) {
				System.out.println(stringArr.get(i));
			}
			
		}
		
	}
}

