package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLHelper {

	private final String host = "127.0.0.1";
	private final String port = "3306";
	private final String database = "wot";
	
	private Connection connection;
		
	public MySQLHelper() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, "root", "");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getFourRandomLocations() {
		
		ArrayList<String> locations = new ArrayList<String>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM `locations` ORDER BY RAND() LIMIT 4");
		
			while(resultSet.next())
			{
				locations.add(resultSet.getString("location"));
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return locations;
	}
}
