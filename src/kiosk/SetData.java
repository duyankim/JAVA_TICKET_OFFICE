package kiosk;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SetData {
	private int dayOrNight;
	private int ticketCount;
	private int dcGroup;
	private int resultPrice;
	private int age;
	
	private int ageGroup;
	private String date;

	public SetData () {
		
	}

	public SetData (int dayOrNight, int age, int ticketCount, int dcGroup, int resultPrice) {
		this.dayOrNight = dayOrNight;
		this.age = age;
		this.ticketCount = ticketCount;
		this.dcGroup = dcGroup;
		this.resultPrice = resultPrice;
	}

	public String getDayOrNight() {
		String dayOrNight_str = "";
		if (dayOrNight == 1) {
			dayOrNight_str = "주간권";
		} else if (dayOrNight == 2) {
			dayOrNight_str = "야간권";
		} 
		return dayOrNight_str;
	}

	public void setDayOrNight(int dayOrNight) {
		this.dayOrNight = dayOrNight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAgeGroup() {
		String ageGroup_str = "";
		if (age < ConstValue.MIN_CHILD) {
			ageGroup_str = "유아";
		} else if (age >= ConstValue.MIN_CHILD && age <= ConstValue.MAX_CHILD) {
			ageGroup_str = "어린이";
		} else if (age >= ConstValue.MIN_TEEN && age <= ConstValue.MAX_TEEN) {
			ageGroup_str = "청소년";
		} else if (age >= ConstValue.MIN_ADULT && age <= ConstValue.MAX_ADULT) {
			ageGroup_str = "어른";
		} else if (age > ConstValue.ADULT) {
			ageGroup_str = "경로";
		}
		return ageGroup_str;
	}

	public void setAgeGroup(int ageGroup) {
		this.ageGroup = ageGroup;
	}

	public int getTicketCount() {
		return ticketCount;
	}

	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}

	public String getDcGroup() {
		String dcGroup_str = "";
		switch (dcGroup) {
		case 2: 
			dcGroup_str = "장애인";
			break;
		case 3: 
			dcGroup_str = "국가유공자";
			break;
		case 4: 
			dcGroup_str = "다자녀";
			break;
		case 5: 
			dcGroup_str = "임산부";
			break;
		default:
			dcGroup_str = "없음";
			break;
		}
		return dcGroup_str;
	}

	public void setDcGroup(int dcGroup) {
		this.dcGroup = dcGroup;
	}

	public int getResultPrice() {
		return resultPrice;
	}

	public void setResultPrice(int resultPrice) {
		this.resultPrice = resultPrice;
	}

	public String getDate() {
		Date today = new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date = sdf.format(today);
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}