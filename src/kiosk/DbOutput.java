package kiosk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbOutput {

	private Connection conn;
	private Statement stmt;
	
	public void connectDB(Data data) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "000000");
			stmt = conn.createStatement();
	
			addToDB(data);
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addToDB(Data data) {
		try {
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			
			stmt.execute("INSERT INTO `report2` (`date`, `type`, `age`, `count`, `price`, `advantage`)" 
					+ "VALUES (" 
							+ "now(), '"
							+ data.getDayOrNight() + "', '" 
							+ data.getAgeGroup() + "', '" 
							+ data.getTicketCount() + "', '" 
							+ data.getResultPrice() +"', '" 
							+ data.getDcGroup() + "');");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
