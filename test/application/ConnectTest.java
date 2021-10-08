package application;

import java.sql.*;

import sait.mms.contracts.DatabaseDriver;
import sait.mms.drivers.MariaDBDriver;

/**
 * Class description: Simply connects and disconnects from the database.
 *
 * @author Joe Blow (123456)
 *
 */
public class ConnectTest {
	/**
	 * Tests connecting to the database.
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args)  throws ClassNotFoundException {
		DatabaseDriver driver = new MariaDBDriver();
		
		try {
			driver.connect();
			
			System.out.println("Connected!");
			
			ResultSet rs = driver.get("SELECT 'Hello from the other side!'");
			
			boolean hasRow = rs.next();
			
			if (hasRow) {
				String column1 = rs.getString(1);
				System.out.println(column1);
			} else {
				System.out.println("Ooops! No rows were found.");
			}
			
			driver.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
