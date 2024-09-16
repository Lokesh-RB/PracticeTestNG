package TestNGPayC;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Date {

	
	

		  
		
		 // Static method to generate a random company name
	    public static String generateRandomCompanyName() {
	        String[] MESSAGE_ELEMENTS = {"Winfosys", "Cognizant", "Google", "Accenture", "Microsoft", "Wipro", "Siemens", "Thought works", "Ryan", "Olivia"};
	        Random random = new Random();
	        return MESSAGE_ELEMENTS[random.nextInt(MESSAGE_ELEMENTS.length)];
	    }
	    // Static method to generate a random name
	    public static String generateRandomsubject() {
	        String[] MESSAGE_ELEMENTS = {"Electric Bill", "Water Bill", "Groceries", "Teamout", "Other Expense", "Garden", "Listeners", "Maven", "Computer", "Laptop"};
	        Random random = new Random();
	        return MESSAGE_ELEMENTS[random.nextInt(MESSAGE_ELEMENTS.length)];
	    }
	 
		 // Static method to generate a random last name
	    public static String generateRandomLastName() {
	        String[] MESSAGE_ELEMENTS = {"Vinay", "Kumar", "Ravi", "Gagan", "Mohit", "Sharan", "Kiran", "Abhishek", "Raayan", "Olivia"};
	        Random random = new Random();
	        return MESSAGE_ELEMENTS[random.nextInt(MESSAGE_ELEMENTS.length)];
	    }
		 // Static method to generate a random name
	    public static String generateRandommail() {
	        String[] MESSAGE_ELEMENTS = {"vinay", "kumar", "ravi", "gagan", "mohit", "sharan", "kiran", "abhishek", "raayan", "olivia"};
	        Random random = new Random();
	        return MESSAGE_ELEMENTS[random.nextInt(MESSAGE_ELEMENTS.length)];
	    }
	    // Static method to generate a random name
	    public static String generateRandompurchaseorder() {
	        String[] MESSAGE_ELEMENTS = {"New Invoice", "Critical", "Major", "Teamout", "Minor", "Blocker", "Listeners", "Selenium", "Download", "Market"};
	        Random random = new Random();
	        return MESSAGE_ELEMENTS[random.nextInt(MESSAGE_ELEMENTS.length)];
	    }
	  
		WebDriver driver;
		
		
		
		
		@Test(priority=1)

	    void open_app() 
	   {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://backoffice.chaincrm.io/");
		
	   }
		  
		@Test(priority=2)
		void Login() 
		{
//			 Boolean Next=driver.findElement(By.xpath("//button[@class='LoginNextBtn']")).isEnabled();
//		      System.out.println(Next);

		      driver.findElement(By.xpath("//input[@type='text']")).sendKeys("lokeshrb@mailinator.com");
		      driver.findElement(By.xpath("//button[@class='LoginNextBtn']")).click();
		      driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Loki@123");
		      driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		}
		
		
		@Test(priority = 8)
		 void AllPurchaseOrders()
		 {
        	driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
        	driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
        	driver.findElement(By.xpath("//p[contains(text(),'Purchase Orders')]")).click();
        	
         	driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
			
		  driver.findElement(By.xpath("//div[@class=' css-11qgko6-control']")).click();
		  driver.findElement(By.xpath("(//div[contains(text(),'All Purchase Orders')])[2]")).click();
		  String MyPO = driver.findElement(By.xpath("//div[@class='d-flex w-50']")).getText();
		  System.out.println("All Purchase Order: "+MyPO);
		  WebElement allpo= driver.findElement(By.xpath("//div[@class='leadListTableFullWidth']"));
		  List<WebElement> rowCount = allpo.findElements(By.tagName("tr")) ;
		  String backEndData = "Total Records : "+(rowCount.size());
		  System.out.println(backEndData);
		  SoftAssert SA=new SoftAssert();
		  SA.assertEquals(backEndData, MyPO, "Records Not Matching");
		  SA.assertAll();

		 }
		}
	
	

