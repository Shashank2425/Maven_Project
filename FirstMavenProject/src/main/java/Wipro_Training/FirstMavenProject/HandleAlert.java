package Wipro_Training.FirstMavenProject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class HandleAlert {
	
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","F:\\Selenium Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
	}
	
	@Test
	public void Operation() {
		driver.get("http://demo.automationtesting.in/Alerts.html");
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();
		
		Alert message=driver.switchTo().alert();
		System.out.println("The message in the alert box is: "+message.getText());
		message.accept();
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
		System.out.println("The message in the alert box is:"+message.getText());
		message.accept();
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button")).click();
		message.sendKeys("Tester"); 
		message.accept();
		String  str=driver.findElement(By.xpath("//*[@id=\"demo1\"]")).getText();
		//System.out.println(str);
		
		String expected="Hello Tester How are you today";

		if( expected.equals(str)) { 
			System.out.println("Verification Sucessful-Text Matching");
			driver.close();
			driver.quit(); //doesn't matter as per now for a single instance 
			}
		else {
			System.out.println("Verification Sucessful-Not matching");
		
		}
	}
}