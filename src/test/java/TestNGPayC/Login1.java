package TestNGPayC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


     //With PageFactory
public class Login1 
{
    WebDriver driver;
	//Constructor
    Login1(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);    	
    }
    
    
    //Locators
    
    @FindBy(xpath="//input[@type='text']")
    WebElement txt_mail;
    
    @FindBy(xpath="//button[@class='LoginNextBtn']")
    WebElement btn_cont;
    
    @FindBy(xpath="//input[@type='password']")
    WebElement txt_pwd;
   
    @FindBy(xpath="//button[contains(text(),'Next')]")
    WebElement btn_lgn;
    
    
    //Action methods
    public void setMailId(String mail)
    {
    	txt_mail.sendKeys(mail);
    	
    }
    public void clickContinue() 
    {
    	btn_cont.click();
    }
    public void setPwd(String pwd) 
    {
    	txt_pwd.sendKeys(pwd);	
    }
    public void clickLogin() 
    {
    	btn_lgn.click();
    }
    
    
    
	
	
}
