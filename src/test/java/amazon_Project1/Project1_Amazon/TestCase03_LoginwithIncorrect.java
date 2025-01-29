package amazon_Project1.Project1_Amazon;

import org.testng.annotations.Test;

public class TestCase03_LoginwithIncorrect extends LoginandQuit {
	@Test(retryAnalyzer = RetryTests.class)
	public void loginwithincorrectcred() throws InterruptedException {
		Login_Incorrectcredential l2 = new Login_Incorrectcredential(driver);
		HomePage_Project1 h1 = new HomePage_Project1(driver);
		h1.Account_list_homepage(driver);
		h1.signin_homepage();
		l2.un();
		l2.continuebuttn();
		l2.pwd();
		l2.signin();

	}
}
