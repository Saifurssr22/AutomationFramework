package vTiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;
import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	@Test
	public void sampleJDBC() throws SQLException {
		Driver driverRef = new Driver();

		// Step 1: Register the Driver
		DriverManager.registerDriver(driverRef);

		// Step 2: Get the connection with driver-database name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/candidateinfo", "root", "root");

		// Step 3: Issue Create Statement
		Statement state = con.createStatement();

		// Step 4: Execute the Query
		ResultSet result = state.executeQuery("select * from sdet;");

		while (result.next()) {
			System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(3) + " "
					+ result.getString(4) + " " + result.getString(5));
		}

		// Step 5: Close the db
		con.close();
		System.out.println("DB is Closed");
	}
}