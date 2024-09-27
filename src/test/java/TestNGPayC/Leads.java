package TestNGPayC;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Leads 

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
	  public static String generatePhoneno() {
	        String[] MESSAGE_ELEMENTS = {"9866885566", "5465868888", "8675748390", "7564678909", "7686906879", "5488667890", "7575889900", "9876789098", "7788998866", "9876778995"};
	        Random random = new Random();
	        return MESSAGE_ELEMENTS[random.nextInt(MESSAGE_ELEMENTS.length)];
	  }
	   public static String generateRandomCountry() {
		   String[] MESSAGE_ELEMENTS= {"New India","Sri Lanka","Japan","Singapore"};
		   Random random=new Random();
		   return MESSAGE_ELEMENTS[random.nextInt(MESSAGE_ELEMENTS.length)];
	   }
	  
	   public static String generateRandomCity() {
		   String[] MESSAGE_ELEMENTS= {"Huvina  Hadagali", "Bangalore", "Hyderabad", "Chennai"};
		   Random random=new Random();
		   return MESSAGE_ELEMENTS[random.nextInt(MESSAGE_ELEMENTS.length)];
	   }
	   
	   public static String generateRandomFax() {
		   String[] MESSAGE_ELEMENTS= {"886775588998","75647383947568","756484984477","453267889445"};
		   Random random=new Random();
		   return MESSAGE_ELEMENTS[random.nextInt(MESSAGE_ELEMENTS.length)];
	   }
       public static String generateRandomTeam() {
       	
       	String[] Team= {"Backend","Frontend","Data Base","Testing"};
       	Random random=new Random();
       	return Team[random.nextInt(Team.length)];
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

		      Login1 lp=new Login1(driver);
		      lp.setMailId("lokeshrb@mailinator.com");
		      lp.clickContinue();
		      lp.setPwd("Loki@123");
		      lp.clickLogin();
		      
		      
//		      driver.findElement(By.xpath("//input[@type='text']")).sendKeys("lokeshrb@mailinator.com");
//		      driver.findElement(By.xpath("//button[@class='LoginNextBtn']")).click();
//		      driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Loki@123");
//		      driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		}
		
	/*	
		@Test(priority=3, dependsOnMethods=("Login"))
		void create_Lead() throws InterruptedException 
		{
			
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
			driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();

		      
		      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		
		    //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Create Lead')]"))).click();
		
		      driver.findElement(By.xpath("//button[contains(text(),'Create Lead')]")).click();
		      
		      WebElement company_name=driver.findElement(By.xpath("//input[@name='companyName']"));
		      company_name.sendKeys(generateRandomCompanyName());
		      
		     WebElement Last_name= driver.findElement(By.xpath("//input[@name='lastName']"));
		      Last_name.sendKeys(generateRandomLastName());
		//    
		      driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys(generateRandommail()+"@mailinator.com");
		      driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
		      
		      
		       
		}
		
		
		@Test(priority=4)
		void Edit_Lead() 
		{
			driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		    driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();      
		    driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		
		driver.findElement(By.xpath("(//td[@class='overflow_text leadName cursorPointer'])[2]")).click();		
	     driver.findElement(By.xpath("//button[contains(text(),'Edit')]")).click();
	    WebElement company_name=driver.findElement(By.xpath("//input[@name='companyName']"));
	    company_name.sendKeys(generateRandomCompanyName());
	    WebElement Last_name= driver.findElement(By.xpath("//input[@name='lastName']"));
	    Last_name.sendKeys(generateRandomLastName());
	    driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys(generateRandommail()+"@mailinator.com");
	    
	  // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='createContactButtonSave']"))).click();
		
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Update')]"))).click();
		}

		@Test(priority=5)
		void clone_Lead() 
		{
			  driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();

			  driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();

		      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		        driver.findElement(By.xpath("(//td[@class='overflow_text leadName cursorPointer'])[1]")).click();

	                             //Clone
	          driver.findElement(By.xpath("//button[@class='btn btn-secondary bg-white text-dark border border-primary'][2]")).click();
	          driver.findElement(By.xpath("//div[contains(text(),'Clone')]")).click();
	          driver.findElement(By.xpath("//button[contains(text(),'Save')][2]")).click();
			
			
		}
		
		@Test(priority=6)
		void Share_Lead()
		{
			  driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();

		    driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();

		      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		        driver.findElement(By.xpath("(//td[@class='overflow_text leadName cursorPointer'])[1]")).click();

		      
	                  //Share to the user
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
	        driver.findElement(By.xpath("//span[@class='cursorPointer']")).click();
	   
		}
		
		@Test(priority=7)
		void Converted_Leads() throws InterruptedException 
		{
	          Thread.sleep(2000);

			  driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
			  driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();   
		      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'All Leads')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'Converted Leads')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'50 Records Per Page')]")).click();

		      List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));

		      // Get the count of rows
		      int recordCount = rows.size();
		      
		      
		      // Print the count
		      System.out.println("Total number of converted Leads: " + recordCount);

		}
		
		
		
		@Test(priority=8)
		void Junk_Leads() throws InterruptedException 
		{	    
	          Thread.sleep(2000);
			  driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
			  driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();   
		      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'All Leads')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'Junk Leads')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'50 Records Per Page')]")).click();

		      List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));

		      // Get the count of rows
		      int recordCount = rows.size();
		      
		      
		      // Print the count
		      System.out.println("Total number of Junk Leads: " + recordCount);

		}
		
		

		@Test(priority=9)
		void Leads_Shared_by_Me_() 
		{
			
			
			  driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
			  driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();   
		      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		      
		      driver.findElement(By.xpath("//div[contains(text(),'All Leads')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'Leads Shared by Me')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'50 Records Per Page')]")).click();

		      List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));

		      // Get the count of rows
		      int recordCount = rows.size();
		      
		      
		      // Print the count
		      System.out.println("Total number of Leads Shared by Me: " + recordCount);

		}
		

		@Test(priority=10)
		void Leads_Shared_to_Me_() 
		{

			driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
			driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();   
		      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'All Leads')]")).click();
		      
		      driver.findElement(By.xpath("//div[contains(text(),'Leads Shared by Me')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'50 Records Per Page')]")).click();

		      List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));

		      // Get the count of rows
		      int recordCount = rows.size();     
		      // Print the count
		      System.out.println("Total number of Leads Shared to Me: " + recordCount);

		}

		@Test(priority=11)
		void Mailing_Labels() 
		{
			driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
			driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();   
		      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'All Leads')]")).click();

		      
		      driver.findElement(By.xpath("//div[contains(text(),'Leads Shared to Me')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'50 Records Per Page')]")).click();

		      List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));

		      // Get the count of rows
		      int recordCount = rows.size();
		      
		      
		      // Print the count
		      System.out.println("Total number of Mailing Labels: " + recordCount);
		}
		
		@Test(priority=12)
		void My_Converted_Leads() 
		{

			  driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
			  driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();   
		      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'All Leads')]")).click();
		      
		      driver.findElement(By.xpath("//div[contains(text(),'Mailing Labels')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'50 Records Per Page')]")).click();

		      List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));

		      // Get the count of rows
		      int recordCount = rows.size();
		      
		      
		      // Print the count
		      System.out.println("Total number of My Converted Leads: " + recordCount);
		}
		
		@Test(priority=13)
		void My_Leads() 
		{
			driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
			driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();   
		      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'All Leads')]")).click();


		      
		      driver.findElement(By.xpath("//div[contains(text(),'My Converted Leads')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'50 Records Per Page')]")).click();

		      List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));

		      // Get the count of rows
		      int recordCount = rows.size();
		      
		      
		      // Print the count
		      System.out.println("Total number of My Leads: " + recordCount);
		}
		
		@Test(priority=14)
		void Recently_Created_Leads() 
		{
			driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
			driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();   
		      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'All Leads')]")).click();
		      
		      
		      
		      driver.findElement(By.xpath("//div[contains(text(),'My Leads')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'50 Records Per Page')]")).click();

		      List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));

		      // Get the count of rows
		      int recordCount = rows.size();
		      
		      
		      // Print the count
		      System.out.println("Total number of Recently Created Leads: " + recordCount);
		}
		
		@Test(priority=14)
		void Recently_Modified_Leads() 
		{	     
		
				driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
			driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();   
		      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'All Leads')]")).click();
		
		
		
			  driver.findElement(By.xpath("//div[contains(text(),'Recently Created Leads')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'10 Records Per Page')]")).click();
		      driver.findElement(By.xpath("//div[contains(text(),'50 Records Per Page')]")).click();

		      List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));

		      // Get the count of rows
		      int recordCount = rows.size();
		      
		      
		      // Print the count
		      System.out.println("Total number of Recently Modified Leads: " + recordCount);
		}

		
		@Test(priority=15)
		void Leads_Mass_Delete() 
		{
			driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
			driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();
			
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
		
		@Test(priority=16)
		void Leads_Mass_Transfer() throws InterruptedException
		{
		
		      driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
			  driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();
			
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
			
			
		@Test(priority=17)
		void Leads_Individual_Edit() throws InterruptedException
		{
		      driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
			  driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();
			
		      driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();	
		      driver.findElement(By.xpath("(//td[@class='overflow_text leadName cursorPointer'])[2]")).click();
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollTo(0,500)");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@name='leadInfoEmail']")).click();
			WebElement email=driver.findElement(By.xpath("//input[@name='leadInfoEmail']"));
			email.clear();
			email.sendKeys(generateRandommail()+"@mailinator.com");
			driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();
			Thread.sleep(2000);

			WebElement Phone=driver.findElement(By.xpath("//input[@name='leadPhone']"));
			Phone.click();
			Phone.clear();
			Thread.sleep(500);

            Phone.sendKeys(generatePhoneno());
            Thread.sleep(500);
            driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();
            Thread.sleep(1000);

			WebElement Mobile=driver.findElement(By.xpath("//input[@name='leadMobile']"));
			Mobile.click();
			Mobile.clear();
			Thread.sleep(500);

			Mobile.sendKeys(generatePhoneno());
            Thread.sleep(500);
            driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//input[@name='leadInfoLeadSource']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//div[@class=' css-1xc3v61-indicatorContainer']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//div[contains(text(),'Cold Call')]")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();
            Thread.sleep(500);
            
            
            driver.findElement(By.xpath("//input[@name='leadInfoIndustryType']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//div[@class=' css-qav5hl-singleValue']")).click(); 
            driver.findElement(By.xpath("//div[contains(text(),'Data/Telecom OEM')]")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//input[@name='leadAnnualRevenue']")).click();
            driver.findElement(By.xpath("//input[@name='leadAnnualRevenue']")).sendKeys("202");
            Thread.sleep(500);
            driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();

            driver.findElement(By.xpath("//input[@name='leadInfoWebsite']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@name='leadInfoWebsite']")).sendKeys("www.gogle.com");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='companyName']")).click();
            Thread.sleep(1000);
           WebElement comp= driver.findElement(By.xpath("//input[@name='companyName']"));
           Thread.sleep(1000);
           comp.sendKeys(generateRandomCompanyName());
            
           driver.findElement(By.xpath("//input[@name='leadInfoLeadStatus']")).click();
           Thread.sleep(1000);
           driver.findElement(By.xpath("//div[@class=' css-qav5hl-singleValue']")).click();
           Thread.sleep(1000);
           driver.findElement(By.xpath("//div[contains(text(),'Junk Lead')]")).click();             
		}
		
		@Test(priority=18)
		void Leads_Mass_Update() throws InterruptedException
		{
			  //For Annual revenue field update
		      driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
			  driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();
			
		      driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click();
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[2]")).click();
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[3]")).click();
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[4]")).click();
		      
		      driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	    	  driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	    	  driver.findElement(By.xpath("//input[@id='massValue']")).sendKeys("101");
	    	  driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
			
              Thread.sleep(2000);
              
            //For Company field update
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click();
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[2]")).click();
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[3]")).click();
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[4]")).click();
		    
		      driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	    	  driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	    	  
	    	  driver.findElement(By.xpath("//div[@class='cursorPointer d-flex justify-content-between w-100 my-1 p-1 border-0']")).click();
	    	  driver.findElement(By.xpath("(//span[contains(text(),'Company')])[2]")).click();
	    	  WebElement compan=driver.findElement(By.xpath("//input[@id='massValue']"));
	    	  compan.sendKeys(generateRandomCompanyName());
	          Thread.sleep(1000);
	    	  driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
	    	  
	    	  //For Country field update
	    	  Thread.sleep(2000);
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click();
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[2]")).click();
		      
		      driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	    	  driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	    	  
	    	  driver.findElement(By.xpath("//div[@class='cursorPointer d-flex justify-content-between w-100 my-1 p-1 border-0']")).click();
	    	  driver.findElement(By.xpath("//span[contains(text(),'Country')]")).click();
	    	  WebElement countr=driver.findElement(By.xpath("//input[@id='massValue']"));
	    	  countr.sendKeys(generateRandomCountry());
	          Thread.sleep(1000);
	    	  driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
	    	  
	    	  //For City field update
	    	  Thread.sleep(2000);
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click();
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[2]")).click();
		      
		      driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	    	  driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	    	  
	    	  driver.findElement(By.xpath("//div[@class='cursorPointer d-flex justify-content-between w-100 my-1 p-1 border-0']")).click();
	    	  driver.findElement(By.xpath("//span[contains(text(),'City')]")).click();
	    	  WebElement cit=driver.findElement(By.xpath("//input[@id='massValue']"));
	    	  cit.sendKeys(generateRandomCity());
	          Thread.sleep(1000);
	    	  driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
	    	  
	    	//For Email field update
	    	  Thread.sleep(2000);
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click();
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[2]")).click();
		      
		      driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	    	  driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	    	  
	    	  driver.findElement(By.xpath("//div[@class='cursorPointer d-flex justify-content-between w-100 my-1 p-1 border-0']")).click();
	    	  driver.findElement(By.xpath("(//span[contains(text(),'Email')])[2]")).click();
	    	  WebElement emai=driver.findElement(By.xpath("//input[@id='massValue']"));
	    	  emai.sendKeys(generateRandommail()+"@mailinator.com");
	          Thread.sleep(1000);
	    	  driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
	    	  
	    	//For Fax field update
	    	  Thread.sleep(2000);
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click();
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[2]")).click();
		      
		      driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	    	  driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	    	  
	    	  driver.findElement(By.xpath("//div[@class='cursorPointer d-flex justify-content-between w-100 my-1 p-1 border-0']")).click();
	    	  driver.findElement(By.xpath("//span[contains(text(),'Fax')]")).click();
	    	  WebElement Fax=driver.findElement(By.xpath("//input[@id='massValue']"));
	    	  Fax.sendKeys(generateRandomFax());
	          Thread.sleep(1000);
	    	  driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
	    	  
	    	//For Industry field update
	    	  Thread.sleep(2000);
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click();
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[2]")).click();
		      
		      driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	    	  driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	    	  
	    	  driver.findElement(By.xpath("//div[@class='cursorPointer d-flex justify-content-between w-100 my-1 p-1 border-0']")).click();
	    	  driver.findElement(By.xpath("//span[contains(text(),'Industry')]")).click();
	    	  
	    	  driver.findElement(By.xpath("//div[@class=' css-16rszb6-control']")).click();
	    	  driver.findElement(By.xpath("//div[contains(text(),'Data/Telecom OEM')]")).click();
	          Thread.sleep(500);
	          driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
	    	  
	        //For Job title field update
	    	  Thread.sleep(2000);
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click();
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[2]")).click();
		      
		      driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	    	  driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	    	  
	    	  driver.findElement(By.xpath("//div[@class='cursorPointer d-flex justify-content-between w-100 my-1 p-1 border-0']")).click();
	    	  driver.findElement(By.xpath("//span[contains(text(),'Job Title')]")).click();
	    	  WebElement Titl=driver.findElement(By.xpath("//input[@id='massValue']"));
	    	  Titl.sendKeys(generateRandomTeam());

	          Thread.sleep(500);
	          driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
	    	  
	          //For Lead source field update
	    	  Thread.sleep(2000);
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click();
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[2]")).click();
		    
		      driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	    	  driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	    	  
	    	  driver.findElement(By.xpath("//div[@class='cursorPointer d-flex justify-content-between w-100 my-1 p-1 border-0']")).click();
	          Thread.sleep(500);

	    	  driver.findElement(By.xpath("//span[contains(text(),'Lead Source')]")).click();
	          Thread.sleep(500);
	    	  driver.findElement(By.xpath("//div[@class=' css-16rszb6-control']")).click();
	    	  driver.findElement(By.xpath("//div[contains(text(),'Cold Call')]")).click();
	          Thread.sleep(500);
	          driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
	          
	          
	          //For Lead status field update
	    	  Thread.sleep(2000);
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click();
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[2]")).click();
		      
		      driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	    	  driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	    	  
	    	  driver.findElement(By.xpath("//div[@class='cursorPointer d-flex justify-content-between w-100 my-1 p-1 border-0']")).click();
	          Thread.sleep(500);

	    	  driver.findElement(By.xpath("//span[contains(text(),'Lead Status')]")).click();
	          Thread.sleep(500);

	    	  driver.findElement(By.xpath("//div[@class=' css-16rszb6-control']")).click();
	    	  driver.findElement(By.xpath("//div[contains(text(),'Junk Lead')]")).click();
	          Thread.sleep(500);
	          driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
	          
	          
	        //For Mobile field update
	    	  Thread.sleep(2000);
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click();
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[2]")).click();
		      
		      driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	    	  driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	    	  
	    	  driver.findElement(By.xpath("//div[@class='cursorPointer d-flex justify-content-between w-100 my-1 p-1 border-0']")).click();
	          Thread.sleep(500);

	          driver.findElement(By.xpath("//span[contains(text(),'Mobile')]")).click();
	    	 
	    	  WebElement Mobi=driver.findElement(By.xpath("//input[@id='massValue']"));
	    	  Mobi.sendKeys(generatePhoneno());
	          Thread.sleep(1000);
	    	  driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
	     
	        //For Phone number field update
	    	  Thread.sleep(2000);
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click();
		      driver.findElement(By.xpath("(//input[@id='vehicle1'])[2]")).click();		      
		      driver.findElement(By.xpath("//div[@class=' css-1qpx96c-indicatorContainer']")).click();
	    	  driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();	    	  
	    	  driver.findElement(By.xpath("//div[@class='cursorPointer d-flex justify-content-between w-100 my-1 p-1 border-0']")).click();
	          Thread.sleep(1000);
	    	  driver.findElement(By.xpath("(//span[contains(text(),'Phone Number')])[2]")).click();  	 
		      WebElement Phon=driver.findElement(By.xpath("//input[@id='massValue']"));
		      Phon.sendKeys(generatePhoneno());
		      Thread.sleep(1000);
		      driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();	          	          
		}
		
	
		
		@Test(priority=19)
		void Leads_Add_Product() throws InterruptedException
		{
			  //For Annual revenue field update
		      driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
			  driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();
			
		      driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
		      driver.findElement(By.xpath("(//td[@class='overflow_text leadName cursorPointer'])[1]")).click();
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
		
		@Test(priority=20)
		void Leads_Delete_Product() throws InterruptedException {
		    // For Annual revenue field update
		    driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
		    driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		    driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();
			
		    driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
		    driver.findElement(By.xpath("(//td[@class='overflow_text leadName cursorPointer'])[1]")).click();
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
		
		
		
		@Test(priority=21)
		void Leads_Add_Campaign() throws InterruptedException
		{
			
		      driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
			  driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		      driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();
	          Thread.sleep(500);
	          driver.findElement(By.xpath("(//div[@class=' css-qav5hl-singleValue'])[2]")).click();
		      Thread.sleep(2000);
		      driver.findElement(By.xpath("(//td[@class='overflow_text leadName cursorPointer'])[1]")).click();
		      driver.findElement(By.xpath("//li[contains(text(),'Campaign')]")).click();
	          Thread.sleep(1000);
		      driver.findElement(By.xpath("//button[contains(text(),'Add Campaign')]")).click();
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
		
		
		@Test(priority=22)
		void Leads_Delete_Campaign() throws InterruptedException {
		    // For Annual revenue field update
		    driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
		    driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		    driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();
		    Thread.sleep(2000);
			
		    driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
		    driver.findElement(By.xpath("(//td[@class='overflow_text leadName cursorPointer'])[1]")).click();
		    driver.findElement(By.xpath("//li[contains(text(),'Products')]")).click();
		    Thread.sleep(1000);

		    WebElement elementToHover = driver.findElement(By.xpath("(//td[@class='productsTabledata'])[9]"));

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
		
		
		@Test(priority=23)
		
		 void Leads_Add_Note() throws InterruptedException {
		    // For Annual revenue field update
		    driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
		    driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		    driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();
		    Thread.sleep(2000);
			
		    driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
		    driver.findElement(By.xpath("(//td[@class='overflow_text leadName cursorPointer'])[1]")).click();
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
	
		
		@Test(priority=24)
		void Leads_Edit_Note() throws InterruptedException {
		    // For Annual revenue field update
		    driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
		    driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		    driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();
		    Thread.sleep(2000);
			
		    driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
		    driver.findElement(By.xpath("(//td[@class='overflow_text leadName cursorPointer'])[1]")).click();
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

		 @Test(priority=25)
		 
		 void LeadsNewTaskOpenActivities() throws InterruptedException {
		    // For Annual revenue field update
		    driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
		    driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		    driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();
		    Thread.sleep(2000);
			
		    driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
		    driver.findElement(By.xpath("(//td[@class='overflow_text leadName cursorPointer'])[1]")).click();
		
		    driver.findElement(By.xpath("//li[.='Open Activities']")).click();
		    Thread.sleep(500);
		
		    driver.findElement(By.xpath("//button[.='Add New']")).click();
		    Thread.sleep(500);
		
		    driver.findElement(By.xpath("//li[.='Task']")).click();
		    Thread.sleep(500);
				
		    driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("Automations testing");
		    Thread.sleep(500);
		  
		    driver.findElement(By.xpath("//input[@class='insertCommonInputFieldCalls cursorPointer w-100']")).click();
		    Thread.sleep(500);
		
		    driver.findElement(By.xpath("(//li[@class='cursorPointer list-group-item'])[2]")).click();
		    Thread.sleep(500);
		
		    driver.findElement(By.xpath("//button[.='Next']")).click();
		    Thread.sleep(500);
		
		    driver.findElement(By.xpath("//button[.='Save']")).click();
		    Thread.sleep(500);
		
		    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    		try {
    			WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Task Created Succesfully')]")));
    			// If success message is found, print it
    			System.out.println("Success message: " + successMessage.getText());
    		}catch(Exception e) {
    			System.out.println("Error message found.");
    		}						
		}
		
		 
		@Test(priority=26)
		 
		 void LeadsNewTaskOpenActivities() throws InterruptedException {
		    // For Annual revenue field update
		    driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
		    driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		    driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();
		    Thread.sleep(2000);
			
		    driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
		    driver.findElement(By.xpath("(//td[@class='overflow_text leadName cursorPointer'])[1]")).click();
		
		    driver.findElement(By.xpath("//li[.='Open Activities']")).click();
		    Thread.sleep(500);		
		    driver.findElement(By.xpath("//button[.='Add New']")).click();
		    driver.findElement(By.xpath("//li[.='Call']")).click();		    		 
		    driver.findElement(By.xpath("//li[.='Schedule a Call']")).click();
		    Thread.sleep(500);
		    driver.findElement(By.xpath("(//div[@class='cursorPointer'])[2]")).click();
		    
		    driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(generateRandomLastName());

		    
		    driver.findElement(By.xpath("//span[.='02']")).click();
		    driver.findElement(By.xpath("//div[.='AM']")).click();
		 
		    driver.findElement(By.xpath("//button[.='Schedule']")).click();
		    driver.findElement(By.xpath("//button[.='Create']")).click();

		    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

	  		try {
	  			WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Call Created Succesfully')]")));
	  			// If success message is found, print it
	  			System.out.println("Success message: " + successMessage.getText());
	  			System.out.println("This testcase pass");
	  		}catch(Exception e) {
	  			System.out.println("Error message found.");
	  			System.out.println("This testcase fails");
	  		}
	  		
	  		driver.findElement(By.xpath("//span[.='Calls']")).click();	 
	  			
	  	List<WebElement> nameList=driver.findElements(By.xpath("//td[.='gagan']"));
	  		
	  		String expectedName="gagan";
	  		boolean nameFound= false;
	  		
	  		for(WebElement nameElement:nameList)
	  		if(nameElement.getText().equals(expectedName))
	  		{
	  		nameFound=true;	
	  		}
		
	if(nameFound)
	{
		System.out.println("Name '" + expectedName + "' is displayed in the list.");
    } else {
        System.out.println("Name '" + expectedName + "' is not displayed in the list.");
    }
		}
			 	
		
		@Test(priority=27)
		 
		 void LeadsNewTaskOpenActivities() throws InterruptedException {
		    // For Annual revenue field update
		    driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
		    driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		    driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();
		    Thread.sleep(2000);
			
		    driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
		    driver.findElement(By.xpath("(//td[@class='overflow_text leadName cursorPointer'])[1]")).click();
		
		    driver.findElement(By.xpath("//li[.='Open Activities']")).click();
		    Thread.sleep(500);		
		    driver.findElement(By.xpath("//button[.='Add New']")).click();
		    driver.findElement(By.xpath("//li[.='Call']")).click();		    		 
		    driver.findElement(By.xpath("//li[.='Log a Call']")).click();
		    Thread.sleep(500);
		
		
		    driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(generateRandomLastName());
		    		
		    driver.findElement(By.xpath("(//input[@type='text'])[32]")).sendKeys("2");
		   
		    driver.findElement(By.xpath("(//div[@class='cursorPointer'])[2]")).click();
		    driver.findElement(By.xpath("//span[.='01']")).click();
		    driver.findElement(By.xpath("//button[.='Save']")).click();
		    
		    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

	  		try {
	  			WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Call Created Succesfully')]")));
	  			// If success message is found, print it
	  			System.out.println("Success message: " + successMessage.getText());
	  			System.out.println("This testcase pass");
	  		}catch(Exception e) {
	  			System.out.println("Error message found.");
	  			System.out.println("This testcase fails");
	  		}
		  
		}
	*/	
		
		@Test(priority=28)
		 
		 void LeadsNewTaskOpenActivities() throws InterruptedException {
		 
		    driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
		    driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
		    driver.findElement(By.xpath("//p[contains(text(),'Leads')]")).click();
		    Thread.sleep(2000);
			
		    driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
		    driver.findElement(By.xpath("(//td[@class='overflow_text leadName cursorPointer'])[1]")).click();
		
		    driver.findElement(By.xpath("//li[.='Open Activities']")).click();
		    Thread.sleep(500);		
		    driver.findElement(By.xpath("//button[.='Add New']")).click();
		    driver.findElement(By.xpath("//li[.='Meeting']")).click();
		    driver.findElement(By.xpath("(//input[@name='title'])[2]")).sendKeys(generateRandomLastName());
		    driver.findElement(By.xpath("(//div[@class='cursorPointer'])[2]")).click();
		    driver.findElement(By.xpath("//span[.='01']")).click();
		    driver.findElement(By.xpath("(//div[@class='cursorPointer'])[5]")).click();
		    driver.findElement(By.xpath("//span[.='02']")).click();
		    
		    		
		    driver.findElement(By.xpath("//input[@name='location']")).sendKeys(generateRandomCity());		
		    driver.findElement(By.xpath("//button[.='Save']")).click();		
		    driver.findElement(By.xpath("//button[.='Create']")).click();		
		
		    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

	  		try {
	  			WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Meeting details added successfully')]")));
	  			// If success message is found, print it
	  			System.out.println("Success message: " + successMessage.getText());
	  			System.out.println("This testcase pass");
	  		}catch(Exception e) {
	  			System.out.println("Error message found.");
	  			System.out.println("This testcase fails");
	  		}	
		  	
		    		
		    		
		}
}
