package amazon_Project1.Project1_Amazon;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Product1page_Project1 {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//step1	
	// @FindBy(xpath = "//div[@data-asin='B099S1BQRB']")
	@FindBy(xpath = "//div[@role='listitem' and @data-asin='B099S1BQRB'][1]")
	WebElement notebook;
	// select dropdown
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addToCartButton;

	@FindBy(xpath = "//div[@id='featurebullets_feature_div']")
	WebElement aboutitem;
	@FindBy(xpath = "	//*[@id='corePriceDisplay_desktop_feature_div']")
	WebElement price;
	@FindBy(xpath = "//select[@name='s']")
	WebElement sortlist_dropdown;
	@FindBy(xpath = "//div[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']")
	WebElement addedtocart_text;

	public void product(WebDriver driver) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(notebook));
		notebook.click();
		// notebook = driver.findElement(By.xpath("//span[.='Classmate Pulse 6 Subject
		// Spiral Notebook - Pack of 3 | Unruled | 300 Pages | 24.0cm x 18.0cm |
		// Attractive Cover Designs | Soft Cover | Notebooks for College Students']"));
		Set<String> pcid = driver.getWindowHandles();
		Iterator i1 = pcid.iterator();
		String parentid = (String) i1.next();
		String childid = (String) i1.next();
		driver.switchTo().window(childid);
	}

	public void verifyitem() {
		Assert.assertEquals(aboutitem.isDisplayed(), true);
		Assert.assertEquals(price.isDisplayed(), true);
	}

	public void addtocart() {
		addToCartButton.click();
		Assert.assertEquals(addedtocart_text.isDisplayed(), true);

	}

	public void sort() throws InterruptedException {
		Select s1 = new Select(sortlist_dropdown);
		s1.selectByVisibleText("Price: Low to High");
		Thread.sleep(2000);
		s1.selectByVisibleText("Avg. Customer Review");

	}

	// step3
	public Product1page_Project1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// about item //div[@id='featurebullets_feature_div']
	// //div[@id='featurebullets_feature_div']
	// price
	// *[@id="corePriceDisplay_desktop_feature_div"]

}
