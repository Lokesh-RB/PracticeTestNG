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
  public static String generateRandomTeam() {
       	
       	String[] Team= {"Backend","Frontend","Data Base","Testing"};
       	Random random=new Random();
       	return Team[random.nextInt(Team.length)];
       }
  
  public static String generateRandomDept() {
     	
     	String[] Team= {"Finance","Marketing","Technical","Executive"};
     	Random random=new Random();
     	return Team[random.nextInt(Team.length)];
     }
    
    public static String generateRandomAmount() {
    	String[]MESSAGE_ELEMENTS= {"112","342","536","748"};
    	Random random=new Random();
    	return MESSAGE_ELEMENTS[random.nextInt(MESSAGE_ELEMENTS.length)];
    }
    
    public static String generateRandomCountry() {
    	String[] Country= {"New India","Japan","Sri Lanka","Saudi Arabia"};
    	Random random=new Random();
    	return Country[random.nextInt(Country.length)];
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
    public static String generateRandomState() {
    	String[] State= {"Karnataka","Andhra Pradesh","Arunachal Pradesh","Madhya Pradesh"};
    	Random random=new Random();
    	return State[random.nextInt(State.length)];
    }
    // Static method to generate a random name
    public static String generateRandompurchaseorder() {
        String[] MESSAGE_ELEMENTS = {"New Invoice", "Critical", "Major", "Teamout", "Minor", "Blocker", "Listeners", "Selenium", "Download", "Market"};
        Random random = new Random();
        return MESSAGE_ELEMENTS[random.nextInt(MESSAGE_ELEMENTS.length)];
    }
    public static String generateRandomCity() {
    	String[] City= {"Vatican City","Huvina Hadagali","Davangere","Bangalore"};
    	Random random=new Random();
    	return City[random.nextInt(City.length)];
    	
    }
    
    public static String geneateRandomMobile() {
    	String[] MESSAGE_ELEMENTS= {"9877889966","9997889966","8877889966","9877229966"};
    	Random random=new Random();
    	return MESSAGE_ELEMENTS[random.nextInt(MESSAGE_ELEMENTS.length)];
    }
    
    
    public static String geneateRandomcategory() {
    	String[] MESSAGE_ELEMENTS= {"Loading","Live aplication","Inorm him","Priority"};
    	Random random=new Random();
    	return MESSAGE_ELEMENTS[random.nextInt(MESSAGE_ELEMENTS.length)];
    }
    public static String generateRandomTermsConditions() {
    	String[] Terms_Conditions= {"New Terms and Cnditions", "Different Terms and Conditions","Important Terms Conditions","Random Terms and Conditions"};
   Random random=new Random();
   return Terms_Conditions[random.nextInt(Terms_Conditions.length)];
    }
    
    public static String generateRandomDescription() {
    	String[] Description= {"A quote is a direct repetition or reproduction of someone else's words, typically with an acknowledgment of the original source. It can capture ideas, wisdom, or expressions from literature, speeches, interviews, or everyday conversations.", "Quotes are often used to support an argument, convey inspiration, or highlight significant viewpoints. They are usually enclosed in quotation marks and must be attributed correctly to the author or speaker to maintain authenticity and respect intellectual property."};
  Random random=new Random();
  return Description[random.nextInt(Description.length)];
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
	
	
	@Test(priority=9)
	void Vendor_Add_Product() throws InterruptedException
	{
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
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
			
			
	
	   @Test(priority=10)
	  	void Vendor_Mass_Transfer() throws InterruptedException
	  	{
		      Thread.sleep(2000);
	  	      driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
			  driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Vendors')]")).click();
		      driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
	
	          driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click(); 
	          driver.findElement(By.xpath("(//input[@id='vehicle1'])[2]")).click();
	        	driver.findElement(By.xpath("(//input[@id='vehicle1'])[3]")).click();
	        	driver.findElement(By.xpath("(//input[@id='vehicle1'])[4]")).click();	      
	        	
	        	driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	    		driver.findElement(By.xpath("//div[contains(text(),'Mass Transfer')]")).click();
	    		driver.findElement(By.xpath("//img[@src='/static/media/user-search-01.f7897915c904c53cc76c49ced9419915.svg']")).click();
	    		
	    		
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

	         driver.findElement(By.xpath("//button[contains(text(),'Done')]")).click();
             Thread.sleep(1000);

		        driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
	        	}
	       	
	   
	   @Test(priority=12)
	  	void Vendor_Mass_Delete() throws InterruptedException
	  	{
		      Thread.sleep(2000);
	  	      driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
			  driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Vendors')]")).click();
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
	   
	  @Test(priority=13)
	  	void Vendor_Mass_Update() throws InterruptedException
	  	{
		      Thread.sleep(2000);
	  	      driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
			  driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Vendors')]")).click();
		      driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
	
	          driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click(); 
	          driver.findElement(By.xpath("(//input[@id='vehicle1'])[2]")).click();
	          driver.findElement(By.xpath("(//input[@id='vehicle1'])[3]")).click();
	          driver.findElement(By.xpath("(//input[@id='vehicle1'])[4]")).click();	      
	        	
	          driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	    	  driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	          Thread.sleep(500);
	          
	          WebElement	Vname = driver.findElement(By.xpath("//input[@id='massValue']"));
	         Vname.sendKeys(generateRandompurchaseorder());
             Thread.sleep(500);
             driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click(); 
             Thread.sleep(500);

             driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click(); 
             driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	    	  driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	          Thread.sleep(500);
             
	          driver.findElement(By.xpath("//button[@id='mass-dropdown']")).click();
	             Thread.sleep(500);
	             
	           WebElement  Vemail =driver.findElement(By.xpath("//a[contains(text(),'Email')]"));
	           Vemail.click();
	          driver.findElement(By.xpath("//input[@id='massValue']")).sendKeys(generateRandommail()+"mailinator.com");
	           Thread.sleep(500);
	          
             driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
             Thread.sleep(500);
            
             driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click(); 
             driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	    	  driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	          Thread.sleep(500);
             
	          driver.findElement(By.xpath("//button[@id='mass-dropdown']")).click();
	             Thread.sleep(500);
	             
           WebElement  VPhone =driver.findElement(By.xpath("//a[contains(text(),'Phone')]"));
           VPhone.click();
           driver.findElement(By.xpath("//input[@id='massValue']")).sendKeys(geneateRandomMobile());
           Thread.sleep(500);
           
           driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click(); 
           Thread.sleep(500);
           driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click(); 
           driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	    	  driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	          Thread.sleep(500);
           
	          driver.findElement(By.xpath("//button[@id='mass-dropdown']")).click();
	             Thread.sleep(500);
	             driver.findElement(By.xpath("//a[contains(text(),'Website')]")).click();
	             
	             
	             driver.findElement(By.xpath("//input[@id='massValue']")).sendKeys("www.google.com");
           Thread.sleep(500);
           driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
          
           Thread.sleep(500); 
           driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click(); 
           driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	       driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	       Thread.sleep(500);
           
	       driver.findElement(By.xpath("//button[@id='mass-dropdown']")).click();
	       Thread.sleep(500);
  
           WebElement  Vcategory =driver.findElement(By.xpath("//a[contains(text(),'Category')]"));
           Vcategory.click();
           driver.findElement(By.xpath("//input[@id='massValue']")).sendKeys(geneateRandomcategory());
           Thread.sleep(500);
           driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
           Thread.sleep(500);
           
           
           driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click(); 
           driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	       driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	       Thread.sleep(500);
           
	       driver.findElement(By.xpath("//button[@id='mass-dropdown']")).click();
	       Thread.sleep(500);
  
           WebElement  Vcountry =driver.findElement(By.xpath("//a[contains(text(),'Country')]"));
           Vcountry.click();
           driver.findElement(By.xpath("//input[@id='massValue']")).sendKeys(generateRandomCountry());
           Thread.sleep(500);
           driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
           Thread.sleep(500);
           
           driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click(); 
           driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	       driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	       Thread.sleep(500);
           
	       driver.findElement(By.xpath("//button[@id='mass-dropdown']")).click();
	       Thread.sleep(500);
  
           WebElement  Vstate =driver.findElement(By.xpath("//a[contains(text(),'State')]"));
           Vstate.click();
           driver.findElement(By.xpath("//input[@id='massValue']")).sendKeys(generateRandomState());
           Thread.sleep(500);
           driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
           Thread.sleep(500);
           
           driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click(); 
           driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	       driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	       Thread.sleep(500);
           
	       driver.findElement(By.xpath("//button[@id='mass-dropdown']")).click();
	       Thread.sleep(500);
  
           WebElement  Vcity =driver.findElement(By.xpath("//a[contains(text(),'City')]"));
           Vcity.click();
           driver.findElement(By.xpath("//input[@id='massValue']")).sendKeys(generateRandomCity());
           Thread.sleep(500);
           driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
           Thread.sleep(500);
           
           
           driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click(); 
           driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	       driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	       Thread.sleep(500);
           
	       driver.findElement(By.xpath("//button[@id='mass-dropdown']")).click();
	       Thread.sleep(500);
  
           WebElement  Vstreet =driver.findElement(By.xpath("//a[contains(text(),'street')]"));
           Vstreet.click();
           driver.findElement(By.xpath("//input[@id='massValue']")).sendKeys(generateRandomBillingStreet());
           Thread.sleep(500);
           driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
           Thread.sleep(500);
           
           
           driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click(); 
           driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	       driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	       Thread.sleep(500);
           
	       driver.findElement(By.xpath("//button[@id='mass-dropdown']")).click();
	       Thread.sleep(500);
  
           WebElement  VZipcode =driver.findElement(By.xpath("//a[contains(text(),'Zip Code')]"));
           VZipcode.click();
           driver.findElement(By.xpath("//input[@id='massValue']")).sendKeys(generateRandomCode());
           Thread.sleep(500);
           driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
           Thread.sleep(500);
           
           driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click(); 
           driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	       driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	       Thread.sleep(500);
           
	       driver.findElement(By.xpath("//button[@id='mass-dropdown']")).click();
	       Thread.sleep(500);
  
           WebElement  VGLaccount =driver.findElement(By.xpath("//a[contains(text(),'GL Account')]"));
           VGLaccount.click();
           driver.findElement(By.xpath("//div[@class=' css-16rszb6-control']")).click();
           driver.findElement(By.xpath("//div[contains(text(),'Interest Income')]")).click();
           Thread.sleep(500);
           driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
       
	  	}
	  
	
	 @Test(priority=14)
	  	void Vendor_Individual_Edit() throws InterruptedException
	  	{
		      Thread.sleep(2000);
	  	      driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
			  driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Vendors')]")).click();
		      driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
	
		      driver.findElement(By.xpath("(//td[@class='overflow_text vendorName cursorPointer'])[1]")).click();
		      Thread.sleep(500);

		      WebElement VIPhone=driver.findElement(By.xpath("//input[@name='vendorInfoPhone']"));
		      VIPhone.click();
		      VIPhone.clear();
		      VIPhone.sendKeys(geneateRandomMobile());
		      Thread.sleep(500);  	
		      driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();
		      
		      Thread.sleep(500); 
		      WebElement VIWebsite=driver.findElement(By.xpath("//input[@name='vendorInfoWebsite']"));
		      VIWebsite.click();
		      VIWebsite.clear();
		      VIWebsite.sendKeys("www.facebok.com");
		      Thread.sleep(500);  	
		      driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();
		      
		      
//		    WebElement acc =driver.findElement(By.xpath("(//img[@src='/static/media/Account.f388005f1034c11a12f47b06093bd16e.svg'])[2]"));
//		  	Actions ac = new Actions(driver);
//		  	ac.moveToElement(acc).perform();
		      
		      Thread.sleep(500); 
		      WebElement VICategory=driver.findElement(By.xpath("//input[@name='vendorInfoCategory']"));
		      VICategory.click();
		      VICategory.clear();
		      VICategory.sendKeys(geneateRandomcategory());
		      Thread.sleep(500);  	
		      driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click(); 
		      
		      Thread.sleep(500); 
		      WebElement VIName=driver.findElement(By.xpath("//input[@name='vendorName']"));
		      VIName.click();
		      VIName.clear();
		      VIName.sendKeys(generateRandompurchaseorder());
		      Thread.sleep(500);  	
		      driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click(); 
		      
		      Thread.sleep(500); 
		      WebElement VIemail=driver.findElement(By.xpath("//input[@name='vendorInfoEmail']"));
		      VIemail.click();
		      VIemail.clear();
		      VIemail.sendKeys(generateRandommail()+"mailinator.com");
		      Thread.sleep(500);  	
		      driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click(); 
		      Thread.sleep(500); 
		      
		      Thread.sleep(500); 
		      WebElement VIGLacc=driver.findElement(By.xpath("//input[@name='glAccount']"));
		      VIGLacc.click();
		      driver.findElement(By.xpath("//div[@class=' css-qav5hl-singleValue']")).click();
		      Thread.sleep(500);    
		      driver.findElement(By.xpath("//div[contains(text(),'Rental Income')]")).click();
		      Thread.sleep(500);
		      driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click(); 
		      Thread.sleep(500); 
		      
		      Thread.sleep(500); 
		      WebElement VIStreet=driver.findElement(By.xpath("//input[@name='vendorInfoStreet']"));
		      VIStreet.click();
		      VIStreet.clear();		      
		      VIStreet.sendKeys(generateRandomBillingStreet());
		      driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();
		      
		      Thread.sleep(500); 
		      WebElement VICity=driver.findElement(By.xpath("//input[@name='vendorInfoCity']"));
		      VICity.click();
		      VICity.clear();		      
		      VICity.sendKeys(generateRandomCity());
		      driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();
		      
		      Thread.sleep(500); 
		      WebElement VIZipcode=driver.findElement(By.xpath("//input[@name='vendorInfoZipCode']"));
		      VIZipcode.click();
		      VIZipcode.clear();		      
		      VIZipcode.sendKeys(generateRandomCode());
		      driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();
		      
		      Thread.sleep(500); 
		      WebElement VIState=driver.findElement(By.xpath("//input[@name='vendorInfoState']"));
		      VIState.click();
		      VIState.clear();		      
		      VIState.sendKeys(generateRandomState());
		      driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();
		      
		      Thread.sleep(500); 
		      WebElement VICountry=driver.findElement(By.xpath("//input[@name='vendorInfoCountry']"));
		      VICountry.click();
		      VICountry.clear();		      
		      VICountry.sendKeys(generateRandomCountry());
		      driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();     
	  	}
	  	
	  	*/

	 @Test(priority=15)
	  	void Vendor_New_Purchase_Order_Related_List() throws InterruptedException
	  	{
		  Thread.sleep(2000);
 	      driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
		  driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	      driver.findElement(By.xpath("//p[contains(text(),'Vendors')]")).click();
	      driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();

	      driver.findElement(By.xpath("(//td[@class='overflow_text vendorName cursorPointer'])[1]")).click();
	      Thread.sleep(500);
	      driver.findElement(By.xpath("//li[.='Purchase Orders']")).click();
	      Thread.sleep(500);
	      
	      driver.findElement(By.xpath("(//button[.='New'])[1]")).click();
	      Thread.sleep(1000);
		 
	      WebElement Psub=driver.findElement(By.xpath("//input[@name='subject']"));
	      Psub.sendKeys(generateRandomsubject());
	      Thread.sleep(500);	 
		 
	      driver.findElement(By.xpath("//input[@name='requisitionNumber']")).sendKeys("123");
	      Thread.sleep(500);
	      driver.findElement(By.xpath("(//img[@src='/static/media/Contact.5fe67bb258d810fb72df1f441373b84c.svg'])[2]")).click();
	      Thread.sleep(500);
	      driver.findElement(By.xpath("//td[contains(text(),'testing@mailinator.com')]")).click();
	      driver.findElement(By.xpath("//button[contains(text(),'Done')]")).click();
	      

	      
	      WebElement PAmount= driver.findElement(By.xpath("//input[@name='exciseDuty']"));
          PAmount.sendKeys(generateRandomAmount());
          driver.findElement(By.xpath("(//div[@class=' css-qav5hl-singleValue'])[2]")).click();
          Thread.sleep(500);
          driver.findElement(By.xpath("//div[.='Approved']")).click();

          WebElement PPOnumber= driver.findElement(By.xpath("//input[@name='exciseDuty']"));
          PPOnumber.sendKeys(geneateRandomMobile());
          
 	     WebElement PPo= driver.findElement(By.xpath("//input[@name='poNumber']"));
 	     PPo.sendKeys(generateRandomAmount());
          
          WebElement Ptrack=driver.findElement(By.xpath("//input[@name='trackingNumber']"));
          Ptrack.sendKeys(generateRandomAmount());
          
          WebElement Psales=driver.findElement(By.xpath("//input[@name='salesCommission']"));
          Psales.sendKeys(generateRandomAmount());
          
  		
 		 Thread.sleep(2000);
 		JavascriptExecutor js1= (JavascriptExecutor)driver;
 		js1.executeScript("window.scrollTo(0,500)");
 		 Thread.sleep(2000);
 		
 		WebElement street=driver.findElement(By.xpath("//input[@name='billingStreet']"));
 		street.sendKeys(generateRandomBillingStreet());
 		Thread.sleep(1000);
 		
 		WebElement city=driver.findElement(By.xpath("//input[@name='billingCity']"));
 		city.sendKeys(generateRandomCity());
 		Thread.sleep(1000);

 		WebElement state=driver.findElement(By.xpath("//input[@name='billingState']"));
 		state.sendKeys(generateRandomState());
 		Thread.sleep(1000);

 		WebElement code=driver.findElement(By.xpath("//input[@name='billingCode']"));
 		code.sendKeys(generateRandomCode());
 		Thread.sleep(1000);

 		WebElement country=driver.findElement(By.xpath("//input[@name='billingCountry']"));
 		country.sendKeys(generateRandomCountry());
 		
 		//Shipping 
 		Thread.sleep(1000);

 		WebElement street1=driver.findElement(By.xpath("//input[@name='shippingStreet']"));
 		street1.sendKeys(generateRandomBillingStreet());
 		Thread.sleep(1000);

 		WebElement city1=driver.findElement(By.xpath("//input[@name='shippingCity']"));
 		city1.sendKeys(generateRandomCity());
 		Thread.sleep(1000);

 		WebElement state1=driver.findElement(By.xpath("//input[@name='shippingState']"));
 		state1.sendKeys(generateRandomState());
 		Thread.sleep(1000);

 		WebElement code1=driver.findElement(By.xpath("//input[@name='shippingCode']"));
 		code1.sendKeys(generateRandomCode());
 		Thread.sleep(1000);

 		WebElement country1=driver.findElement(By.xpath("//input[@name='shippingCountry']"));
 		country1.sendKeys(generateRandomCountry());
 		Thread.sleep(1000);

 		JavascriptExecutor jsP=(JavascriptExecutor)driver;
 		jsP.executeScript("window.scrollTo(0,1500)");
 		Thread.sleep(1000);
 		WebElement Terms=driver.findElement(By.xpath("//input[@name='termsAndConditions']"));
 		Terms.sendKeys(generateRandomTermsConditions());
 		Thread.sleep(1000);
 		
 		
 		WebElement Descr=driver.findElement(By.xpath("//input[@name='description']"));
 		Descr.sendKeys(generateRandomDescription());	
 		
 		 Thread.sleep(2000);
 		JavascriptExecutor js2= (JavascriptExecutor)driver;
 		js2.executeScript("window.scrollTo(0,-1000)");
 		 Thread.sleep(2000);
 		driver.findElement(By.xpath("(//button[contains(text(),'Save')])[2]")).click();
 		
 		 
	    	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    	   
	    	   try {
	    		   WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Purchase Details added Succesfully')]")));
	    		   // If success message is found, print it
			         System.out.println("Success message: " + successMessage.getText());		         
			         System.out.println("The Testcase is Pass");
			         			     
			         
	    	   }catch(Exception e) {
	    		   System.out.println("No success or error message found.");
        	       System.out.println("The Testcase is Fail");
			         
	    	   }		          		    		
     
	  	}
	  	
	 
	 
	  	
	 @Test(priority=16, dependsOnMethods=("Login"))
	  	void VendorNewContactRelatedList() throws InterruptedException
	  	{
	
		  Thread.sleep(2000);
	      driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
		  driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	      driver.findElement(By.xpath("//p[contains(text(),'Vendors')]")).click();
	      driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();

	      driver.findElement(By.xpath("(//td[@class='overflow_text vendorName cursorPointer'])[1]")).click();
	      Thread.sleep(500);
	      driver.findElement(By.xpath("//li[.='Contacts']")).click();
	      Thread.sleep(500);
	      
	      driver.findElement(By.xpath("(//button[.='New'])[2]")).click();
	      Thread.sleep(1000);
		 
	      WebElement CFN=driver.findElement(By.xpath("//input[@name='firstName']"));
	      CFN.sendKeys(generateRandomLastName());
	      
	      driver.findElement(By.xpath("(//img[@src='/static/media/Account.f388005f1034c11a12f47b06093bd16e.svg'])[2]")).click();
	      Thread.sleep(500);
	      driver.findElement(By.xpath("//td[.='Deepak Sharma']")).click();
	      driver.findElement(By.xpath("//button[contains(text(),'Done')]")).click();
	      Thread.sleep(500);
	      
	      WebElement CMail=driver.findElement(By.xpath("//input[@name='emailId']"));
	      CMail.sendKeys(generateRandommail()+"@mailinator.com");
	      Thread.sleep(500);
	      
	      WebElement CPhone=driver.findElement(By.xpath("//input[@name='phone']"));
	      CPhone.sendKeys(geneateRandomMobile());
	      Thread.sleep(500);
	      
	      WebElement COPhone=driver.findElement(By.xpath("//input[@name='otherPhone']"));
	      COPhone.sendKeys(geneateRandomMobile());
	      Thread.sleep(500); 
	      
	      WebElement CAssist=driver.findElement(By.xpath("//input[@name='assistant']"));
	      CAssist.sendKeys(generateRandommail());
	      Thread.sleep(500);
	      
	      WebElement CAPhone=driver.findElement(By.xpath("//input[@name='phone']"));
	      CAPhone.sendKeys(geneateRandomMobile());
	      Thread.sleep(500);
	      
	      driver.findElement(By.xpath("//div[@class=' css-qav5hl-singleValue']")).click();
	      driver.findElement(By.xpath("//div[.='Employee Referral']")).click();

	      WebElement CLastname=driver.findElement(By.xpath("//input[@name='lastName']"));
	      CLastname.sendKeys(generateRandomLastName());
	      Thread.sleep(500);
	      
	      WebElement CTitle=driver.findElement(By.xpath("//input[@name='title']"));
	      CTitle.sendKeys(generateRandomTeam());
	      Thread.sleep(500);
	      
	      WebElement CDept=driver.findElement(By.xpath("//input[@name='department']"));
	      CDept.sendKeys(generateRandomDept());
	      Thread.sleep(500);
	      
	      WebElement CMob=driver.findElement(By.xpath("//input[@name='homePhone']"));
	      CMob.sendKeys(geneateRandomMobile());
	      Thread.sleep(500);
	      
	      WebElement CSMail=driver.findElement(By.xpath("//input[@name='secondaryEmailId']"));
	      CSMail.sendKeys(generateRandommail()+"@mailinator.com");
	      Thread.sleep(500);
	      
	  
	        //Address
 		    Thread.sleep(2000);
	 		JavascriptExecutor js1= (JavascriptExecutor)driver;
	 		js1.executeScript("window.scrollTo(0,500)");
	 		 Thread.sleep(2000);
	 		
	 		WebElement street=driver.findElement(By.xpath("//input[@name='mailingStreet']"));
	 		street.sendKeys(generateRandomBillingStreet());
	 		Thread.sleep(1000);
	 		
	 		WebElement city=driver.findElement(By.xpath("//input[@name='mailingCity']"));
	 		city.sendKeys(generateRandomCity());
	 		Thread.sleep(1000);

	 		WebElement state=driver.findElement(By.xpath("//input[@name='mailingState']"));
	 		state.sendKeys(generateRandomState());
	 		Thread.sleep(1000);

	 		WebElement code=driver.findElement(By.xpath("//input[@name='mailingZip']"));
	 		code.sendKeys(generateRandomCode());
	 		Thread.sleep(1000);

	 		WebElement country=driver.findElement(By.xpath("//input[@name='mailingCountry']"));
	 		country.sendKeys(generateRandomCountry());
	 		
	 		//Shipping 
	 		Thread.sleep(1000);

	 		WebElement street1=driver.findElement(By.xpath("//input[@name='otherStreet']"));
	 		street1.sendKeys(generateRandomBillingStreet());
	 		Thread.sleep(1000);

	 		WebElement city1=driver.findElement(By.xpath("//input[@name='otherCity']"));
	 		city1.sendKeys(generateRandomCity());
	 		Thread.sleep(1000);

	 		WebElement state1=driver.findElement(By.xpath("//input[@name='otherState']"));
	 		state1.sendKeys(generateRandomState());
	 		Thread.sleep(1000);

	 		WebElement code1=driver.findElement(By.xpath("//input[@name='otherZip']"));
	 		code1.sendKeys(generateRandomCode());
	 		Thread.sleep(1000);
	 		
	 		WebElement country1=driver.findElement(By.xpath("//input[@name='otherCountry']"));
	 		country1.sendKeys(generateRandomCountry());
	 		Thread.sleep(1000);

	 		JavascriptExecutor jsP=(JavascriptExecutor)driver;
	 		jsP.executeScript("window.scrollTo(0,1500)");
	 		Thread.sleep(1000);
	
	 		WebElement Descr=driver.findElement(By.xpath("//textarea[@name='description']"));
	 		Descr.sendKeys(generateRandomDescription());	
	 		
	 		 Thread.sleep(2000);
	 		JavascriptExecutor js2= (JavascriptExecutor)driver;
	 		js2.executeScript("window.scrollTo(0,-1000)");
	 		 Thread.sleep(2000);
	 		driver.findElement(By.xpath("(//button[contains(text(),'Save')])[2]")).click();
	 		
	 		 
		    	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		    	   
		    	   try {
		    		   WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Contact Created Succesfully')]")));
		    		   // If success message is found, print it
				         System.out.println("Success message: " + successMessage.getText());		         
				         System.out.println("The Testcase is Pass");
				         			     
				         
		    	   }catch(Exception e) {
		    		   System.out.println("No success or error message found.");
	        	       System.out.println("The Testcase is Fail");
				         
		    	   }	  
	  	}
	
	 @Test(priority=17, dependsOnMethods=("Login"))
	  	void VendorDelete() throws InterruptedException
	  	{
		 Thread.sleep(2000);
	      driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
		  driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	      driver.findElement(By.xpath("//p[contains(text(),'Vendors')]")).click();
	      driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();

	      driver.findElement(By.xpath("(//td[@class='overflow_text vendorName cursorPointer'])[1]")).click();
	      Thread.sleep(500);
	      
	    driver.findElement(By.xpath("//button[@class='btn btn-secondary bg-white text-dark border border-primary']")).click();
  		Thread.sleep(1000);
  		driver.findElement(By.xpath("//div[contains(text(),'Delete')]")).click();

  		driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();

  		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

  		try {
  			WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Vendors details deleted successfully.')]")));
  			// If success message is found, print it
  			System.out.println("Success message: " + successMessage.getText());
  		}catch(Exception e) {
  			System.out.println("No success or error message found.");
  		}      
	  	}  	
}