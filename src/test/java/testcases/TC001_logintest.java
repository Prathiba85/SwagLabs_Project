package testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class TC001_logintest extends BaseClass {
	public LoginPage lp;

	@Test
	public void valid_login() throws InterruptedException, FilloException {
		lp = new LoginPage(driver);
		Recordset recordset = connection.executeQuery("Select * from data where TestName = 'test01'");
		recordset.next();
		String username = recordset.getField("UserName");
		String password = recordset.getField("Password");
		lp.SetUsername(username);
		lp.SetPassword(password);
	
		 lp.ClickLogin();
	   
	   String actualtext= lp.getText();
	   String expectedtext = "Products";
	   
	   Assert.assertEquals(actualtext, expectedtext);
		

	}
	@Test
	public void InvalidLogin() throws FilloException
	{
		lp = new LoginPage(driver);
		Recordset recordset = connection.executeQuery("Select * from data where TestName = 'test02'");
		recordset.next();
		String username = recordset.getField("UserName");
		String password = recordset.getField("Password");
		lp.SetUsername(username);
		lp.SetPassword(password);
	    lp.ClickLogin();
	   
	   String actualtext= lp.geterrorText();
	   String expectedtext = "Epic sadface: Sorry, this user has been locked out.";
	   
	   Assert.assertEquals(actualtext, expectedtext);
		
		
	}


}
