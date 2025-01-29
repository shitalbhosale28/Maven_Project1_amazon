package amazon_Project1.Project1_Amazon;

import org.testng.annotations.Test;

public class Testcase01_Registration extends LoginandQuit {
	@Test(retryAnalyzer = RetryTests.class)
	public void registration() throws InterruptedException {
		RegistrationPage_Project1 r1 = new RegistrationPage_Project1(driver);
		r1.starthere_Register();
		r1.nameRegister();
		r1.mobileRegister();
		r1.passRegister();
		r1.verifymobile_Register();
	}
}
