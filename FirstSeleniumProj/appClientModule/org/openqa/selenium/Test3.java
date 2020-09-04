package org.openqa.selenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Test3 {

	public static void main(String[] args)throws BiffException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver.exe");
        WebDriver dr= new ChromeDriver();
        
        dr.manage().window().maximize();
        dr.get("https://demo.opencart.com/");
        File f = new File("C:\\Users\\shash\\Desktop\\Wipro Assignments\\Automation Testing\\Test_WorkSheet.xls");
        
        Workbook w = Workbook.getWorkbook(f); 
        
        Sheet s = w.getSheet(0);
        
        int row = s.getRows();
        int col = s.getColumns();
        System.out.println("Rows:"+row);
        System.out.println("Columns:"+col);
        System.out.println("---------------------------");
        String [] str = new String[col];

        for(int i = 1 ;i<row ; i++)
        {
            
            for(int j=0;j<col;j++)
            {
                jxl.Cell c = (jxl.Cell) s.getCell(j, i);
                
                str[j]  = ((jxl.Cell) c).getContents();
                
                System.out.println(str[j]);
            }
            
            System.out.println("========================");
            
            
            dr.findElement(By.xpath("//span[text()='My Account']")).click();
            
            dr.findElement(By.linkText("Login")).click();
            
            dr.findElement(By.cssSelector("input#input-email")).sendKeys(str[0]);
            
            dr.findElement(By.cssSelector("input#input-password")).sendKeys(str[1]);
            
            Thread.sleep(2000);
            
            dr.findElement(By.xpath("//input[@value='Login']")).click();
            
            
            dr.findElement(By.linkText("Logout")).click();
            
            //dr.close();
        }
	}
}
