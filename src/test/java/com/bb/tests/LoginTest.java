package com.bb.tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bb.base.BasePage;
import com.bb.pages.LoginPage;

public class LoginTest extends BasePage {

	
	LoginPage loginPage;
	
	@BeforeSuite
	public void setUp() {
		invokeBrowser();
		loginPage =  new LoginPage(driver);
	}
	
	   @DataProvider (name = "login")
	     public Object[][] validLogin(){
		 return new Object[][] {{"Demo Web Shop. Login","Demo Web Shop","rkudikala89@Gmail.com","testing1234"}};
	     }
		

	@Test(dataProvider = "login", priority = 0, testName = "BBBAN-T1", suiteName = "Smoke", description = "Login test with valid data")
	public void Verify_the_login_functionality_with_valid_data(String loginTitle,String homePageTitle, String email, String password) {
		loginPage.clickLoginLink();
		Assert.assertEquals(loginPage.getTitle(), loginTitle);
		loginPage.enterEmailAddress(email);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		loginPage.clickLogout();
		Assert.assertEquals(loginPage.getTitle(), homePageTitle);
	}

	
	@AfterSuite
	public void closeBrowser() {
		close();
	}
	
}
