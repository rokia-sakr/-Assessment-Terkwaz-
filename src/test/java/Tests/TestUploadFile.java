package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.Herokuapppage;

public class TestUploadFile 
{
	ChromeDriver driver ;  
	Herokuapppage hero;


	@BeforeClass
	public void setUp()  //run this method before start execution test 
	{
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.navigate().to("https://the-internet.herokuapp.com");//open url in browser then maxaimze it
		driver.manage().window().maximize();
	}

	@Test
	public void testFileUpload() throws InterruptedException 

	{
		String imageName = "landscape.jpg"; //provide naame of image
		String imagePath = System.getProperty("user.dir")+"/Uploads/"+imageName;	//this path of image to upload it 
		hero=new Herokuapppage(driver);
		hero.clickupload();       //this is method found in Herokuapppage to click upload btn
		hero.sendpath(imagePath);   //this is method found in Herokuapppage  to send image
		WebElement uploadedFiles = driver.findElement(By.id("uploaded-files")); 
		System.out.println(uploadedFiles.getText());
		Thread.sleep(3000);
		SoftAssert sa= new SoftAssert();  //I used soft assertion beacuse if test fail don't stop execution
		sa.assertEquals(imageName, uploadedFiles.getText());// is to assert that image is uplod correctly 
	}

	@AfterClass
	public void tearDown() //run this method after  execution test 
	{
		driver.quit();  //close browser when test is ended 
	}


}
