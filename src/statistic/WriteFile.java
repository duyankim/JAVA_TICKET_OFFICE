package statistic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class WriteFile {

	/* 일자별 매출 파일 */
	public void dailySalesFile(List<SalesData> list) throws IOException, FileNotFoundException {
		BufferedWriter bw;
		File file = new File(ConstValue.dailySales);
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ConstValue.dailySales, true), "MS949"));
		
		Calculation calc = new Calculation();
		ArrayList<String[]> sum = calc.dailyCalc(list);
		
		if (file.exists()) {
			for (String[] data : sum) {
				bw.append(String.format("%s-%s-%s,%d\n", 
						data[0], data[1], data[2], data[3]));
			}
			bw.close();
		} else {
			bw.write("일자, 총 매출");
			bw.close();
		}
	}
}
