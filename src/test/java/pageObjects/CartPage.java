package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponentClass;

public class CartPage extends AbstractComponentClass {

	public WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath  = "(//input[@name='submit.add-to-cart'])[2]")
	WebElement AdddToCartBtn;

	@FindBy(xpath = "(//h4[contains(text(),'Added to Cart')])[2]")
	WebElement SuccessAddedtoCart;
	
	@FindBy(xpath = "//span[@id='productTitle']")
	WebElement ItemName;
	

	public void ClickAddToCart() throws InterruptedException {
		Thread.sleep(3000);
		waitForWebElementToAppear(AdddToCartBtn);
		scrollToElement(AdddToCartBtn);
		AdddToCartBtn.click();
	}

	public String ItemAddedtoCartMessage() {
		waitForWebElementToAppear(SuccessAddedtoCart);
		String AddedtoCart = SuccessAddedtoCart.getText();
		System.out.println(AddedtoCart);
		return AddedtoCart; 
	}
	
	public String ValidateAddedToCartNotification() {
	String Message = ItemAddedtoCartMessage();
	System.out.println("Success Message: "+Message);
	return Message;
	}
	
	

}
