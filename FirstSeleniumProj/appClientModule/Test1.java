import java.io.File;
import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Test1 {
    /*
     * @param args
     * @throws BiffException
     * @throws IOException
     * @throws InterruptedException
     **/
    public static void main(String[] args) throws BiffException, IOException, InterruptedException {
        // TODO Auto-generated method stub
        
        
        //Open The browser
        System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver.exe");
        WebDriver dr = new ChromeDriver();
        
        // Launch the Orange HRM browser
        dr.get("https://demo.opencart.com/");
        dr.manage().window().maximize();

        //fetching the file
       File f = new File("C:\\Users\\shash\\Desktop\\Wipro Assignments\\Automation Testing\\Test_WorkSheet.xls");
    //    File f = new File (" C:\\Users\shash\Desktop\\Wipro Assignments\\Automation Testing\\Test_WorkSheet.xls ");
        
        Workbook w = Workbook.getWorkbook(f); 
        
        Sheet s = w.getSheet(0);
        
        int row = s.getRows();
        int col = s.getColumns();String [] str = new String[col];

        for(int i = 1 ;i<row ; i++)
        {
            
            for(int j=0;j<col;j++)
            {
                jxl.Cell c = (jxl.Cell) s.getCell(j, i);
                
                str[j]  = ((jxl.Cell) c).getContents();
                
            }
        }
        
        //entering the details for registration
        dr.findElement(By.xpath("//span[text()='My Account']")).click();
        dr.findElement(By.linkText("Register")).click();
        dr.findElement(By.name("firstname")).sendKeys("Sumanth");
        Thread.sleep(1000);
        dr.findElement(By.name("lastname")).sendKeys("Reddy");
        Thread.sleep(1000);
        dr.findElement(By.name("email")).sendKeys("sumanth.reddy@gmail.com");
        Thread.sleep(1000);
        dr.findElement(By.name("telephone")).sendKeys("986565");
        Thread.sleep(1000);
        dr.findElement(By.name("password")).sendKeys("sumanth");
        dr.findElement(By.name("confirm")).sendKeys("sumanth");
        dr.findElement(By.name("agree")).click();Thread.sleep(1000);
        dr.findElement(By.xpath("//input[@value='Continue']")).click();
        dr.findElement(By.linkText("Continue")).click();
        Thread.sleep(1000);
        dr.findElement(By.linkText("Logout")).click();
        
        //printing the details on console
        System.out.println("title of the page is "+dr.getTitle()); 
        System.out.println("The current URL of the page is "+dr.getCurrentUrl());
        Thread.sleep(1000);
        
        //quit the application.
        dr.quit();
        

    }
}
