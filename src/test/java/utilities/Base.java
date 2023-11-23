package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public void baseClass() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/inputData/data.properties");
		prop = new Properties();
		prop.load(fis);
	}
	
	public static WebDriver initilizeDriver()
	{
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/drivers/msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
}
