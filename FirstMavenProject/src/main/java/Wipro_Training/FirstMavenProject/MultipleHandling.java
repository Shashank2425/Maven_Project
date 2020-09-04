package Wipro_Training.FirstMavenProject;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class MultipleHandling {
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		}
	
	@Test 
	public void Operation() throws InterruptedException {
		driver.get("http://demo.automationtesting.in/Windows.html");
		
		driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();
		Thread.sleep(1000);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(tabs2.get(1));
		
		String page=driver.getCurrentUrl();
		String exp="http://www.sakinalium.in/";
		
		System.out.println(page);

		//driver.findElement(by)
		if(exp.equals(page)) {
			System.out.println("Verification Successful- Expected tab opened");
		}
		else {
			System.out.println("Verification Successful- Expected tab not opened");
			//driver.close();
		}
		Thread.sleep(500);
		driver.switchTo().window(tabs2.get(0));
		//Opening in separate window
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
		Thread.sleep(800);
		driver.findElement(By.xpath("//*[@id=\"Seperate\"]/button")).click(); 	
		Thread.sleep(800);
		
		//driver.switchTo().window()
		
		driver.quit();
		
	}
}
