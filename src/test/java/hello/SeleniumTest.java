package hello;
import junit.framework.TestCase;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class SeleniumTest  extends TestCase{

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capability = DesiredCapabilities.Firefox(); 
		IWebDriver driver = new RemoteWebDriver("35.195.58.39:4444", capability); 
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testSimple() throws Exception {
		this.driver.get("http://www.google.com");
		assertEquals("Google", this.driver.getTitle());
	}

	@After
	public void tearDown() throws Exception {
		this.driver.quit();
	}

}
