package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractclass.AbstractComponents;

public class CheckoutPage extends AbstractComponents
{
    WebDriver driver;
  
	public CheckoutPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//.action_submit
	@FindBy(xpath="(//a[normalize-space()='Place Order'])[1]")
	WebElement submit;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	By results=By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName)
	{
		Actions a=new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
	}
	public confirmationPage submitorder()
	{
		selectCountry.click();
		submit.click();
		return new confirmationPage(driver);
	}
}
