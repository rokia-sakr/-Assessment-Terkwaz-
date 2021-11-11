package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GooglePage extends PageBase
{
	public GooglePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
	}
	
	@FindBy(css="input.gLFyf.gsfi")
	WebElement textbox ; 
	
 
	
	public void searchforkey(String keysearch) throws InterruptedException
	{
		textbox.sendKeys(keysearch);
		Thread.sleep(30);
		textbox.sendKeys(Keys.ENTER);
		
		
	}
	

}
