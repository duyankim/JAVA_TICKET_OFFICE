package statistic;

public class ConstValue {

	// 파일 경로 입력
	public static final String report = "report.csv";
	public static final String dailySales = "dailySales.csv";
	public static final String typeSales = "typeSales.csv";
	public static final String discountSales = "discountSales.csv";

	// 주간 야간 구분
	public static final int[] TYPE_INT = {1, 2};
	public static final String[] TYPE = {"주간권", "야간권"};

	// 나이에 따른 그룹
	public static final int[] AGE_GROUP= {1, 2, 3, 4, 5}; //BABY, CHILD, TEEN, ADULT, OLD
	public static final String[] AGE = {"유아", "어린이", "청소년", "어른", "경로"};

	// 우대 할인 그룹
	public static final int[] DC_GROUP = {1, 2, 3, 4, 5}; 
	//NOTHING, DISABLED, MERIT, MULTICHILD, PREGNANT;
}
