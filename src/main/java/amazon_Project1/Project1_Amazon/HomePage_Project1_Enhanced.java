package amazon_Project1.Project1_Amazon;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage_Project1_Enhanced {
	WebDriver driver;
	// step1
	@FindBy(name = "email")
	WebElement username;
	@FindBy(xpath = "//span[@class='nav-line-2 ']")
	WebElement account_signhoverover;

	@FindBy(xpath = "(//span[.='Sign in'])[1]")
	WebElement Signin_button;

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchbox;

	@FindBy(xpath = "//span[.='Sign Out']")
	WebElement signout_button;

	// step2
	public void Account_list_homepage(WebDriver driver) throws InterruptedException {
		Actions a1 = new Actions(driver);
		a1.moveToElement(account_signhoverover).perform();
		Thread.sleep(2000);
	}

	public void signin_homepage() throws InterruptedException {
		Signin_button.click();
		// Thread.sleep(4000);
	}

	public void searchproduct() {
		searchbox.sendKeys(Data.getExcelData(7, 1) + Keys.ENTER);
	}

	public void signout() {
		signout_button.click();
		Assert.assertEquals(username.isDisplayed(), true);
	}

	// step3
	public HomePage_Project1_Enhanced(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
