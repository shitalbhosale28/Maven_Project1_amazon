package amazon_Project1.Project1_Amazon;

import org.testng.annotations.Test;

public class Testcase15_Cartpage_Withoutlogin extends LoginandQuit {

	@Test(retryAnalyzer = RetryTests.class)
	public void cartpage_withoutlogin() throws InterruptedException {
		HomePage_Project1 h1 = new HomePage_Project1(driver);
		Product1page_Project1 p1 = new Product1page_Project1(driver);
		h1.searchproduct();
		p1.product(driver);
		p1.addtocart();
		PaymentPage_project1 pp = new PaymentPage_project1(driver);
		pp.proceedbuy();

	}

}
