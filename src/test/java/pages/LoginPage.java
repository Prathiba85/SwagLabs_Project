package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public static WebDriver driver;
	// Objects
	@FindBy(xpath="//input[@name='user-name']")WebElement username;
	@FindBy(xpath="//input[@name='password']")WebElement password;
	@FindBy(xpath="//input[@name='login-button']")WebElement login;
	@FindBy(xpath="//span[@class='title']")WebElement product;
	@FindBy(xpath="//h3[@data-test='error']")WebElement Error;
	
	
	//Actions
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);	
	}
	
	public void SetUsername(String name)
	{
		username.sendKeys(name);
	}

	public void SetPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void ClickLogin()
	{
		login.click();
	}
	
	public String getText()
	{
		return product.getText();
	}
	public String geterrorText()
	{
		return Error.getText();
	}

}
