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
		if (type.equals(ConstValue.TYPE[0])) {
			type_int = ConstValue.TYPE_INT[0];
		} else if (type.equals(ConstValue.TYPE[1])) {
			type_int = ConstValue.TYPE_INT[1];
		}
		return type_int;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAgeGroup() {
		int ageGroup_int=0;
		if (ageGroup.equals(ConstValue.AGE[0])) {
			ageGroup_int = ConstValue.AGE_GROUP[0];
		} else if (ageGroup.equals(ConstValue.AGE[1])) {
			ageGroup_int = ConstValue.AGE_GROUP[1];
		} else if (ageGroup.equals(ConstValue.AGE[2])) {
			ageGroup_int = ConstValue.AGE_GROUP[2];
		} else if (ageGroup.equals(ConstValue.AGE[3])) {
			ageGroup_int = ConstValue.AGE_GROUP[3];
		} else if (ageGroup.equals(ConstValue.AGE[4])) {
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
		int dcGroup_int = 0;
		if (dcGroup.equals(ConstValue.DC[0])) {
			dcGroup_int = ConstValue.DC_GROUP[0];
		} else if (dcGroup.equals(ConstValue.DC[1])) {
			dcGroup_int = ConstValue.DC_GROUP[1];
		} else if (dcGroup.equals(ConstValue.DC[2])) {
			dcGroup_int = ConstValue.DC_GROUP[2];
		} else if (dcGroup.equals(ConstValue.DC[3])) {
			dcGroup_int = ConstValue.DC_GROUP[3];
		} else if (dcGroup.equals(ConstValue.DC[4])) {
			dcGroup_int = ConstValue.DC_GROUP[4];
		}
		return dcGroup_int;
	}

	public void setDcGroup(String dcGroup) {
		this.dcGroup = dcGroup;
	}

}
