package org.openqa.selenium;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Test_WorkSheet {
	
	public static void main(String args[]) throws BiffException, IOException, InterruptedException{
		
		File f= new File("C:\\Users\\shash\\Desktop\\UserInformation.xls"); //file instance
		
		Workbook w=Workbook.getWorkbook(f);
		
		Sheet s =w.getSheet(0);    //here the parameter in mtd is the sheet number or we can use name instead if a sheet is named
		
		
		//getting the details of sheet

		int row=s.getRows();
		int col=s.getColumns();

		System.out.println("No. of rows:"+row);
		System.out.println("------------------------------------------");
		System.out.println("No. of rows:"+col);
		System.out.println("------------------------------------------");

		//getting the content of sheet
		String [] str=new String[col];

		for(int i=1;i<row;i++){   //here i is from 1 coz to ignore the headings in worksheet
			//int k=0;	
			for(int j=0;j<col;j++){
				jxl.Cell c=s.getCell(j,i);
			
				str[j]=c.getContents();
				
				System.out.println(str[j]);
			}
			Thread.sleep(1050);
			System.out.println("==================================");
		}
		
	}
}
