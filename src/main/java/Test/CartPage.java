package Test;

import java.util.List;
import java.util.zip.CheckedOutputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractclass.AbstractComponents;

public class CartPage extends AbstractComponents
{
	WebDriver driver;
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css=".cartSection h3")
	List<WebElement>  cartproducts;
	
public CartPage(WebDriver driver) 
{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
public boolean verifyproductdisplay(String ProductName)
{
	boolean match=cartproducts.stream().anyMatch(product ->product.getText().equalsIgnoreCase(ProductName));
	return match;
}


public CheckoutPage goTocheckout()
{
	checkoutEle.click();
	return new CheckoutPage(driver);
	
}


}
