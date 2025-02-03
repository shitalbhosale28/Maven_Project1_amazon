package amazon_Project1.Project1_Amazon;

import org.testng.annotations.Test;

public class Testcase11_Checkoutprocess_project1 extends LoginandQuit {
	@Test(retryAnalyzer = RetryTests.class)
	public void checkout() throws InterruptedException {
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
		p1.addtocart();
		PaymentPage_project1 pp = new PaymentPage_project1(driver);
		pp.proceedbuy();
		// pp.Cashondeliveryoption(); sometime cod gets disable and our srcipts gets failed
		// pp.allapyment_selection();
		// pp.usethispayment();
	}
}
