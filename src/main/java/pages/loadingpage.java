package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class loadingpage extends PageBase{

	public loadingpage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
		
}
	@FindBy(linkText="Dynamic Loading")
	WebElement loadingbtn ;
	@FindBy(linkText="Example 2: Element rendered after the fact")
	WebElement examplebtn ;
	@FindBy(css="button")
	WebElement startbtn ;
	public void startload() 
	{
		loadingbtn.click();
		examplebtn.click();
		
	}
	public void clickstart() 
	{
		startbtn.click();
	}
	
}
