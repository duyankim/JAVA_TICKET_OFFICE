package statistic;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		FileRead read = new FileRead();
		List<SalesData> list;
		
		ArrayList<String[]> data = read.readFile();
		list = read.setData(data);
		
		OutputPrint print = new OutputPrint();
		print.allDataPrint(list);
		print.salesTypePrint(list);
		print.dailyIncomePrint(list);
		print.dcIncomePrint(list);
		
		FileWrite write = new FileWrite();
		write.dailySalesFile(list);
	}
}
