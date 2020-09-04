package Wipro_Training.FirstMavenProject;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestData {
	
	//public static String filepath ="C:\\Users\\shash\\Desktop\\AccountInformation.xls";
    public static Object[][] testData(int sheetno) throws BiffException, IOException
    {
       File f = new File("C:\\Users\\shash\\Desktop\\AccountInformation.xls");
        
       Workbook w= Workbook.getWorkbook(f);
        
        Sheet s = w.getSheet(sheetno);
        
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
        //System.out.println(data);
    }	

}
