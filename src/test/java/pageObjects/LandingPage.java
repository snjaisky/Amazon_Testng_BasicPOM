package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponentClass;

public class LandingPage extends AbstractComponentClass {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;

	By searchbox = By.id("twotabsearchtextbox");

	@FindBy(id = "nav-link-accountList")
	WebElement signin;

	@FindBy(xpath = "//div[@id='nav-flyout-ya-signin']/a")
	WebElement signinBtn;

	public SearchResultsPage SearchFor(String searchele) {
		waitForElementToAppear(searchbox);
		searchBox.click();
		searchBox.sendKeys(searchele);
		searchBox.sendKeys(Keys.ENTER);
		SearchResultsPage searchResult = new SearchResultsPage(driver);
		return searchResult;

	}

	public SigninPage Signin() throws InterruptedException {

		waitForWebElementToAppear(signin);
		signin.click();
		SigninPage signinpage = new SigninPage(driver);
		return signinpage;

	}
	
public String VerifyPageTitle() {
	return driver.getTitle();
}


}
