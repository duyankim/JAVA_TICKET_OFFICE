package statistic;

public class SalesData {
	private String date;
	private String type;
	private String ageGroup;
	private int count;
	private int price;
	private String dcGroup;

	public SalesData(String date, String type, String ageGroup, int count, int price, String dcGroup) {
		this.date = date;
		this.type = type;
		this.ageGroup = ageGroup;
		this.count = count;
		this.price = price;
		this.dcGroup = dcGroup;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getType() {
		int type_int = 0;
		if (type.equals("주간권")) {
			type_int = ConstValue.TYPE_INT[0];
		} else if (type.equals("야간권")) {
			type_int = ConstValue.TYPE_INT[1];
		}
		return type_int;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAgeGroup() {
		int ageGroup_int=0;
		if (ageGroup.equals("유아")) {
			ageGroup_int = ConstValue.AGE_GROUP[0];
		} else if (ageGroup.equals("어린이")) {
			ageGroup_int = ConstValue.AGE_GROUP[1];
		} else if (ageGroup.equals("청소년")) {
			ageGroup_int = ConstValue.AGE_GROUP[2];
		} else if (ageGroup.equals("어른")) {
			ageGroup_int = ConstValue.AGE_GROUP[3];
		} else if (ageGroup.equals("노인")) {
			ageGroup_int = ConstValue.AGE_GROUP[4];
		}
		return ageGroup_int;
	}

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDcGroup() {
		int dcGroup_str = 0;
		if (dcGroup == "없음") {
			dcGroup_str = ConstValue.NOTHING;
		} else if (dcGroup == "장애인") {
			dcGroup_str = ConstValue.DISABLED;
		} else if (dcGroup == "국가유공자") {
			dcGroup_str = ConstValue.MERIT;
		} else if (dcGroup == "다자녀") {
			dcGroup_str = ConstValue.MULTICHILD;
		} else if (dcGroup == "임산부") {
			dcGroup_str = ConstValue.PREGNANT;
		}
		return dcGroup_str;
	}

	public void setDcGroup(String dcGroup) {
		this.dcGroup = dcGroup;
	}

}
