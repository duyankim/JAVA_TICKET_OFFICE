package statistic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class ReadFile {

	/* 파일 읽기 */
	ArrayList<String[]> readFile() {
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
	
	/* 자료구조에 사용될 데이터 읽기 */
	List<SalesData> setData(ArrayList<String[]> reportData) {
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

	/* 파일에 첫 번째 줄이 있는지 확인하기 */
	boolean isEmpty(File file) {
		BufferedReader br;
		boolean isEmpty = false;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "MS949"));
			if ((br.readLine()) == null) {
				isEmpty = true;
			} else if ((br.readLine()) != null) {
				isEmpty = false;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isEmpty;
	}
}
