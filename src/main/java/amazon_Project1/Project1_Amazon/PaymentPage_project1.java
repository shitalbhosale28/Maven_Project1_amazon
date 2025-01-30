package amazon_Project1.Project1_Amazon;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage_project1 {
	WebDriver driver;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	@FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
	WebElement Proceedbutton;

	@FindBy(xpath = "(//span[@class='a-declarative'])[8]")
	WebElement changepay_link;

	@FindBy(xpath = "//span[.='Cash on Delivery/Pay on Delivery'][1]")
	WebElement cod_payoption;

	@FindBy(name = "ppw-instrumentRowSelection")
	WebElement creditcard_radiobutton;

	@FindBy(xpath = "//span[@id='checkout-secondary-continue-button-id-announce']")
	WebElement usethispaymen_button;

	@FindBy(xpath = "(//span[@class='a-declarative'])[10]")
	WebElement revieworder_button;

	@FindBy(xpath = "(//input[@name='placeYourOrder1'])[3]")
	WebElement placeorder_button;
	@FindBy(xpath = "//img[@class='apx-add-pm-trigger-common-image']")
	WebElement addcreditdetails_button;
	@FindBy(xpath = "//span[@class='a-button a-button-primary']")
	WebElement nextstep_payment;
	@FindBy(xpath = "(//input[@name='ppw-instrumentRowSelection'])[1]")
	WebElement credicard_radio;
	@FindBy(xpath = "(//input[@name='ppw-instrumentRowSelection'])[2]")
	WebElement netbanking_radio;
	@FindBy(xpath = "(//input[@name='ppw-instrumentRowSelection'])[3]")
	WebElement otherupi;
	@FindBy(xpath = "(//span[.='EMI'])[4]")
	WebElement emi;
	@FindBy(xpath = "//input[@name='ppw-claimCode']")
	WebElement coupencode;

	// step2
	public void proceedbuy() {
		Proceedbutton.click();
	}

	public void allapyment_selection() {
		credicard_radio.click();
		netbanking_radio.click();
		wait.until(ExpectedConditions.visibilityOf(otherupi));
		otherupi.click();
		wait.until(ExpectedConditions.visibilityOf(emi));
		emi.click();

	}

	public void changepayment() {
		changepay_link.click();
	}

	public void coupencode() {
		coupencode.sendKeys("Match251" + Keys.ENTER);
	}

	public void Cashondeliveryoption() {
		cod_payoption.click();
	}

	public void creditcard() {
		wait.until(ExpectedConditions.visibilityOf(creditcard_radiobutton));
		creditcard_radiobutton.click();
	}

	public void addcredit_details() {
		wait.until(ExpectedConditions.visibilityOf(addcreditdetails_button));
		addcreditdetails_button.click();
	}

	public void usethispayment() {
		usethispaymen_button.click();
		nextstep_payment.click();

	}

	public void revieworder() {
		revieworder_button.click();
	}

	public void placeorder() {
		placeorder_button.click();
	}

	// step3
	public PaymentPage_project1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
