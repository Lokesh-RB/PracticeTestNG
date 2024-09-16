package TestNGPayC;

import java.awt.Window;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Individual {
	WebDriver driver;
	//private WebDriver driver;
	
	 // Static method to generate a random name
    public static String generateRandomName() {
        String[] MESSAGE_ELEMENTS = {"John", "Jane", "David", "Emily", "Michael", "Sarah", "Alex", "Emma", "Ryan", "Olivia"};
        Random random = new Random();
        return MESSAGE_ELEMENTS[random.nextInt(MESSAGE_ELEMENTS.length)];
    }
    // Static method to generate a random account number
    public static String generateRandomAccountNumber() {
        StringBuilder accountNumber = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            accountNumber.append(random.nextInt(10));
        }
    	return accountNumber.toString();
    }
    // Static method to generate a random Mobile number
    public static String generateRandomMobileNumber() {
        StringBuilder mobileNumber = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            mobileNumber.append(random.nextInt(10));
        }
    	return mobileNumber.toString();
    }
    public static String generateRandomEmail(String name) {
        String[] emailProviders = {"mailinator.com"};
        Random random = new Random();
        return name.toLowerCase() + random.nextInt(1000) + "@" + emailProviders[random.nextInt(emailProviders.length)];
    }
	  @BeforeClass 
	 public void LoginSetup() throws InterruptedException {
		    WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			Thread.sleep(1000);
			driver.manage().window().maximize();
			Thread.sleep(3000);
			driver.get("https://siladev.paycircle.io/");
			Thread.sleep(1000);
	  }	 
	 @Test(priority = 1,retryAnalyzer=listeners.MyRetryAnalyzer.class)
	  public void Login() throws InterruptedException 
	  {
			  driver.findElement(By.xpath("//input[@class='mobileNum']")).sendKeys("9000000005");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//input[@class='passWord']")).sendKeys("Loki@123");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//button[@class='continueSignIn']")).click();
			  Thread.sleep(3000);				
			  List<WebElement> buttons = driver.findElements(By.xpath("//button[@class='sessionExpireButton']"));
		       if (!buttons.isEmpty()) 
		       {
		           
		    	   // Click the first button if it is present
		            buttons.get(0).click();
		            System.out.println("Clicked the first button.");
		    		Thread.sleep(8000);
		    	}		  
	  }
     
	   @Test(priority = 2,retryAnalyzer=listeners.MyRetryAnalyzer.class)
      public void Deposit_Sameday_ACH() throws InterruptedException
	  {
		//  driver.findElement(By.xpath("//span[contains(text(),'Deposit')]")).click();
		   WebDriverWait want = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
	        want.until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	              //  return driver.findElement(By.xpath("//span[contains(text(),'Deposit')]")).isEnabled();
	            	  return driver.findElement(By.xpath("//span[contains(text(),'Deposit')]")).isDisplayed();
	            }
	        });

	        // Once the button is enabled, locate it and click
	        WebElement buteon = driver.findElement(By.xpath("//span[contains(text(),'Deposit')]"));
	        buteon.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='search_input_wallet']")).sendKeys("USD");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//img[@src='/static/media/Dollar-USD-icon.e5efcca16f825149a37184c86e2c3301.svg']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@class='enable-button fw-bold']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//label[@for='Same Day ACHdes']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@class='enable-button fw-bold']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='currencyInput']")).sendKeys("20");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='SelectBank_container d-flex  justify-content-between ']")).click();
			Thread.sleep(3000); 
			driver.findElement(By.xpath("//div[@class='cardContainer d-flex align-items-center gap-3 mb-4 text-white border-0'][1]")).click();
			Thread.sleep(1000); 
			driver.findElement(By.xpath("//button[@class='bankModel_cont_button fw-bold']")).click();
			Thread.sleep(1500);  
	  		driver.findElement(By.xpath("//button[@class='enable-button fw-bold']")).click();
	  		Thread.sleep(1000); 
	  		
	  		driver.findElement(By.xpath("//button[@class=' depositButton']")).click();
	  		//Thread.sleep(24000);
	  		
	  		
	  	    // Wait until the button becomes enabled after entering the OTP
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
	        wait.until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return driver.findElement(By.xpath("//button[@class='enable-button fw-bold ']")).isEnabled();
	            }
	        });

	        // Once the button is enabled, locate it and click
	        WebElement button = driver.findElement(By.xpath("//button[@class='enable-button fw-bold ']"));
	        button.click();	  	
	        
	        
	   String actual_error  =   driver.findElement(By.xpath("//span[@class=\"d-flex justify-content-center\"]")).getText();
	       String  Expected_Result= "Transaction Initiation Successful!";
	       Assert.assertEquals(actual_error, Expected_Result);
	 
	  }
	 
	  //Dashboard search Same Day ACH
@Test(priority = 3, retryAnalyzer=listeners.MyRetryAnalyzer.class)
     public void Dashboard_Deposit_SameDay_ACH() throws InterruptedException 
     {
	//  driver.findElement(By.xpath("//span[contains(text(),'Deposit')]")).click();
	   WebDriverWait want = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
     want.until(new ExpectedCondition<Boolean>() {
         public Boolean apply(WebDriver driver) {
           //  return driver.findElement(By.xpath("//span[contains(text(),'Deposit')]")).isEnabled();
         	  return driver.findElement(By.xpath("//span[contains(text(),'Deposit')]")).isDisplayed();
         }
     });

     // Once the button is enabled, locate it and click
     WebElement buteon = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		// driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("USD");
		 Thread.sleep(2000);
         driver.findElement(By.xpath("(//span[contains(text(),'Deposit')])[2]"));
         //  driver.findElement(By.name("Deposit- Same Day ACH - savings"));
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@id='currencyInput']")).sendKeys("12");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[contains(text(),'Deposit again')]")).click();
		 
		  // Wait until the button becomes enabled after entering the OTP
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
	        wait.until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) { 
	            	
	                return driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).isEnabled();
	            }
	        });

	        // Once the button is enabled, locate it and click
	        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
	        button.click();	
  }
	  	    	    
      @Test(priority = 4, retryAnalyzer=listeners.MyRetryAnalyzer.class)
      public void Deposit_Standard_ACH() throws InterruptedException
      {
		   // Wait until the Dashboard becomes displaye
    	  WebDriverWait want = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
	        want.until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	              //  return driver.findElement(By.xpath("//span[contains(text(),'Deposit')]")).isEnabled();
	            	  return driver.findElement(By.xpath("//span[contains(text(),'Deposit')]")).isDisplayed();
	            }
	        });

	        // Once the button is enabled, locate it and click
	        WebElement buteon = driver.findElement(By.xpath("//span[contains(text(),'Deposit')]"));
	        buteon.click();
    	  
    	//	driver.findElement(By.xpath("//span[contains(text(),'Deposit')]")).click();
  	  		Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='search_input_wallet']")).sendKeys("USD");
  	  		Thread.sleep(3000);
  	  		driver.findElement(By.xpath("//img[@src='/static/media/Dollar-USD-icon.e5efcca16f825149a37184c86e2c3301.svg']")).click();
  	  		Thread.sleep(2000);
  	  		driver.findElement(By.xpath("//button[@class='enable-button fw-bold']")).click();
  	  		Thread.sleep(3000);
			driver.findElement(By.xpath("//label[@for='Standard ACHdes']")).click();
  	  		Thread.sleep(3000);
  	  		driver.findElement(By.xpath("//button[@class='enable-button fw-bold']")).click();
  	  		Thread.sleep(3000);
  	  		driver.findElement(By.xpath("//input[@id='currencyInput']")).sendKeys("80");
  	  		Thread.sleep(2000);
  	  	driver.findElement(By.xpath("//div[@class='SelectBank_container d-flex  justify-content-between ']")).click();
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//div[@class='cardContainer d-flex align-items-center gap-3 mb-4 text-white border-0'][1]")).click();
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//button[@class='bankModel_cont_button fw-bold']")).click();
		Thread.sleep(1500);  
  		driver.findElement(By.xpath("//button[@class='enable-button fw-bold']")).click();
  		Thread.sleep(1000); 
  		
  		driver.findElement(By.xpath("//button[@class=' depositButton']")).click();
  		//Thread.sleep(24000);
  		
  		
  	    // Wait until the button becomes enabled after entering the OTP
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(By.xpath("//button[@class='enable-button fw-bold ']")).isEnabled();
            }
            
        });

        // Once the button is enabled, locate it and click
        WebElement button = driver.findElement(By.xpath("//button[@class='enable-button fw-bold ']"));
        button.click();	  			  		
  }
      	  //Dashboard search Standard ACH
@Test(priority = 5, retryAnalyzer=listeners.MyRetryAnalyzer.class)
     public void Dashboard_Standard_ACH() throws InterruptedException 
     {
		 driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("USD");
		 Thread.sleep(2000);
		  driver.findElement(By.xpath("(//span[contains(text(),'Deposit')])[2]"));
		  Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@id='currencyInput']")).sendKeys("12");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[contains(text(),'Deposit again')]")).click();
		 
		  // Wait until the button becomes enabled after entering the OTP
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
	        wait.until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) { 
	            	
	                return driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).isEnabled();
	            }
	        });

	        // Once the button is enabled, locate it and click
	        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
	        button.click();	
  }
       	
@Test(priority = 6, retryAnalyzer=listeners.MyRetryAnalyzer.class)
public void Recent_Deposit() throws InterruptedException
{
	 // Wait until the Dashboard becomes displaye
	  WebDriverWait wat = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
      wat.until(new ExpectedCondition<Boolean>() {
          public Boolean apply(WebDriver driver) 
          {
            //  return driver.findElement(By.xpath("//span[contains(text(),'Deposit')]")).isEnabled();
          	  return driver.findElement(By.xpath("//span[contains(text(),'Deposit')]")).isDisplayed();
          }
      });

      // Once the button is enabled, locate it and click
      WebElement buton = driver.findElement(By.xpath("//span[contains(text(),'Deposit')]"));
      buton.click();
      
	//		driver.findElement(By.xpath("//span[contains(text(),'Deposit')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//span[contains(text(),'Deposit')])[2]")).click();
			Thread.sleep(3000);		
			driver.findElement(By.xpath("//input[@id='currencyInput']")).clear();
			Thread.sleep(2000);		
			driver.findElement(By.xpath("//input[@id='currencyInput']")).sendKeys("25");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='enable-button fw-bold']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class=' depositButton']")).click();

	  	    // Wait until the button becomes enabled after entering the OTP
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
	        wait.until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return driver.findElement(By.xpath("//button[@class='enable-button fw-bold ']")).isEnabled();
	            }
	        });

	        // Once the button is enabled, locate it and click
	        WebElement button = driver.findElement(By.xpath("//button[@class='enable-button fw-bold ']"));
	        button.click();	
}
     
   @Test(priority = 7, retryAnalyzer=listeners.MyRetryAnalyzer.class)
     public void Fiat_PayCircle_To_PayCircle_Transfer() throws InterruptedException 
     {
	   
		 // Wait until the Dashboard becomes displaye
		  WebDriverWait wat = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
	      wat.until(new ExpectedCondition<Boolean>() {
	          public Boolean apply(WebDriver driver) {
	            //  return driver.findElement(By.xpath("//span[contains(text(),'Transfer')]")).isEnabled();
	          	  return driver.findElement(By.xpath("//span[contains(text(),'Transfer')]")).isDisplayed();
	          }
	      });
       
	      // Once the button is enabled, locate it and click
	      WebElement buton = driver.findElement(By.xpath("//span[contains(text(),'Transfer')]"));
	      buton.click();
	      
    	// 	driver.findElement(By.xpath("//span[contains(text(),'Transfer')]")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//input[@id='search_wallet_asset']")).sendKeys("USD");
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//img[@src='/static/media/Dollar-USD-icon.e5efcca16f825149a37184c86e2c3301.svg']")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//input[@id='search_account']")).sendKeys("5432167890");
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//div[contains(text(),'Charan  Raj_01')]")).click();
    		Thread.sleep(3000);    			
    		
    		WebElement continueButton = driver.findElement(By.xpath("//button[@class='enable-button']")); // Adjust the XPath as necessary
    		Thread.sleep(1000);
            // Click the button using JavaScript
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Thread.sleep(1000);
            js.executeScript("arguments[0].click();", continueButton);
	    	
    		driver.findElement(By.xpath("//input[@value='Pay now']")).click();
    		Thread.sleep(1000);
    		driver.findElement(By.xpath("//input[@id='currencyInput']")).sendKeys("3");
    		Thread.sleep(1000);
     		
    		driver.findElement(By.xpath("//button[@class='enable-button']")).click();
    		  // Wait until the button becomes enabled after entering the OTP
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
	        wait.until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return driver.findElement(By.xpath("//button[@class='enable-button']")).isEnabled();
	            }
	        });

	        // Once the button is enabled, locate it and click
	        WebElement button = driver.findElement(By.xpath("//button[@class='enable-button']"));
	        button.click();	
    		
     }
   
     //Dashboard search Tansfer Now
@Test(priority = 8, retryAnalyzer=listeners.MyRetryAnalyzer.class)
     public void Dashboard_Transfer_Now() throws InterruptedException 
     {
		 driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("USD");
		 Thread.sleep(2000);
         driver.findElement(By.xpath("(//span[contains(text(),'Transfer')])[3]"));
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@id='currencyInput']")).sendKeys("2");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[contains(text(),'Transfer again')]")).click();
		 
		  // Wait until the button becomes enabled after entering the OTP
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
	        wait.until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) { 
	            	
	                return driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).isEnabled();
	            }
	        });

	        // Once the button is enabled, locate it and click
	        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
	        button.click();	
  }
      
      @Test(priority = 9, retryAnalyzer=listeners.MyRetryAnalyzer.class)
      public void Recent_Transfer() throws InterruptedException 
      {
 		 // Wait until the Dashboard becomes displaye
		  WebDriverWait wat = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
	      wat.until(new ExpectedCondition<Boolean>() {
	          public Boolean apply(WebDriver driver) {
	            //  return driver.findElement(By.xpath("//span[contains(text(),'Transfer')]")).isEnabled();
	          	  return driver.findElement(By.xpath("//span[contains(text(),'Transfer')]")).isDisplayed();
	          }
	      });

	      // Once the button is enabled, locate it and click
	      WebElement buton = driver.findElement(By.xpath("//span[contains(text(),'Transfer')]"));
	      buton.click();
			Thread.sleep(2000);
    	//  	driver.findElement(By.xpath("//span[contains(text(),'Transfer')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[contains(text(),'Transfer')])[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@value='Pay now']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='enable-button']")).click();
  		  // Wait until the button becomes enabled after entering the OTP
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
	        wait.until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return driver.findElement(By.xpath("//button[@class='enable-button']")).isEnabled();
	            }
	        });

	        // Once the button is enabled, locate it and click
	        WebElement button = driver.findElement(By.xpath("//button[@class='enable-button']"));
	        button.click();	
   }
      
    @Test(priority = 10, retryAnalyzer=listeners.MyRetryAnalyzer.class)
    public void Splitpayment() throws InterruptedException 
    {
    		
    	// Wait until the Dashboard becomes displaye
		  WebDriverWait wat = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
	      wat.until(new ExpectedCondition<Boolean>() {
	          public Boolean apply(WebDriver driver) {
	            //  return driver.findElement(By.xpath("//span[contains(text(),'Transfer')]")).isEnabled();
	          	  return driver.findElement(By.xpath("//span[contains(text(),'Transaction History')]")).isDisplayed();
	          }
	      });

	      // Once the button is enabled, locate it and click
	      WebElement buton = driver.findElement(By.xpath("//span[contains(text(),'Transaction History')]"));
	      buton.click();
    	
    //	driver.findElement(By.xpath("//span[contains(text(),'Transaction History')]")).click();
    		Thread.sleep(2000);
    		
    		driver.findElement(By.xpath("(//span[contains(text(),'Transfer')])[3]")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("(//td[contains(text(),'Settled')])[1]")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//button[@class='enable-button fw-bold mb-2 mx-auto']")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//input[@id='expenseName']")).sendKeys("Room Rent");
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//input[@id='search_input_wallet']")).sendKeys("9000000002");
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//span[contains(text(),'xxxxxxxx')]")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//button[@class='fw-bold mx-auto enable-button']")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//button[@class='enable-button fw-bold']")).click();
    		Thread.sleep(2000);
    	
    }
   
   @Test(priority = 11, retryAnalyzer=listeners.MyRetryAnalyzer.class)
    public void splitpayment_remainder_markaspaid() throws InterruptedException 
    {
    		driver.findElement(By.xpath("//span[contains(text(),'Split Pay')]")).click();
    		Thread.sleep(3000);
    		driver.findElement(By.xpath("//a[contains(text(),'Room Rent')]")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//span[contains(text(),'Send reminder')]")).click();
    		Thread.sleep(3000);
    		driver.findElement(By.xpath("//button[contains(text(),'Remind')]")).click();
    		Thread.sleep(4000);
    		driver.findElement(By.xpath("//span[@class=' splitAPIBtn cursorPointer']")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//button[@class=' firstLetterUpperCase']")).click();
    		Thread.sleep(4000);
    	
    }
   
    @Test(priority = 12, retryAnalyzer=listeners.MyRetryAnalyzer.class)
    public void Transfer_Others() throws InterruptedException 
    {			   
	    driver.findElement(By.xpath("//span[contains(text(),'Transfer')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='search_wallet_asset']")).sendKeys("USD");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='/static/media/Dollar-USD-icon.e5efcca16f825149a37184c86e2c3301.svg']")).click();
		Thread.sleep(2000);

		WebElement messageElement2=driver.findElement(By.xpath("//input[@id='search_account']"));
		messageElement2.click();
	    messageElement2.sendKeys(generateRandomMobileNumber());
	   
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//button[@class='enable-button']")).click();
		Thread.sleep(2000);
		
		WebElement messageElement=driver.findElement(By.xpath("//input[@name='benifName']"));
		messageElement.click();
	    messageElement.sendKeys(generateRandomName());
			
//	    String S1=generateRandomName();
	    
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='benifBankName']")).sendKeys("State bank of india");
		Thread.sleep(1000);
		
		WebElement messageElement1=driver.findElement(By.xpath("//input[@name='benifAccountNumber']"));
		messageElement1.click();
		messageElement1.sendKeys(generateRandomAccountNumber());	
		
		//Account type Dropdown
		driver.findElement(By.xpath("//div[contains(text(),'SAVINGS')]")).click();
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//div[contains(text(),'CHECKING')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='benifRoutingNumber']")).sendKeys("021001208");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@name='benifEmail']")).sendKeys("shankar@mailinator.com");
		Thread.sleep(1000);
		
//		WebElement messageElement3=driver.findElement(By.xpath("//input[@name='benifEmail']"));
		
		 String randomName = generateRandomName();
	     String randomEmail = generateRandomEmail(randomName);
	     WebElement emailElement = driver.findElement(By.xpath("//input[@name='benifEmail']"));
	     emailElement.click();
	     emailElement.sendKeys(randomEmail);
		
	     
		
		
		driver.findElement(By.xpath("//input[@name='benifReference']")).sendKeys("Refer#u77");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='benifStreetOne']")).sendKeys("Palace road");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='benifStreetTwo']")).sendKeys("2nd Main");
		Thread.sleep(1000);
		
		//Benef State Dropdown
		driver.findElement(By.xpath("//input[@id='react-select-3-input']")).click();	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'California')]")).click();
		Thread.sleep(2000);	    

		
		//Benef City Dropdown
		driver.findElement(By.xpath("//input[@id='react-select-4-input']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[contains(text(),'Agoura')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='benifZipcode']")).sendKeys("46860");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='bankStreetOne']")).sendKeys("Church street");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='bankStreetTwo']")).sendKeys("3rd Main");
		Thread.sleep(1000);
		
		//Bank State Dropdown
		driver.findElement(By.xpath("//input[@id='react-select-5-input']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[contains(text(),'Colorado')]")).click();
		Thread.sleep(2000);
		
		//Bank City Dropdown
		driver.findElement(By.xpath("//input[@id='react-select-6-input']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Akron')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='bankPostalcode']")).sendKeys("46861");
		
		driver.findElement(By.xpath("//button[@class='manageadd_button px-5 py-2']")).click();
		Thread.sleep(22000);
    		
    		//Transfer Other Amount page
    		driver.findElement(By.xpath("//input[@id='currencyInput']")).sendKeys("11");
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//button[@class='enable-button']")).click();
    		Thread.sleep(23000);
    	
    }
        
      @Test(priority = 12, retryAnalyzer=listeners.MyRetryAnalyzer.class)
      public void Transfer_OneTime() throws InterruptedException {
    	 
    	  		driver.findElement(By.xpath("//span[contains(text(),'Transfer')]")).click();
    			Thread.sleep(2000);
    			driver.findElement(By.xpath("//input[@id='search_wallet_asset']")).sendKeys("USD");
    			Thread.sleep(2000);
    			driver.findElement(By.xpath("//img[@src='/static/media/Dollar-USD-icon.e5efcca16f825149a37184c86e2c3301.svg']")).click();
    			Thread.sleep(2000);
    			driver.findElement(By.xpath("//input[@id='search_account']")).sendKeys("9911223346");
    			Thread.sleep(1000);
    			driver.findElement(By.xpath("//div[contains(text(),'Malinga  Lasith')]")).click();
    			Thread.sleep(1000);
    			driver.findElement(By.xpath("//button[@class='enable-button']")).click();
    			Thread.sleep(2000);
       			driver.findElement(By.xpath("//input[@value='Pay later']")).click();
    			Thread.sleep(1000);
    			
    			//Select date
    			WebElement p = driver.findElement(By.xpath("//input[@placeholder='Select date']")); 
    			Thread.sleep(2000); 
    			p.click(); 
    			Thread.sleep(2000); 

    			//Select date(Next year)
    			driver.findElement(By.xpath("//span[@class='react-datepicker__year-read-view--selected-year']")).click();		 
    			driver.findElement(By.xpath("//div[text()='2025']")).click(); 
    			Thread.sleep(2000); 
    			driver.findElement(By.xpath("//div[text()='25']")).click(); 
    			Thread.sleep(2000); 
    			driver.findElement(By.xpath("//button[@class='enable-button']")).click();
    			Thread.sleep(2000);
    			
    			//Transfer Onetime Amount page
    			driver.findElement(By.xpath("//input[@id='currencyInput']")).sendKeys("1.10");
    			Thread.sleep(1000); 
    			driver.findElement(By.xpath("//button[@class='enable-button']")).click();
    			// Wait until the button becomes enabled after entering the OTP
    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
    	        wait.until(new ExpectedCondition<Boolean>() {
    	            public Boolean apply(WebDriver driver) {
    	                return driver.findElement(By.xpath("//button[@class='enable-button']")).isEnabled();
    	            }
    	        });
    	        // Once the button is enabled, locate it and click
    	        WebElement button = driver.findElement(By.xpath("//button[@class='enable-button']"));
    	        button.click();	
    			
    	 
    	
      }  
        
      @Test(priority = 13, retryAnalyzer=listeners.MyRetryAnalyzer.class)
      public void Transfer_Recurring() throws InterruptedException {
    	
    		    driver.findElement(By.xpath("//span[contains(text(),'Transfer')]")).click();
    			Thread.sleep(2000);
    			driver.findElement(By.xpath("//input[@id='search_wallet_asset']")).sendKeys("USD");
    			Thread.sleep(2000);
    			driver.findElement(By.xpath("//img[@src='/static/media/Dollar-USD-icon.e5efcca16f825149a37184c86e2c3301.svg']")).click();
    			Thread.sleep(2000);
    			driver.findElement(By.xpath("//input[@id='search_account']")).sendKeys("9911223346");
    			Thread.sleep(1000);
    			driver.findElement(By.xpath("//div[contains(text(),'Malinga  Lasith')]")).click();
    			Thread.sleep(2000);
    			driver.findElement(By.xpath("//button[@class='enable-button']")).click();
    			Thread.sleep(2000);   			
    			driver.findElement(By.xpath("//input[@value='Pay later']")).click();
    			Thread.sleep(1000);
    			driver.findElement(By.xpath("//input[@id='recurring']")).click(); 
    			Thread.sleep(1000); 
    			
    			// Locate the slider element
    			WebElement slider = driver.findElement(By.xpath("//div[@class='ant-slider-rail']"));
    		    int xOffset = calculateOffsetFor18();
    			Actions sliderAction = new Actions(driver);
    		    Thread.sleep(2000); 
    		   //  sliderAction.clickAndHold(slider).moveByOffset(4, 0).release().perform();
    		  //  sliderAction.dragAndDropBy(slider, 18, 0).build().perform();
    		    sliderAction.dragAndDropBy(slider, xOffset, 01).build().perform();
    		    Thread.sleep(2000); 

    			
    		      //driver.findElement(By.xpath("//div[@aria-valuenow='24']")).click();
    		     //Period dropdown
    		    driver.findElement(By.xpath("//button[@id='dropdown-basic-button-transactionHistory']")).click(); 
    		    Thread.sleep(2000); 
    		    driver.findElement(By.xpath("//a[contains(text(),'Quarterly')]")).click(); 
    		    Thread.sleep(2000); 
    		        
    		      //Select date
    				WebElement q = driver.findElement(By.xpath("//input[@placeholder='Select date']")); 
    				Thread.sleep(2000); 
    				q.click(); 

    				//Select date(Next year)
    				driver.findElement(By.xpath("//span[@class='react-datepicker__year-read-view--selected-year']")).click();		 
    				driver.findElement(By.xpath("//div[text()='2025']")).click(); 
    				Thread.sleep(2000); 
    				driver.findElement(By.xpath("//div[text()='25']")).click(); 
    				Thread.sleep(2000); 
    				
    				driver.findElement(By.xpath("//button[@class='enable-button']")).click();
    				Thread.sleep(2000);
    		        
    				//Transfer Recurring Amount page
    				driver.findElement(By.xpath("//input[@id='currencyInput']")).sendKeys("1.10");
    				Thread.sleep(1000); 
    				driver.findElement(By.xpath("//button[@class='enable-button']")).click();
        			driver.findElement(By.xpath("//button[@class='enable-button']")).click();
        			// Wait until the button becomes enabled after entering the OTP
        	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
        	        wait.until(new ExpectedCondition<Boolean>() {
        	            public Boolean apply(WebDriver driver) {
        	                return driver.findElement(By.xpath("//button[@class='enable-button']")).isEnabled();
        	            }
        	        });
        	        // Once the button is enabled, locate it and click
        	        WebElement button = driver.findElement(By.xpath("//button[@class='enable-button']"));
        	        button.click();	        			    	
      }
     
      private int calculateOffsetFor18() {
		// TODO Auto-generated method stub
		return 2;
	}
	@Test(priority = 14, retryAnalyzer=listeners.MyRetryAnalyzer.class)
      public void Selftransfer() throws InterruptedException {
    	
    		driver.findElement(By.xpath("//span[contains(text(),'Self Transfer')]")).click();
  			Thread.sleep(2000);
  			driver.findElement(By.xpath("//button[@class='enable-button fw-bold']")).click();
  			Thread.sleep(2000);
  			driver.findElement(By.xpath("//label[@for='Same Day ACHdes']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@class='enable-button fw-bold']")).click();
			Thread.sleep(2000);
  			driver.findElement(By.xpath("//input[@id='currencyInput']")).sendKeys("10");
  			Thread.sleep(1000);  	        
  			driver.findElement(By.xpath("//div[@class='SelectBank_container d-flex  justify-content-between ']")).click();
  			Thread.sleep(4000); 			
  			driver.findElement(By.xpath("//div[@class='accoount_Number d-flex '][1]")).click();
  			Thread.sleep(2000); 
  			driver.findElement(By.xpath("//button[@class='bankModel_cont_button fw-bold']")).click();
  			Thread.sleep(2000); 
  			driver.findElement(By.xpath("//button[@class='enable-button mb-0']")).click();
			// Wait until the button becomes enabled after entering the OTP
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
	        wait.until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return driver.findElement(By.xpath("//button[@class='enable-button fw-bold ']")).isEnabled();
	            }
	        });
	        // Once the button is enabled, locate it and click
	        WebElement button = driver.findElement(By.xpath("//button[@class='enable-button fw-bold ']"));
	        button.click();	
    	
      }
      
   
      @Test(priority = 15, retryAnalyzer=listeners.MyRetryAnalyzer.class)
      public void Recent_selftransfer() throws InterruptedException {
    	 
    		driver.findElement(By.xpath("//span[contains(text(),'Self Transfer')]")).click();
  			Thread.sleep(2000);
  			driver.findElement(By.xpath("(//span[contains(text(),'Pay self')])[1]")).click();
  			Thread.sleep(4000); 	       
  			driver.findElement(By.xpath("//button[@class='enable-button mb-0']")).click();
			// Wait until the button becomes enabled after entering the OTP
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
	        wait.until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return driver.findElement(By.xpath("//button[@class='enable-button fw-bold ']")).isEnabled();
	            }
	        });
	        // Once the button is enabled, locate it and click
	        WebElement button = driver.findElement(By.xpath("//button[@class='enable-button fw-bold ']"));
	        button.click();	
  			Thread.sleep(2000);

      }
    
    //Dashboard search Self Transfer
      @Test(priority = 16, retryAnalyzer=listeners.MyRetryAnalyzer.class)
           public void Dashboard_Self_Transfer_() throws InterruptedException 
           {
      		 driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("USD");
      		 Thread.sleep(2000);
               driver.findElement(By.xpath("(//span[contains(text(),'Self-transfer')])[1]"));
      		 Thread.sleep(2000);
      		 driver.findElement(By.xpath("//input[@id='currencyInput']")).sendKeys("12");
      		 Thread.sleep(2000);
      		 driver.findElement(By.xpath("//button[contains(text(),'Self-transfer again')]")).click();
      		 
      		  // Wait until the button becomes enabled after entering the OTP
      	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
      	        wait.until(new ExpectedCondition<Boolean>() {
      	            public Boolean apply(WebDriver driver) { 
      	            	
      	                return driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).isEnabled();
      	            }
      	        });

      	        // Once the button is enabled, locate it and click
      	        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
      	        button.click();	
        }
     
      /*
	 Trade feature has been removed In Sila.
	 -----------------------------------------
	 @Test(priority = 13, retryAnalyzer=listeners.MyRetryAnalyzer.class)
      public void Trade_Buy() throws InterruptedException {
    	
    		  
    		driver.findElement(By.xpath("//span[contains(text(),'Trade')]")).click();
  			Thread.sleep(2000);
  			driver.findElement(By.xpath("//input[@class='inputBox text-white w-100']")).sendKeys("BTC");
  			Thread.sleep(2000);
  			driver.findElement(By.xpath("//div[contains(text(),'BTC')]")).click();
  			Thread.sleep(2000);
  			driver.findElement(By.xpath("//input[@placeholder='0.00']")).sendKeys("10");
  			Thread.sleep(2000);
  			driver.findElement(By.xpath("//button[@class='tradeContinueButton']")).click();
  			Thread.sleep(3000);
  			driver.findElement(By.xpath("//button[@class='detailedPageButtonBuy text-capitalize mx-2 mt-2']")).click();
  			Thread.sleep(3000);
  			driver.findElement(By.xpath("//button[@class='detailedPageButtonBuy w-25 align-middle']")).click();
  			Thread.sleep(11000);
     
      }	      
      @Test(priority = 14, retryAnalyzer=listeners.MyRetryAnalyzer.class)
      public void Trade_Sell() throws InterruptedException {
    	
    		  driver.findElement(By.xpath("//span[contains(text(),'Trade')]")).click();
  			Thread.sleep(2000);
  			driver.findElement(By.xpath("//button[@class='sellButton ']")).click();
  			Thread.sleep(2000);
  			driver.findElement(By.xpath("//input[@class='inputBox text-white w-100']")).sendKeys("BTC");
  			Thread.sleep(2000);
  			driver.findElement(By.xpath("//div[contains(text(),'BTC')]")).click();
  			Thread.sleep(2000);
  			driver.findElement(By.xpath("//input[@placeholder='0.00']")).sendKeys("0.000001");
  			Thread.sleep(2000);
  			driver.findElement(By.xpath("//button[@class='tradeContinueButton']")).click();
  			Thread.sleep(3000);
  			driver.findElement(By.xpath("//button[@class='detailedPageButtonSell text-capitalize mx-2 mt-2']")).click();
  			Thread.sleep(3000);
  			driver.findElement(By.xpath("//button[@class='detailedPageButtonSell w-25 align-middle']")).click();
  			Thread.sleep(12000);
    	 
      }      
 
	 // Manage Beneficiary feature has been removed in Sila
	  
      @Test(priority = 15, retryAnalyzer=listeners.MyRetryAnalyzer.class)
      public void Manage_Beneficiary() throws InterruptedException {
    	 
    		  driver.findElement(By.xpath("//span[contains(text(),'Manage Beneficiary')]")).click();
    			Thread.sleep(2000);
    			driver.findElement(By.xpath("//p[@class='d-flex gap-2  primary-textColor me-3']")).click();
    			Thread.sleep(2000);    			
    			WebElement messageElement=driver.findElement(By.xpath("//input[@name='benifName']"));
      			messageElement.click();
      		    messageElement.sendKeys(generateRandomName());
      		    Thread.sleep(1000);
    			driver.findElement(By.xpath("//input[@name='benifBankName']")).sendKeys("State bank of india");
    			Thread.sleep(1000);
    			WebElement messageElement1=driver.findElement(By.xpath("//input[@name='benifAccountNumber']"));
      			messageElement1.click();
      			messageElement1.sendKeys(generateRandomAccountNumber());
      			Thread.sleep(2000);
    			
    			//Account type Dropdown
    			driver.findElement(By.xpath("//div[contains(text(),'SAVINGS')]")).click();
    			Thread.sleep(1000);
    			driver.findElement(By.xpath("//div[contains(text(),'CHECKING')]")).click();
    			Thread.sleep(1000);
    			driver.findElement(By.xpath("//input[@name='benifRoutingNumber']")).sendKeys("021001208");
    			Thread.sleep(1000);
//    			driver.findElement(By.xpath("//input[@name='benifPhone']")).sendKeys("9876453678");
    			
    			WebElement messageElement2=driver.findElement(By.xpath("//input[@name='benifPhone']"));
    			messageElement2.click();
    		    messageElement2.sendKeys(generateRandomMobileNumber());
    			Thread.sleep(1000);   
    			
    			String randomName = generateRandomName();
     		     String randomEmail = generateRandomEmail(randomName);
     		     WebElement emailElement = driver.findElement(By.xpath("//input[@name='benifEmail']"));
     		     emailElement.click();
     		     emailElement.sendKeys(randomEmail);
     		     Thread.sleep(1000);
    			driver.findElement(By.xpath("//input[@name='benifReference']")).sendKeys("Refer#u77");
    			Thread.sleep(1000);
    			driver.findElement(By.xpath("//input[@name='benifStreetOne']")).sendKeys("Palace road");
    			Thread.sleep(1000);
    			driver.findElement(By.xpath("//input[@name='benifStreetTwo']")).sendKeys("2nd Main");
    			Thread.sleep(1000);
    			
    			//Benef State Dropdown
    			driver.findElement(By.xpath("//input[@id='react-select-3-input']")).click();	
    			Thread.sleep(2000);
    			driver.findElement(By.xpath("//div[contains(text(),'California')]")).click();
    			Thread.sleep(2000);	    
    		
    			//Benef City Dropdown
    			driver.findElement(By.xpath("//input[@id='react-select-4-input']")).click();
    			Thread.sleep(2000);
    			driver.findElement(By.xpath("//div[contains(text(),'Agoura')]")).click();
    			Thread.sleep(1000);
    			driver.findElement(By.xpath("//input[@name='benifZipcode']")).sendKeys("46860");
    			Thread.sleep(1000);
    			driver.findElement(By.xpath("//input[@name='bankStreetOne']")).sendKeys("Church street");
    			Thread.sleep(1000);
    			driver.findElement(By.xpath("//input[@name='bankStreetTwo']")).sendKeys("3rd Main");
    			Thread.sleep(1000);
    			
    			//Bank State Dropdown
    			driver.findElement(By.xpath("//input[@id='react-select-5-input']")).click();
    			Thread.sleep(2000);
    			driver.findElement(By.xpath("//div[contains(text(),'Colorado')]")).click();
    			Thread.sleep(2000);
    			
    			//Bank City Dropdown
    			driver.findElement(By.xpath("//input[@id='react-select-6-input']")).click();
    			Thread.sleep(2000);
    			driver.findElement(By.xpath("//div[contains(text(),'Akron')]")).click();
    			Thread.sleep(2000);
    			driver.findElement(By.xpath("//input[@name='bankPostalcode']")).sendKeys("46861");
    			driver.findElement(By.xpath("//button[@class='manageadd_button px-2 py-2']")).click();
    			Thread.sleep(22000);
    	  
      }
*/
	 
	 @Test(priority = 17, retryAnalyzer=listeners.MyRetryAnalyzer.class)
      public void Add_Wallet() throws InterruptedException {
    		    driver.findElement(By.xpath("//span[@class='primary-textColor']")).click();
    			Thread.sleep(2000);
    			driver.findElement(By.xpath("//input[@placeholder='Search asset']")).sendKeys("USDC");
    			Thread.sleep(2000);
    			driver.findElement(By.xpath("//p[contains(text(),'USDC')]")).click();
    			Thread.sleep(2000);
    			driver.findElement(By.xpath("//button[@class='enableButtonStyle']")).click();
    			Thread.sleep(5000);
    	
      }
	  
	  @Test(priority = 18, retryAnalyzer=listeners.MyRetryAnalyzer.class)
	     public void Diam_PayCircle_To_PayCircle_DIAM_Transfer() throws InterruptedException 
	     {		   
		      
	         	driver.findElement(By.xpath("//span[contains(text(),'Transfer')]")).click();
	    		Thread.sleep(2000);
	    		driver.findElement(By.xpath("//input[@id='search_wallet_asset']")).sendKeys("DIAM");
	    		Thread.sleep(2000);
	    		driver.findElement(By.xpath("//img[@src='/static/media/DiamCoin.2f1e922f1da80678f95421b70fd93ecc.svg']")).click();
	    		Thread.sleep(2000);
	    		driver.findElement(By.xpath("//input[@id='search_account']")).sendKeys("9000000004");
	    		Thread.sleep(2000);
	    		driver.findElement(By.xpath("//div[contains(text(),'Pat  Starc')]")).click();
	    		Thread.sleep(2500);
	    		driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
	    		Thread.sleep(3000);   				    		
	    		driver.findElement(By.xpath("//input[@id='currencyInput']")).sendKeys("3");
	    		Thread.sleep(1000);
	    		
	    		
	    		driver.findElement(By.xpath("//button[@class='enable-button']")).click();
	    		  // Wait until the button becomes enabled after entering the OTP
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
		        wait.until(new ExpectedCondition<Boolean>() {
		            public Boolean apply(WebDriver driver) {
		                return driver.findElement(By.xpath("//button[@class='enable-button']")).isEnabled();
		            }
		        });

		        // Once the button is enabled, locate it and click
		        WebElement button = driver.findElement(By.xpath("//button[@class='enable-button']"));
		        button.click();	
	     }


 @AfterClass
      public void tearDown() {
          if (driver == null) {
              driver.quit();
          }
      }
}