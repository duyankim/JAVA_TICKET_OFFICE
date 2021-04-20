package kiosk;

import java.util.Calendar;

public class SetData {
	private String date;
	private int dayOrNight;
	private String dayOrNight_str;
	private int ageGroup;
	private String ageGroup_str;
	private long idNum;
	private int age;
	private int ticketCount;
	private int regularPrice;
	private int discount;
	private String discount_str;
	private int resultPrice;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDayOrNight() {
		return dayOrNight_str;
	}

	public void setDayOrNight(int dayOrNight) {
		if (dayOrNight == 1) {
			this.dayOrNight_str = ConstValue.DAY_STR;
		} else if (dayOrNight == 2) {
			this.dayOrNight_str = ConstValue.NIGHT_STR;
		} 
	}

	public long getIdNum() {
		return idNum;
	}

	public void setIdNum(long idNum) {
		Calendar cal = Calendar.getInstance();
		int currentYear = cal.get(Calendar.YEAR) - 2000; 
		int frontTwoDigit = (int) (idNum / ConstValue.FULL_DIGIT_12);
		int backFirstDigit = (int) (idNum / ConstValue.SEVEN_DIGIT % 10);
		
		if (frontTwoDigit == 0 || frontTwoDigit > 0 && frontTwoDigit <= currentYear) {
			//앞 자리수가 2000년대 ~ 2020년대면 주민등록번호 뒷자리의 첫째 자리가 3, 4일 경우만 입력 받음

			if (backFirstDigit == 3 || backFirstDigit == 4) {
				this.idNum = idNum;
			} 
			
		} else if (frontTwoDigit <= 99 && frontTwoDigit > currentYear) {
			//앞 자리수가 1922년 ~ 1999년이면 주민등록번호 뒷자리의 첫째 자리가 1, 2일 경우만 입력 받음

			if (backFirstDigit == 1 || backFirstDigit == 2) {
				this.idNum = idNum;
			} 
		} 
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAgeGroup() {
		return ageGroup_str;
	}

	public void setAgeGroup(int ageGroup) {
		switch (ageGroup) {
		case ConstValue.BABY: 
			this.ageGroup_str = "유아";
			break;
		case ConstValue.CHILD:
			this.ageGroup_str = "어린이";
			break;
		case ConstValue.TEEN:
			this.ageGroup_str = "청소년";
			break;
		case ConstValue.ADULT:
			this.ageGroup_str = "어른";
			break;
		case ConstValue.OLD:
			this.ageGroup_str = "경로";
			break;
		default:
			break;
		}
	}

	public int getTicketCount() {
		return ticketCount;
	}

	public void setTicketCount(int ticketCount) {
		if (ticketCount >= 1 && ticketCount <= 10) {
			this.ticketCount = ticketCount;
		} 
	}

	public int getRegularPrice() {
		return regularPrice;
	}

	public void setRegularPrice(int regularPrice) {
		this.regularPrice = regularPrice;
	}

	public String getDiscount() {
		return discount_str;
	}

	public void setDiscount(int discount) {
		if (discount >= 1 && discount <= 5) {
			switch (discount) {
			case ConstValue.NOTHING : 
				this.discount_str = "우대적용 없음\n";
				break;
			case ConstValue.DISABLED :
				this.ageGroup_str = "장애인 우대적용\n";
				break;
			case ConstValue.MERIT :
				this.ageGroup_str = "국가유공자 우대적용\n";
				break;
			case ConstValue.MULTICHILD :
				this.ageGroup_str = "다자녀 우대적용\n";
				break;
			case ConstValue.PREGNANT :
				this.ageGroup_str = "임산부 우대적용\n";
				break;
			default:
				break;
			}
		} 
	}

	public int getResultPrice() {
		return resultPrice;
	}

	public void setResultPrice(int reseultPrice) {
		this.resultPrice = reseultPrice;
	}
}