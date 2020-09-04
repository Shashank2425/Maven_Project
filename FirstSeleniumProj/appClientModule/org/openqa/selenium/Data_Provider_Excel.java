package org.openqa.selenium;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import jxl.read.biff.BiffException;

public class Data_Provider_Excel {
WebDriver dr;
    
    @BeforeMethod
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver.exe");
        dr= new ChromeDriver();
        
        dr.manage().window().maximize();
        
        dr.get("https://demo.opencart.com/");
    }
    
    @DataProvider
    public Object[][] getData() throws BiffException, IOException
    {
        Object[][] data = TestUtil.testData(0) ;
        
        return data;
    }
    
    @Test(dataProvider = "getData")
    public void testData(String email, String pwd) throws InterruptedException
    {
        dr.findElement(By.xpath("//span[text()='My Account']")).click();
        
        dr.findElement(By.linkText("Login")).click();
        
        dr.findElement(By.cssSelector("input#input-email")).sendKeys(email);
        
        dr.findElement(By.cssSelector("input#input-password")).sendKeys(pwd);
        
        Thread.sleep(1000);
        
        dr.findElement(By.xpath("//input[@value='Login']")).click();
        
        
        dr.findElement(By.linkText("Logout")).click();
        
    }
    
    @AfterMethod
    public void closing()
    {
        dr.close();
    }
}	
