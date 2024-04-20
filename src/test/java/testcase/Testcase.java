package testcase;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import BaseClass.Baseclass;
import pageObjects.LandingPage;
import pageObjects.SearchResultsPage;
import pageObjects.SigninPage;

public class Testcase extends Baseclass {

	LandingPage landingpage;
	SearchResultsPage searchResult;
	SigninPage signin;

	@Test
	public void FirstTest() throws InterruptedException, IOException {

		landingpage = launchApplication();
		searchResult = landingpage.SearchFor("iphone");
		Thread.sleep(2000);
		List<String> searchResultNames = searchResult.SearchresultList();
		int count = searchResult.getSearchResultCount();
		System.out.println("Total count of search Result is:" + count);
		for (String list : searchResultNames) {
			System.out.println(list);
		}

	}

	@Test
	public void signin() throws IOException, InterruptedException {

		landingpage = launchApplication();
		signin = landingpage.Signin();
		String title= landingpage.VerifyPageTitle();
		Assert.assertEquals(title, "Amazon Sign In");
		signin.enterEmailaddress(prop.getProperty("username"));
		Assert.assertTrue(signin.isErrorMessageDisplayed());
		

	}

	@AfterClass
	public void close() {
		TearDown();
	}

}
