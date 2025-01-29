package amazon_Project1.Project1_Amazon;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTests implements IRetryAnalyzer {
	int retryCount = 0;
	public static final int MAX_RETRY = 1;

	@Override
	public boolean retry(ITestResult result) {
		System.out.println("retrying for retrycount =" + retryCount);
		if (retryCount < MAX_RETRY) {
			retryCount++;
			System.out.println("retrying for retrycount =" + retryCount);
			return true;
		}

		return false;
	}

}
