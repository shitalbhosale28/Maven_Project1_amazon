package amazon_Project1.Project1_Amazon;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditProfilePage_Project1 {

	WebDriver driver;
	WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//step1
	@FindBy(xpath = "//button[.='Manage Profiles']")
	// button[.='Manage Profiles']
	WebElement manageprofile_link;

	// @FindBy(xpath = "//a[.='View']")
	@FindBy(linkText = "View")
	WebElement view_link;

	@FindBy(xpath = "//button[@class='edit-pencil-icon-button']")
	WebElement editbutton;

	@FindBy(xpath = "//input[@id='editProfileNameInputId']")
	WebElement editprofilename_textbox;

	@FindBy(xpath = "//span[@class='a-button a-button-primary editProfileContinueButton']")
	WebElement editprofile_button;

	// step2

	public void manageprofile() {

		w1.until(ExpectedConditions.visibilityOf(manageprofile_link));
		manageprofile_link.click();
	}

	public void viewprofile() {
		w1.until(ExpectedConditions.elementToBeClickable(view_link));
		view_link.click();
	}

	public void editprofile() {
		editbutton.click();
	}

	public void editprofilename() throws InterruptedException {
		editprofilename_textbox.clear();
		Thread.sleep(3000);
		editprofilename_textbox.sendKeys("shitalamolbhosaleus");
	}

	public void changename() {
		w1.until(ExpectedConditions.elementToBeClickable(editprofile_button));
		editprofile_button.click();
	}

//stpe 3 
	public EditProfilePage_Project1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
