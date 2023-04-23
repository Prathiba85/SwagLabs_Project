package testcases;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public Fillo fillo;
	Connection connection;

	@BeforeSuite
	public void ExcelSetup() throws FilloException
	{
		
		fillo = new Fillo();
		connection = fillo.getConnection("DataSheet.xlsx");
	}
	
	
	@BeforeMethod
	public void SetUp(Method method) {	
		
		WebDriverManager.chromedriver().setup();
		
		//this is added to get name of the test case in xml.
		
		this.driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}

	@AfterMethod
	public void TearDown() {
		
		driver.quit();
		
	}
	
	

}
