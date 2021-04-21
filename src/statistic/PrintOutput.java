package statistic;

import java.util.ArrayList;
import java.util.List;

public class PrintOutput {

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
	
	/* 권종별 판매 현황 출력 */
	public void salesTypePrint(List<SalesData> list) {
		String dayOrNight=" ";
		
		System.out.println("-------------------- 권종별 판매현황 --------------------");

		for(int type : ConstValue.TYPE_INT){
			int[] sumType = typeCalc(list, type);
			
			if (type == 1) dayOrNight = ConstValue.TYPE[0];
			else if (type == 2) dayOrNight = ConstValue.TYPE[1];

			System.out.printf("%s 총 %d매\n", dayOrNight, sumType[0]);
			
			for (int i=0; i < ConstValue.AGE.length; i++) {
				System.out.printf("%s %d매", ConstValue.AGE[i], sumType[i+2]);
				if (i < ConstValue.AGE.length-1) {
					System.out.printf(", ");
				} else {
					System.out.printf("\n");
				}
			}
			System.out.printf("%s 매출 : %d원\n\n", dayOrNight, sumType[1]);
		}
		System.out.println("---------------------------------------------------------\n");
	}
	
	/* 일자별 매출 계산 */
	public ArrayList<String[]> dailyCalc(List<SalesData> list) {
		ArrayList<String[]> sum = new ArrayList<String[]>();

		int temp=0;
		String date;
		String[] dateData = new String[4];
		//year, month, day, outcomeSum
		
		for (int i=0; i<list.size()-1; i++) {
			date = list.get(i).getDate();
	
			if (date.equals(list.get(i+1).getDate())) {
				temp += list.get(i).getPrice();
			} else {
				
			}
			dateData[3] = Integer.toString(temp);
			
			dateData[0] = date.substring(0,4);
			dateData[1] = date.substring(4,6);
			dateData[2] = date.substring(6);
			
			sum.add(dateData);
			temp = 0;
		}

		return sum;
	}
	
	/* 일자별 매출 현황 출력 */
	public void dailyOutcomePrint(List<SalesData> list) {
		System.out.println("-------------------- 일자별 매출현황 --------------------");
		
		ArrayList<String[]> sum = dailyCalc(list);
		
		for(String[] daily : sum){
			System.out.printf("%s년 %s월 %s일 : 총 매출%10s원\n", daily[0], daily[1], daily[2], daily[3]);
		}
		System.out.println("----------------------------------------------------------");
	}
}
