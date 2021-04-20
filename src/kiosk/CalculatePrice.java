package kiosk;

import java.util.Calendar;

public class CalculatePrice {

	/* 만나이 계산 */
	int calcAge(long idNum) {
		
		// 생년월일 계산
		long calcIDNumber = 0;
		// 구매자 생년월일
		int customerYear, customerMonth, customerDay = 0;
		// 오늘날짜
		int todayYear, todayMonth, todayDay = 0;
		// 구매자 성별 및 2000년생 구분
		int type = 0;
		int koreanAge, age = 0;

		/* 주민등록번호로 생년월일 추출 */
		// 앞자리 보존을 위해 해당 값을 더해줌
		idNum += ConstValue.FULL_DIGIT_14;
		// 총 8자리 (FULL_DIGIT의 1 + 앞자리 6자리 + 뒷자리 첫 번째 수)를 변수에 할당
		calcIDNumber = idNum / ConstValue.SEVEN_DIGIT;
		// 주민번호 뒷 자리의 첫번째 수
		type = (int) (calcIDNumber % 10);

		// FULL_DIGIT의 1 + 주민번호 생년월일 6자리만 변수에 대입
		calcIDNumber /= ConstValue.ONE_DIGIT;
		// 탄생 일을 구해서 변수에 대입
		customerDay = (int) (calcIDNumber % ConstValue.TWO_DIGIT);

		// FULL_DIGIT의 1 + 주민번호 생년월 4자리만 변수에 대입
		calcIDNumber /= ConstValue.TWO_DIGIT;
		// 탄생 월을 구해서 변수에 대입
		customerMonth = (int) (calcIDNumber % ConstValue.TWO_DIGIT);

		// FULL_DIGIT의 1 + 주민번호 생년 2자리만 변수에 대입
		calcIDNumber /= ConstValue.TWO_DIGIT;
		// 탄생 년을 구해서 변수에 대입
		customerYear = (int) (calcIDNumber % ConstValue.TWO_DIGIT);

		if ((type == ConstValue.MALE_NEW) || (type == ConstValue.FEMALE_NEW)) {
			customerYear += ConstValue.NEW_GENERATION;
		} else {
			customerYear += ConstValue.OLD_GENERATION;
		}

		/* 오늘 날짜 구하기 */
		Calendar time = Calendar.getInstance();
		// 현재 년도
		todayYear = time.get(Calendar.YEAR);
		// 현재 월
		todayMonth = time.get(Calendar.MONTH);
		// 현재 일
		todayDay = time.get(Calendar.DATE);

		// 한국식 나이
		koreanAge = todayYear - customerYear + 1;

		/* 만나이 계산 */
		// 올해 생일이 지난 경우
		if ((customerMonth < todayMonth) || ((customerMonth == todayMonth) && (customerDay <= todayDay))) {
			age = koreanAge - ConstValue.AFTER_BIRTH;
		} else { // 아직 생일이 지나지 않은 경우
			age = koreanAge - ConstValue.BEFORE_BIRTH;
		}

		return age;
	}

	/* 연령대별 분류 */
	public int calcAgeGroup(int age) {
		
		int ageGroup = 0;

		if (age < ConstValue.MIN_CHILD) {
			ageGroup = 1;
		} else if (age >= ConstValue.MIN_CHILD && age <= ConstValue.MAX_CHILD) {
			ageGroup = 2;
		} else if (age >= ConstValue.MIN_TEEN && age <= ConstValue.MAX_TEEN) {
			ageGroup = 3;
		} else if (age >= ConstValue.MIN_ADULT && age <= ConstValue.MAX_ADULT) {
			ageGroup = 4;
		} else if (age > ConstValue.ADULT) {
			ageGroup = 5;
		}

		return ageGroup;
	}

	/* 주야권과 나이에 따른 금액 계산 */
	public int calcDayOrNightPrice(int ageGroup, int dayOrNight) {
		int calcPrice = 0;

		if (ageGroup == ConstValue.BABY) {
			calcPrice = ConstValue.BABY_PRICE;
		} else if (ageGroup == ConstValue.CHILD) {
			if (dayOrNight == 1) {
				calcPrice = ConstValue.CHILD_DAY_PRICE;
			} else if (dayOrNight == 2) {
				calcPrice = ConstValue.CHILD_NIGHT_PRICE;
			}
		} else if (ageGroup == ConstValue.TEEN) {
			if (dayOrNight == 1) {
				calcPrice = ConstValue.TEEN_DAY_PRICE;
			} else if (dayOrNight == 2) {
				calcPrice = ConstValue.TEEN_NIGHT_PRICE;
			}
		} else if (ageGroup == ConstValue.ADULT) {
			if (dayOrNight == 1) {
				calcPrice = ConstValue.ADULT_DAY_PRICE;
			} else if (dayOrNight == 2) {
				calcPrice = ConstValue.ADULT_NIGHT_PRICE;
			}
		} else {
			if (dayOrNight == 1) {
				calcPrice = ConstValue.OLD_DAY_PRICE;
			} else if (dayOrNight == 2) {
				calcPrice = ConstValue.OLD_NIGHT_PRICE;
			}
		}

		return calcPrice;
	}

	/* 우대사항에 따른 할인 계산 */
	public int calcDiscount(int regularPrice, int dcSelect) {
		int discountPrice = 0;
		
		switch (dcSelect) {
		case 2: // 장애인
			discountPrice = (int) (regularPrice * ConstValue.DISABLED_DC_RATE);
			break;
		case 3: // 국가유공자
			discountPrice = (int) (regularPrice * ConstValue.MERIT_DC_RATE);
			break;
		case 4: // 다자녀
			discountPrice = (int) (regularPrice * ConstValue.MULTICHILD_DC_RATE);
			break;
		case 5: // 임산부
			discountPrice = (int) (regularPrice * ConstValue.PREGNANT_DC_RATE);
			break;
		default:// 해당사항 없음
			discountPrice = regularPrice;
			break;
		}
		return discountPrice;
	}

	/* 주문 갯수에 따른 금액 계산 */
	public int calcPriceResult(int discountPrice, int ticketCount) {
		int resultPrice = discountPrice * ticketCount;
		return resultPrice;
	}
	
	/* 계산 함수 호출 */
	public int processIntegration(long idNum, int dayOrNight, int dcSelect, int ticketCount) {

		int regularPrice, discountPrice = 0, priceResult;
		int age, ageGroup;
		SetData data = new SetData();
		
		//만 나이 계산
		age = calcAge(idNum);
		data.setAge(age);
		
		//나이에 따른 금액 계산
		ageGroup = calcAgeGroup(age);
		data.setAgeGroup(ageGroup);
		
		//주야권에 따른 금액 계산
		regularPrice = calcDayOrNightPrice(ageGroup, dayOrNight);
		data.setRegularPrice(regularPrice);
		
		//우대사항에 따른 할인 계산
		discountPrice = calcDiscount(regularPrice, dcSelect);
		
		//주문 갯수에 따른 최종 금액 계산
		priceResult = calcPriceResult(discountPrice, ticketCount);
		data.setResultPrice(priceResult);
		
		//최종 요금 확인
		return priceResult;
	}

}