package amazon_Project1.Project1_Amazon;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(value = TestListener.class)
public class Testcase07_ProductDetailsPage_project1 extends LoginandQuit {

	@Test(testName = "productdetails", retryAnalyzer = RetryTests.class)
	public void verifyProductDetails() throws InterruptedException {
		HomePage_Project1 h1 = new HomePage_Project1(driver);
		SearchResultPage_Project1 s1 = new SearchResultPage_Project1(driver);
		Product1page_Project1 p1 = new Product1page_Project1(driver);
		h1.Account_list_homepage(driver);
		h1.signin_homepage();
		LoginPage_Project1 L1 = new LoginPage_Project1(driver);
		L1.un();
		L1.continuebuttn();
		L1.pwd();
		L1.signin();
		h1.searchproduct();
		p1.product(driver);
		p1.verifyitem();
		// Assert.assertEquals(false, true);
	}
}