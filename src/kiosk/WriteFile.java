package kiosk;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WriteFile {
	BufferedWriter bw;

	public void writeFile(SetData data) throws IOException, FileNotFoundException {
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ConstValue.fileOutput, true), "utf-8"));
		bw.append(String.format("%s,%s,%s,%d,%d,%s\n", data.getDate(), data.getDayOrNight(), data.getAgeGroup(),
				data.getTicketCount(), data.getDiscount()));
		bw.close();
	}
}