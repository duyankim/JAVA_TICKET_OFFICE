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

public class FileWrite {

	public void writeFile(Data data) throws IOException, FileNotFoundException {
		BufferedWriter bw;
		
		File file = new File(ConstValue.fileOutput);
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "MS949"));
		
		if (file.exists()) {
			bw.append(String.format("%s,%s,%s,%d,%d,%s\n", 
					data.getDate(), data.getDayOrNight(), data.getAgeGroup(),
					data.getTicketCount(), data.getResultPrice(), data.getDcGroup()));
			bw.close();
		} else {
			bw.write("날짜, 권종, 연령구분, 수량, 가격, 우대사항");
			bw.close();
		}
	}
}