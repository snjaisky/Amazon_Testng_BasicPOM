package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponentClass;

public class SigninPage extends AbstractComponentClass {

	public WebDriver driver;

	public SigninPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ap_email")
	WebElement SigninInputBox;

	@FindBy(xpath = "//div[@id='auth-error-message-box']//h4")
	WebElement ErrorMessage;

	public void enterEmailaddress(String username) {
		SigninInputBox.click();
		SigninInputBox.sendKeys(username);
		SigninInputBox.sendKeys(Keys.ENTER);
	}

	public boolean isErrorMessageDisplayed() {

		waitForWebElementToAppear(ErrorMessage);
		return ErrorMessage.isDisplayed();
	}

}
