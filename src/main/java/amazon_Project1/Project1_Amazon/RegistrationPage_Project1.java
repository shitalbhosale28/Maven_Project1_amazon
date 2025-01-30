package amazon_Project1.Project1_Amazon;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage_Project1 {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
		wait.until(ExpectedConditions.visibilityOf(starthere));
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
