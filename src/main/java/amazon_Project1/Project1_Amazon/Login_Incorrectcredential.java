package amazon_Project1.Project1_Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Incorrectcredential {

	WebDriver driver;
	// step1
	@FindBy(name = "cvf_captcha_captcha_action")
	WebElement captcha_Continuebutton_asserttest;
	@FindBy(name = "email")
	WebElement username;

	@FindBy(xpath = "//input[@class='a-button-input']")
	WebElement conti_button;

	@FindBy(id = "ap_password")
	WebElement password;

	@FindBy(id = "signInSubmit")
	WebElement Sign_button;

//step 2
	public void un() {
		username.sendKeys("shital.bhosale@hotmail.com");
	}

	public void continuebuttn() {
		conti_button.click();
	}

	public void pwd() {
		password.sendKeys("Test@123");
	}

	public void signin() {
		Sign_button.click();
		// Assert.assertEquals(captcha_Continuebutton_asserttest.isDisplayed(), true);

	}

	public Login_Incorrectcredential(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
