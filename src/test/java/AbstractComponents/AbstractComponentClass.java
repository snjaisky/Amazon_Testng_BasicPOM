package AbstractComponents;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponentClass {

	public WebDriver driver;

	public AbstractComponentClass(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElementToAppear(By finby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(finby));
	}

	public void waitForWebElementToAppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void MouseHover(WebElement element) {

		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}

	public String getWindoWhandle() {
		String ParentWindow = driver.getWindowHandle();
		return ParentWindow;
	}

	public void SwitchToNewTab() {

		String ParentWindow = getWindoWhandle();
		Set<String> Handles = driver.getWindowHandles();
		for (String handle : Handles) {
			if (!handle.equals(ParentWindow)) {
				driver.switchTo().window(handle);
			}

		}

	}

	public void SwitchBacktoParentWindow() {
		String ParentWindow = getWindoWhandle();
		driver.switchTo().window(ParentWindow);
	}

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

}
