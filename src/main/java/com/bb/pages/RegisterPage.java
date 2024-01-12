package com.bb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	/*
	 * Page Objects
	 */
	
	By registerlink = By.className("ico-register");
	By radiobtn = By.id("gender-female");
	By firstnametxt = By.id("FirstName");
	By lastnametxt = By.id("LastName");
	By emailadrs = By. id("Email");
	By passtxt= By.id("Password");
	By cnfmpasstxt = By.id("ConfirmPassword");
	By resiterbtn = By.id("register-button");
	By validMsg = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]");
	
	/* method creation */
	
	public void clickOnRegisterLink() {
		driver.findElement(registerlink).click();
	}
	
	public void clickOnradiobtn() {
		driver.findElement(radiobtn).click();
	}
	
	public void enterFrstnm(String firstname) {
		driver.findElement(firstnametxt).sendKeys(firstname);
	}
	
	public void enterLstnm(String lastname) {
		driver.findElement(lastnametxt).sendKeys(lastname);
	}
	
	public void enterEmailAddress(String emailad) {
		driver.findElement(emailadrs).sendKeys(emailad);
	}
	
	public void enterpassword(String password) {
		driver.findElement(passtxt).sendKeys(password);
	}
	
	public void entercnfmpassword(String confirmpass) {
		driver.findElement(cnfmpasstxt).sendKeys(confirmpass);
	}
	
	public void clickOnRegisterbtn() {
		driver.findElement(resiterbtn).click();
	}
	
	public void verifySuccesfullMsg() {
		String successmsg = driver.findElement(validMsg).getText();
		Assert.assertEquals(successmsg, "Your registration completed");
	}
	
}

