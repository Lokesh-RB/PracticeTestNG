package TestNGPayC;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Invoice {
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
		 Boolean Next=driver.findElement(By.xpath("//button[@class='LoginNextBtn']")).isEnabled();
	      System.out.println(Next);

	      driver.findElement(By.xpath("//input[@type='text']")).sendKeys("lokeshrb@mailinator.com");
	      driver.findElement(By.xpath("//button[@class='LoginNextBtn']")).click();
	      driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Loki@123");
	      driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
	}
	
	@Test(priority=3)
	void Invoice_Create_Mandatory_fields() throws InterruptedException 
	{
		
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
	      driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	      driver.findElement(By.xpath("//p[contains(text(),'Invoice')]")).click();
	      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
	      driver.findElement(By.xpath("//button[contains(text(),'Create Invoice')]")).click();
	      WebElement Invoice_Subject= driver.findElement(By.xpath("//input[@name='subject']"));
	      Invoice_Subject.sendKeys(generateRandomsubject());
	      
	      JavascriptExecutor js = (JavascriptExecutor) driver;
	      js.executeScript("window.scrollBy(0, 320)"); // Scroll down by 1000 pixels

	      
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//span[@class='insertCommonInputField cursorPointer rounded-1 pt-2 overflow_text pe-4 dfg']")).click();
	      driver.findElement(By.xpath("//li[@class='cursorPointer w-100 px-2 border-bottom my-1']")).click();
	      
	      JavascriptExecutor js1 = (JavascriptExecutor) driver;
	      js1.executeScript("window.scrollTo(0, 0)"); // Scroll up by 1000 pixels
	      
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//button[contains(text(),'Save')][2]")).click();
	      Thread.sleep(2000);
	}
	@Test(priority=4)
	void Invoice_Create_With_Without_Mandatory_fields() throws InterruptedException 
	{
		driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	      driver.findElement(By.xpath("//p[contains(text(),'Invoice')]")).click();
	      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
	      driver.findElement(By.xpath("//button[contains(text(),'Create Invoice')]")).click();

	      driver.findElement(By.xpath("//span[@class='leadInputField cursorPointer rounded-1 pt-2']")).click();
	      driver.findElement(By.xpath("//li[@class='cursorPointer w-100 px-2 border-bottom my-1']")).click();
	      WebElement Invoice_Subject= driver.findElement(By.xpath("//input[@name='subject']"));
	      Invoice_Subject.sendKeys(generateRandomsubject());
	      
	      
	      WebElement Purchase_Order=driver.findElement(By.xpath("//input[@name='purchaseOrder']"));
	      Purchase_Order.sendKeys(generateRandompurchaseorder());
	      driver.findElement(By.xpath("//input[@name='exciseDuty']")).sendKeys("123");
	       
	      driver.findElement(By.xpath("//input[@name='salesCommission']")).sendKeys("12");
	      
	      Thread.sleep(2000);
	      JavascriptExecutor js2 = (JavascriptExecutor) driver;      
	      js2.executeScript("window.scrollTo(0, 500)"); // Scroll up by 1000 pixels
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//span[@class='insertCommonInputField cursorPointer rounded-1 pt-2 overflow_text pe-4 dfg']")).click();
	      driver.findElement(By.xpath("//li[@class='cursorPointer w-100 px-2 border-bottom my-1'][2]")).click();

	      driver.findElement(By.xpath("(//span[@class='clear-button'])[4]")).click();
	      Thread.sleep(1000);
	     driver.findElement(By.xpath("(//span[@class='leadInputField cursorPointer rounded-1 pt-2 overflow_text pe-4'])[1]")).click();
	     driver.findElement(By.xpath("//li[@class='cursorPointer w-100 px-2 border-bottom my-1'][1]")).click();
	      
	     driver.findElement(By.xpath("//input[@name='billingStreet']")).sendKeys("Palace road"); 
	     driver.findElement(By.xpath("//input[@name='billingCity']")).sendKeys("Vatican City"); 
	     driver.findElement(By.xpath("//input[@name='billingState']")).sendKeys("Madhya Pradesh"); 
	     driver.findElement(By.xpath("//input[@name='billingCode']")).sendKeys("583216"); 
	     driver.findElement(By.xpath("//input[@name='billingCountry']")).sendKeys("Sri Lanka"); 
	     Thread.sleep(1000);

	     driver.findElement(By.xpath("//input[@name='shippingStreet']")).sendKeys("Church street"); 
	     driver.findElement(By.xpath("//input[@name='shippingCity']")).sendKeys("Hoovina Hadagali"); 
	     driver.findElement(By.xpath("//input[@name='shippingState']")).sendKeys("Andhra Pradesh"); 
	     driver.findElement(By.xpath("//input[@name='shippingCode']")).sendKeys("583215"); 
	     driver.findElement(By.xpath("//input[@name='shippingCountry']")).sendKeys("New India"); 
	     
	     
	     JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("window.scrollBy(0, 1000)"); // Scroll down by 1000 pixels
	     Thread.sleep(1000);

	     driver.findElement(By.xpath("//textarea[@name='termsAndConditions']")).sendKeys("jkhsdjkhfjjsdjfhsdkjfhewu ewrewiru ureurweur weuru"); 
	     driver.findElement(By.xpath("(//textarea[@name='description'])[2]")).sendKeys("jhd gdf dfljgklfdl gdfjglj dfjgjdflkgj");      
	     
	     JavascriptExecutor js1 = (JavascriptExecutor) driver;
	     js1.executeScript("window.scrollBy(0, -2000)"); // Scroll up by 1000 pixels
	     Thread.sleep(1000);	     
	     driver.findElement(By.xpath("//button[contains(text(),'Save')][2]")).click();	
	}
	
	@Test(priority=5)
	void Invoice_Edit_With_Without_Mandatory_fields() throws InterruptedException 
	{
		
		  driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
		  driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	      driver.findElement(By.xpath("//p[contains(text(),'Invoice')]")).click();
	      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
	      
	      driver.findElement(By.xpath("(//td[@class='overflow_text pe-1 leadName cursorPointer'])[2]")).click();
	      driver.findElement(By.xpath("//button[contains(text(),'Edit')]")).click();

	      driver.findElement(By.xpath("//span[@class='leadInputField cursorPointer rounded-1 pt-2']")).click();
	      driver.findElement(By.xpath("//li[@class='cursorPointer w-100 px-2 border-bottom my-1']")).click();
	      
	      WebElement Invoice_Subject= driver.findElement(By.xpath("//input[@name='subject']"));
	      Invoice_Subject.clear();
	      Invoice_Subject.sendKeys(generateRandomsubject());
	      
	      
	      WebElement Purchase_Order=driver.findElement(By.xpath("//input[@name='purchaseOrder']"));
	      Purchase_Order.clear();
	      Purchase_Order.sendKeys(generateRandompurchaseorder());
	      
	      driver.findElement(By.xpath("//input[@name='exciseDuty']")).clear();

	      driver.findElement(By.xpath("//input[@name='exciseDuty']")).sendKeys("456");
	      

	     // driver.findElement(By.xpath("//input[@name='salesCommission']")).clear();
	      
	      driver.findElement(By.xpath("//input[@name='salesCommission']")).sendKeys(Keys.CONTROL + "a");
	      driver.findElement(By.xpath("//input[@name='salesCommission']")).sendKeys(Keys.BACK_SPACE);
	      
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//input[@name='salesCommission']")).sendKeys("12");
	      Thread.sleep(2000);

	      
	    Thread.sleep(2000);
	      JavascriptExecutor js2 = (JavascriptExecutor) driver;      
	      js2.executeScript("window.scrollTo(0, 500)"); // Scroll up by 1000 pixels
	      Thread.sleep(2000);

	      driver.findElement(By.xpath("//span[@class='insertCommonInputField cursorPointer rounded-1 pt-2 overflow_text pe-4 dfg']")).click();
	      driver.findElement(By.xpath("//li[@class='cursorPointer w-100 px-2 border-bottom my-1'][3]")).click();
	      Thread.sleep(1000);
	     driver.findElement(By.xpath("(//span[@class='leadInputField cursorPointer rounded-1 pt-2 overflow_text pe-4'])[1]")).click();
	     driver.findElement(By.xpath("//li[@class='cursorPointer w-100 px-2 border-bottom my-1'][1]")).click();
	      
	     driver.findElement(By.xpath("//input[@name='billingStreet']")).clear(); 
	     driver.findElement(By.xpath("//input[@name='billingStreet']")).sendKeys("Ring road"); 
	     driver.findElement(By.xpath("//input[@name='billingCity']")).clear(); 

	     driver.findElement(By.xpath("//input[@name='billingCity']")).sendKeys("Bhagya Nagar"); 
	     
	     driver.findElement(By.xpath("//input[@name='billingState']")).clear(); 

	     driver.findElement(By.xpath("//input[@name='billingState']")).sendKeys("Arunachal Pradesh"); 
	     
	     driver.findElement(By.xpath("//input[@name='billingCode']")).clear(); 

	     driver.findElement(By.xpath("//input[@name='billingCode']")).sendKeys("583215"); 
	     
	     driver.findElement(By.xpath("//input[@name='billingCountry']")).clear(); 

	     
	     driver.findElement(By.xpath("//input[@name='billingCountry']")).sendKeys("Japan"); 
	     Thread.sleep(1000);

	     driver.findElement(By.xpath("//input[@name='shippingStreet']")).clear(); 
	     driver.findElement(By.xpath("//input[@name='shippingStreet']")).sendKeys("palk strait"); 
	     
	     driver.findElement(By.xpath("//input[@name='shippingCity']")).clear(); 
	     driver.findElement(By.xpath("//input[@name='shippingCity']")).sendKeys("Davangere"); 
	     
	     driver.findElement(By.xpath("//input[@name='shippingState']")).clear(); 
	     driver.findElement(By.xpath("//input[@name='shippingState']")).sendKeys("uttar Pradesh"); 
	     
	     driver.findElement(By.xpath("//input[@name='shippingCode']")).clear(); 
	     driver.findElement(By.xpath("//input[@name='shippingCode']")).sendKeys("583214"); 
	     
	     driver.findElement(By.xpath("//input[@name='shippingCountry']")).clear(); 

	     driver.findElement(By.xpath("//input[@name='shippingCountry']")).sendKeys("New Delhi"); 
	     
	     
	     JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("window.scrollBy(0, 1000)"); // Scroll down by 1000 pixels
	     Thread.sleep(1000);

	     driver.findElement(By.xpath("//textarea[@name='termsAndConditions']")).clear(); 
	     driver.findElement(By.xpath("(//textarea[@name='description'])[2]")).clear();      
	     
	     JavascriptExecutor js1 = (JavascriptExecutor) driver;
	     js1.executeScript("window.scrollBy(0, -2000)"); // Scroll up by 1000 pixels
	     Thread.sleep(1000);	     
	     driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();     

	}
	
	@Test(priority=6)
	void Invoice_Clone()
	{
		 
	      driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	      driver.findElement(By.xpath("//p[contains(text(),'Invoice')]")).click();
	      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
	     
	      
	      driver.findElement(By.xpath("(//td[@class='overflow_text pe-1 leadName cursorPointer'])[1]")).click();
	      driver.findElement(By.xpath("//button[@class='btn btn-secondary bg-white text-dark border border-primary'][2]")).click();
	      driver.findElement(By.xpath("//div[contains(text(),'Clone')]")).click();
		  driver.findElement(By.xpath("//button[contains(text(),'Save')][2]")).click();
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		     try {
		         // Try to capture the success message
		         WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
		             By.xpath("//h4[contains(text(),'Invoice information details added Succesfully')]")
		         ));
		         
		         // If success message is found, print it
		         System.out.println("Success message: " + successMessage.getText());
		     } catch (Exception e) {
		         // If no success message is found, try capturing any error message

		         try {
		             // Generic locator for any error message (modify based on actual HTML structure)
		             WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
		                 By.xpath("//h4[contains(@class, 'Something went wrong. Please try after sometime')]") // Replace with actual class or structure of error message
		             ));
		             
		             // Print the captured error message
		             System.out.println("Error message: " + errorMessage.getText());
		         } catch (Exception ex) {
		             System.out.println("No success or error message found.");
		         }
		     }
		  
	
	}
	@Test(priority=7)
	void Invoice_Share() 
	{
		  driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();

		driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
		  driver.findElement(By.xpath("//p[contains(text(),'Invoice')]")).click();
		  driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		
		
		  driver.findElement(By.xpath("(//td[@class='overflow_text pe-1 leadName cursorPointer'])[1]")).click();
		  driver.findElement(By.xpath("//button[@class='btn btn-secondary bg-white text-dark border border-primary'][2]")).click();
		  driver.findElement(By.xpath("//div[contains(text(),'Share')]")).click();
		  
		  try {
	          // Check if the 'Revoke' button is present on the page
	          List<WebElement> revokeButton = driver.findElements(By.xpath("//span[text()='Revoke Sharing']"));

	          if (revokeButton.size() > 0) {
	              // If the Revoke button is present, click it
	              revokeButton.get(0).click();
	              System.out.println("Revoke button clicked");
	              driver.findElement(By.xpath("//button[contains(text(),'Revoke')]")).click();
	              Thread.sleep(1000);
	        	  driver.findElement(By.xpath("//button[@class='btn btn-secondary bg-white text-dark border border-primary'][2]")).click();
	        	  driver.findElement(By.xpath("//div[contains(text(),'Share')]")).click();
	              
	        	  
	        	  driver.findElement(By.xpath("//span[contains(text(),'0 Users')]")).click();
	       	   driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
	       	   driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	       	   driver.findElement(By.xpath("//button[contains(text(),'Share')]")).click();
	       	   
	       	   
	       	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	       	   
	       	   try {
	       		   WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Shared successfully')]")));
	       		   // If success message is found, print it
	   		         System.out.println("Success message: " + successMessage.getText());
	       	   }catch(Exception e) {
	       		   System.out.println("No success or error message found.");
	       	   }      
	          } 
	           else {
	              // Continue with the rest of the script
	              System.out.println("Revoke button not found. Continuing with the rest of the code...");
	              
	              // Add the rest of your script here
	       	   driver.findElement(By.xpath("//span[contains(text(),'0 Users')]")).click();
	    	   driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
	    	   driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	    	   driver.findElement(By.xpath("//button[contains(text(),'Share')]")).click();
	    	   
	    	   
	    	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    	   
	    	   try {
	    		   WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Shared successfully')]")));
	    		   // If success message is found, print it
			         System.out.println("Success message: " + successMessage.getText());
	    	   }catch(Exception e) {
	    		   System.out.println("No success or error message found.");
	    	   }
	          }
	      } catch (Exception e) {
	          System.out.println("Error: " + e.getMessage());
	      }   
		
	}


	@Test(priority=8)
	void Invoice_Delete() 
	{
		  driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();

		driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
		driver.findElement(By.xpath("//p[contains(text(),'Invoice')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();


		driver.findElement(By.xpath("(//td[@class='overflow_text pe-1 leadName cursorPointer'])[1]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-secondary bg-white text-dark border border-primary'][2]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Delete')]")).click();

		driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

		try {
			WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Invoice details deleted successfully.')]")));
			// If success message is found, print it
			System.out.println("Success message: " + successMessage.getText());
		}catch(Exception e) {
			System.out.println("No success or error message found.");
		}      

		
		
	}
	
	@Test(priority=9)
	void Invoice_Delete_Click_on_Cancel_button() throws InterruptedException //And it navigate to Overview page
	{
		  driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();

		driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
		driver.findElement(By.xpath("//p[contains(text(),'Invoice')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();


		driver.findElement(By.xpath("(//td[@class='overflow_text pe-1 leadName cursorPointer'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-secondary bg-white text-dark border border-primary'][2]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Delete')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
        Thread.sleep(2000);
		try {

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));    

			WebElement overviewElement = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Overview')]")));  // Replace with actual ID or locator

			System.out.println("Navigated to Overview page successfully.");

		} catch (Exception e) {
			System.out.println("Error: " + "Other page is displayed");
		}		
	}	
}
