package pageObjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Base;

public class HomePage extends Base {

	public WebDriver driver = initilizeDriver();
	public JavascriptExecutor js;
	public WebDriverWait wait;

	By productTitle = By.xpath("//h3[@class='product-title']"); 
	By addToCartBtn = By.xpath("//button[text()='Add to cart']"); // //a[text()='Add to cart']
	By myAccount = By.xpath("(//a[text()='My account']) [2]");
	By email = By.xpath("//input[@name='username']");
	By password = By.xpath("//input[@name='password']");
	By loginBtn = By.xpath("//button[@value='Log in']");
	By viewCart = By.xpath("(//a[text()='View cart']) [2]");
	By checkoutBtn = By.xpath("//div[@class='wc-proceed-to-checkout']");
	By checkbox = By.xpath("(//input[@type='checkbox']) [1]");
	By placeOrderBtn = By.xpath("(//button[@type='submit']) [3]");

	public void openUrl() {
		driver.get("https://testing.hindtec.com/");
	}

	public void Login(String emails, String passwords) {
		driver.findElement(myAccount).click();
		driver.findElement(email).sendKeys(emails);
		driver.findElement(password).sendKeys(passwords);
		driver.findElement(loginBtn).click();
	}

	public void addProductsToCart(String productName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)");
		List<WebElement> prod = driver.findElements(productTitle);
		for (int i=0; i<prod.size(); i++) {
			String pro = prod.get(i).getText();
			if (pro.equalsIgnoreCase(productName)) {
				driver.findElements(productTitle).get(i).click();
				driver.findElement(addToCartBtn).click();
				break;
			}
		}
	}
	
	public void proceedToCheckout()
	{
		driver.findElement(viewCart).click();
		driver.findElement(checkoutBtn).click();
		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("arguments[0].click();", driver.findElement(checkbox));
		driver.findElement(placeOrderBtn);
	}
}
