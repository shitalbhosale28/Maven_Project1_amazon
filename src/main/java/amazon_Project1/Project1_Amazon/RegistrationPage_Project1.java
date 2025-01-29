package amazon_Project1.Project1_Amazon;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage_Project1 {

	WebDriver driver;
	// step1
	@FindBy(linkText = "Start here.")
	WebElement starthere;

	@FindBy(id = "ap_customer_name")
	WebElement yourname;

	@FindBy(id = "ap_phone_number")
	WebElement mobilenumber;

	@FindBy(id = "ap_password")
	WebElement password;

	@FindBy(id = "continue")
	WebElement verifymobile;

	// step2
	public void starthere_Register() throws InterruptedException {
		Thread.sleep(2000);
		starthere.click();
	}

	public void nameRegister() {
		yourname.sendKeys("komal" + Keys.ENTER);
	}

	public void mobileRegister() {
		mobilenumber.sendKeys("9604232794" + Keys.ENTER);
	}

	public void passRegister() {
		password.sendKeys("Komal@2025");
	}

	public void verifymobile_Register() {
		verifymobile.click();
	}

	// STEP3
	public RegistrationPage_Project1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
