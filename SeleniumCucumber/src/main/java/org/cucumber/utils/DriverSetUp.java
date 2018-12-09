package org.cucumber.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DriverSetUp {

	public void setupRemodeDriver(String ipAddress) {
	}

	public static WebDriver setupDriver(String browser, String driverPath) {
		WebDriver driver = null;

		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", driverPath + "//chromedriver.exe");
			driver = new EventFiringWebDriver(new ChromeDriver());
			break;
		case "iexplorer":
			System.setProperty("webdriver.ie.driver", driverPath + "//IEDriverServer.exe");
			driver = new EventFiringWebDriver(new InternetExplorerDriver());
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", driverPath + "//geckodriver.exe");
			driver = new EventFiringWebDriver(new FirefoxDriver());
			break;
		}
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

}
