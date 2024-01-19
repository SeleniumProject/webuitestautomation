package com.bb.tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bb.base.BasePage;
import com.bb.pages.RegisterPage;

public class RegisterTest extends BasePage {

	RegisterPage registerpage;
	
	@BeforeSuite
	public void setUp() {
		invokeBrowser();
		registerpage = new RegisterPage(driver);
	}
	
	  @DataProvider (name = "register")
    public Object[][] validLogin(){
	 return new Object[][] {{"Demo Web Shop","Demo Web Shop. Register","Ramya","kumari","ramya13636586@gmail.com","testing1234","testing1234"}};
    }

	
	@Test(dataProvider = "register")
	public void verifyRegisterPageWithValidCredentials(String HomePageTitle , String RegisterTitle,  String FirstName , String lastName , String EmailAddress , String Password , String ConfirmPassword) {
		 
		Assert.assertEquals(registerpage.getTitle(), HomePageTitle);
		registerpage.clickOnRegisterLink();
		Assert.assertEquals(registerpage.getTitle(), RegisterTitle );
		registerpage.clickOnradiobtn();
		registerpage.enterFrstnm(FirstName);
		registerpage.enterLstnm(lastName);
		registerpage.enterEmailAddress(EmailAddress);
		registerpage.enterpassword(Password);
		registerpage.entercnfmpassword(ConfirmPassword);
		registerpage.clickOnRegisterbtn();
		registerpage.verifySuccesfullMsg();
	}
	
	@AfterSuite
	
	public void closeBrowser() {
		driver.close();
	}
	
		
}
