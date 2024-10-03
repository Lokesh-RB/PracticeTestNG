package TestNGPayC;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SettingsCreateProfile 
{
     	WebDriver driver;
     	
     	@Test(priority=1)
     	public void Openapp() 
     	{
     		WebDriver driver= new ChromeDriver();
     		driver.get("https://backoffice.chaincrm.io/");
     		driver.manage().window().maximize();
     		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
     	}
     	
     	@Test(priority=2)
     	public void Login()
     	{

     	      Login1 lp=new Login1(driver);
     	      lp.setMailId("lokeshrb@mailinator.com");
     	      lp.clickContinue();
     	      lp.setPwd("Loki@123");
     	      lp.clickLogin();     		
     	}
     	
     	@Test(priority=3)
     	public void AddProfileInSettings()
     	{
     		driver.findElement(By.xpath("//img[@src='/static/media/setting-01.6c22fcffdf153e4cef1206bf658aaa60.svg']")).click();
     		driver.findElement(By.xpath("(//div[@class='d-flex justify-content-between cursorPointer'])[2]")).click();
     		driver.findElement(By.xpath("(//span[contains(text(),'Security Control')])")).click();
     		//Thread.sleep(2000);
     		driver.findElement(By.xpath("(//span[contains(text(),'Profile')])[3]")).click();
     		//Thread.sleep(2000);
     		driver.findElement(By.xpath("(//button[contains(text(),'New Profile')])")).click();
     		//Thread.sleep(2000);
     		driver.findElement(By.xpath("(//input[@name='profileName'])")).sendKeys("ashokbro1");
     		//Thread.sleep(2000);
     		driver.findElement(By.xpath("(//button[@class='unassignButton px-4'])")).click();  ///Profile added successfully
     		//Thread.sleep(2000);
     		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));  
     		   try 
     		   {
     			   WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[contains(text(),'Clone Profile cannot be empty.')])")));
     			   // If success message is found, print it
     		         System.out.println("Success message: " + successMessage.getText());  //Invalid call duration
     		   }
     		   catch(Exception e)
     		   {
     			   System.out.println("No success or error message found.");  //One of the required field is empty or contains invalid data, please check your input(s).
     		   }
     	}
     		
     		
     
     	
     	
	
}
