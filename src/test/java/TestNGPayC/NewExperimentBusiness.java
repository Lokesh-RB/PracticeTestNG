package TestNGPayC;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewExperimentBusiness {
	WebDriver driver;
	@BeforeClass
		public void SignInsetup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		Thread.sleep(1000);

		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://cwtv2.paycircle.io/");
		Thread.sleep(1000);
	}


	@Test(priority = 0)
	public void Login() throws InterruptedException{
				driver.findElement(By.xpath("//input[@placeholder='Mobile number']")).sendKeys("9998887731");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@placeholder='Enter your company email']")).sendKeys("vikas08@mailinator.com");
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
	  

    //Transfer Fiat PayCircle to Others
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
	    
	    
	    
	    @Test(priority = 1)
	    public void Transer() throws InterruptedException, AWTException {
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
	//		Thread.sleep(24000);
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
			
	        
	        
//	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
//	        WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Transaction Initiation Successful!')]")));
//
//	        // Fetch and verify the text of the success message
//	        String messageText = successMessage.getText();
//	        if (messageText.equals("Transaction Initiation Successful!")) {
//	            System.out.println("Success message: " + messageText);
//	            System.out.println("Test case passed!");
//	        } else {
//	            System.out.println("Unexpected message: " + messageText);
//	            System.out.println("Test case failed!");
//	        }
	        
	        
//	        // Wait until the success message appears, with a timeout of 2 seconds
//	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
//	        WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Transaction Initiation Successful!')]")));
//
//	        // Fetch and verify the text of the success message
//	        String messageText = successMessage.getText();
//	        Assert.assertEquals(messageText, "Transaction Initiation Successful!", "Success message does not match expected.");
	    }    
	        
	        
	        
	        
	        
			}
	  









