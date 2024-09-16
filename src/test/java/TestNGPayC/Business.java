package TestNGPayC;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Business {
	WebDriver driver;
	
	@BeforeClass
		public void SignInsetup() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		Thread.sleep(1000);

		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://cwtv2.paycircle.io/");
		Thread.sleep(1000);		
	}

	@Test(priority = 0, retryAnalyzer=listeners.MyRetryAnalyzer.class)
	public void Login() throws InterruptedException{
				driver.findElement(By.xpath("//input[@placeholder='Mobile number']")).sendKeys("9998887731");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@placeholder='Enter your company email']")).sendKeys("vikas05@mailinator.com");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Loki@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
				Thread.sleep(2000);
		
		List<WebElement> buttons = driver.findElements(By.xpath("(//p[contains(text(),'Proceed')])[2]"));

	    if (!buttons.isEmpty()) {
	        // Click the first button if it is present
	        buttons.get(0).click();
	        System.out.println("Clicked the first button.");
			Thread.sleep(8000);
	    }
	}
	  
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
	    
    
    @Test(priority = 1, retryAnalyzer=listeners.MyRetryAnalyzer.class)  
   
    public void Deposit_ACH() throws InterruptedException
    {		  
			  	driver.findElement(By.xpath("//span[contains(text(),'Deposit')]")).click();
			  	Thread.sleep(2000);
		   		driver.findElement(By.xpath("//input[@id='search_input_wallet']")).sendKeys("USD");
				Thread.sleep(2000);				
				driver.findElement(By.xpath("//img[@src='/static/media/Dollar-USD-icon.e5efcca16f825149a37184c86e2c3301.svg']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@class='fw-bold enable-button enableButtonLite']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//label[@for='ACHdes']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@class='enable-button fw-bold enableButtonLite']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='currencyInput']")).sendKeys("20");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@class='SelectBank_container d-flex  justify-content-between inputBoxLite']")).click();
				Thread.sleep(2000); 
				driver.findElement(By.xpath("//div[@class='cardContainer d-flex align-items-center gap-3 mb-4 text-white border-0'][1]")).click();
				Thread.sleep(1000); 
				driver.findElement(By.xpath("//button[@class='bankModel_cont_button  fw-bold enableButtonLite']")).click();
				Thread.sleep(1000); 
				driver.findElement(By.xpath("//button[@class='fw-bold enable-button enableButtonLite']")).click();
				Thread.sleep(1000); 
				driver.findElement(By.xpath("//button[@class='depositButton  enableButtonLite']")).click();
			       // Wait until the button becomes enabled after entering the OTP
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
		        wait.until(new ExpectedCondition<Boolean>() {
		            public Boolean apply(WebDriver driver) {
		                return driver.findElement(By.xpath("//button[@class='fw-bold enable-button enableButtonLite']")).isEnabled();
		            }
		        });

		        // Once the button is enabled, locate it and click
		        WebElement button = driver.findElement(By.xpath("//button[@class='fw-bold enable-button enableButtonLite']"));
		        button.click();		
				
		        
		        
		        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
		        WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Transaction Initiation Successful!')]")));

		        // Fetch and verify the text of the success message
		        String messageText = successMessage.getText();
		        if (messageText.equals("Transaction Initiation Successful!")) {
		            System.out.println("Success message: " + messageText);
		            System.out.println("Deposit_Successfully");
		        } else {
		            System.out.println("Unexpected message: " + messageText);
		            System.out.println("Test case failed!");
		        }
		        
		        		
    }
   
    @Test(priority = 2, retryAnalyzer=listeners.MyRetryAnalyzer.class)  
    public void Wire() throws InterruptedException
    {		 
	  			driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
			    driver.findElement(By.xpath("//span[contains(text(),'Deposit')]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='search_input_wallet']")).sendKeys("USD");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div/div/div[2]/div[1]/img")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@class='fw-bold enable-button enableButtonLite']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//label[@for='Wiredes']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='enable-button fw-bold enableButtonLite']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='currencyInput']")).sendKeys("80");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@class='fw-bold enable-button enableButtonLite']")).click();
				Thread.sleep(10000);
				driver.findElement(By.xpath("//div[@class='closeBtn']")).click();
				Thread.sleep(2000);
		  
    }
    /*
    @Test(priority = 3, retryAnalyzer=listeners.MyRetryAnalyzer.class)  
    public void Recent_Deposit() throws InterruptedException
    {		 
				driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
			  	driver.findElement(By.xpath("//span[contains(text(),'Deposit')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[contains(text(),'Deposit')])[2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='currencyInput']")).clear();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='currencyInput']")).sendKeys("25");
				Thread.sleep(2000);
		        driver.findElement(By.xpath("//button[@class='fw-bold enable-button enableButtonLite']")).click();
				Thread.sleep(2000);
		        driver.findElement(By.xpath("//button[@class='depositButton  enableButtonLite']")).click();
			       // Wait until the button becomes enabled after entering the OTP
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
		        wait.until(new ExpectedCondition<Boolean>() {
		            public Boolean apply(WebDriver driver) {
		                return driver.findElement(By.xpath("//button[@class='fw-bold enable-button enableButtonLite']")).isEnabled();
		            }
		        });

		        // Once the button is enabled, locate it and click
		        WebElement button = driver.findElement(By.xpath("//button[@class='fw-bold enable-button enableButtonLite']"));
		        button.click();		
				
		        
		        
		        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(3));
		        WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Transaction Initiation Successful!')]")));

		        // Fetch and verify the text of the success message
		        String messageText = successMessage.getText();
		        if (messageText.equals("Transaction Initiation Successful!")) {
		            System.out.println("Success message: " + messageText);
		            System.out.println("Deposit_Successfully");
		        } else {
		            System.out.println("Unexpected message: " + messageText);
		            System.out.println("Test case failed!");
		        }
		        			 
    }
			  
    @Test(priority = 4, retryAnalyzer=listeners.MyRetryAnalyzer.class)  
    public void Fiat_PayCircle_To_PayCircle_Transfer() throws InterruptedException
    {
		 
				driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
				driver.findElement(By.xpath("//span[contains(text(),'Transfer')]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='search_wallet_asset']")).sendKeys("USD");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//img[@src='/static/media/Dollar-USD-icon.e5efcca16f825149a37184c86e2c3301.svg']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='inputBox inputBoxLite']")).sendKeys("vikas08@mailinator.com");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[contains(text(),'Motorola')]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@value='Pay now']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='search_wallet_asset']")).sendKeys("3");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite fw-bold']")).click();
			       // Wait until the button becomes enabled after entering the OTP
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
		        wait.until(new ExpectedCondition<Boolean>() {
		            public Boolean apply(WebDriver driver) {
		                return driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite fw-bold']")).isEnabled();
		            }
		        });

		        // Once the button is enabled, locate it and click
		        WebElement button = driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite fw-bold']"));
		        button.click();		
				
		        
		        
		        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(3));
		        WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Transaction Initiation Successful!')]")));

		        // Fetch and verify the text of the success message
		        String messageText = successMessage.getText();
		        if (messageText.equals("Transaction Initiation Successful!")) {
		            System.out.println("Success message: " + messageText);
		            System.out.println("Transfer Successfully");
		        } else {
		            System.out.println("Unexpected message: " + messageText);
		            System.out.println("Test case failed!");
		        }
		        	
    }
    @Test(priority = 5, retryAnalyzer=listeners.MyRetryAnalyzer.class)
    public void Recent_Transfer() throws InterruptedException 
    {	  			
    		driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
    		driver.findElement(By.xpath("//span[contains(text(),'Transfer')]")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("(//button[contains(text(),'Transfer')])[1]")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//input[@value='Pay now']")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//input[@id='search_wallet_asset']")).sendKeys("3");
    		Thread.sleep(1000);		
    		driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite fw-bold']")).click();
    		
		       // Wait until the button becomes enabled after entering the OTP
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
	        wait.until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite fw-bold']")).isEnabled();
	            }
	        });

	        // Once the button is enabled, locate it and click
	        WebElement button = driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite fw-bold']"));
	        button.click();		
			
	        
	        
	        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(3));
	        WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Transaction Initiation Successful!')]")));

	        // Fetch and verify the text of the success message
	        String messageText = successMessage.getText();
	        if (messageText.equals("Transaction Initiation Successful!")) {
	            System.out.println("Success message: " + messageText);
	            System.out.println("Transfer Succcessfully");
	        } else {
	            System.out.println("Unexpected message: " + messageText);
	            System.out.println("Test case failed!");
	        }
	            	
    }
    
    @Test(priority=6, retryAnalyzer=listeners.MyRetryAnalyzer.class)
    public void Transfer_Others_Invoice() throws InterruptedException, AWTException {
    	 
		driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
    	driver.findElement(By.xpath("//span[contains(text(),'Transfer')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='search_wallet_asset']")).sendKeys("USD");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='/static/media/Dollar-USD-icon.e5efcca16f825149a37184c86e2c3301.svg']")).click();
		Thread.sleep(2000);
		WebElement buttn=driver.findElement(By.xpath("//input[@id='docupload']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",buttn);
		
		Robot rb=new Robot();
		rb.delay(2000);
		StringSelection ss=new StringSelection("\"C:\\Users\\Lokesh R B\\Downloads\\Invoice1.2.pdf\"");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
	//	rb.keyPress(KeyEvent.VK_CONTROL);
	//	rb.keyPress(KeyEvent.VK_ESCAPE);

		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.delay(1500);
		rb.keyRelease(KeyEvent.VK_CONTROL);                    
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(1500);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.delay(1500);
		driver.findElement(By.xpath("//button[@class='confirmPreviewButton enableButtonLite']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite']")).click();
		Thread.sleep(16000);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='benifRoutingNumber']")).clear();
		driver.findElement(By.xpath("//input[@name='benifRoutingNumber']")).sendKeys("021001208");
		Thread.sleep(2000);
		WebElement messageElement2=driver.findElement(By.xpath("(//input[@class='bankDetailInput   px-2 liteModeBen'])[4]"));
		messageElement2.click();
	    messageElement2.sendKeys(generateRandomMobileNumber());
	    Thread.sleep(2000);
		WebElement messageElement1=driver.findElement(By.xpath("(//input[@class='bankDetailInput   px-2 liteModeBen'])[2]"));
		messageElement1.click();
		messageElement1.sendKeys(generateRandomAccountNumber());
		
	Thread.sleep(2000);
   	String randomName = generateRandomName();
	String randomEmail = generateRandomEmail(randomName);
	WebElement emailElement = driver.findElement(By.xpath("//input[@name='benifEmail']"));
	emailElement.click();
	emailElement.sendKeys(randomEmail);
     
    driver.findElement(By.xpath("//input[@name='benifStreetOne']")).sendKeys("Palace road");
	Thread.sleep(1000);	
 	driver.findElement(By.xpath("//input[@name='benifStreetTwo']")).sendKeys("3rd Main");
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
	driver.findElement(By.xpath("//input[@name='benifZipcode']")).sendKeys("46861");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@name='bankStreetOne']")).sendKeys("Church street");
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//input[@class='bankDetailInput   px-2 liteModeBen'])[5]")).sendKeys("2nd Main");
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
	driver.findElement(By.xpath("//input[@name='bankPostalCode']")).sendKeys("46862");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@class='manageadd_button px-5 py-2 enableButtonLite ']")).click();
	Thread.sleep(24000);
				
	//Transfer Other Amount page

	driver.findElement(By.xpath("//input[@id='search_wallet_asset']")).clear();
	Thread.sleep(2000);

	driver.findElement(By.xpath("//input[@id='search_wallet_asset']")).sendKeys("11");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='search_wallet_asset']")).clear();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='search_wallet_asset']")).sendKeys("11");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite fw-bold']")).click();

    // Wait until the button becomes enabled after entering the OTP
 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
 wait.until(new ExpectedCondition<Boolean>() {
     public Boolean apply(WebDriver driver) {
         return driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite fw-bold']")).isEnabled();
     }
 });

 // Once the button is enabled, locate it and click
 WebElement button = driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite fw-bold']"));
 button.click();		
	
 
 
	 WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(3));
	 WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Transaction Initiation Successful!')]")));
	
	 // Fetch and verify the text of the success message
	 String messageText = successMessage.getText();
	 if (messageText.equals("Transaction Initiation Successful!")) {
	     System.out.println("Success message: " + messageText);
	     System.out.println("Transfer Successfully");
	 } else {
	     System.out.println("Unexpected message: " + messageText);
	     System.out.println("Test case failed!");
	 }
     }

    @Test(priority = 7, retryAnalyzer=listeners.MyRetryAnalyzer.class)
    public void Fiat_PayCircle_to_Others() throws InterruptedException 
    {
    	driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
		Thread.sleep(1000);
    	driver.findElement(By.xpath("//span[contains(text(),'Transfer')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='search_wallet_asset']")).sendKeys("USD");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='/static/media/Dollar-USD-icon.e5efcca16f825149a37184c86e2c3301.svg']")).click();
		Thread.sleep(2000);
		
//   	driver.findElement(By.xpath("//input[@class='inputBox inputBoxLite']")).sendKeys("8736106100");
		WebElement messageElement2=driver.findElement(By.xpath("//input[@class='inputBox inputBoxLite']"));
		messageElement2.click();
	    messageElement2.sendKeys(generateRandomMobileNumber());
	   
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite']")).click();
		Thread.sleep(2000);
		
//   	driver.findElement(By.xpath("//input[@name='benifName']")).sendKeys("Vishwa Karthik");
		
		WebElement messageElement=driver.findElement(By.xpath("//input[@name='benifName']"));
		messageElement.click();
	    messageElement.sendKeys(generateRandomName());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='benifBankName']")).sendKeys("State bank of india");
		Thread.sleep(1000);
//   		driver.findElement(By.xpath("//input[@name='benifAccountNumber']")).sendKeys("9837323962100");
		
		WebElement messageElement1=driver.findElement(By.xpath("//input[@name='benifAccountNumber']"));
		messageElement1.click();
		messageElement1.sendKeys(generateRandomAccountNumber());
		Thread.sleep(2000);
				
		//Account type Dropdown
		driver.findElement(By.xpath("//div[contains(text(),'SAVINGS')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'CHECKING')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='benifRoutingNumber']")).sendKeys("021001208");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@name='benifPhone']")).sendKeys("8731257287");
		
		WebElement messageElement0=driver.findElement(By.xpath("//input[@name='benifPhone']"));
		messageElement0.click();
	    messageElement0.sendKeys(generateRandomMobileNumber());
	    
		Thread.sleep(1000); 
//		driver.findElement(By.xpath("//input[@name='benifEmail']")).sendKeys("karthivishwa@mailinator.com");
		
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
		driver.findElement(By.xpath("//input[@name='benifStreetTwo']")).sendKeys("3rd Main");
		Thread.sleep(2000);
				
		//Benef State Dropdown
		driver.findElement(By.xpath("//input[@id='react-select-8-input']")).click();	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'California')]")).click();
		Thread.sleep(2000);	    
			
		//Benef City Dropdown
		driver.findElement(By.xpath("//input[@id='react-select-9-input']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Agoura')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='benifZipcode']")).sendKeys("46861");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='bankStreetOne']")).sendKeys("Church street");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='bankStreetTwo']")).sendKeys("2nd Main");
		Thread.sleep(1000);
				
		//Bank State Dropdown
		driver.findElement(By.xpath("//input[@id='react-select-10-input']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Colorado')]")).click();
		Thread.sleep(2000);
				
		//Bank City Dropdown
		driver.findElement(By.xpath("//input[@id='react-select-11-input']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Akron')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='bankPostalCode']")).sendKeys("46862");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='manageadd_button px-5 py-2 enableButtonLite ']")).click();


    	//Transfer Other Amount page
    	driver.findElement(By.xpath("//input[@id='search_wallet_asset']")).sendKeys("11");
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite fw-bold']")).click();

	       // Wait until the button becomes enabled after entering the OTP
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
     wait.until(new ExpectedCondition<Boolean>() {
         public Boolean apply(WebDriver driver) {
             return driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite fw-bold']")).isEnabled();
         }
     });

     // Once the button is enabled, locate it and click
     WebElement button = driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite fw-bold']"));
     button.click();		
		
     
     
     WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(3));
     WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Transaction Initiation Successful!')]")));

     // Fetch and verify the text of the success message
     String messageText = successMessage.getText();
     if (messageText.equals("Transaction Initiation Successful!")) {
         System.out.println("Success message: " + messageText);
         System.out.println("Transfer Successfully");
     } else {
         System.out.println("Unexpected message: " + messageText);
         System.out.println("Test case failed!");
     }
     
    }
    
    @Test(priority = 8, retryAnalyzer=listeners.MyRetryAnalyzer.class)
    public void Transfer_OneTime() throws InterruptedException 
    {
    		driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
    		Thread.sleep(1000);   		
    		driver.findElement(By.xpath("//span[contains(text(),'Transfer')]")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//input[@id='search_wallet_asset']")).sendKeys("USD");
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//img[@src='/static/media/Dollar-USD-icon.e5efcca16f825149a37184c86e2c3301.svg']")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//input[@class='inputBox inputBoxLite']")).sendKeys("vikas08@mailinator.com");
    		Thread.sleep(1000);
    		driver.findElement(By.xpath("//div[contains(text(),'Motorola')]")).click();
    		Thread.sleep(1000);
    		driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite']")).click();
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
    		driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite']")).click();
    		Thread.sleep(2000);
    		
    		//Transfer Onetime Amount page
    		driver.findElement(By.xpath("//input[@id='search_wallet_asset']")).sendKeys("1.40");
    		Thread.sleep(1000); 
    		driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite fw-bold']")).click();

		       // Wait until the button becomes enabled after entering the OTP
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
	        wait.until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite fw-bold']")).isEnabled();
	            }
	        });

	        // Once the button is enabled, locate it and click
	        WebElement button = driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite fw-bold']"));
	        button.click();		
			
	        
	        
	        WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(3));
	        WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Transaction Initiation Successful!')]")));

	        // Fetch and verify the text of the success message
	        String messageText = successMessage.getText();
	        if (messageText.equals("Transaction Initiation Successful!")) {
	            System.out.println("Success message: " + messageText);
	            System.out.println("Transfer Successfully");
	        } else {
	            System.out.println("Unexpected message: " + messageText);
	            System.out.println("Test case failed!");
	        }
	       
    }
    @Test(priority = 9, retryAnalyzer=listeners.MyRetryAnalyzer.class)
    public void Transfer_Recurring() throws InterruptedException 
    {
    		  driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
    		  Thread.sleep(1000);
	  		  driver.findElement(By.xpath("//span[contains(text(),'Transfer')]")).click();
	  		  Thread.sleep(2000);
	  		  driver.findElement(By.xpath("//input[@id='search_wallet_asset']")).sendKeys("USD");
	  		  Thread.sleep(2000);
	  		  driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div[1]/img")).click();
	  		  Thread.sleep(3000);
	  		  driver.findElement(By.xpath("(//input[@id='search_wallet_asset'])[2]")).sendKeys("vikas08@mailinator.com");
	  		  Thread.sleep(1000);
	  		  driver.findElement(By.xpath("//div[contains(text(),'Motorola')]")).click();
	  		  Thread.sleep(2000);
	  		  driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite']")).click();
	  		  Thread.sleep(2000);
	  		  driver.findElement(By.xpath("//input[@value='Pay later']")).click();
	  		  Thread.sleep(1000);
	  		  driver.findElement(By.xpath("//input[@id='recurring']")).click(); 
	  		  Thread.sleep(1000); 
  
  		   
  			// Locate the slider element
	  		  WebElement slider = driver.findElement(By.xpath("//div[@class='ant-slider-rail']"));
	  		  Actions sliderAction = new Actions(driver);
	  	      Thread.sleep(2000);  
	  	      sliderAction.clickAndHold(slider).moveByOffset(4, 0).release().perform();
	  	      Thread.sleep(2000); 
  		
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
	  	      driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite']")).click();
	  	      Thread.sleep(2000);
  	        
  			//Transfer Recurring Amount page
	  	      driver.findElement(By.xpath("//input[@id='search_wallet_asset']")).sendKeys("1.80");
	  	      Thread.sleep(1000); 
	  	      driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite fw-bold']")).click();

		       // Wait until the button becomes enabled after entering the OTP
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
	        wait.until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite fw-bold']")).isEnabled();
	            }
	        });

	        // Once the button is enabled, locate it and click
	        WebElement button = driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite fw-bold']"));
	        button.click();		
			
	        
	        
	        WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(3));
	        WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Transaction Initiation Successful!')]")));

	        // Fetch and verify the text of the success message
	        String messageText = successMessage.getText();
	        if (messageText.equals("Transaction Initiation Successful!")) {
	            System.out.println("Success message: " + messageText);
	            System.out.println("Transfer Successfully");
	        } else {
	            System.out.println("Unexpected message: " + messageText);
	            System.out.println("Test case failed!");
	        }
	        
  	 
}
   
    @Test(priority = 10, retryAnalyzer=listeners.MyRetryAnalyzer.class)
    public void Self_transfer() throws InterruptedException {
    	
		driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
  		driver.findElement(By.xpath("//span[contains(text(),'Self Transfer')]")).click();
  		Thread.sleep(2000);
  		driver.findElement(By.xpath("//button[@class='enable-button fw-bold enableButtonLite']")).click();
  		Thread.sleep(2000);
  		driver.findElement(By.xpath("//input[@id='currencyInput']")).sendKeys("10");
  		Thread.sleep(1000); 
  		driver.findElement(By.xpath("//div[@class='SelectBank_container  d-flex  justify-content-between inputBoxLite']")).click();
  		Thread.sleep(2000); 
  		driver.findElement(By.xpath("//div[@class='accoount_Number d-flex '][1]")).click();
  		Thread.sleep(2000); 
  		driver.findElement(By.xpath("//button[@class='bankModel_cont_button fw-bold enableButtonLite']")).click();
  		Thread.sleep(2000); 
  		driver.findElement(By.xpath("//button[@class='enable-button fw-bold enableButtonLite']")).click();

	       // Wait until the button becomes enabled after entering the OTP
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
     wait.until(new ExpectedCondition<Boolean>() {
         public Boolean apply(WebDriver driver) {
             return driver.findElement(By.xpath("//button[@class='enable-button fw-bold enableButtonLite']")).isEnabled();
         }
     });

     // Once the button is enabled, locate it and click
     WebElement button = driver.findElement(By.xpath("//button[@class='enable-button fw-bold enableButtonLite']"));
     button.click();		
		
     
     
     WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(3));
     WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Transaction Initiation Successful!')]")));

     // Fetch and verify the text of the success message
     String messageText = successMessage.getText();
     if (messageText.equals("Transaction Initiation Successful!")) {
         System.out.println("Success message: " + messageText);
         System.out.println("Self Transfer Successfully");
     } else {
         System.out.println("Unexpected message: " + messageText);
         System.out.println("Test case failed!");
     }
     
    }
    @Test(priority =11, retryAnalyzer=listeners.MyRetryAnalyzer.class)
    public void Recent_Self_Transfer() throws InterruptedException {
    	
			driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
    		driver.findElement(By.xpath("//span[contains(text(),'Self Transfer')]")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//span[contains(text(),'Pay self')]")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//input[@id='currencyInput']")).clear();
    		Thread.sleep(1000);
    		driver.findElement(By.xpath("//input[@id='currencyInput']")).sendKeys("11");
    		Thread.sleep(1000);
    		driver.findElement(By.xpath("//button[@class='enable-button fw-bold enableButtonLite']")).click();

		       // Wait until the button becomes enabled after entering the OTP
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
	        wait.until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return driver.findElement(By.xpath("//button[@class='enable-button fw-bold enableButtonLite']")).isEnabled();
	            }
	        });

	        // Once the button is enabled, locate it and click
	        WebElement button = driver.findElement(By.xpath("//button[@class='enable-button fw-bold enableButtonLite']"));
	        button.click();		
			
	        
	        
	        WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(3));
	        WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Transaction Initiation Successful!')]")));

	        // Fetch and verify the text of the success message
	        String messageText = successMessage.getText();
	        if (messageText.equals("Transaction Initiation Successful!")) {
	            System.out.println("Success message: " + messageText);
	            System.out.println("Self Transfer Successfully");
	        } else {
	            System.out.println("Unexpected message: " + messageText);
	            System.out.println("Test case failed!");
	        }
	        
    }
    @Test(priority = 12, retryAnalyzer=listeners.MyRetryAnalyzer.class)
    public void Trade_Buy() throws InterruptedException 
    {
		driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
  	    driver.findElement(By.xpath("//span[contains(text(),'Trade')]")).click();
  		Thread.sleep(2000);
  		driver.findElement(By.xpath("//input[@class='inputBox w-100 inputBoxStyle']")).sendKeys("BTC");
  		Thread.sleep(2000);
  		driver.findElement(By.xpath("//div[contains(text(),'BTC')]")).click();
  		Thread.sleep(2000);
  		driver.findElement(By.xpath("//input[@placeholder='0.00']")).sendKeys("1");
  		Thread.sleep(2000);
  		driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite']")).click();
  		Thread.sleep(3000);
  		driver.findElement(By.xpath("//button[@class='detailedPageButtonBuy']")).click();
  		Thread.sleep(3000);
  		driver.findElement(By.xpath("//button[@class='detailedPageButtonBuy w-25 align-middle']")).click();
  		Thread.sleep(11000);
  	 
    }
    
    @Test(priority = 13, retryAnalyzer=listeners.MyRetryAnalyzer.class)
    public void Trade_SELL() throws InterruptedException
    {
		driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
  		driver.findElement(By.xpath("//span[contains(text(),'Trade')]")).click();
  		Thread.sleep(2000);
  		driver.findElement(By.xpath("//button[@class='sellButton liteModeSection ']")).click();
  		Thread.sleep(2000);
  		driver.findElement(By.xpath("//input[@class='inputBox w-100 inputBoxStyle']")).sendKeys("BTC");
  		Thread.sleep(2000);
  		driver.findElement(By.xpath("//div[contains(text(),'BTC')]")).click();
  		Thread.sleep(2000);
  		driver.findElement(By.xpath("//input[@placeholder='0.00']")).sendKeys("0.000001");
  		Thread.sleep(2000);
  		driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite']")).click();
  		Thread.sleep(3000);
  		driver.findElement(By.xpath("//button[@class='detailedPageButtonSell text-capitalize mx-2 mt-2']")).click();
  		Thread.sleep(3000);
  		driver.findElement(By.xpath("//button[@class='detailedPageButtonSell w-25 align-middle']")).click();
  		Thread.sleep(12000);
  	  
    }
    @Test(priority = 14, retryAnalyzer=listeners.MyRetryAnalyzer.class)
    public void Manage_Beneficiary() throws InterruptedException 
    {
    		driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
    		Thread.sleep(1000);
    		driver.findElement(By.xpath("//span[contains(text(),'Manage Beneficiary')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//p[contains(text(),'Add Beneficiary')]")).click();
			Thread.sleep(2000);   
			
//			driver.findElement(By.xpath("//input[@name='benifName']")).sendKeys("Madhu Shanaka");
			
			WebElement messageElement=driver.findElement(By.xpath("//input[@name='benifName']"));
			messageElement.click();
		    messageElement.sendKeys(generateRandomName());
		    
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='benifBankName']")).sendKeys("State bank of india");
			Thread.sleep(1000);
//			driver.findElement(By.xpath("//input[@name='benifAccountNumber']")).sendKeys("780843267890");
			
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
//			driver.findElement(By.xpath("//input[@name='benifPhone']")).sendKeys("9876453678");
			
			WebElement messageElement2=driver.findElement(By.xpath("//input[@name='benifPhone']"));
			messageElement2.click();
		    messageElement2.sendKeys(generateRandomMobileNumber());
			Thread.sleep(1000);  
			Thread.sleep(1000);
			
//			driver.findElement(By.xpath("//input[@name='benifEmail']")).sendKeys("madhushanaka@mailinator.com");
			
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
			Thread.sleep(2000);
			
			//Benef State Dropdown
			driver.findElement(By.xpath("//input[@id='react-select-23-input']")).click();	
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[contains(text(),'California')]")).click();
			Thread.sleep(2000);	    
		
			//Benef City Dropdown
			driver.findElement(By.xpath("//input[@id='react-select-24-input']")).click();
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
			driver.findElement(By.xpath("//input[@id='react-select-25-input']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[contains(text(),'Colorado')]")).click();
			Thread.sleep(2000);
			
			//Bank City Dropdown
			driver.findElement(By.xpath("//input[@id='react-select-26-input']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[contains(text(),'Akron')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='bankPostalCode']")).sendKeys("46861");
			driver.findElement(By.xpath("//button[@class='manageadd_button px-2 py-2 enableButtonLite']")).click();

			// Once the button is enabled, locate it and click
		     WebElement button = driver.findElement(By.xpath("//button[@class='enable-button enableButtonLite fw-bold']"));
		     button.click();		
				
		     
		     
		     WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(3));
		     WebElement successMessage = wait11.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Company transaction beneficiary added successfully!')]")));

		     // Fetch and verify the text of the success message
		     String messageText = successMessage.getText();
		     if (messageText.equals("Company transaction beneficiary added successfully!")) {
		         System.out.println("Success message: " + messageText);
		         System.out.println("Beneficiary not added");
		     } else {
		         System.out.println("Unexpected message: " + messageText);
		         System.out.println("Test case failed!");
		     }
		    }			
			

  	 
    
    @Test(priority =15, retryAnalyzer=listeners.MyRetryAnalyzer.class)
    public void Delete_wallet() throws InterruptedException
    
    {

    	driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
		Thread.sleep(2000);
    	driver.findElement(By.xpath("//li[contains(text(),'Wallet')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h3[contains(text(),'USDC')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='cancelButtonLite']")).click();
		Thread.sleep(3000);

		
    }
    
    @Test(priority = 16, retryAnalyzer=listeners.MyRetryAnalyzer.class)
    public void Add_Wallet() throws InterruptedException 
    {
    	driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
		Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Add wallet')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search asset']")).sendKeys("USDC");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[contains(text(),'USDC')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='enableButtonStyle enableButtonLite ']")).click();
		Thread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();

  	  
    }
    @Test(priority = 17, retryAnalyzer=listeners.MyRetryAnalyzer.class)
    public void From_dashboard_search_Deposit() throws InterruptedException 
    {
     //   driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
	    driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
		Thread.sleep(1000);

  		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("USD");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[contains(text(),'Deposit')])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='currencyInput']")).sendKeys("11");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='  mx-auto py-2 px-3 rounded enableButtonLite']")).click();

	       // Wait until the button becomes enabled after entering the OTP
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
     wait.until(new ExpectedCondition<Boolean>() {
         public Boolean apply(WebDriver driver) {
             return driver.findElement(By.xpath("//button[@class='  mx-auto py-2 px-5 rounded enableButtonLite']")).isEnabled();
         }
     });

     // Once the button is enabled, locate it and click
     WebElement button = driver.findElement(By.xpath("//button[@class='  mx-auto py-2 px-5 rounded enableButtonLite']"));
     button.click();		
		
     
     
     WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(3));
     WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Transaction Initiation Successful!')]")));

     // Fetch and verify the text of the success message
     String messageText = successMessage.getText();
     if (messageText.equals("Transaction Initiation Successful!")) {
         System.out.println("Success message: " + messageText);
         System.out.println("Test case passed!");
     } else {
         System.out.println("Unexpected message: " + messageText);
         System.out.println("Test case failed!");
     }
    }
    
    
    @Test(priority = 18, retryAnalyzer=listeners.MyRetryAnalyzer.class)
    public void From_dashboard_search_transfer_PayCircle_to_PayCircle() throws InterruptedException 
    {
	    driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
		Thread.sleep(1000);

  		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("USD");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[contains(text(),'Transfer')])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='currencyInput']")).sendKeys("11");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='  mx-auto py-2 px-3 rounded enableButtonLite']")).click();

	       // Wait until the button becomes enabled after entering the OTP
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
     wait.until(new ExpectedCondition<Boolean>() {
         public Boolean apply(WebDriver driver) {
             return driver.findElement(By.xpath("//button[@class='  mx-auto py-2 px-5 rounded enableButtonLite']")).isEnabled();
         }
     });

     // Once the button is enabled, locate it and click
     WebElement button = driver.findElement(By.xpath("//button[@class='  mx-auto py-2 px-5 rounded enableButtonLite']"));
     button.click();		
		
     
     
     WebDriverWait wait13 = new WebDriverWait(driver, Duration.ofSeconds(3));
     WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Transaction Initiation Successful!')]")));

     // Fetch and verify the text of the success message
     String messageText = successMessage.getText();
     if (messageText.equals("Transaction Initiation Successful!")) {
         System.out.println("Success message: " + messageText);
         System.out.println("Test case passed!");
     } else {
         System.out.println("Unexpected message: " + messageText);
         System.out.println("Test case failed!");
     }
    }
    
    @Test(priority = 19, retryAnalyzer=listeners.MyRetryAnalyzer.class)
    public void From_dashboard_search_transfer_PayCircle_to_Others() throws InterruptedException 
    {
	    driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
		Thread.sleep(1000);

  		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("USD");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[contains(text(),'Transfer')])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='currencyInput']")).sendKeys("11");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='  mx-auto py-2 px-3 rounded enableButtonLite']")).click();

	       // Wait until the button becomes enabled after entering the OTP
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
     wait.until(new ExpectedCondition<Boolean>() {
         public Boolean apply(WebDriver driver) {
             return driver.findElement(By.xpath("//button[@class='  mx-auto py-2 px-5 rounded enableButtonLite']")).isEnabled();
         }
     });

     // Once the button is enabled, locate it and click
     WebElement button = driver.findElement(By.xpath("//button[@class='  mx-auto py-2 px-5 rounded enableButtonLite']"));
     button.click();		
		
     
     
     WebDriverWait wait14 = new WebDriverWait(driver, Duration.ofSeconds(3));
     WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Transaction Initiation Successful!')]")));

     // Fetch and verify the text of the success message
     String messageText = successMessage.getText();
     if (messageText.equals("Transaction Initiation Successful!")) {
         System.out.println("Success message: " + messageText);
         System.out.println("Test case passed!");
     } else {
         System.out.println("Unexpected message: " + messageText);
         System.out.println("Test case failed!");
     }
}

   @Test(priority = 20, retryAnalyzer=listeners.MyRetryAnalyzer.class)
   public void Delete_Beneficiary() throws InterruptedException 
   {
   		driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
		Thread.sleep(2000);
	   	driver.findElement(By.xpath("//span[contains(text(), 'Manage Beneficiary')]"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//p[@class='d-flex gap-2 align-items-center'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='cacl_button   p-2  cancelButtonLite']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='cancelButtonLite']")).click();
		Thread.sleep(3000);

   }
    
   @Test(priority = 21, retryAnalyzer=listeners.MyRetryAnalyzer.class)
   public void Delete_Schedulepayment() throws InterruptedException 
   {
	   	driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
		Thread.sleep(2000);
	   	driver.findElement(By.xpath("//span[contains(text(), 'Scheduled Payments')]"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='d-flex justify-content-between align-content-center mt-3 w-100 px-2 mt-1'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='delete_button  d-flex align-items-center justify-content-center me-2 liteMode']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class=' delete_btn_ben d-flex justify-content-center align-items-center cancelButtonLite']")).click();
		Thread.sleep(3000);

   }
   @Test(priority = 22, retryAnalyzer=listeners.MyRetryAnalyzer.class)
   public void Pause_Schedulepayment() throws InterruptedException 
   {
   		driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
		Thread.sleep(1000);
	   	driver.findElement(By.xpath("//span[contains(text(), 'Scheduled Payments')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='d-flex justify-content-between align-content-center mt-3 w-100 px-2 mt-1'])[1]")).click();
		Thread.sleep(1000);	

		List<WebElement> button1 = driver.findElements(By.xpath("//button[@class='schedule_input_box_pause_button cancelButtonLite']"));

	    if (!button1.isEmpty()) {
	        // Click the first button if it is present
	        button1.get(0).click();
	        System.out.println("Pause button is there");
			Thread.sleep(1000);
	    }
	    System.out.println("Pause button is not there");

		driver.findElement(By.xpath("//span[@class=' delete_btn_ben d-flex justify-content-center align-items-center enableButtonLite text-white']")).click();
		Thread.sleep(3000);

}
   @Test(priority = 23, retryAnalyzer=listeners.MyRetryAnalyzer.class)
   public void Schedule_Payment_edit() throws InterruptedException {
   	driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
		Thread.sleep(1000);
	   driver.findElement(By.xpath("//span[contains(text(), 'Scheduled Payments')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='d-flex justify-content-between align-content-center mt-3 w-100 px-2 mt-1'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='schedule_input_box_button d-flex align-items-center justify-content-center ms-4  enableButtonLite']")).click();
		Thread.sleep(1000);
	   
		WebElement slider = driver.findElement(By.xpath("//div[@class='ant-slider-rail']"));
		  Actions sliderAction = new Actions(driver);
	      Thread.sleep(2000);  
	      sliderAction.clickAndHold(slider).moveByOffset(3, 0).release().perform();
	      Thread.sleep(2000); 
	
        //Period dropdown
	      driver.findElement(By.xpath("//button[@id='dropdown-basic-button-transactionHistory']")).click(); 
	      Thread.sleep(2000); 
	      driver.findElement(By.xpath("(//div[contains(text(),'YEARLY')])[2]")).click(); 
	      Thread.sleep(2000); 
        
      //Select date
	      WebElement z = driver.findElement(By.xpath("//input[@placeholder='Select a date']")); 
	      Thread.sleep(2000); 
	      z.click(); 

		//Select date(Next year)
	      driver.findElement(By.xpath("//span[@class='react-datepicker__year-read-view--selected-year']")).click();		 
	      driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--next']")).click(); 
	      Thread.sleep(2000); 
	      driver.findElement(By.xpath("(//div[contains(text(),'1')])[1]")).click(); 
	      Thread.sleep(2000); 
	      driver.findElement(By.xpath("//button[@class='schedule_input_box_button ms-4 enableButtonLite']")).click();
	      Thread.sleep(3000);
		
   }
    @Test(priority = 24, retryAnalyzer=listeners.MyRetryAnalyzer.class)
    public void Favourite() throws InterruptedException
    {
    		driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
    		Thread.sleep(1000);
	    	driver.findElement(By.xpath("//span[contains(text(), 'Manage Beneficiary')]")).click();
			Thread.sleep(2000);
			Thread.sleep(1000);	
			driver.findElement(By.xpath("(//img[@src='/static/media/unfillStar.239527f173970044a2f0439898439ded.svg'])[2]")).click();
			Thread.sleep(2000);
		   	driver.findElement(By.xpath("//p[@class='fav_button darkModeSection d-flex gap-2 liteModeSection']")).click();
			Thread.sleep(2000);
		
		List<WebElement> button2 = driver.findElements(By.xpath("//span[contains(text(),'Account number')]"));

	    if (!button2.isEmpty()) {
	        // Click the first button if it is present
	        button2.get(0).click();
	        System.out.println("Beneficiary is displayed");
			Thread.sleep(6000);
	    }	    
		driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
		}    */
}