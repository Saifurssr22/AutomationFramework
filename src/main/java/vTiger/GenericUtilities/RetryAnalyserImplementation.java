package vTiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class will provide implementation to the IRetyrAnalyser Interface of TestNG
 * 
 * @author LENOVO
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {

	int count = 0;
	int retryCount = 3;

	/**
	 * Retry untill retry count is met
	 */
	public boolean retry(ITestResult result) {

		while (count < retryCount) {

			count++;
			return true;
		}

		return false;
	}

} 