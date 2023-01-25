package vTiger.Practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLineTest {

	@Test
	public void readData() {
		String BROWSER = System.getProperty("browser");
		System.out.println(BROWSER);

		String URL = System.getenv("url");
		System.out.println(URL);

		String USERNAME = System.getenv("username");
		System.out.println(USERNAME);

		String PASSWORD = System.getProperty("password");
		System.out.println(PASSWORD);
	}
}
