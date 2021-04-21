package statistic;

import java.util.ArrayList;
import java.util.List;

public class RunMain {

	public static void main(String[] args) {
		ReadFile read = new ReadFile();
		List<SalesData> list;
		
		ArrayList<String[]> data = read.readFile();
		list = read.setData(data);
		
		PrintOutput print = new PrintOutput();
		print.salesTypePrint(list);
		print.dailyOutcomePrint(list);
	}
}
