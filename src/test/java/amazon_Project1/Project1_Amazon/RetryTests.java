package amazon_Project1.Project1_Amazon;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTests implements IRetryAnalyzer {
	int retryCount = 0;
	public static final int MAX_RETRY = 2;

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < MAX_RETRY) {
			retryCount++;
			System.out.println("retrying <" + result.getName() + "> for retrycount =" + retryCount);
			return true;
		}

		return false;
	}

}
