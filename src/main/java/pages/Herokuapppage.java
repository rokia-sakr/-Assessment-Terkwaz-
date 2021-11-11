package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Herokuapppage extends PageBase
{
	public Herokuapppage  (WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
	}
	
	
	@FindBy(linkText="File Upload")
	WebElement uploadbtn ;
	
	@FindBy(id="file-upload")
	WebElement fileuploader ; 
	
	@FindBy(id="file-submit")
	WebElement submit; 
	public void clickupload() 
	{
		uploadbtn.click();
	}
	public void sendpath(String path) 
	{
		fileuploader.sendKeys(path);
		submit.click();
	}
}
