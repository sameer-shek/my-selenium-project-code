package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractclass.AbstractComponents;

public class LandingPage extends AbstractComponents
{
WebDriver driver;

public LandingPage(WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

//WebElement userEmail=driver.findElement(By.id("userEmail"));

@FindBy(id="userEmail")
WebElement userEmail;

@FindBy(id="userPassword")
WebElement passwordelement;

@FindBy(id="login")
WebElement submit;

public productcatalog loginApplication(String email, String password)
{
userEmail.sendKeys("sameershek11233@gmail.com");
passwordelement.sendKeys("Sameer@11233");
submit.click();
productcatalog productcatalog =new productcatalog(driver);
return productcatalog;
}

public void goTo()
{
driver.get("https://rahulshettyacademy.com/client");
}


}