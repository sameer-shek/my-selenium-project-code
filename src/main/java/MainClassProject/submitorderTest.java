package MainClassProject;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Test.CartPage;
import Test.CheckoutPage;
import Test.LandingPage;
import Test.confirmationPage;
import Test.productcatalog;
import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class submitorderTest
{
	public static void main(String[] args) throws InterruptedException 
	{
		String productname="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		LandingPage landingpage=new LandingPage(driver);
		landingpage.goTo();
		productcatalog productcatalog=landingpage.loginApplication("sameershek11233@gmail.com","Sameer@11233");
		
		List<WebElement>products=productcatalog.getproductList();
		productcatalog.addToCart(productname);
		CartPage cartPage=productcatalog.goToCartpage();
		boolean match=cartPage.verifyproductdisplay(productname);
		assertTrue(match);
		cartPage.goToCartpage();
		CheckoutPage checkoutPage=cartPage.goTocheckout();
		checkoutPage.selectCountry("india");
		
		confirmationPage confirmationPage= checkoutPage.submitorder();
		String confirmMessage=confirmationPage.getconfirmationmessage();
		assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
		
		
	}
}
