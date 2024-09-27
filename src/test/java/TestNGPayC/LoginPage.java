package TestNGPayC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


     //Without PageFactory
public class LoginPage {
	
	
	WebDriver driver;
	
	//Constructor
	LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}

	//Locators
	By txt_mail_loc=By.xpath("//input[@type='text']");
	By btn_cont_loc=By.xpath("//button[@class='LoginNextBtn']");
	By txt_pwd_loc=By.xpath("//input[@type='password']");
	By btn_lgn_loc=By.xpath("//button[contains(text(),'Next')]");
	
	
	
	//Action methods
	public void setMailId(String mail) 
	{
	driver.findElement(txt_mail_loc).sendKeys(mail);	
	}
	
	public void clickContinue()
	{
		driver.findElement(btn_cont_loc).click();	
	}
	public void setPwd(String pwd) 
	{
		driver.findElement(txt_pwd_loc).sendKeys(pwd);	

	}
	
	public void clickLogin() 
	{
		driver.findElement(btn_lgn_loc).click();	

	}
}
