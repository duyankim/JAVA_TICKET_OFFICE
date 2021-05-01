package statistic;

import java.util.ArrayList;
import java.util.List;

public class PrintOutput {
	
	/* 파일 모든 결과 출력 */
	void allDataPrint(List<SalesData> list) {
		System.out.println("====================== report.csv ======================");
		System.out.printf("%-6s%4s%6s%4s%8s%6s\n", 
				"날짜", "권종", "연령구분", "수량", "가격", "우대사항");
		for (SalesData data : list) {
			System.out.printf("%-6s  %4d    %6d%6d  %8d    %6d\n", 
					data.getDate(), data.getType(), data.getAgeGroup(), 
					data.getCount(), data.getPrice(), data.getDcGroup());
		}
		System.out.println("---------------------------------------------------------\n");
	}

	/* 권종별 판매 현황 출력 */
	void salesTypePrint(List<SalesData> list) {
		Calculation calc = new Calculation();
		String dayOrNight=" ";

		System.out.println("==================== 권종별 판매현황 ====================");

		for(int type : ConstValue.TYPE_INT){
			int[] sumType = calc.typeCalc(list, type);
			
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
	
	/* 일자별 매출 현황 출력 */
	void dailyIncomePrint(List<SalesData> list) {
		Calculation calc = new Calculation();
		System.out.println("==================== 일자별 매출현황 ====================");
		
		ArrayList<String[]> sum = calc.dailyCalc(list);
		
		for(String[] daily : sum){
			System.out.printf("%s년 %s월 %s일 : 총 매출%10s원\n", daily[0], daily[1], daily[2], daily[3]);
		}
		System.out.println("---------------------------------------------------------");
	}
}
