package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	By email = By.cssSelector("[id='username']");
	By password = By.cssSelector("[id='password']");
	By login = By.xpath("//button[contains(text(),'Log in')]");
	By errorMessage = By.id("login-form-error");
	By usernameRequired = By.id("username-error");
	By passwordReguired = By.id("password-error");

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLogin() {
		return driver.findElement(login);
	}

	public WebElement getErrorMessage() {
		return driver.findElement(errorMessage);
	}

	public WebElement getUserNameRequiredMessage() {
		return driver.findElement(usernameRequired);
	}

	public WebElement getPasswordRequiredMessage() {
		return driver.findElement(passwordReguired);
	}

}
