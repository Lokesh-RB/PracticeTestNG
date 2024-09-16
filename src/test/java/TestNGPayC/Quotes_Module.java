package TestNGPayC;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Quotes_Module 

{
	
	
	 WebDriver driver;
	
	 public static String generateRandomsubject() {
	        String[] MESSAGE_ELEMENTS = {"Electric Bill", "Water Bill", "Groceries", "Teamout", "Other Expense", "Garden", "Listeners", "Maven", "Computer", "Laptop"};
	        Random random = new Random();
	        return MESSAGE_ELEMENTS[random.nextInt(MESSAGE_ELEMENTS.length)];
	 }   
     
	        public static String generateRandomBillingStreet() {
	        	String[] MESSAGE_ELEMENTS= {"Palace road", "Church  road", "Palk street", "HSR Layout"};
	        	Random random= new Random();
	        	return MESSAGE_ELEMENTS[random.nextInt(MESSAGE_ELEMENTS.length)];
	        	
	        }
	        
	        
	        public static String generateRandomTeam() {
	        	
	        	String[] Team= {"Backend","Frontend","Data Base","Testing"};
	        	Random random=new Random();
	        	return Team[random.nextInt(Team.length)];
	        }
	        	
	        public static String generateRandomCity() {
	        	String[] City= {"Vatican City","Huvina Hadagali","Davangere","Bangalore"};
	        	Random random=new Random();
	        	return City[random.nextInt(City.length)];
	        	
	        }
	        
	        public static String generateRandomState() {
	        	String[] State= {"Karnataka","Andhra Pradesh","Arunachal Pradesh","Madhya Pradesh"};
	        	Random random=new Random();
	        	return State[random.nextInt(State.length)];
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
	        
	        public static String generateRandomcustmerNo() {
	        	String[]custmerNo= {"456BTC","123USD","789TRX","246UNO"};
	        	Random random=new Random();
	        	return custmerNo[random.nextInt(custmerNo.length)];
	        	
	        }
	        
	        public static String generateRandomPurchaseOrder() {
	        	String[]PurchaseOrder= {"123","456","789","001"};
	        	Random random=new Random();
	        	return PurchaseOrder[random.nextInt(PurchaseOrder.length)];
	        }
	        
	        

	        @Test(priority=1)
	        void Open_application()
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
	        @Test(priority=3, dependsOnMethods= ("Login"))
	        void Create_Quote() throws InterruptedException
	        {
	        	driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	    		driver.findElement(By.xpath("//p[contains(text(),'Quotes')]")).click();
	    		driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
	    		driver.findElement(By.xpath("//button[contains(text(),'Create Quote')]")).click();
	        	
	    		WebElement sub=driver.findElement(By.xpath("//input[@name='subject']"));
	    		sub.sendKeys(generateRandomsubject());
	    		
	    		driver.findElement(By.xpath("(//div[@class=' css-qav5hl-singleValue'])[1]")).click();
	    		Thread.sleep(500);
	    		driver.findElement(By.xpath("//div[contains(text(),'Negotiation')]")).click();
	    		Thread.sleep(500);
	    		WebElement Team=driver.findElement(By.xpath("//input[@name='team']"));
	    		Team.sendKeys(generateRandomTeam());
	    		
	    		Thread.sleep(500);
	    		driver.findElement(By.xpath("(//div[@class=' css-1xc3v61-indicatorContainer'])[2]")).click();	    	
	    		Thread.sleep(1000);
	
	    		driver.findElement(By.xpath("//div[contains(text(),'UPS')]")).click();
	    		
	    		 Thread.sleep(1000);
	    		JavascriptExecutor js= (JavascriptExecutor)driver;
	    		js.executeScript("window.scrollTo(0,-1000)");
	    		 Thread.sleep(1000);
	    		

	    		
	    		driver.findElement(By.xpath("(//span[@class='cursorPointer pt-2 ps-1'])[2]")).click();
	    		driver.findElement(By.xpath("//td[contains(text(),'pola')]")).click();
	    		driver.findElement(By.xpath("//button[contains(text(),'Done')]")).click();
	    		
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

	    		
	    		WebElement Terms=driver.findElement(By.xpath("//textarea[@name='termsAndConditions']"));
	    		Terms.sendKeys(generateRandomTermsConditions());
	    		Thread.sleep(1000);
	    		
	    		
	    		WebElement Descr=driver.findElement(By.xpath("(//textarea[@name='description'])[2]"));
	    		Descr.sendKeys(generateRandomDescription());	
	    		
	    		 Thread.sleep(2000);
	    		JavascriptExecutor js2= (JavascriptExecutor)driver;
	    		js2.executeScript("window.scrollTo(0,-1000)");
	    		 Thread.sleep(2000);
	    		driver.findElement(By.xpath("(//button[contains(text(),'Save')])[2]")).click();
	    		
	    		 
		    	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		    	   
		    	   try {
		    		   WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Quotes information details added Succesfully')]")));
		    		   // If success message is found, print it
				         System.out.println("Success message: " + successMessage.getText());
		    	   }catch(Exception e) {
		    		   System.out.println("No success or error message found.");
		    	   }		          		    		
	        }
	        
	      
	        @Test(priority=4, dependsOnMethods= ("Create_Quote"))
	        void Edit_Quote() throws InterruptedException
	        {
	        	driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
	        	driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	    		driver.findElement(By.xpath("//p[contains(text(),'Quotes')]")).click();
	    		driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
	        	
	    		driver.findElement(By.xpath("(//td[@class='overflow_text subject cursorPointer'])[1]")).click();
	    		Thread.sleep(500);
	    		driver.findElement(By.xpath("//button[contains(text(),'Edit')]")).click();
	    		Thread.sleep(1000);
	    		
	    		WebElement sub=driver.findElement(By.xpath("//input[@name='subject']"));
	    		sub.clear();
	    		sub.sendKeys(generateRandomsubject());
	    		
	    		driver.findElement(By.xpath("(//div[@class=' css-qav5hl-singleValue'])[1]")).click();
	    		Thread.sleep(500);
	    		driver.findElement(By.xpath("//div[contains(text(),'Delivered')]")).click();
	    		Thread.sleep(500);
	    		
	    		WebElement Team=driver.findElement(By.xpath("//input[@name='team']"));
	    		Team.clear();
	    		Team.sendKeys(generateRandomTeam());
	    		
	    		
	    		Thread.sleep(500);
	    		driver.findElement(By.xpath("(//div[@class=' css-1xc3v61-indicatorContainer'])[2]")).click();	    	
	    		Thread.sleep(1000);
	
	    		driver.findElement(By.xpath("//div[contains(text(),'USPS')]")).click();
	    		
	    		 Thread.sleep(1000);
		    		JavascriptExecutor js= (JavascriptExecutor)driver;
		    		js.executeScript("window.scrollTo(0,-1000)");
		    		 Thread.sleep(1000);
		    		

		    		
		    		driver.findElement(By.xpath("(//span[@class='cursorPointer pt-2 ps-1'])[2]")).click();
		    		driver.findElement(By.xpath("//td[contains(text(),'pushpa')]")).click();
		    		driver.findElement(By.xpath("//button[contains(text(),'Done')]")).click();
	    		
	    		//
		    		Thread.sleep(2000);
		    		JavascriptExecutor js1= (JavascriptExecutor)driver;
		    		js1.executeScript("window.scrollTo(0,500)");
		    		 Thread.sleep(2000);
		    		
		    		WebElement street=driver.findElement(By.xpath("//input[@name='billingStreet']"));
		    		street.clear();
		    		street.sendKeys(generateRandomBillingStreet());
		    		Thread.sleep(1000);
		    		
		    		WebElement city=driver.findElement(By.xpath("//input[@name='billingCity']"));
		    		city.clear();
		    		city.sendKeys(generateRandomCity());
		    		Thread.sleep(1000);

		    		WebElement state=driver.findElement(By.xpath("//input[@name='billingState']"));
		    		state.clear();
		    		state.sendKeys(generateRandomState());
		    		Thread.sleep(1000);

		    		WebElement code=driver.findElement(By.xpath("//input[@name='billingCode']"));
		    		code.clear();
		    		code.sendKeys(generateRandomCode());
		    		Thread.sleep(1000);

		    		WebElement country=driver.findElement(By.xpath("//input[@name='billingCountry']"));
		    		country.clear();
		    		country.sendKeys(generateRandomCountry());
		    		
		    		//Shipping 
		    		Thread.sleep(1000);

		    		WebElement street1=driver.findElement(By.xpath("//input[@name='shippingStreet']"));
		    		street1.clear();
		    		street1.sendKeys(generateRandomBillingStreet());
		    		Thread.sleep(1000);

		    		WebElement city1=driver.findElement(By.xpath("//input[@name='shippingCity']"));
		    		city1.clear();
		    		city1.sendKeys(generateRandomCity());
		    		Thread.sleep(1000);

		    		WebElement state1=driver.findElement(By.xpath("//input[@name='shippingState']"));
		    		state1.clear();
		    		state1.sendKeys(generateRandomState());
		    		Thread.sleep(1000);

		    		WebElement code1=driver.findElement(By.xpath("//input[@name='shippingCode']"));
		    		code1.clear();
		    		code1.sendKeys(generateRandomCode());
		    		Thread.sleep(1000);

		    		WebElement country1=driver.findElement(By.xpath("//input[@name='shippingCountry']"));
		    		country1.clear();
		    		country1.sendKeys(generateRandomCountry());
		    		Thread.sleep(1000);

		    		
		    		//driver.findElement(By.xpath("//textarea[@name='termsAndConditions']")).clear();
		    	
		    		WebElement Terms_Conditions=driver.findElement(By.xpath("//textarea[@name='termsAndConditions']"));
		    		Terms_Conditions.clear();
		    		Terms_Conditions.sendKeys(generateRandomTermsConditions());		
		    		Thread.sleep(1000);
		    		
		    		WebElement Descr=driver.findElement(By.xpath("(//textarea[@name='description'])[2]"));
		    		Descr.clear();
		    		Descr.sendKeys(generateRandomDescription());		    		
		    		Thread.sleep(1000);
		    		
		    		
		    		 Thread.sleep(2000);
		    		JavascriptExecutor js2= (JavascriptExecutor)driver;
		    		js2.executeScript("window.scrollTo(0,-1000)");
		    		 Thread.sleep(2000);
		    		driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
		    		
		    		 
			    	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			    	   
			    	   try {
			    		   WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Quotes info details updated Succesfully')]")));
			    		   // If success message is found, print it
					         System.out.println("Success message: " + successMessage.getText());
			    	   }catch(Exception e) {
			    		   System.out.println("No success or error message found.");
			    	   }     	
	        }
	        
	        @Test(priority=5, dependsOnMethods= ("Login"))
	        void Delete_Quote() throws InterruptedException 
	        {
	        	driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();

	    		driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	    		driver.findElement(By.xpath("//p[contains(text(),'Quotes')]")).click();
	    		driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();

	    		driver.findElement(By.xpath("(//td[@class='overflow_text subject cursorPointer'])[1]")).click();
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("//button[@class='btn btn-secondary bg-white text-dark border border-primary'][2]")).click();
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("//div[contains(text(),'Delete')]")).click();

	    		driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();

	    		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

	    		try {
	    			WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Quote details deleted successfully.')]")));
	    			// If success message is found, print it
	    			System.out.println("Success message: " + successMessage.getText());
	    		}catch(Exception e) {
	    			System.out.println("No success or error message found.");
	    		}      
    	
	        }	
	        
	        
	        
	        
	        @Test(priority=6, dependsOnMethods= ("Login"))
	        void Clone_Quote() throws InterruptedException 
	        {
	        	driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();

	    		driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	    		driver.findElement(By.xpath("//p[contains(text(),'Quotes')]")).click();
	    		driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();

	    		driver.findElement(By.xpath("(//td[@class='overflow_text subject cursorPointer'])[1]")).click();
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("//button[@class='btn btn-secondary bg-white text-dark border border-primary'][2]")).click();
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("//div[contains(text(),'Clone')]")).click();
	    		driver.findElement(By.xpath("(//button[contains(text(),'Save')])[2]")).click();
	    		
		    	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		    	   
		    	   try {
		    		   WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Quotes information details added Succesfully')]")));
		    		   // If success message is found, print it
				         System.out.println("Success message: " + successMessage.getText());
		    	   }catch(Exception e) {
		    		   System.out.println("No success or error message found.");
		    	   }

	        }
	        
	       
	        
	        @Test(priority=7, dependsOnMethods= ("Login"))
	        void Clone_Quote_With_Changing_data() throws InterruptedException 
	        {
	        	driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();

	    		driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	    		driver.findElement(By.xpath("//p[contains(text(),'Quotes')]")).click();
	    		driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();

	    		driver.findElement(By.xpath("(//td[@class='overflow_text subject cursorPointer'])[1]")).click();
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("//button[@class='btn btn-secondary bg-white text-dark border border-primary'][2]")).click();
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("//div[contains(text(),'Clone')]")).click();

          		WebElement sub=driver.findElement(By.xpath("//input[@name='subject']"));
	    		sub.clear();
	    		sub.sendKeys(generateRandomsubject());
	    		
	    		driver.findElement(By.xpath("(//div[@class=' css-qav5hl-singleValue'])[1]")).click();
	    		Thread.sleep(500);
	    		driver.findElement(By.xpath("//div[contains(text(),'Confirmed')]")).click();
	    		Thread.sleep(500);
	    		
	    		WebElement Team=driver.findElement(By.xpath("//input[@name='team']"));
	    		Team.clear();
	    		Team.sendKeys(generateRandomTeam());
	    		
	    		Thread.sleep(500);
	    		driver.findElement(By.xpath("(//div[@class=' css-1xc3v61-indicatorContainer'])[2]")).click();	    	
	    		Thread.sleep(1000);	
	    		driver.findElement(By.xpath("//div[contains(text(),'DHL')]")).click();	    		
	    		 Thread.sleep(1000);
	    		
	    		 Thread.sleep(1000);
	    		JavascriptExecutor js= (JavascriptExecutor)driver;
	    		js.executeScript("window.scrollTo(0,-1000)");
	    		 Thread.sleep(1000);
	    		
	    		driver.findElement(By.xpath("(//span[@class='cursorPointer pt-2 ps-1'])[2]")).click();
	    		driver.findElement(By.xpath("//td[contains(text(),'RAJA')]")).click();
	    		driver.findElement(By.xpath("//button[contains(text(),'Done')]")).click();
	    		
	    		Thread.sleep(2000);
	    		JavascriptExecutor js1= (JavascriptExecutor)driver;
	    		js1.executeScript("window.scrollTo(0,500)");
	    		 Thread.sleep(2000);
	    		
	    		WebElement street=driver.findElement(By.xpath("//input[@name='billingStreet']"));
	    		street.clear();
	    		street.sendKeys(generateRandomBillingStreet());
	    		
	    		
	    		WebElement city=driver.findElement(By.xpath("//input[@name='billingCity']"));
	    		city.clear();
	    		city.sendKeys(generateRandomCity());
	    		Thread.sleep(1000);

	    		WebElement state=driver.findElement(By.xpath("//input[@name='billingState']"));
	    		state.clear();
	    		state.sendKeys(generateRandomState());
	    		Thread.sleep(1000);

	    		WebElement code=driver.findElement(By.xpath("//input[@name='billingCode']"));
	    		code.clear();
	    		code.sendKeys(generateRandomCode());
	    		Thread.sleep(1000);

	    		WebElement country=driver.findElement(By.xpath("//input[@name='billingCountry']"));
	    		country.clear();
	    		country.sendKeys(generateRandomCountry());
	    		
	    		//Shipping 
	    		Thread.sleep(1000);

	    		WebElement street1=driver.findElement(By.xpath("//input[@name='shippingStreet']"));
	    		street1.clear();
	    		street1.sendKeys(generateRandomBillingStreet());
	    		Thread.sleep(1000);

	    		WebElement city1=driver.findElement(By.xpath("//input[@name='shippingCity']"));
	    		city1.clear();
	    		city1.sendKeys(generateRandomCity());
	    		Thread.sleep(1000);

	    		WebElement state1=driver.findElement(By.xpath("//input[@name='shippingState']"));
	    		state1.clear();
	    		state1.sendKeys(generateRandomState());
	    		Thread.sleep(1000);

	    		WebElement code1=driver.findElement(By.xpath("//input[@name='shippingCode']"));
	    		code1.clear();
	    		code1.sendKeys(generateRandomCode());
	    		Thread.sleep(1000);

	    		WebElement country1=driver.findElement(By.xpath("//input[@name='shippingCountry']"));
	    		country1.clear();
	    		country1.sendKeys(generateRandomCountry());
	    		Thread.sleep(1000);

	    		
	    		//driver.findElement(By.xpath("//textarea[@name='termsAndConditions']")).clear();
	    	
	    		WebElement Terms_Conditions=driver.findElement(By.xpath("//textarea[@name='termsAndConditions']"));
	    		Terms_Conditions.clear();
	    		Terms_Conditions.sendKeys(generateRandomTermsConditions());		
	    		Thread.sleep(1000);
	    		
	    		WebElement Descr=driver.findElement(By.xpath("(//textarea[@name='description'])[2]"));
	    		Descr.clear();
	    		Descr.sendKeys(generateRandomDescription());		    		
	    		Thread.sleep(1000);
	    		
	    		
	    		 Thread.sleep(2000);
	    		JavascriptExecutor js2= (JavascriptExecutor)driver;
	    		js2.executeScript("window.scrollTo(0,-1000)");
	    		 Thread.sleep(2000);
	    		
	    		driver.findElement(By.xpath("(//button[contains(text(),'Save')])[2]")).click();
		    	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		    	   
		    	   try {
		    		   WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Quotes information details added Succesfully')]")));
		    		   // If success message is found, print it
				         System.out.println("Success message: " + successMessage.getText());
		    	   }catch(Exception e) {
		    		   System.out.println("No success or error message found.");
		    	   }

	        }
	      
	        
	        @Test(priority=8, dependsOnMethods= ("Login"))
	        void Clone_Quote_Save_and_New() throws InterruptedException 
	        {
	        	
	        	driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
	    		driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	    		driver.findElement(By.xpath("//p[contains(text(),'Quotes')]")).click();
	    		driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();

	    		driver.findElement(By.xpath("(//td[@class='overflow_text subject cursorPointer'])[1]")).click();
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("//button[@class='btn btn-secondary bg-white text-dark border border-primary'][2]")).click();
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("//div[contains(text(),'Clone')]")).click();
	    		
	    		WebElement headerElement = driver.findElement(By.xpath("//h6[contains(text(),'Quote Information')]")); // Replace with actual locator
	            String initialHeaderText = headerElement.getText();
	    		
	    		driver.findElement(By.xpath("(//button[contains(text(),'Save')])[1]")).click();
	    		
		    	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		    	   
		    	   try {
		    		   WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Quotes information details added Succesfully')]")));
		    		   // If success message is found, print it
				         System.out.println("Success message: " + successMessage.getText());
		    	   }catch(Exception e) {
		    		   System.out.println("No success or error message found.");
		    	   }
	        }
         
	        @Test(priority=9, dependsOnMethods= ("Login"))
	        void Mass_Delete_Quote() 
	        {
	        	driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
	    		driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	    		driver.findElement(By.xpath("//p[contains(text(),'Quotes')]")).click();
	    		driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
	    		
	    		driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click();
	    		driver.findElement(By.xpath("(//input[@id='vehicle1'])[2]")).click();
	    		driver.findElement(By.xpath("(//input[@id='vehicle1'])[3]")).click();
	    		driver.findElement(By.xpath("(//input[@id='vehicle1'])[4]")).click();
	    		driver.findElement(By.xpath("(//input[@id='vehicle1'])[5]")).click();

	    		driver.findElement(By.xpath("(//div[@class=' css-qav5hl-singleValue'])[1]")).click();
	    		driver.findElement(By.xpath("//div[contains(text(),'Mass Delete')]")).click();
	    		driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
	    		
	    		

		    	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		    	   
		    	   try {
		    		   WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Quote details deleted successfully.')]")));
		    		   // If success message is found, print it
				         System.out.println("Success message: " + successMessage.getText());
		    	   }catch(Exception e) {
		    		   System.out.println("No success or error message found.");
		    	   }	    		
	        }
	    
	        @Test(priority=10, dependsOnMethods= ("Login"))
	        void Save_and_New_Quote() throws InterruptedException 
	        {
	        	// Navigate through the UI
	        	driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
	        	driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	        	driver.findElement(By.xpath("//p[contains(text(),'Quotes')]")).click();
	        	driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
	        	driver.findElement(By.xpath("(//td[@class='overflow_text subject cursorPointer'])[1]")).click();
	        	Thread.sleep(1000); // Consider replacing with WebDriverWait if needed
	        	driver.findElement(By.xpath("//button[@class='btn btn-secondary bg-white text-dark border border-primary'][2]")).click();
	        	Thread.sleep(1000); // Consider replacing with WebDriverWait if needed
	        	driver.findElement(By.xpath("//div[contains(text(),'Clone')]")).click();

	        	// Capture initial header text
	        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        	WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[contains(text(),'Quote Information')]")));
	        	String initialHeaderText = headerElement.getText().trim();
	        	System.out.println("Initial Header: " + initialHeaderText);

	        	// Click Save and New
	        	driver.findElement(By.xpath("(//button[contains(text(),'Save')])[1]")).click();

	        	// Wait for success message
	        	try {
	        	    WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Quotes information details added Succesfully')]")));
	        	    System.out.println("Success message: " + successMessage.getText());
	        	} catch (Exception e) {
	        	    System.out.println("No success or error message found.");
	        	}

	        	// Wait and capture the header text again
	        	WebElement newHeaderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Create Quote')]")));
	        	String finalHeaderText = newHeaderElement.getText().trim();
	        	System.out.println("Final Header: " + finalHeaderText);

	        	// Verify if the header text remains the same
	        	if (initialHeaderText.equals(finalHeaderText)) {
	        	    System.out.println("Test Passed: The user remains on the same page after clicking 'Save and New'.");
	        	} else {
	        	    System.out.println("Test Failed: The user navigated to a different page.");
	        	}    	        
	        } 
	     */
	        @Test(priority=11, dependsOnMethods= ("Login"))
	        void Quote_Share() throws InterruptedException 
	        {
	        	driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
	        	driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	        	driver.findElement(By.xpath("//p[contains(text(),'Quotes')]")).click();
	        	driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
	        	driver.findElement(By.xpath("(//td[@class='overflow_text subject cursorPointer'])[1]")).click();
	        	Thread.sleep(1000); // Consider replacing with WebDriverWait if needed
	        	driver.findElement(By.xpath("//button[@class='btn btn-secondary bg-white text-dark border border-primary'][2]")).click();
	        	Thread.sleep(1000); // Consider replacing with WebDriverWait if needed
	        	driver.findElement(By.xpath("//div[contains(text(),'Share')]")).click();
	        	
	        	 try {
	   	          // Check if the 'Revoke' button is present on the page
	   	          List<WebElement> revokeButton = driver.findElements(By.xpath("//span[text()='Revoke Sharing']"));

	   	          if (revokeButton.size() > 0) {
	   	              // If the Revoke button is present, click it
	   	              revokeButton.get(0).click();	   	            
	   	              driver.findElement(By.xpath("//button[contains(text(),'Revoke')]")).click();
	   	              Thread.sleep(1000);
	   	              System.out.println("Revoke button clicked");
	   	              
	   	              
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
	   	              System.out.println("Revoke button not found. We can share the Quote");
	   	              
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
	    /*
	        @Test(priority=12, dependsOnMethods= ("Login"))
	        void Quote_Mass_Update() 
	        {
	        	
	        	driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
	        	driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	        	driver.findElement(By.xpath("//p[contains(text(),'Quotes')]")).click();
	        	
	         	driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
	        
	        	driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click();
	        	driver.findElement(By.xpath("(//input[@id='vehicle1'])[2]")).click();
	        	driver.findElement(By.xpath("(//input[@id='vehicle1'])[3]")).click();
	        	driver.findElement(By.xpath("(//input[@id='vehicle1'])[4]")).click();
	        	driver.findElement(By.xpath("(//input[@id='vehicle1'])[5]")).click();
	        	
	        	driver.findElement(By.xpath("(//div[@class=' css-qav5hl-singleValue'])[1]")).click();
	    		driver.findElement(By.xpath("//div[contains(text(),'Mass Update')]")).click();
	        	
	    		
	    		driver.findElement(By.xpath("//input[@id='massValue']")).sendKeys("Image add");
	    		driver.findElement(By.xpath("//button[@class='createContactButtonSave']")).click();
	        	}
	        	
	    
	   
	        @Test(priority=13, dependsOnMethods= ("Login"))
	        void Quote_Mass_Transfer() throws InterruptedException 
	        {
	        	
	        	driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
	        	driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	        	driver.findElement(By.xpath("//p[contains(text(),'Quotes')]")).click();
	        	
	         	driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
	        		         	
	        	driver.findElement(By.xpath("(//input[@id='vehicle1'])[1]")).click();
	        	driver.findElement(By.xpath("(//input[@id='vehicle1'])[2]")).click();
	        	driver.findElement(By.xpath("(//input[@id='vehicle1'])[3]")).click();
	        	driver.findElement(By.xpath("(//input[@id='vehicle1'])[4]")).click();
	        	driver.findElement(By.xpath("(//input[@id='vehicle1'])[5]")).click();
	        	
	        	driver.findElement(By.xpath("(//div[@class=' css-qav5hl-singleValue'])[1]")).click();
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
	        
	        
	        
	        @Test(priority=14, dependsOnMethods= ("Login"))
	        void Quote_Notes_Functionality() throws InterruptedException 
	        {
	        	
	        	driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
	        	driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	        	driver.findElement(By.xpath("//p[contains(text(),'Quotes')]")).click();
	        	
	         	driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();	
	         	driver.findElement(By.xpath("(//td[@class='overflow_text subject cursorPointer'])[1]")).click();
	        	
	         	driver.findElement(By.xpath("//li[contains(text(),'Notes')]")).click();
	         	Thread.sleep(2000);
	         
	         	
	         	driver.findElement(By.xpath("//textarea[@class='notesClass']")).click();
	        	driver.findElement(By.xpath("(//input[@type='text'])[17]")).sendKeys("HJKJKHJKH sjfhhjk");
	         	Thread.sleep(1000);
	        	driver.findElement(By.xpath("//textarea[@class='notesClass']")).sendKeys("Yenagutte sjfhhjk");	        	
	         	Thread.sleep(1000);  
	         	
	         	String filepath= "C:\\Users\\Lokesh R B\\Desktop\\New Docx\\sa1.jpg";
	         	WebElement fileinput=driver.findElement(By.xpath("(//input[@type='file'])"));
	         	fileinput.sendKeys(filepath);         	
	          	driver.findElement(By.xpath("//button[@class='editNoteButton']")).click();
	          
	        }
	  
	        @Test(priority=15, dependsOnMethods= ("Login"))
	        void Quote_Related_List_Sales_Order() throws InterruptedException
	        {
	        	
	        	
	        	driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
	        	driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	        	driver.findElement(By.xpath("//p[contains(text(),'Quotes')]")).click();
	        	
	         	driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();	
	         	driver.findElement(By.xpath("(//td[@class='overflow_text subject cursorPointer'])[1]")).click();
	        	
	         	
	         	driver.findElement(By.xpath("//li[contains(text(),'Sales Orders')]")).click();
	         	Thread.sleep(1000);
	         	
	         	driver.findElement(By.xpath("//button[contains(text(),'New')]")).click();
	         	Thread.sleep(500);
	         	WebElement sub=driver.findElement(By.xpath("//input[@name='subject']"));
	         	sub.sendKeys(generateRandomsubject());
	         	
	         	
	        	WebElement custno=driver.findElement(By.xpath("//input[@name='customerNo']"));
	         	custno.sendKeys(generateRandomcustmerNo());
	         	
	          	JavascriptExecutor js0=(JavascriptExecutor) driver;
                js0.executeScript("window.scrollTo(0,500)");	 
	    		Thread.sleep(1000);
	         	
	         	driver.findElement(By.xpath("(//span[@class='leadInputField cursorPointer rounded-1 pt-2'])[3]")).click();
	         	driver.findElement(By.xpath("(//div[@class='d-flex flex-column'])[2]")).click();     	
	          	driver.findElement(By.xpath("//input[@name='pending']")).sendKeys("Import Error");
	        
	          	JavascriptExecutor js=(JavascriptExecutor) driver;
                js.executeScript("window.scrollTo(0,500)");	 
	    		Thread.sleep(1000);

               driver.findElement(By.xpath("(//div[@class=' css-1xc3v61-indicatorContainer'])[1]")).click();
	         	Thread.sleep(500);
	        	
	    		driver.findElement(By.xpath("//div[contains(text(),'UPS')]")).click();
	    		

	    		driver.findElement(By.xpath("//input[@name='salesCommission']")).sendKeys("123");
	    		Thread.sleep(500);
	    		driver.findElement(By.xpath("(//span[@class='cursorPointer pt-2 ps-1'])[5]")).click();
	    		 
	    		driver.findElement(By.xpath("(//td[contains(text(),'')])[17]")).click();
	    		driver.findElement(By.xpath("//button[contains(text(),'Done')]")).click();
	    		
	    		
	    		JavascriptExecutor js1=(JavascriptExecutor)driver; 
	    		js1.executeScript("window.scrollTo(0,-1000)");
	    		Thread.sleep(1000);

	    		driver.findElement(By.xpath("(//span[@class='cursorPointer pt-2 ps-1'])[2]")).click();
	    		 
	    		driver.findElement(By.xpath("(//td[contains(text(),'')])[17]")).click();
	    		driver.findElement(By.xpath("//button[contains(text(),'Done')]")).click();
	    		Thread.sleep(1000);
	    		
	    		
	    	    WebElement	puOrder=driver.findElement(By.xpath("//input[@name='purchaseOrder']"));
	    		puOrder.sendKeys(generateRandomPurchaseOrder());
	    		
	    		
	    		JavascriptExecutor js2=(JavascriptExecutor)driver;
	    		js2.executeScript("window.scrollTo(0,500)");
	    		Thread.sleep(500);
	    		
	    		driver.findElement(By.xpath("(//span[@class='cursorPointer pt-2 ps-1'])[4]")).click();
	    		driver.findElement(By.xpath("//td[contains(text(),'Android iOS')]")).click();
	    		driver.findElement(By.xpath("//button[contains(text(),'Done')]")).click();
	    		Thread.sleep(1500);
	    		WebElement Excduty=driver.findElement(By.xpath("//input[@name='exciseDuty']"));
	    		Excduty.sendKeys(generateRandomPurchaseOrder());
	    		Thread.sleep(500);
	    		driver.findElement(By.xpath("(//div[@class=' css-qav5hl-singleValue'])[2]")).click();
	    		driver.findElement(By.xpath("//div[contains(text(),'Delivered')]")).click();
	    		
	    		JavascriptExecutor js3=(JavascriptExecutor)driver;
	    		js3.executeScript("window.scrollTo(0,1000)");
	    		Thread.sleep(1500);
	    		
	    		
	    		WebElement street=driver.findElement(By.xpath("//input[@name='billingStreet']"));
	    		street.sendKeys(generateRandomBillingStreet());
	    		Thread.sleep(500);
	    		
	    		WebElement city=driver.findElement(By.xpath("//input[@name='billingCity']"));
	    		city.sendKeys(generateRandomCity());
	    		Thread.sleep(500);

	    		WebElement state=driver.findElement(By.xpath("//input[@name='billingState']"));
	    		state.sendKeys(generateRandomState());
	    		Thread.sleep(1000);

	    		WebElement code=driver.findElement(By.xpath("//input[@name='billingCode']"));
	    		code.sendKeys(generateRandomCode());
	    		Thread.sleep(500);

	    		WebElement country=driver.findElement(By.xpath("//input[@name='billingCountry']"));
	    		country.sendKeys(generateRandomCountry());
	    		
	    		//Shipping 
	    		Thread.sleep(500);

	    		WebElement street1=driver.findElement(By.xpath("//input[@name='shippingStreet']"));
	    		street1.sendKeys(generateRandomBillingStreet());
	    		Thread.sleep(500);

	    		WebElement city1=driver.findElement(By.xpath("//input[@name='shippingCity']"));
	    		city1.sendKeys(generateRandomCity());
	    		Thread.sleep(500);

	    		WebElement state1=driver.findElement(By.xpath("//input[@name='shippingState']"));
	    		state1.sendKeys(generateRandomState());
	    		Thread.sleep(500);

	    		WebElement code1=driver.findElement(By.xpath("//input[@name='shippingCode']"));
	    		code1.sendKeys(generateRandomCode());
	    		Thread.sleep(500);

	    		WebElement country1=driver.findElement(By.xpath("//input[@name='shippingCountry']"));
	    		country1.sendKeys(generateRandomCountry());
	    		Thread.sleep(500);

	    		
	    		WebElement Terms=driver.findElement(By.xpath("//textarea[@name='termsAndConditions']"));
	    		Terms.sendKeys(generateRandomTermsConditions());
	    		Thread.sleep(500);
	    		
	    		
	    		WebElement Descr=driver.findElement(By.xpath("(//textarea[@name='description'])[2]"));
	    		Descr.sendKeys(generateRandomDescription());	
	    		
	    		 Thread.sleep(2000);
	    		JavascriptExecutor js4= (JavascriptExecutor)driver;
	    		js4.executeScript("window.scrollTo(0,-1000)");
	    		Thread.sleep(2000);
	    		driver.findElement(By.xpath("(//button[contains(text(),'Save')])[2]")).click();
	    		Thread.sleep(2000);
	    		driver.findElement(By.xpath("//h4[contains(text(),'Sales order  details added Succesfully')]")).click();
	    		Thread.sleep(1000);
	    		
	    		
   		
	    		
//	    		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
//	    		try {
//	    		WebElement	successmessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Sales order  details added Succesfully')]")));
//	    		//If success message display
//	    			System.out.println("Success message:" + successmessage.getText());
//	    		
//	    		}catch(Exception e) {
//	    			 System.out.println("No success or error message found.");
//	    		}
	        }
	       
	        
	        @Test(priority=16, dependsOnMethods= ("Login"))
	        void Quote_Overview_page() throws InterruptedException
	        {
	        
	        	driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
	        	driver.findElement(By.xpath("//p[contains(text(),'Commerce')]")).click();
	        	driver.findElement(By.xpath("//p[contains(text(),'Quotes')]")).click();
	        	
	         	driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();	
	         	driver.findElement(By.xpath("(//td[@class='overflow_text subject cursorPointer'])[1]")).click();	        	
	         	
	         	JavascriptExecutor js5=(JavascriptExecutor)driver;
	         	js5.executeScript("window.scrollTo(0,500)");
	         	Thread.sleep(2000);

	         	WebElement subj=driver.findElement(By.xpath("//input[@name='subject']"));
	         	subj.click();
	         	Thread.sleep(500);
	         	subj.sendKeys(generateRandomsubject());
	         	driver.findElement(By.xpath("//span[@class='ps-2 cursorPointer']")).click();
	         	
	         	driver.findElement(By.xpath("//input[@name='quoteStageInfo']")).click();
	         	driver.findElement(By.xpath("//div[@class=' css-1xc3v61-indicatorContainer']")).click();
	         	
	         	driver.findElement(By.xpath("(//div[contains(text(),'Delivered')])[2]")).click();
	         	driver.findElement(By.xpath("//span[@class='ps-2 cursorPointer']")).click();
	            WebElement TeamInfo	=driver.findElement(By.xpath("//input[@name='teamInfo']"));
	            TeamInfo.click();
	            TeamInfo.sendKeys(generateRandomTeam());
	         	driver.findElement(By.xpath("//span[@class='ps-2 cursorPointer']")).click();

	         	driver.findElement(By.xpath("//input[@name='carrierInfo']")).click();

	         	driver.findElement(By.xpath("//div[@class=' css-1xc3v61-indicatorContainer']")).click();
	         	driver.findElement(By.xpath("//div[contains(text(),'UPS')]")).click();
	         	driver.findElement(By.xpath("//span[@class='ps-2 cursorPointer']")).click();
	         	
	         	WebElement BSI=driver.findElement(By.xpath("//input[@name='billingStreetInfo']"));
                BSI.sendKeys(generateRandomBillingStreet());
                     	
	        }
        	   */     
}	