package kiosk;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

public class WriteFile {

	public void writeFile(SetData data) throws IOException, FileNotFoundException {
		BufferedWriter bw;
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ConstValue.fileOutput, true), "MS949"));
		
		File file = new File(ConstValue.fileOutput);
		
		if (file.exists()) {
			bw.append(String.format("%s,%s,%s,%d,%d,%s\n", data.getDate(), data.getDayOrNight(), data.getAgeGroup(),
					data.getTicketCount(), data.getResultPrice(), data.getDcGroup()));
			bw.close();
		} else {
			bw.write("날짜, 권종, 연령구분, 수량, 가격, 우대사항");
			bw.close();
		}
	}
	
	public void writeDB(Timestamp date, String dayOrNight, String ageGroup, int ticketCount, int resultPrice, String dcGroup) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "000000");
			
			Statement stmt = conn.createStatement();
			
			stmt.execute("INSERT INTO `report2` (`date`, `type`, `age`, `count`, `price`, `advantage`)" 
			+ "VALUES ('" 
					+ date + "', '"
					+ dayOrNight + "', '" 
					+ ageGroup + "', '" 
					+ ticketCount + "', '" 
					+ resultPrice +"', '" 
					+ dcGroup + "');");
			
			ResultSet rset = stmt.executeQuery("select * from `report2`");
	
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}