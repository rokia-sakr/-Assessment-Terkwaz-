package Tests;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.GooglePage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class googlesearch 
{
	ChromeDriver driver ; 
	GooglePage homepage;
	@Test
	public void opeURL() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver(); 
		SoftAssert sa= new SoftAssert();   //I used soft assertion beacuse if test fail don't stop execution 
		driver.navigate().to("https://www.google.com/");
		homepage=new GooglePage(driver);
		homepage.searchforkey("selenium webdriver");   //used this method from class homepage
		WebElement result = driver.findElement(By.cssSelector("div.iDjcJe span"));
		sa.assertEquals(result.getText(),"What is the WebDriver in selenium?");//assert that this sentence is displayedand equal result


	}
	@AfterClass
	public void tearDown() //run this method after  execution test
	{
		driver.quit();  //close browser when tests is ended 
	}
}
