package BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.LandingPage;

public class Baseclass {

	public WebDriver driver;
	
	public Properties prop ;

	public WebDriver BrowerInitiation() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\utilities\\config.properties");
		prop.load(fis);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;

	}

	public LandingPage launchApplication() throws IOException {

		driver = BrowerInitiation();
		driver.get(prop.getProperty("url"));
		LandingPage landingpage = new LandingPage(driver);
		return landingpage;

	}
	
	public void TearDown() {
		driver.quit();
	}
	

}
