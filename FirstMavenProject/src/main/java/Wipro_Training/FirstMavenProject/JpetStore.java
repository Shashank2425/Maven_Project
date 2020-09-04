package Wipro_Training.FirstMavenProject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import jxl.read.biff.BiffException;

public class JpetStore {
	
	WebDriver wd;
	
	@BeforeSuite
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver.exe");
		
		wd= new ChromeDriver();	
	}
	
	
	@DataProvider
	
	 public Object[][] getData() throws BiffException, IOException
   {
       Object[][] data = TestData.testData(0) ;
       
       return data;
   }
	
	@DataProvider
	
	public Object[][] getData1() throws BiffException, IOException
	{
		
		Object [][] data= UserInfo.testData(0);
		return data;
	}
	
@DataProvider
	
	public Object[][] getData2() throws BiffException, IOException
	{
		
		Object [][] data= LoginInfo.testData(0);
		return data;
	}
	
	@Test(dataProvider = "getData",priority=0)
	public void Login(String Username, String Password, String CPwd) throws InterruptedException {
		
		wd.get("https://petstore.octoperf.com/");

		wd.findElement(By.linkText("Enter the Store")).click();	Thread.sleep(900);
		wd.findElement(By.linkText("Sign In")).click();					Thread.sleep(900);
		wd.findElement(By.linkText("Register Now!")).click();		Thread.sleep(900);
		
		//Account INFO
		wd.findElement(By.name("username")).sendKeys(Username); 			Thread.sleep(1000);
		wd.findElement(By.name("password")).sendKeys(Password); 			Thread.sleep(1000);
		wd.findElement(By.name("repeatedPassword")).sendKeys(CPwd); 	Thread.sleep(1000);
	}	
	
	
		@Test(dataProvider="getData1",priority=1)
		public void Register(String FirstName, String LastName, String Email, String Phone, String Address1, 
				String Address2, String City, String State, String Zip, String Country) throws InterruptedException {
		//User Info
		wd.findElement(By.name("account.firstName")).sendKeys(FirstName);
		Thread.sleep(1000);
		wd.findElement(By.name("account.lastName")).sendKeys(LastName); 
		Thread.sleep(1000);
		wd.findElement(By.name("account.email")).sendKeys(Email); 
		Thread.sleep(1000);
		wd.findElement(By.name("account.phone")).sendKeys(Phone); 
		Thread.sleep(1000);
		wd.findElement(By.name("account.address1")).sendKeys(Address1); 
		Thread.sleep(1000);
		wd.findElement(By.name("account.address2")).sendKeys(Address2); 
		Thread.sleep(1000);
		wd.findElement(By.name("account.city")).sendKeys(City); 
		Thread.sleep(1000);
		wd.findElement(By.name("account.state")).sendKeys(State); 
		Thread.sleep(1000);
		wd.findElement(By.name("account.zip")).sendKeys(Zip); 
		Thread.sleep(1000);
		wd.findElement(By.name("account.country")).sendKeys(Country); 
		Thread.sleep(1000);
		}
		
		@Test(priority=2)
		public void Profile() throws InterruptedException {
		//Profile Info
		Select lang= new Select(wd.findElement(By.name("account.languagePreference")));
		lang.selectByVisibleText("english");
		Thread.sleep(800);
		Select category= new Select(wd.findElement(By.name("account.favouriteCategoryId")));
		category.selectByVisibleText("DOGS");
		
	//creating an account
		wd.findElement(By.name("newAccount")).click();
		}
		
		@Test(dataProvider="getData2", priority=3)
		public void Operation(String Username, String Password) throws InterruptedException {
			//logging in with the registered creds.
			wd.get("https://petstore.octoperf.com/actions/Catalog.action");
			wd.findElement(By.linkText("Sign In")).click(); 								Thread.sleep(800);
			wd.findElement(By.name("username")).sendKeys(Username); 	Thread.sleep(1000);
			wd.findElement(By.name("password")).sendKeys(Password); 	Thread.sleep(1000);
			wd.findElement(By.name("signon")).click();
		
			System.out.println("Welcome to Jpet Store"+Username+"!");
		
		//clicking on fish icon
			wd.findElement(By.xpath("//a[@href='https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH']")).click();
			wd.findElement(By.linkText("FI-FW-01")).click();
			System.out.println("Koi");
			wd.findElement(By.linkText("EST-5")).click();
			wd.findElement(By.linkText("Add to Cart")).click();
			wd.findElement(By.name("EST-5")).sendKeys("3");
			wd.findElement(By.className("updateCartQuantities")).click();
			System.out.println("Sub Total: $55.50 ");

			wd.findElement(By.linkText("Proceed to Checkout")).click();
			//checking out
			wd.findElement(By.className("newOrder")).click();
			wd.findElement(By.linkText("Confirm")).click();
		
			System.out.println("Thank You...");
		
			WebElement order=wd.findElement(By.name("Order #18858\r\n" + "		2020/08/12 01:04:02"));
			System.out.println("Order No:"+order);
		
			wd.findElement(By.linkText("Sign Out")).click();
		
	}
}
