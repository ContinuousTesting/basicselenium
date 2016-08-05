package com.cts.basicselenium;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class seleniumTest {
  private String baseUrl;
  private WebDriver driver;
  private ScreenshotHelper screenshotHelper;
  
  @Before
  public void openBrowser() {
	  
	    
	System.out.println("Called openBrowser-");
	System.setProperty("webdriver.chrome.driver", "C:\\Apps\\SeleniumWebdrivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("http://www.google.com");
    screenshotHelper = new ScreenshotHelper();
  }
  
  @After
  public void saveScreenshotAndCloseBrowser() throws IOException {
    screenshotHelper.saveScreenshot("screenshot.png");
    driver.quit();
  }
  
  @Test
  public void pageTitleCompare() throws IOException {
    assertEquals("The page title should equal Google at the start of the test.", "Google", driver.getTitle());
    //WebElement searchField = driver.findElement(By.name("q"));
    
  }
  
  private class ScreenshotHelper {
  
    public void saveScreenshot(String screenshotFileName) throws IOException {
      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenshot, new File(screenshotFileName));
    }
  }
}