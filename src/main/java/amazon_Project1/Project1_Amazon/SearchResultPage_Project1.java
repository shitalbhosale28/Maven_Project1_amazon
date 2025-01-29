package amazon_Project1.Project1_Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchResultPage_Project1 {

	WebDriver driver;

	@FindBy(xpath = "(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")
	WebElement product_book;

	@FindBy(xpath = "//span[.='Get It by Tomorrow']")
	WebElement getittomorrow_Checkbox;

	@FindBy(xpath = "//span[.='10% Off or more']")
	WebElement discount;

	@FindBy(xpath = "//span[.='YOUVA']")
	WebElement Brand_Checkbox;

	public void product_book() throws InterruptedException {
		product_book.click();

	}

	public void filter() throws InterruptedException {
		getittomorrow_Checkbox.click();
		Thread.sleep(3000);
		discount.click();
		Assert.assertEquals(getittomorrow_Checkbox.isDisplayed(), true);
		// Assert.assertEquals(Brand_Checkbox.isSelected(), true);

	}

	public SearchResultPage_Project1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
