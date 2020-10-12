package Resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
public WebDriver driver;
public String URL, userId, password;
public FileOutputStream fout;
public Properties prop;


public WebDriver initilizeDriver() throws IOException
{
prop=new Properties();
FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
prop.load(fis);
String browserName=prop.getProperty("browser");
//String browserName=System.getProperty("browser");
URL=prop.getProperty("url");
userId=prop.getProperty("user");
password=prop.getProperty("pass");

if(browserName.contains("chrome"))
{
System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
ChromeOptions option=new ChromeOptions();
if(browserName.contains("headless"))
		{
	option.addArguments("headless");
		
		
		}
driver=new ChromeDriver(option);
		}
else if(browserName.equals("firefox"))
{
	
driver=new FirefoxDriver();
}
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
return driver;

}


public String getScreenShot(String tesCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File Source=ts.getScreenshotAs(OutputType.FILE);
	String destinationPath=System.getProperty("user.dir")+"\\reports\\"+tesCaseName+".png";
	FileUtils.copyFile(Source, new File(destinationPath));
	
return destinationPath;
}


}