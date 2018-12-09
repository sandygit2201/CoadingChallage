package org.cucumber.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.cucumber.handlers.FileReaderHandler;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class Application {
	private WebDriver driver;
	private static final Logger log = Logger.getLogger(Application.class);
	private String presentFrameContext;
	private Wait<EventFiringWebDriver> wait;
	
	public Application(WebDriver driver){
		this.driver = driver;
		this.wait = new FluentWait<EventFiringWebDriver>((EventFiringWebDriver) driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(WebDriverException.class)
				.ignoring(NoSuchElementException.class).ignoring(ElementNotVisibleException.class)
				.ignoring(StaleElementReferenceException.class);
	}
	
	public String getPresentFrameContext() {
		return presentFrameContext;
	}

	public void setPresentFrameContext(String presentFrameContext) {
		this.presentFrameContext = presentFrameContext;
	}
	
	
	public static void sleep(long seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void waitForPageToLoad() {
		sleep(200);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) this.driver;
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		boolean isDocReady = wait.until(expectation);
		while(!isDocReady){
			isDocReady = wait.until(expectation);
		}
		
		boolean jQueryDefined = (Boolean) jsExecutor.executeScript("return typeof jQuery != 'undefined'");
		if(jQueryDefined)
				waitForjQueryReady();
	}
	
	public void waitForjQueryReady(){
		sleep(200);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) this.driver;
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
			}
		};
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		boolean isjQueryReady = wait.until(expectation);
		while(!isjQueryReady){
			isjQueryReady = wait.until(expectation);
		}
	}
	
	
	public void switchFrameContext(String requiredFrameContext) {
		try {
			if (this.getPresentFrameContext()!=null) {
				if (!requiredFrameContext.equalsIgnoreCase(this.getPresentFrameContext())) {
					this.setPresentFrameContext(requiredFrameContext);
					if ("Child".equalsIgnoreCase(this.getPresentFrameContext()))
						this.driver.switchTo().frame("main");
					else
						this.driver.switchTo().defaultContent();
				}
			}else
				this.setPresentFrameContext("Parent");
		} catch (Exception e) {
			log.error(e.getCause());
		}
	}
	
	public void verifyVisibilityOfElement(WebElement element) {
		element = wait.until(ExpectedConditions.visibilityOf(element));
		if (element != null)
			wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void applicationSynchronization(WebElement element, String requiredFrameContext){
		this.waitForPageToLoad();
		this.switchFrameContext(requiredFrameContext);
		this.verifyVisibilityOfElement(element);
	}
	
	
	/**
	 * This method will read the url from project configuration file
	 * and launches the application
	 */
	public void launchApplication(){
		String url = FileReaderHandler.getInstance().getConfigFileReader().getProjectConfigProperty().getProperty("url");
		this.driver.get(url);
		this.waitForPageToLoad();
	}
	
	
	/**
	 * This method will enter the text in given element
	 * @param element
	 * @param text
	 */
	public void enterText(WebElement element, String text, String requiredFrameContext){
		this.applicationSynchronization(element, requiredFrameContext);
		element.clear();
		element.sendKeys(text);
		log.info("Entered '" + text + " ' in the text box");
	}
	
	/**
	 * This method will click on the given element
	 * @param element
	 */
	public void click(WebElement element, String requiredFrameContext){
		this.applicationSynchronization(element, requiredFrameContext);
		element.click();
		log.info("Clicked on given element");
	}
	
	/**
	 * This method will verify the page title
	 * @param pageTitle
	 */
	public void verifyPageTitle(String pageTitle){
		this.waitForPageToLoad();
		String actPageTitle = this.driver.getTitle();
		Assert.assertEquals(pageTitle, actPageTitle);
		log.info("Expected page Title: '" + pageTitle + "' Actual page tile '" + actPageTitle + "'");
	}
	
	public void clickElementFromList(List<WebElement> webElements, String textOfElement, String requiredFrameContext){
		this.waitForPageToLoad();
		switchFrameContext(requiredFrameContext);
		if (webElements.size() == 0)
			throw new NoSuchElementException();
		for (WebElement element : webElements) {
			if (textOfElement.equalsIgnoreCase(element.getText())) {
				verifyVisibilityOfElement(element);
				element.click();
				log.info("Clicked on '" + textOfElement + "' from project menu dropdown");
				break;
			}
		}
	}
	
	/**
	 * This method will enter unique text in given element
	 * and returns back the same
	 * @param element
	 * @param text
	 */
	public String enterUniqueText(WebElement element, String prefix, String requiredFrameContext){
		this.applicationSynchronization(element, requiredFrameContext);
		String runTimeData = prefix + DateFormattingUtil.getDateInHHmmssFormat();
		element.sendKeys(runTimeData);
		log.info("Entered '" + runTimeData + " ' in the text box");
		return runTimeData;
	}
	
	/**
	 * This method selects the given text from drop down
	 * @param element
	 * @param text
	 * @param requiredFrameContext
	 */
	public void selectByVisibleTextFromDropdown(WebElement element, String text, String requiredFrameContext){
		this.applicationSynchronization(element, requiredFrameContext);
		Select select = new Select(element);
		select.selectByVisibleText(text);
		log.info("Selected '" + text + " ' from dropdown");
	}
	
	/**
	 * This method uploads the given file
	 * @param element
	 * @param file
	 * @param requiredFrameContext
	 */
	public void uploadFile(WebElement element, String file, String requiredFrameContext){
		this.applicationSynchronization(element, requiredFrameContext);
		element.sendKeys(file);
		log.info("File '" + file + " ' uploaded successfully");
	}
	
	/**
	 * Uploads the file using Robot class
	 * @param imagePath
	 */
	 public void uploadFileWithRobot (String imagePath) {
	        StringSelection stringSelection = new StringSelection(imagePath);
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        clipboard.setContents(stringSelection, null);
	 
	        Robot robot = null;
	 
	        try {
	            robot = new Robot();
	        } catch (AWTException e) {
	            e.printStackTrace();
	        }
	 
	        robot.delay(250);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.delay(150);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	    }
	 
	/**
	 * This method verifies the expected text with actula text of the element
	 * @param element
	 * @param expectedText
	 * @param requiredFrameContext
	 */
	public void verifyText(WebElement element, String expectedText, String requiredFrameContext){
		this.applicationSynchronization(element, requiredFrameContext);
		Assert.assertEquals(expectedText, element.getText());
		log.info("Expected text: '" + expectedText + "' Actual text '" + element.getText() + "'");
	}
	
	/**
	 * Gives the data from table
	 * @param element
	 * @param requiredFrameContext
	 * @return
	 */
	public List<String> getTableData(WebElement element, String requiredFrameContext){
		this.applicationSynchronization(element, requiredFrameContext);
		switchFrameContext(requiredFrameContext);
		List<String> recordDetails = new ArrayList<>();
		WebElement tbody = element.findElement(By.tagName("tbody"));
		List<WebElement> tRows = tbody.findElements(By.tagName("tr"));
		List<WebElement> tCols = tRows.get(0).findElements(By.tagName("td"));
		for (WebElement column : tCols) {
			recordDetails.add(column.getText());
		}
		return recordDetails;
	}
	 
	/**
	 * This method gets the handle on keyboard and presses enter button
	 * @param element
	 * @param requiredFrameContext
	 * @return
	 */
	public void clickKeyboardEnter(WebElement element, String requiredFrameContext) {
		switchFrameContext(requiredFrameContext);
		((EventFiringWebDriver) driver).getKeyboard().pressKey(Keys.ENTER);
		log.info("Pressed enter button in keyboard");
	}
	
	/**
	 * This method send the action as enter on the web element
	 * @param element
	 * @param requiredFrameContext
	 * @return
	 */
	public void sendKeysEnter(WebElement element, String requiredFrameContext) {
		this.applicationSynchronization(element, requiredFrameContext);
		element.sendKeys(Keys.ENTER);
		log.info("Pressed enter button in keyboard");
	}
	
	/**
	 * Returns the text of the element
	 * @param element
	 * @param requiredFrameContext
	 * @return
	 */
	public String getElementText(WebElement element, String requiredFrameContext){
		this.applicationSynchronization(element, requiredFrameContext);
		return element.getText();
	}
	
	public void waitForSomeTime(long waitTime){
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method logs out from the application
	 */
	public void logOut(WebElement element1, WebElement element2, String frameContext){
		switchFrameContext(frameContext);
		verifyVisibilityOfElement(element1);
		element1.click();
		new Application(this.driver).waitForPageToLoad();
		verifyVisibilityOfElement(element2);
		element2.click();
		new Application(this.driver).waitForPageToLoad();
		log.info("Clicked on log off link");
	}



	

}
