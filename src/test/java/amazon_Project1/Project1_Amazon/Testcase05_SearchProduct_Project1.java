package amazon_Project1.Project1_Amazon;

import org.testng.annotations.Test;

public class Testcase05_SearchProduct_Project1 extends LoginandQuit {
	@Test(retryAnalyzer = RetryTests.class)
	public void searchproduct1() throws InterruptedException {
		HomePage_Project1 h1 = new HomePage_Project1(driver);
		h1.Account_list_homepage(driver);
		h1.signin_homepage();
		LoginPage_Project1 L1 = new LoginPage_Project1(driver);
		L1.un();
		L1.continuebuttn();
		L1.pwd();
		L1.signin();
		h1.searchproduct();
	}
}
