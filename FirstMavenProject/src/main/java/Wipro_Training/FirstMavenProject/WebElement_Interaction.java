package Wipro_Training.FirstMavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class WebElement_Interaction {
WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		
	@Test
	public void Operation() throws ElementClickInterceptedException{
		driver.get("https://demoqa.com/automation-practice-form");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("firstName")).sendKeys("Sunny");
		driver.findElement(By.id("lastName")).sendKeys("Singh");
		driver.findElement(By.id("userEmail")).sendKeys("sunny2425@gmail.com");
		
		WebElement radio= driver.findElement(By.id("gender-radio-1"));
		radio.click();
		
		driver.findElement(By.id("userNumber")).sendKeys("1234567890");
		driver.findElement(By.id("dateOfBirthInput")).sendKeys("15-Jun-1998");
		driver.findElement(By.id("subjectsInput")).sendKeys("English,Hindi,Telugu");
		driver.findElement(By.id("hobbies-checkbox-3")).click();
	//	driver
		//driver
		//driver
		driver.findElement(By.id("currentAddress")).sendKeys("abcdefghijklmnopqrstuvwxyz");
		Select state= new Select(driver.findElement(By.id("react-select-3-input")));
		state.selectByVisibleText("Rajasthan");
		Select city=new Select(driver.findElement(By.id("react-select-4-input")));
		city.selectByVisibleText("Jaipur");
		

		
//		driver

	}
}
