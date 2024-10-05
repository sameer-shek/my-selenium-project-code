package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractclass.AbstractComponents;

public class productcatalog extends AbstractComponents
{
WebDriver driver;

public productcatalog(WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}



@FindBy(css = ".mb-3")
List<WebElement> products;

@FindBy(css = ".ng-animating")
WebElement spinner ;


By productsby=By.cssSelector(".mb-3");
By addToCart=By.cssSelector(".card-body button:last-of-type");
By toastMessage=By.cssSelector("#toast-container");


public List<WebElement> getproductList()
{
	waitForElementToAppear(productsby);
	return products;
}
public WebElement getProductByName(String ProductName)
{
	WebElement prod=getproductList().stream().filter(product->
	product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
	return prod;
}
public void addToCart(String productName) throws InterruptedException
{
	WebElement prod=getProductByName(productName);
	prod.findElement(addToCart).click();
	waitForElementToAppear(toastMessage);
	waitForElementDissappear(spinner);
	
}
public void goTo()
{
driver.get("https://rahulshettyacademy.com/client");
}
 

}