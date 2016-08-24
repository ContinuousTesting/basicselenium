package com.cts.basicselenium;

import static junit.framework.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumTest {
  private String baseUrl;
  private WebDriver driver;
  private ScreenshotHelper screenshotHelper;
  
  @Before
  public void openBrowser() {
	  
	    
	System.out.println("Called openBrowser-123456");
	System.setProperty("webdriver.chrome.driver", "C:\\Apps\\SeleniumWebDriver\\chromedriver.exe");
	/*Map<String, Object> chromeOptions = new HashMap<String, Object>();
	chromeOptions.put("binary", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
	driver = new ChromeDriver(capabilities);*/
	driver = new ChromeDriver();
    driver.get("http://localhost:8080/petclinic/");
    screenshotHelper = new ScreenshotHelper();
  }
  
  @After
  public void saveScreenshotAndCloseBrowser() throws IOException {
    screenshotHelper.saveScreenshot("screenshot.png");
    try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    driver.quit();
  }
  
  @Test
  public void pageTitleCompare() throws IOException {
    assertEquals("The page title should equal Google at the start of the test.", "PetClinic :: a Spring Framesdfwork demonstration", driver.getTitle());
    //WebElement searchField = driver.findElement(By.name("q"));
    
  }
  
  private class ScreenshotHelper {
  
    public void saveScreenshot(String screenshotFileName) throws IOException {
      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenshot, new File(screenshotFileName));
    }
  }
}