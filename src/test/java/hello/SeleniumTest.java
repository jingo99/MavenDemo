package hello;
import junit.framework.TestCase;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class SeleniumTest  extends TestCase{

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setPlatform(Platform.LINUX);
		capabilities.setCapability("marionette", true);
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities); 
		
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
