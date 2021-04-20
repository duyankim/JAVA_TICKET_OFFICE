package kiosk;

import java.util.Calendar;
import java.util.Scanner;

public class GetInput {

	// 티켓 종류 입력
	int inputTicketSelect() {
		PrintOutput print = new PrintOutput();
		Scanner sc = new Scanner(System.in);
		int ticketSelect;

		System.out.printf("권종을 선택하세요.\n");
		System.out.printf("1. 주간권\n");
		System.out.printf("2. 야간권\n");
		System.out.printf("-> ");

		while (true) {
			ticketSelect = sc.nextInt();

			if (ticketSelect == 1 || ticketSelect == 2) {
				break;
			} else {
				print.printErrorMsg();
			}
		}
		return ticketSelect;
	}

	// 주민등록번호 입력
	long inputIDNumber() {
		PrintOutput print = new PrintOutput();
		Scanner sc = new Scanner(System.in);
		long idNum;

		System.out.printf("주민등록번호를 입력해주세요.\n");
		System.out.printf("->");

		while (true) {
			idNum = sc.nextLong();
			
			Calendar cal = Calendar.getInstance();
			int currentYear = cal.get(Calendar.YEAR) - 2000; 
			int frontTwoDigit = (int) (idNum / ConstValue.FULL_DIGIT_12);
			int backFirstDigit = (int) (idNum / ConstValue.SEVEN_DIGIT % 10);
			System.out.println(frontTwoDigit);
			System.out.println(backFirstDigit);
			if ((idNum >= ConstValue.FULL_DIGIT_11) && (idNum < ConstValue.FULL_DIGIT_14)) {
				if (frontTwoDigit == 0 || frontTwoDigit > 0 && frontTwoDigit <= currentYear) {
					//앞 자리수가 2000년대 ~ 2020년대면 주민등록번호 뒷자리의 첫째 자리가 3, 4일 경우만 입력 받음

					
					if (backFirstDigit == 3 || backFirstDigit == 4) {
						break;
					} 
					
				} else if (frontTwoDigit <= 99 && frontTwoDigit > currentYear) {
					//앞 자리수가 1922년 ~ 1999년이면 주민등록번호 뒷자리의 첫째 자리가 1, 2일 경우만 입력 받음

					if (backFirstDigit == 1 || backFirstDigit == 2) {
						break;
					} 
				} 
			} else {
				print.printErrorMsgWrongID();
			}
		}
		return idNum;
	}

	// 주문 갯수 입력
	int inputOrderCount() {
		PrintOutput print = new PrintOutput();
		Scanner sc = new Scanner(System.in);
		int order;

		System.out.printf("몇 개를 주문하시겠습니까?(최대 10개)\n");
		System.out.printf("->");

		while (true) {
			order = sc.nextInt();

			if (order >= ConstValue.ORDER_MIN && order <= ConstValue.ORDER_MAX) {
				break;
			} else {
				print.printErrorMsg();
			}
		}
		return order;
	}

	// 우대사항 입력
	int inputDiscountSelect() {
		PrintOutput print = new PrintOutput();
		Scanner sc = new Scanner(System.in);
		int dcSelect;

		System.out.printf("우대사항을 선택하세요.\n");
		System.out.printf("1. 없음(나이 우대는 자동처리)\n");
		System.out.printf("2. 장애인\n");
		System.out.printf("3. 국가유공자\n");
		System.out.printf("4. 다자녀\n");
		System.out.printf("5. 임산부\n");

		while (true) {
			dcSelect = sc.nextInt();

			if (dcSelect >= 1 && dcSelect <= 5) {
				break;
			} else {
				print.printErrorMsg();
			}
		}
		return dcSelect;
	}
}