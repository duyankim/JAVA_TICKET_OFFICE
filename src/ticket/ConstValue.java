package ticket;

public class ConstValue {
	
	// 나이에 따른 그룹
	public static final int BABY = 1;
	public static final int CHILD = 2;
	public static final int TEEN = 3;
	public static final int ADULT = 4;
	public static final int OLD = 5;
		
	// 그룹별 티켓 가격
	public static final int BABY_PRICE = 0;
	public static final int ADULT_DAY_PRICE = 56000;
	public static final int ADULT_NIGHT_PRICE = 46000;
	public static final int TEEN_DAY_PRICE = 47000;
	public static final int TEEN_NIGHT_PRICE = 40000;
	public static final int CHILD_DAY_PRICE = 44000;
	public static final int CHILD_NIGHT_PRICE = 37000;
	public static final int OLD_DAY_PRICE = 44000;
	public static final int OLD_NIGHT_PRICE = 37000;
	
	// 그룹별 나이 범위
	public static final int MIN_BABY = 1;
	public static final int MAX_BABY = 2;
	public static final int MIN_CHILD = 3;
	public static final int MAX_CHILD = 12;
	public static final int MIN_TEEN = 13;
	public static final int MAX_TEEN = 18;
	public static final int MIN_ADULT = 19;
	public static final int MAX_ADULT = 64;
	public static final int MIN_OLD = 65;
	
	// 우대 할인율
	public static final double DISABLED_DC_RATE = 0.6;
	public static final double MERIT_DC_RATE = 0.5;
	public static final double MULTICHILD_DC_RATE = 0.8;
	public static final double PREGNANT_DC_RATE = 0.85;
	
	// 최대 주문량
	public static final int MAX_COUNT = 10;
	public static final int MIN_COUNT = 1;
	
	// 주민등록번호 분석
	public static final long FULL_DIGIT = 10000000000000L;
	public static final long FULL_DIGIT_MIN = 10000000000L;
	public static final long SEVEN_DIGIT = 1000000;
	
	public static final int TWO_DIGIT = 100;
	public static final int ONE_DIGIT = 10;
	public static final int OLD_GENERATION = 1900;
	public static final int NEW_GENERATION = 2000;
	public static final int MALE_OLD = 1;
	public static final int FEMALE_OLD = 2;
	public static final int MALE_NEW = 3;
	public static final int FEMALE_NEW = 4;
	public static final int BEFORE_BIRTH = 2;
	public static final int AFTER_BIRTH = 1;
	
	// 파일 위치
	public static final String fileOutput = "report.csv";
}
