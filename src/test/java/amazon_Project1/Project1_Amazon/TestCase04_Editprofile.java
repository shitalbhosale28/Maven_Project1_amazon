package amazon_Project1.Project1_Amazon;

import org.testng.annotations.Test;

public class TestCase04_Editprofile extends LoginandQuit {
	@Test(retryAnalyzer = RetryTests.class)
	public void editprofile() throws InterruptedException {
		LoginPage_Project1 L1 = new LoginPage_Project1(driver);
		HomePage_Project1 h1 = new HomePage_Project1(driver);
		EditProfilePage_Project1 ep = new EditProfilePage_Project1(driver);
		h1.Account_list_homepage(driver);
		h1.signin_homepage();
		L1.un();
		L1.continuebuttn();
		L1.pwd();
		L1.signin();
		h1.Account_list_homepage(driver);
		ep.manageprofile();
		ep.viewprofile();
		ep.editprofile();
		ep.editprofilename();
		ep.changename();

	}
}