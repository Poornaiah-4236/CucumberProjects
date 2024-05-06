package Driveras;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.HashMap;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilites.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
public class DriverUtilites extends ReadProperties {
	
	public WebDriver driver;
	
	public static final String driverPath = System.getProperty("user.dir") + File.separatorChar + "src\\test\\resources"
			+ File.separatorChar + "WebDrivers\\chromedriver.exe";
	

	public void openBrowser() throws IOException {
		getFile();
		System.setProperty("webdriver.chrome.driver", driverPath);	
		WebDriverManager.chromedriver().clearDriverCache().setup();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		ChromeOptions options = new ChromeOptions();
		options.setCapability("browserVersion", "120.0.6099.131");
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		switch (properties.get("Browser").toString()) {
		case "chrome":
			driver = new ChromeDriver(options);
			break;
		}
		driver.get(properties.get("URL").toString());
		driver.manage().window().minimize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		/*
		WebDriverManager.chromedriver().clearDriverCache().setup();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", driverPath);		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--start-maximized", "--incognito", 
				"disable-features=NetworkServiceInProcess", "--disable-dev-shm-usage", "--verbose", "--remote-allow-origins=*", "--ignore-certificate-errors");

		HashMap<String, Object> chromePref = new HashMap<>();
		chromePref.put("download.default_directory", System.getProperty("java.io.tmpdir"));
		options.setExperimentalOption("prefs", chromePref);
		// This gracefully handle insecure certificate error.
		options.setAcceptInsecureCerts(true);	
		
		switch (properties.get("Browser").toString()) {
		case "chrome":
			driver = new ChromeDriver(options);
			break;
		}
		driver.get(properties.get("URL").toString());
		driver.manage().window().minimize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		*/

	}
	public void getFile() throws IOException {
		properties=new Properties();
		FileInputStream fpro=new FileInputStream(filePath);
		properties.load(fpro);
		System.out.println(properties.get("URL"));
	}

	public void ClickOn(WebElement element, String name) {
		if (element.isDisplayed()) {
			element.click();
		}
	}

	public void EnterText(WebElement element, String value) {
		if (element.isDisplayed()) {
			element.sendKeys(value);
		}
	}

	public boolean isElementPresent(WebElement element) {
		boolean isPresent = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			isPresent = wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {

		}
		return isPresent;
	}
	public boolean isEnabled(WebElement element) {
		boolean isPresent = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			isPresent = wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
		} catch (Exception e) {

		}
		return isPresent;
	}

}
