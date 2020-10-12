package Product;
import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;



import PageObjectsProducts.MyStoreHomePage;
import Resources.Base;

public class ValidateMyStore extends Base {
	
	 
	
	 File myobj = new File(System.getProperty("user.dir")+"\\reports\\FinalProductResult.txt");
	 //public static Logger Log=(Logger) org.apache.logging.log4j.LogManager.getLogger(Base.class.getName());
	 public MyStoreHomePage mystore;
	public Base base;
	SoftAssert as =new SoftAssert();
	
	 Actions act;
	
@BeforeTest
 public void initialize() throws IOException
	 {
	
	driver=initilizeDriver();
	
	driver.get(URL);
	//Log.info("Driver is initialized successfully");
	}
	@Test
	 public void clickOnsignin() throws IOException
	 {
	
		mystore=new MyStoreHomePage(driver);
		mystore.getsignin().click();
		//Log.info(" User is able to click on Sign in button successfully");
	 }
	@Test(priority=1)
	public void login()
	{
		mystore.getUserId().sendKeys(userId);
		mystore.getPassword().sendKeys(password);;
		mystore.getsigninButton().click();
		//Log.info(" User is able to signin successfully");
	}
	

	@Test (priority=2)
	public void ProductSelection()
	{
		List<WebElement> productsName =mystore.getElemetns();
		System.out.println(productsName);
	for (WebElement productName:productsName)
	{
		System.out.println(productName.getText());
	if(productName.getText().equalsIgnoreCase("T-SHIRTS"))
	{
		String s=productName.getText();
		System.out.println(s);
		productName.click();
	}
	}

	act=new Actions(driver);
	act.moveToElement(mystore.getProduct()).doubleClick().build().perform();
	//Log.info("Product selected successfully");
	}
	

	@Test (priority=3)
	public void productAddToCart() throws IOException

	{
		mystore.getAddToCart().click();
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mystore.getProductToCheckoutmsg()));
		as.assertEquals(mystore.getProductMsg().getText(), "Product successfully added to your shopping cart");
		
		@SuppressWarnings("resource")
		BufferedWriter writer = new BufferedWriter(new FileWriter(myobj));
		String finalResult=mystore.getFinalProductName().getText()+System.lineSeparator()+mystore.getProductofcolour().getText()+System.lineSeparator()
		+mystore.getQuantityLabel().getText()+" "+mystore.getQuantityvalue().getText()+System.lineSeparator()+mystore.getTotalLabel().getText()
		+" "+mystore.getTotalvalue().getText();
		
		writer.write(finalResult);
		writer.close();
		mystore.getProductToCheckout().click();
		//Log.info("Product added to cart sucessfully");
		as.assertAll();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		//Log.info("Driver close successfully");
	}
	
}
