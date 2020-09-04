package org.openqa.selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class Listeners_Prgm {
	WebDriver dr;
    @BeforeMethod
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver.exe");
        
        dr= new ChromeDriver();
        
    }
    
    @Test
    public void Login()
    {
        dr.get("https://opensource-demo.orangehrmlive.com/"); 
        dr.findElement(By.name("txtUsername")).sendKeys("admin");
        dr.findElement(By.name("txtPassword")).sendKeys("admin123");
        dr.findElement(By.name("Submit")).click();
    }
    
    @Test
    public void failTest()
    {
        System.out.println("method to be failed intentionally");
        Assert.assertTrue(false);
    }
}