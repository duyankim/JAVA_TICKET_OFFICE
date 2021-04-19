package ticket;

import java.io.IOException;
import java.util.Scanner;

public class PrintConsole {

	/* 티켓 가격 출력 */
	public void pricePrint(int priceResult) {
		System.out.printf("가격은 %d원 입니다.\n", priceResult);
		System.out.printf("감사합니다.\n\n");
	}

	/* 주문 내역 출력 */
	public void orderPrint(int totalPrice) {
		CalculatePrice price = new CalculatePrice();

		System.out.printf("티켓 발권을 종료합니다. 감사합니다");
		System.out.printf("\n");
		System.out.printf("=============에버랜드=============\n");

		for (int index = 0; index < RunTicketOffice.position; index++) {
			switch (RunTicketOffice.orderList[index][0]) {
			case 1: // 주간권
				System.out.printf("주간권 ");
				break;
			case 2: // 야간권
				System.out.printf("야간권 ");
				break;
			default:
				break;
			}

			if (price.calcAgeGroup(RunTicketOffice.orderList[index][1]) == ConstValue.BABY) {
				System.out.printf("유아 ");
			} else if (price.calcAgeGroup(RunTicketOffice.orderList[index][1]) == ConstValue.CHILD) {
				System.out.printf("어린이 ");
			} else if (price.calcAgeGroup(RunTicketOffice.orderList[index][1]) == ConstValue.TEEN) {
				System.out.printf("청소년 ");
			} else if (price.calcAgeGroup(RunTicketOffice.orderList[index][1]) == ConstValue.ADULT) {
				System.out.printf("어른 ");
			} else {
				System.out.printf("노인 ");
			}

			System.out.printf("X %3d ", RunTicketOffice.orderList[index][2]);
			System.out.printf("%8d원    ", RunTicketOffice.orderList[index][3]);

			switch (RunTicketOffice.orderList[index][4]) {
			case 1: // 해당사항 없음
				System.out.printf("우대적용 없음\n");
				break;
			case 2: // 장애인
				System.out.printf("장애인 우대적용\n");
				break;
			case 3: // 국가유공자
				System.out.printf("국가유공자 우대적용\n");
				break;
			case 4: // 다자녀
				System.out.printf("다자녀 우대적용\n");
				break;
			case 5: // 임산부
				System.out.printf("임산부 우대적용\n");
				break;
			default:
				break;
			}
		}
		System.out.printf("\n");
		System.out.printf("입장료 총액은 %d원 입니다.\n", RunTicketOffice.totalPrice);
		System.out.printf("==================================\n");
		System.out.printf("\n");
	}
	
	/* 이어서 주문 또는 주문내역 출력 후 종료 */
	public int orderContinue() throws IOException {
		PrintConsole print = new PrintConsole();
		Scanner sc = new Scanner(System.in);
		int continueSelect;

		System.out.printf("계속 발권 하시겠습니까?\n");
		System.out.printf("1. 티켓 발권\n");
		System.out.printf("2. 종료\n");
		
		while (true) {
			continueSelect = sc.nextInt();
			if (continueSelect == 1 || continueSelect == 2) {
				break;
			} else {
				print.errorMessagePrint();
			}
		}
		return continueSelect;
	}
	
	/* 에러 메세지 출력 */
	public void errorMessagePrint() {
		System.out.printf("잘못 입력하셨습니다.\n");
	}
}
