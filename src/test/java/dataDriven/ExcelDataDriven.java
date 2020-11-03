package dataDriven;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDriven {

	public ArrayList<String> getData(String testcasename,String sheetname) throws IOException {

		// step 1 - get access to the Excel first --
		// this program get the data from the excel 

		String fs = (System.getProperty("user.dir") + "//getDataFromExcel.xlsx");
		FileInputStream fis = new FileInputStream(fs);
		
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		workbook.getNumberOfSheets();
		workbook.getSheetName(0);

		ArrayList<String> al = new ArrayList<String>();

		// System.out.println(workbook.getNumberOfSheets()); // print no of sheets -- 1
		// System.out.println(workbook.getSheetName(0)); // print sheet name -- Login

		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase(sheetname));
				

			{

				XSSFSheet sheet = workbook.getSheetAt(i);

				// identify and traverse through Cells

				Iterator<Row> rows = sheet.iterator(); // iterate all rows of the sheet
				Row firstrow = rows.next(); // get access to first row
				
				Iterator<Cell> cell = firstrow.cellIterator(); // iterate all columns of rows
				int k = 0;
				int column = 0;
				while (cell.hasNext()) {

					Cell value = cell.next(); // get access to all cells of first row so can iterate..
					if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {
						column = k;
						//System.out.println(column);
					}
					k++;
				}

				// now we have identified the Cells now traverse thru the first row to get
				// the "Purchase" value
				// in POI API there are only rows and cell concept not such as column

				while (rows.hasNext()) {

					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) {

						// after you grab the Purchase column then get all the data from this row
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {

							al.add(cv.next().getStringCellValue());
							

						}
						//System.out.println(al);
						
					}
					
				}
				
			}
			return al;
		}
		//return al;
		return null;
		
		
	}

}
