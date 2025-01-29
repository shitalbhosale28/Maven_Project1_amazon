package amazon_Project1.Project1_Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Project1 {

	WebDriver driver;
	// step1
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
		String un1 = DataExcel.readusername();

		// username.sendKeys("shital.bhosale@hotmail.com");
		username.sendKeys(un1);
	}

	public void continuebuttn() {
		conti_button.click();
	}

	public void pwd() {
		String pwd = DataExcel.password();

		// username.sendKeys("shital.bhosale@hotmail.com");

		password.sendKeys(pwd);
	}

	public void signin() {
		Sign_button.click();
	}

	public LoginPage_Project1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
