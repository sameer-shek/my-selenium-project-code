package Abstractclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v124.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Test.CartPage;

public class AbstractComponents
{
 WebDriver driver;
 
 
 public AbstractComponents(WebDriver driver)
 {
	 
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
}

@FindBy(css="[routerlink*='cart']")
WebElement cartHeader;



public void waitForElementToAppear(By findby)
 {
	 WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
 }

public CartPage goToCartpage()
{
	cartHeader.click();
	CartPage cartPage=new CartPage(driver);
	return cartPage;
	
}

public void waitForElementDissappear(WebElement ele) throws InterruptedException
{
	//Thread.sleep(1000);
	 WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.invisibilityOf(ele));
}
}
