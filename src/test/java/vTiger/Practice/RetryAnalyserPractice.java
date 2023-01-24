package vTiger.Practice;

import org.testng.annotations.Test;
import org.testng.Assert;

public class RetryAnalyserPractice {

	@Test(retryAnalyzer = vTiger.GenericUtilities.RetryAnalyserImplementation.class)
	public void retryATest()
	{
		System.out.println("Execute");
		Assert.fail();
	}
	
	@Test
	public void retryATest1()
	{
		System.out.println("Execute 1");
	}
}
