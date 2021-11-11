package Tests;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.loadingpage;

public class Testloading

{
	ChromeDriver driver ; 
	loadingpage loading;
	@BeforeClass
	public void setUp()    //run this method before start execution test 
	{
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.navigate().to("https://the-internet.herokuapp.com");//open url in browser then maxaimze it 
		driver.manage().window().maximize();
	}
	

	@Test
	public void Testloading() throws InterruptedException 

	{
		loading=new loadingpage(driver);
		loading.startload();//this method in loadingpage do click on Dynamic Loading then click on Example 2
	     loading.clickstart();//this method in loadingpage ,do click on start button 
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //wait 20 second untill element displayed 
		WebElement message= driver.findElement(By.id("finish")); 
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(message.getText(),"Hello World!"); //assert that hello world is display after loading
		}
	@AfterClass
	public void tearDown()  //run this method after  execution test 
	{
			
		driver.quit();   //close browser when test is ended 
	}
	}


