package Wipro_Training.FirstMavenProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;



public class MouseHover {
	static WebDriver driver;
	@BeforeTest
	 public void setUp( )  {

	  System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver.exe");

	  driver = new ChromeDriver();
	  }
	@Test
	public void Operation() throws InterruptedException, IOException{
	  driver.manage().window().maximize();
	  driver.get("https://www.google.co.in");
	  
	  Actions ac = new Actions(driver);
	  
	  driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("guru99",Keys.ENTER);
	  
	  WebElement element = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a"));
	  ac.moveToElement(element).build().perform();
	  element.click();
	  System.out.println("Guru99 website has been opened");
	  
	  WebElement Testing_Tab = driver.findElement(By.xpath("//*[@id=\"menu-3688-particle\"]/nav/ul/li[2]/div/span[1]/span"));
	  ac.moveToElement(Testing_Tab).perform();
	  System.out.println("The Cursor Tab has been moved to Testing_Tab");
	  Thread.sleep(800);
	  
	  WebElement Selenium_Tab = driver.findElement(By.xpath("//*[@id=\"menu-3688-particle\"]/nav/ul/li[2]/ul/li/div/div[3]/ul/li[5]/a/span/span"));
	  ac.moveToElement(Selenium_Tab).perform();
	  Thread.sleep(1000);
	  Selenium_Tab.click();
	  System.out.println("The Selenium Tab has been clicked");
	  
	  TakesScreenshot scrShot =((TakesScreenshot)driver);
	  File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	  //File NewDest=new File("C:\\Users\\shash\\Desktop\\SelScrSht"+".jpg");
	  FileUtils.copyFile(SrcFile, new File("C:\\Users\\shash\\Desktop\\SelScrSht"+".jpg"));
	  System.out.println("The ScreenShot has been taken");
	  
	  driver.close();
	  
	 }
}
