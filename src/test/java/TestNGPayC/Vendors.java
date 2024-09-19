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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Vendors

{
	  
	
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
	

	/*
	@Test(priority=3)
	void Create_Vendor() 
	{	     
	
		 driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
		    JavascriptExecutor js = (JavascriptExecutor) driver;

		    // Scroll down by a specified number of pixels (e.g., 1000 pixels)
		    js.executeScript("window.scrollBy(0, 1000)");
		    driver.findElement(By.xpath("//p[contains(text(),'Vendors')]")).click();
		    driver.findElement(By.xpath("//button[contains(text(),'Create Vendor')]")).click();
		    
		    
		    WebElement company_name=driver.findElement(By.xpath("//input[@name='vendorName']"));
		    company_name.sendKeys(generateRandomCompanyName());
		    
		    driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9887867899");
		    driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys("guru@mailinator.com");
		    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

	}
	@Test(priority=4)
	void Edit_Vendor() throws InterruptedException 
	{	     
	

	      driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	      
	      driver.findElement(By.xpath("//p[contains(text(),'Vendors')]")).click();
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
	      Thread.sleep(2000);
	      
	      driver.findElement(By.xpath("(//td[@class='overflow_text vendorName cursorPointer'])[4]")).click();
	      driver.findElement(By.xpath("//button[contains(text(),'Edit')]")).click();
	      driver.findElement(By.xpath("//input[@name='phone']")).clear();
	      driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9887867890");
	      driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();

	}
	

	@Test(priority=5)
	void Clone_Vendor() throws InterruptedException
	{	     
	
	      Thread.sleep(2000);

	      driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	      driver.findElement(By.xpath("//p[contains(text(),'Vendors')]")).click();
	      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();

	    //  driver.findElement(By.xpath("//td[contains(text(),'Microsoft')]")).click();
	      driver.findElement(By.xpath("(//td[@class='overflow_text vendorName cursorPointer'])[4]")).click();
	                   //Clone
	    driver.findElement(By.xpath("//button[@class='btn btn-secondary bg-white text-dark border border-primary']")).click();
	    driver.findElement(By.xpath("//div[contains(text(),'Clone')]")).click();
	    driver.findElement(By.xpath("//button[contains(text(),'Save')][2]")).click();
	    Thread.sleep(2000);

	}
	

	@Test(priority=6)
	void Share_Vendor() throws InterruptedException
	{	     
	
	      driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//p[contains(text(),'Vendors')]")).click();
	      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
	      
	      driver.findElement(By.xpath("(//td[@class='overflow_text vendorName cursorPointer'])[4]")).click();
	      
	      driver.findElement(By.xpath("//button[@class='btn btn-secondary bg-white text-dark border border-primary']")).click();
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
	
	
	@Test(priority=7)
	void Vendor_Notes() throws InterruptedException
	{	
		Thread.sleep(2000);
		  driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	      driver.findElement(By.xpath("//p[contains(text(),'Vendors')]")).click();
	      driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
	      driver.findElement(By.xpath("(//td[@class='overflow_text vendorName cursorPointer'])[1]")).click();
	      
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
	@Test(priority=8)
	void Vendor_Edit_Notes() throws InterruptedException
	{	
		 driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	      driver.findElement(By.xpath("//p[contains(text(),'Vendors')]")).click();
	      
	      JavascriptExecutor  js=(JavascriptExecutor)driver;
          js.executeScript("window.scrollTo(0,-500)");	
          
          Thread.sleep(2000);
	      driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
	      driver.findElement(By.xpath("(//td[@class='overflow_text vendorName cursorPointer'])[1]")).click();
	      
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
	
	@Test(priority=9)
	void Vendor_Add_Product() throws InterruptedException
	{
		Thread.sleep(2000);
		  driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	      driver.findElement(By.xpath("//p[contains(text(),'Vendors')]")).click();
	      driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
	      driver.findElement(By.xpath("(//td[@class='overflow_text vendorName cursorPointer'])[1]")).click();
	      
	      driver.findElement(By.xpath("//li[contains(text(),'Products')]")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//button[contains(text(),'Add Product')]")).click();
			  Thread.sleep(500);
		      driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		      Thread.sleep(500);
		      driver.findElement(By.xpath("//button[@class='createContactButtonSave modalButton']")).click();
		      
		      WebDriverWait waiti=new WebDriverWait(driver,Duration.ofSeconds(10));
		      try {
		    	 WebElement successMessageu= waiti.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Relation added successfully')]")));
		     System.out.println("Success message:"+ successMessageu.getText());
		      
		      
		      }
		      catch(Exception e) {
		    	  System.out.println("No success or error message found.");
		      }   
	}
	
		      @Test(priority=10)
		  	void Vendor_Delete_Product() throws InterruptedException
		  	{
		  		Thread.sleep(2000);
		  		driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
				  driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
			      driver.findElement(By.xpath("//p[contains(text(),'Vendors')]")).click();
			      driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
			      driver.findElement(By.xpath("(//td[@class='overflow_text vendorName cursorPointer'])[1]")).click();
			      
			      driver.findElement(By.xpath("//li[contains(text(),'Products')]")).click();
				    Thread.sleep(1000);
				    WebElement elementToHover = driver.findElement(By.xpath("(//td[@class='productsTabledata'])[1]"));

				    // Create an instance of the Actions class
				    Actions actions = new Actions(driver);

				    // Perform the mouseover action
				    actions.moveToElement(elementToHover).perform();
				    
				   driver.findElement(By.xpath("//img[@src='/static/media/cancelCircle.c747dde62c761eecec2bc34ab981fb41.svg']")).click();			
				        Thread.sleep(500);
				        driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
						
				        WebDriverWait waiti = new WebDriverWait(driver, Duration.ofSeconds(10));
				        try {
				            WebElement successMessageu = waiti.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Relation removed successfully')]")));
				            System.out.println("Success message: " + successMessageu.getText());
				        } catch (Exception e) {
				            System.out.println("No success or error message found.");
				        }
				    } 
				
	
		  	
	
	
	
	
	
	
	
}