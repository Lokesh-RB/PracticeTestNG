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
    public static String generateRandomCity() {
    	String[] City= {"Vatican City","Huvina Hadagali","Davangere","Bangalore"};
    	Random random=new Random();
    	return City[random.nextInt(City.length)];
    	
    }
    public static String generateRandomBillingStreet() {
    	String[] MESSAGE_ELEMENTS= {"Palace road", "Church  road", "Palk street", "HSR Layout"};
    	Random random= new Random();
    	return MESSAGE_ELEMENTS[random.nextInt(MESSAGE_ELEMENTS.length)];
    	
    }
    public static String generateRandomCode() {
    	String[]Code= {"583216","583215","583214","583213"};
    	Random random=new Random();
    	return Code[random.nextInt(Code.length)];
    			
    }
    
    public static String generateRandomCountry() {
    	String[] Country= {"New India","Japan","Sri Lanka","Saudi Arabia"};
    	Random random=new Random();
    	return Country[random.nextInt(Country.length)];
    }
    
    public static String generateRandomState() {
    	String[] State= {"Karnataka","Andhra Pradesh","Arunachal Pradesh","Madhya Pradesh"};
    	Random random=new Random();
    	return State[random.nextInt(State.length)];
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
  
    public static String generateRandomExciseduty() 
    {
    	String[]MESSAGE_ELEMENTS= {"102","50","564","345"};
    	Random random=new Random();
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
	
	/*
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
	
	@Test(priority=10)
	void Invoice_Mass_Delete() 
	{
	      driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
		  driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	      driver.findElement(By.xpath("//p[contains(text(),'Invoice')]")).click();
		
	      driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
	      driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click();
	      driver.findElement(By.xpath("(//input[@id='vehicle1'])[2]")).click();
	      driver.findElement(By.xpath("(//input[@id='vehicle1'])[3]")).click();
	      driver.findElement(By.xpath("(//input[@id='vehicle1'])[4]")).click();
	      
	      driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
  	  driver.findElement(By.xpath("//div[contains(text(),'Mass Delete')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
		
		

 	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
 	   
 	   try {
 		   WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Deletion successful')]")));
 		   // If success message is found, print it
		         System.out.println("Success message: " + successMessage.getText());
 	   }catch(Exception e) {
 		   System.out.println("No success or error message found.");
 	   }	    		
 }
		
	@Test(priority=11)
	void Invoice_Mass_Transfer() throws InterruptedException
	{
	      driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
		  driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	      driver.findElement(By.xpath("//p[contains(text(),'Invoice')]")).click();
		
	      driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
	      driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click();
	      driver.findElement(By.xpath("(//input[@id='vehicle1'])[2]")).click();
	      driver.findElement(By.xpath("(//input[@id='vehicle1'])[3]")).click();
	      driver.findElement(By.xpath("(//input[@id='vehicle1'])[4]")).click();
	      
	      driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	      driver.findElement(By.xpath("//div[contains(text(),'Mass Transfer')]")).click();
		  
	      driver.findElement(By.xpath("//img[@src='/static/media/user-search-01.f7897915c904c53cc76c49ced9419915.svg']")).click();
  		
  		
  		// WebDriverWait wait = new WebDriverWait(driver, 10);
      WebElement name =driver.findElement(By.xpath("//span[contains(text(),'Lokesh RB')]"));
      Thread.sleep(1000);

      String currentname=name.getText();
      Thread.sleep(1000);
      if(currentname.equals("BaahuBali Indra"))
      {
          Thread.sleep(1000);

      	driver.findElement(By.xpath("//td[contains(text(),'lokeshrb@mailinator.com')]")).click();
      	
      }
      else {
          Thread.sleep(1000);

      	driver.findElement(By.xpath("//td[contains(text(),'Prasanavarma123@mailinator.com')]")).click();
      }
      Thread.sleep(1000);

      driver.findElement(By.xpath("(//button[contains(text(),'Done')])[2]")).click();
      Thread.sleep(1000);

	        driver.findElement(By.xpath("//button[contains(text(),'Done')]")).click();
      	}
		
	@Test(priority=12)
	void Invoice_Individual_Edit() throws InterruptedException
	{
	      driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
		  driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	      driver.findElement(By.xpath("//p[contains(text(),'Invoice')]")).click();
      	  driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();

	      driver.findElement(By.xpath("(//td[@class='overflow_text pe-1 leadName cursorPointer'])[1]")).click();
	      Thread.sleep(1000);
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("window.scrollTo(0,500)");
		  Thread.sleep(2000);
	      
		 WebElement SubIn= driver.findElement(By.xpath("//input[@name='subjectInfo']"));
		 SubIn.click();
		 SubIn.clear();
		 SubIn.sendKeys(generateRandomsubject());
		 Thread.sleep(500);
		 driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();
		 Thread.sleep(500);
		 
		WebElement sales=driver.findElement(By.xpath("//input[@name='salesCommissionInfo']"));
		sales.click();
		sales.clear();
		 Thread.sleep(500);
		 sales.sendKeys(generateRandomExciseduty());
		 Thread.sleep(500);
		 driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();
		 Thread.sleep(500);
		 
		WebElement ranPurcOrd=driver.findElement(By.xpath("//input[@name='purchaseOrderInfo']"));
		ranPurcOrd.click();
		ranPurcOrd.clear();
		ranPurcOrd.sendKeys(generateRandompurchaseorder());
		 Thread.sleep(500);
		 driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();
		 Thread.sleep(500);
		 
		 WebElement	Execise= driver.findElement(By.xpath("//input[@name='exciseDutyInfo']"));
		 Execise.click();
		 Execise.clear();
		 Thread.sleep(500);
		 Execise.sendKeys(generateRandomExciseduty());
		 Thread.sleep(500);
		 driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();
		 Thread.sleep(500);
		 
		 //Address Info
		 Thread.sleep(2000);
 		JavascriptExecutor js1= (JavascriptExecutor)driver;
 		js1.executeScript("window.scrollTo(0,900)");
 		 Thread.sleep(2000);
 		
 		WebElement street=driver.findElement(By.xpath("//input[@name='billingStreetInfo']"));
		 street.click();
		 street.clear();
 		street.sendKeys(generateRandomBillingStreet());
 		driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();
 		Thread.sleep(1000);
 		
 		WebElement city=driver.findElement(By.xpath("//input[@name='billingCityInfo']"));
 		city.click();
 		city.clear();
 		city.sendKeys(generateRandomCity());
 		driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();

 		Thread.sleep(1000);

 		WebElement state=driver.findElement(By.xpath("//input[@name='billingStateInfo']"));
 		state.click();
 		state.clear();
 		state.sendKeys(generateRandomState());
 		driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();

 		Thread.sleep(1000);

 		WebElement code=driver.findElement(By.xpath("//input[@name='billingCodeInfo']"));
 		code.click();
 		code.clear();
 		code.sendKeys(generateRandomCode());
 		driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();

 		Thread.sleep(1000);

 		WebElement country=driver.findElement(By.xpath("//input[@name='billingCountryInfo']"));
 		country.click();
 		country.clear();
 		country.sendKeys(generateRandomCountry());
 		driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();

 		
 		//Shipping 
 		Thread.sleep(1000);

 		WebElement street1=driver.findElement(By.xpath("//input[@name='shippingStreetInfo']"));
 		street1.click();
 		street1.clear();
 		street1.sendKeys(generateRandomBillingStreet());
 		driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();

 		Thread.sleep(1000);

 		WebElement city1=driver.findElement(By.xpath("//input[@name='shippingCityInfo']"));
 		city1.click();
 		city1.clear();
 		city1.sendKeys(generateRandomCity());
 		driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();

 		Thread.sleep(1000);

 		WebElement state1=driver.findElement(By.xpath("//input[@name='shippingStateInfo']"));
 		state1.click();
 		state1.clear();
 		state1.sendKeys(generateRandomState());
 		driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();

 		Thread.sleep(1000);

 		WebElement code1=driver.findElement(By.xpath("//input[@name='shippingCodeInfo']"));
 		code1.click();
 		code1.clear();
 		code1.sendKeys(generateRandomCode());
 		driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();

 		Thread.sleep(1000);

 		WebElement country1=driver.findElement(By.xpath("//input[@name='shippingCountryInfo']"));
 		country1.click();
 		country1.clear();
 		country1.sendKeys(generateRandomCountry());
 		driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();

 		Thread.sleep(1000);	 
	}
	
	
	@Test(priority=13)
	void Invoice_Note() throws InterruptedException
	{
	  driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
	  driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
      driver.findElement(By.xpath("//p[contains(text(),'Invoice')]")).click();
	  driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();

      driver.findElement(By.xpath("(//td[@class='overflow_text pe-1 leadName cursorPointer'])[1]")).click();
      Thread.sleep(1000);
	 
      driver.findElement(By.xpath("//li[contains(text(),'Notes')]")).click();
	    Thread.sleep(1000);

	    driver.findElement(By.xpath("//textarea[@class='notesClass']")).click();
	    driver.findElement(By.xpath("//textarea[@class='notesClass']")).sendKeys("dss efewfewfd ");
	    
	    driver.findElement(By.xpath("//input[@placeholder='Add Title']")).sendKeys("rty rtytyrty ");
	    
		
   	String filepath= "C:\\Users\\Lokesh R B\\Desktop\\New Docx\\sa1.jpg";
   	WebElement fileinput=driver.findElement(By.xpath("(//input[@type='file'])"));
   	fileinput.sendKeys(filepath);         	
    	driver.findElement(By.xpath("//button[@class='editNoteButton']")).click(); 
	    
	}	
	
	
	@Test(priority=14)
	void Invoice_Edit_Note() throws InterruptedException
	{
	  driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
	  driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
      driver.findElement(By.xpath("//p[contains(text(),'Invoice')]")).click();
	  driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();

      driver.findElement(By.xpath("(//td[@class='overflow_text pe-1 leadName cursorPointer'])[1]")).click();
      Thread.sleep(1000);
	 
      driver.findElement(By.xpath("//li[contains(text(),'Notes')]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(//button[@class='editNoteButton'])[1]")).click();
	    driver.findElement(By.xpath("//textarea[@class='notesClass']")).click();
	    driver.findElement(By.xpath("//textarea[@class='notesClass']")).clear();
	    driver.findElement(By.xpath("//textarea[@class='notesClass']")).sendKeys("dss efewfewfd ");
	    driver.findElement(By.xpath("//input[@placeholder='Add Title']")).clear();
	    driver.findElement(By.xpath("//input[@placeholder='Add Title']")).sendKeys("rty rtytyrty ");        	
      	driver.findElement(By.xpath("(//button[@class='editNoteButton'])[2]")).click();	
	}
	*/
	
	@Test(priority=15)
	void Invoice_Edit_With_Without_Mandatory_fields() throws InterruptedException 
	{
		
		  driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
		  driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	      driver.findElement(By.xpath("//p[contains(text(),'Invoice')]")).click();
	      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
	      
	      driver.findElement(By.xpath("(//td[@class='overflow_text pe-1 leadName cursorPointer'])[2]")).click();
	      driver.findElement(By.xpath("//button[contains(text(),'Edit')]")).click();

       	JavascriptExecutor js5=(JavascriptExecutor)driver;
       	js5.executeScript("window.scrollTo(0,1400)");
       	Thread.sleep(2000);
       	
       	driver.findElement(By.xpath("(//input[@type='number'])[2]")).sendKeys("10");
     	driver.findElement(By.xpath("(//input[@type='number'])[2]")).sendKeys("5");

     	driver.findElement(By.xpath("//span[@class='cursorPointer']")).click();
     	driver.findElement(By.xpath("//input[@name='percentage']")).sendKeys("23");
     	driver.findElement(By.xpath("//button[.='Done']")).click();
     	
     	driver.findElement(By.xpath("//button[.='Add Row']")).click();
     	driver.findElement(By.xpath("(//input[@type='number'])[2]")).sendKeys("10");
     	driver.findElement(By.xpath("(//input[@type='number'])[2]")).sendKeys("5");

     	driver.findElement(By.xpath("//span[@class='cursorPointer']")).click();
     	driver.findElement(By.xpath("//input[@name='percentage']")).sendKeys("23");
     	driver.findElement(By.xpath("//button[.='Done']")).click();    	

     	JavascriptExecutor js6=(JavascriptExecutor)driver;
     	js6.executeScript("window.scrollTo(0,-1400)");
     	Thread.sleep(1000);
    
     	driver.findElement(By.xpath("//button[.='Update']")).click();
    
     	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    	   
	    	   try {
	    		   WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Shared successfully')]")));
	    		   // If success message is found, print it
			         System.out.println("Success message: " + successMessage.getText());
	    	   }catch(Exception e) {
	    		   System.out.println("No success or error message found.");
	    	   }
	    	   
	    	   
	    	   
	}
	
	
	
	
	
	
	
	
	
}