package statistic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculation {

	/* 권종별 판매 현황 계산 */
	public int[] typeCalc(List<SalesData> list, int type) {

		int[] sum = { 0, 0, 0, 0, 0, 0, 0 };
		// typeCountSum, typePriceSum, babySum, childSum, teenSum, adultSum, oldSum

		for (SalesData data : list) {
			if (data.getType() == type) {
				// 티켓 타입별 판매수, 판매액수
				sum[0] += data.getCount();
				sum[1] += data.getPrice();

				// 티켓 타입별 연령그룹 판매수
				for (int i = 0; i < ConstValue.AGE_GROUP.length; i++) {
					if (data.getAgeGroup() == ConstValue.AGE_GROUP[i]) {
						sum[i+2] += data.getCount();
					}
				}
			}
		}
		return sum;
	}
	
	/* 일자별 매출 계산 */
	public ArrayList<String[]> dailyCalc(List<SalesData> list) {
		ArrayList<String[]> sum = new ArrayList<String[]>();

		int dateSum = 0;
		String date;
	
		for (int i=0; i<list.size()-1; i++) {
			String[] dateData = new String[4]; //year, month, day, outcomeSum
			date = list.get(i).getDate();
			
			if (date.equals(list.get(i+1).getDate())) {
				dateSum += list.get(i).getPrice();
			} else {
				dateSum += list.get(i).getPrice();
				dateData[0] = date.substring(0,4);
				dateData[1] = date.substring(4,6);
				dateData[2] = date.substring(6);
				dateData[3] = Integer.toString(dateSum);
				sum.add(dateData);
				dateSum = 0;
			}
		}
		return sum;
	}
}
