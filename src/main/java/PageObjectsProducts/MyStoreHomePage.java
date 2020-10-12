package PageObjectsProducts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyStoreHomePage {
public WebDriver driver;
	

	
		private By signin=By.xpath("//a[@class='login']");
		 private By userId=By.xpath("//label[@for='email']//following-sibling::input");
		 private By password=By.xpath("//input[@id='passwd']");
		
		private By signinbutton=By.xpath("//span[contains(.,'Sign in')]/parent::button");
		
		private By elment=By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//li");
		private By product=By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]");
		
		
		
		private By addToCart=By.xpath("//span[contains(text(),'Add to cart')]");
		private By productMsg=By.xpath("//h2[contains(.,'Product successfully added to your shopping cart')]");
		
		
		
		private By productToCheckout=By.xpath("//span[contains(.,'Proceed to checkout')]");
				
		private By finalProductName=By.xpath("//div[@class='layer_cart_product_info']//span[contains(text(), 'Faded Short Sleeve T-shirts')]");
		private By productOfColour=By.xpath("//span[contains(text(),'Orange, S')]");
		
		private By quantityLabel=By.xpath("//div[@class='layer_cart_product_info']//strong[contains(text(),'Quantity')]");
		
		
		private By quantityValue=By.xpath("//div[@class='layer_cart_product_info']//strong[contains(text(),'Quantity')]/following-sibling::span");
		
		private By totalLabel=By.xpath("//div[@class='layer_cart_product_info']//strong[contains(text(),'Total')]");
		
		private By totalvalue=By.xpath("//div[@class='layer_cart_product_info']//strong[contains(text(),'Total')]/following-sibling::span");
		public MyStoreHomePage(WebDriver driver)
		{
		this.driver=driver;
		
		}
		
		
		public WebElement getsignin()
		{
		return driver.findElement(signin);
		}
		public WebElement getUserId()
		{
		return driver.findElement(userId);
		}
		public WebElement getPassword()
		{
		return driver.findElement(password);
		}
		public WebElement getsigninButton()
		{
		return driver.findElement(signinbutton);
		}
		public List<WebElement> getElemetns()
		{
		return driver.findElements(elment);
		}
		public WebElement getProduct()
		{
		return driver.findElement(product);
		}
		public WebElement getAddToCart()
		{
		return driver.findElement(addToCart);
		}
		public WebElement getProductMsg()
		{
		return driver.findElement(productMsg);
		}
		public WebElement getProductToCheckout()
		{
		return driver.findElement(productToCheckout);
		}
		
		
		public By getProductToCheckoutmsg()
		{
		return productToCheckout;
		}
		public WebElement getFinalProductName()
		{
		return driver.findElement(finalProductName);
		}
		public WebElement getProductofcolour()
		{
		return driver.findElement(productOfColour);
		}
		public WebElement getQuantityLabel()
		{
		return driver.findElement(quantityLabel);
		}
		public WebElement getQuantityvalue()
		{
		return driver.findElement(quantityValue);
		}
		public WebElement getTotalLabel()
		{
		return driver.findElement(totalLabel);
		}
		public WebElement getTotalvalue()
		{
		return driver.findElement(totalvalue);
		}
	}
	
	
	
	
	
	
	
	
	
	

