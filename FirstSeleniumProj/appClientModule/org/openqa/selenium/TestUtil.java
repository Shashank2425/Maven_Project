package org.openqa.selenium;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestUtil {
	static Workbook w;
    static Sheet s;
    static File f;
    
    //public static String filepath ="D:\\TesterDetails.xls";
    public static Object[][] testData(int sheetno) throws BiffException, IOException
    {
        f = new File("C:\\Users\\shash\\Desktop\\Wipro Assignments\\Automation Testing\\Test_WorkSheet.xls");
        
        w= Workbook.getWorkbook(f);
        
        s = w.getSheet(sheetno);
        
        int row = s.getRows();
        int col = s.getColumns();
        
        Object[][] data = new Object[row-1][col];
        int k =0;
        for(int i = 1 ; i< row;i++)
        {
            
            for(int j = 0 ;j<col ; j++)
            {
                
                Cell c = s.getCell(j, i);
                data[k][j] = c.getContents().toString();
            }
            k++;
            
        }
        
        return data;
    }
}
