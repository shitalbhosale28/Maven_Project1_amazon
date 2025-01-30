package amazon_Project1.Project1_Amazon;

import org.testng.annotations.Test;

public class TestCase02_Loginwithdataprovider extends LoginandQuit {
	@Test(retryAnalyzer = RetryTests.class, dataProvider = "usernamepass")
	public void loginwithcorrectcred(String Usernmae, String password) throws InterruptedException {
		NewUser_Project1 n1 = new NewUser_Project1(driver);
		HomePage_Project1 h1 = new HomePage_Project1(driver);
		h1.Account_list_homepage(driver);
		h1.signin_homepage();

		n1.un(Usernmae);
		n1.continuebuttn();
		n1.pwd(password);
		n1.signin();

	}

}
