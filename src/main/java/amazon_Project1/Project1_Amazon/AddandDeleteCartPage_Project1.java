package amazon_Project1.Project1_Amazon;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddandDeleteCartPage_Project1 {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	// STEP1

	@FindBy(xpath = "//div[@id='nav-cart-count-container']")
	WebElement cart;

	// @FindBy(id = "submit.add-to-cart")
	// WebElement addcart_tc5;

	@FindBy(xpath = "//span[@class='a-icon a-icon-small-add']")
	WebElement incrementproduct;

	@FindBy(xpath = "//input[@data-feature-id='item-delete-button']")
	WebElement deletecart;

	@FindBy(xpath = " //span[@class='a-size-base sc-list-item-removed-msg-text-delete']")
	WebElement cartremove_text;

//step2
	public void add_cart_increment(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		cart.click();
		int i = 0;
		while (i < 3) {
			Thread.sleep(2000);
			incrementproduct.click();
			i++;
			// Thread.sleep(2000);
		}

	}

	public void deletecart(WebDriver driver) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(deletecart));
		deletecart.click();

		// wait.until(ExpectedConditions.visibilityOf(cartremove_text));
		Assert.assertEquals(cartremove_text.isDisplayed(), true);
	}

	public AddandDeleteCartPage_Project1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
