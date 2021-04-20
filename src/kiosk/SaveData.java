package kiosk;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SaveData {

	void saveOrder(SetData data, ArrayList<SetData> orderData) {
		Date today = new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date = sdf.format(today);
		orderData.add(data);
	}
}