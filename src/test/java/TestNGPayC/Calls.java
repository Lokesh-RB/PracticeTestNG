package TestNGPayC;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Calls 
{
WebDriver driver;
public static String generateRandomsubject() {
    String[] MESSAGE_ELEMENTS = {"Electric Bill", "Water Bill", "Groceries", "Teamout", "Other Expense", "Garden", "Listeners", "Maven", "Computer", "Laptop"};
    Random random = new Random();
    return MESSAGE_ELEMENTS[random.nextInt(MESSAGE_ELEMENTS.length)];
}
public static String generateRandomLastName() {
    String[] MESSAGE_ELEMENTS = {"Vinay", "Kumar", "Ravi", "Gagan", "Mohit", "Sharan", "Kiran", "Abhishek", "Raayan", "Olivia"};
    Random random = new Random();
    return MESSAGE_ELEMENTS[random.nextInt(MESSAGE_ELEMENTS.length)];
}

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
	}
/*
	@Test(priority=3)
	public void CallsOverviewEdit() throws InterruptedException
	{
		driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
		driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
	    driver.findElement(By.xpath("//p[contains(text(),'Calls')]")).click();
	    driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
		driver.findElement(By.xpath("(//td[@class=' leadName cursorPointer'])[1]")).click();
		
		WebElement Csub=driver.findElement(By.xpath("//input[@name='subject']"));
		Actions act=new Actions(driver);
		act.moveToElement(Csub).click().perform();
		Csub.clear();
		Csub.sendKeys(generateRandomsubject()); 
		driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,1000)");
		Thread.sleep(2000);
				
		
		driver.findElement(By.xpath("(//div[@class='w-100 bg-transparent border rounded-1 p-1'])[1]")).click();
		driver.findElement(By.xpath("//div[@class=' css-1xc3v61-indicatorContainer']")).click();
		driver.findElement(By.xpath("//div[.='Prospecting']")).click();
		driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();

	    WebElement	callA=driver.findElement(By.xpath("//input[@name='callAgenda']"));
	    callA.click();
	    callA.sendKeys(generateRandomLastName());
		driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();
		driver.findElement(By.xpath("(//div[@class='w-100 bg-transparent border rounded-1 p-1'])[2]")).click();
		driver.findElement(By.xpath("//div[@class=' css-1xc3v61-indicatorContainer']")).click();
		driver.findElement(By.xpath("//div[.='Interested']")).click();
		driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();

		driver.findElement(By.xpath("//input[@name='description']")).click();
		driver.findElement(By.xpath("//input[@name='description']")).sendKeys("Tuy hasd asdjkaksjh aksjhdjka jkds sdkljj sdlkjklj sdlkjk");
		driver.findElement(By.xpath("//img[@src='/static/media/Group 71.de961e5da5c06812614a1ab6e7647c56.svg']")).click();
		
	}
	
	
	@Test(priority=4)
	public void CallsAddNotes() throws InterruptedException
	{
		driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
		driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
	    driver.findElement(By.xpath("//p[contains(text(),'Calls')]")).click();
	    driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
		driver.findElement(By.xpath("(//td[@class=' leadName cursorPointer'])[1]")).click();
		
		WebElement Not=driver.findElement(By.xpath("//textarea[@class='notesClass']"));
	Actions acti=new Actions(driver);
	acti.moveToElement(Not).click().perform();
		
		driver.findElement(By.xpath("//textarea[@class='notesClass']")).click();
		driver.findElement(By.xpath("//textarea[@class='notesClass']")).sendKeys("gjhghjhj kjhsjka");
		driver.findElement(By.xpath("//input[@name='title']")).click();
		driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Add new note");
		
		driver.findElement(By.xpath("//button[.='Save']")).click();	
	}
	*/
@Test(priority=5)
public void CallsDelete() throws InterruptedException
{
	driver.findElement(By.xpath("//p[contains(text(),'Home')]")).click();
	driver.findElement(By.xpath("//p[contains(text(),'CRM')]")).click();
    driver.findElement(By.xpath("//p[contains(text(),'Calls')]")).click();
    driver.findElement(By.xpath("//div[@class='d-flex w-50 justify-content-end gap-2']")).click();
	driver.findElement(By.xpath("(//td[@class=' leadName cursorPointer'])[1]")).click();
	
	driver.findElement(By.xpath("//button[@class='btn btn-secondary bg-white text-dark border border-primary ms-2']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//li[contains(text(),'Delete')]")).click();

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
