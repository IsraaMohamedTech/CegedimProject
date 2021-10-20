package Cegedim.codility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.common;

public class login extends common {
	public static WebDriver driver;
	public static  LoginPage loginPage;

	@BeforeTest
	public void initalizeDriver() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("loginUrl"));		
        loginPage = new LoginPage(driver);
	}

	@Test(dataProvider = "getPositiveData")
	public void positiveLogin(String username, String password) {
		loginPage.getEmail().sendKeys(username);
		loginPage.getPassword().sendKeys(password);
		loginPage.getLogin().click();

	}

	@DataProvider
	public Object[][] getPositiveData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "success@codility.com";
		data[0][1] = "123456";
		return data;
	}

	@Test(dataProvider = "getNagitiveData")
	public void nagitiveLogin(String username, String password) {
		loginPage.getEmail().sendKeys(username);
		loginPage.getPassword().sendKeys(password);
		loginPage.getLogin().click();
		Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());

	}

	@DataProvider
	public Object[][] getNagitiveData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "failed@codility.com";
		data[0][1] = "123456";
		return data;
	}

	@Test(dataProvider = "getEmptyData")
	public void emptyFields(String username, String password) throws IOException {
		loginPage.getEmail().sendKeys("");
		loginPage.getPassword().sendKeys("");
		loginPage.getLogin().click();
		Assert.assertTrue(loginPage.getUserNameRequiredMessage().isDisplayed()
				&& loginPage.getPasswordRequiredMessage().isDisplayed());

	}

	@DataProvider
	public Object[][] getEmptyData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "";
		data[0][1] = "";
		return data;
	}

	@AfterTest
	public void closeBrowserWindows() {
		driver.close();
	}

}
