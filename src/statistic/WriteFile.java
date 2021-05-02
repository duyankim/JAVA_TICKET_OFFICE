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
		File file = new File(ConstValue.dailySales);
		BufferedWriter bw = newBufferedWriter(file);

		try {
			if (file.exists() == true) {
				
				ReadFile read = new ReadFile();
				if (read.isEmpty(file) != false) {
					bw.append("일자, 총 매출\n");
				}
				
				Calculation calc = new Calculation();
				ArrayList<String[]> sum = calc.dailyCalc(list);
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
	
	BufferedWriter newBufferedWriter (File file) {
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "MS949"));
		} catch (UnsupportedEncodingException | FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return bw;
	}
}
