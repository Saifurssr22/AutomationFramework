package vTiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;
import com.mysql.cj.jdbc.Driver;

public class SampleJDBCUpdateQuery {

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
		String query = "insert into sdet values(1003,'Mahaboob',9989786526,'mahaboob@gmail.com','Kurnool');";
		int result = state.executeUpdate(query);
		if(result==1)
			System.out.println("Data added successfully");
		
		ResultSet r = state.executeQuery("select * from sdet;");

		while (r.next()) {
			System.out.println(r.getString(1) + " " + r.getString(2) + " " + r.getString(3) + " "
					+ r.getString(4) + " " + r.getString(5));
		}

		// Step 5: Close the db
		con.close();
		System.out.println("DB is Closed");
	}
}