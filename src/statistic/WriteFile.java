package statistic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class WriteFile {

	/* 일자별 매출 파일 */
	void dailySalesFile(List<SalesData> list) {
		BufferedWriter bw = null;
		File file = new File(ConstValue.dailySales);
		
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ConstValue.dailySales, true), "MS949"));
		} catch (UnsupportedEncodingException | FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		Calculation calc = new Calculation();
		ReadFile read = new ReadFile();
		ArrayList<String[]> sum = calc.dailyCalc(list);
		
		try {
			if (file.exists()) {
				if (read.isEmpty(ConstValue.dailySales) == true) {
					bw.append("일자, 총 매출\n");
				}
				
				for (String[] data : sum) {
					bw.append(String.format("%s-%s-%s,%s\n", data[0], data[1], data[2], data[3]));
				}
				bw.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
