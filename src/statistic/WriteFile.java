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
	
	/* 권종별 판매 현황 파일 */
	void salesTypeFile(List<SalesData> list) {
		File file = new File(ConstValue.typeSales);
		BufferedWriter bw = newBufferedWriter(file);

		try {
			if (file.exists() == true) {
				
				ReadFile read = new ReadFile();
				if (read.isEmpty(file) != false) {
					bw.append("구분, 주간권, 야간권\n");
				}
				
				Calculation calc = new Calculation();
				int[] daySum = calc.typeCalc(list, 0);
				int[] nightSum = calc.typeCalc(list, 1);
				
				for (int i = 0; i < ConstValue.AGE.length; i++) {
					bw.append(String.format("%s, %d, %d", ConstValue.AGE[i], daySum[i+2], nightSum[i+2]));
				}
				bw.append(String.format("%s, %d, %d", "합계", daySum[0], nightSum[0]));
				bw.append(String.format("%s, %d, %d", "매출", daySum[1], nightSum[1]));
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
	
	/* 버퍼 라이터 불러오기 */
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
