package statistic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class ReadFile {

	/* 파일 읽기 */
	public ArrayList<String[]> readFile() {
		BufferedReader br;
		String line = null;
		String[] arr;
		ArrayList<String[]> reportData = new ArrayList<String[]>();
		
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(ConstValue.report), "MS949"));
			while ((line = br.readLine()) != null) {
				arr = line.split(",");
				reportData.add(arr);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reportData;
	}
	
	/* 자료구조에 사용 데이터 읽기 */
	public List<SalesData> setData(ArrayList<String[]> reportData) {
		 List<SalesData> list = new ArrayList<SalesData>();
		 String[] eachLine = null;
		 SalesData data = null;
		 
		 String date;
		 String type;
		 String ageGroup;
		 int count;
		 int price;
		 String dcGroup;

		 for (int i=1; i < reportData.size(); i++) {
			 eachLine = reportData.get(i);
			 date = eachLine[0];
			 type = eachLine[1];
			 ageGroup = eachLine[2];
			 count = Integer.parseInt(eachLine[3]);
			 price = Integer.parseInt(eachLine[4]);
			 dcGroup = eachLine[5];
			 data = new SalesData(date, type, ageGroup, count, price, dcGroup);
			 list.add(data);
		 }
		 return list;
	}
}