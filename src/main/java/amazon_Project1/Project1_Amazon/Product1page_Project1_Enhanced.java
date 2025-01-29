package amazon_Project1.Project1_Amazon;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Product1page_Project1_Enhanced {
	WebDriver driver;
//step1	
	// @FindBy(xpath = "//div[@data-asin='B099S1BQRB']")
	@FindBy(xpath = "//div[@role='listitem' and @data-asin='B099S1BQRB'][1]")
	WebElement productEle;
	// select dropdown
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addToCartButton;

	@FindBy(xpath = "//div[@id='featurebullets_feature_div']")
	WebElement aboutitem;
	@FindBy(xpath = "	//*[@id='corePriceDisplay_desktop_feature_div']")
	WebElement price;
	@FindBy(xpath = "//select[@name='s']")
	WebElement sortlist_dropdown;

	public void product(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> results = driver.findElements(By.xpath("//div[@role='listitem' and @data-asin]"));
		String productID = Data.getExcelData(7, 2);
		int resultLocation = 0;
		for (WebElement webElement : results) {
			resultLocation++;
			String dataAsin = webElement.getDomAttribute("data-asin");
			if (productID.equals(dataAsin)) {
				// productEle = webElement;
				String productName = Data.getExcelData(7, 3);
				// productEle = driver.findElement(By.xpath("//h2[@aria-label='" +productName + "']"));
				productEle = driver.findElement(By.xpath("//span[.='" + productName + "']"));
				System.out.println("Working with product >> Search=" + Data.getExcelData(7, 1) + ">Result Found at: " + resultLocation + ", dataAsin=" + dataAsin + ":" + productName);
				break;
			}
		}
		Thread.sleep(1000);
		productEle.click();

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
	}

	public void sort() throws InterruptedException {
		Select s1 = new Select(sortlist_dropdown);
		s1.selectByVisibleText("Price: Low to High");
		Thread.sleep(2000);
		s1.selectByVisibleText("Avg. Customer Review");

	}

	// step3
	public Product1page_Project1_Enhanced(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// about item //div[@id='featurebullets_feature_div']
	// //div[@id='featurebullets_feature_div']
	// price
	// *[@id="corePriceDisplay_desktop_feature_div"]

}
