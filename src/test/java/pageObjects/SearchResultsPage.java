package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponents.AbstractComponentClass;
import BaseClass.Baseclass;

public class SearchResultsPage extends AbstractComponentClass {

	public WebDriver driver;

	public SearchResultsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='a-section']//h2/a/span")
	List<WebElement> searchResult;

	By searchrel = By.xpath("//div[@class='a-section']//h2/a/span");

	public List<String> SearchresultList() {
		List<WebElement> resultList = driver.findElements(searchrel);
		List<String> elements = new ArrayList<String>();
		for (WebElement res : resultList) {
			elements.add(res.getText());

		}
		return elements;
	}

	public int getSearchResultCount() {
		List<WebElement> resultList = driver.findElements(searchrel);
		List<String> elements = new ArrayList<String>();
		int count = resultList.size();
		return count;

	}

	public CartPage AddItemToCart(String productName) throws InterruptedException {

		List<WebElement> resultList = driver.findElements(searchrel);
		List<String> elements = new ArrayList<String>();
		for (WebElement res : resultList) {
			if (res.getText().equals(productName)) {
				res.click();
			}

		}
		SwitchToNewTab();
		CartPage cp = new CartPage(driver);
		cp.ClickAddToCart();
	
		return cp;

	}

}
