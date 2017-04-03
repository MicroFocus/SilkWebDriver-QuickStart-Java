package sample.insurance;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class InsuranceWebTest {

	private WebDriver driver;

	@Before
	public void setup() {
		//TODO: Replace property with path to your chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Silk\\Silk WebDriver\\ng\\WebDriversSWD\\Windows\\Chrome\\2.28\\chromedriver.exe");
		//TODO: Replace property with path to your geckodriver.exe
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\Silk\\Silk WebDriver\\ng\\WebDriversSWD\\Windows\\Gecko\\0.11.1\\geckodriver.exe");
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://demo.borland.com/InsuranceWebExtJS/");
	}

	@Test
	public void searchForAgentWalker() {
		new Select(driver.findElement(By.id("quick-link:jump-menu"))).selectByVisibleText("Agent Lookup");
		
		driver.findElement(By.id("name-search:lastName")).clear();
		driver.findElement(By.id("name-search:lastName")).sendKeys("Walker");
		driver.findElement(By.id("name-search:search-name")).click();
		
		WebElement divtextWalker = driver.findElement(By.xpath("//div[text()=\"Walker\"]"));
		Assert.assertEquals(false, divtextWalker.isSelected());
		Assert.assertEquals(true, divtextWalker.isDisplayed());
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}