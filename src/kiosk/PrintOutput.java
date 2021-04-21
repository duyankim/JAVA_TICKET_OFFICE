package kiosk;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PrintOutput {

	// 에러 메세지 출력
	void printErrorMsg() {
		System.out.println("잘못된 값을 입력했습니다.");
	}

	// 에러 메세지 출력
	void printErrorMsgWrongID() {
		System.out.println("2000년대 이후 출생자는 주민등록번호의 7번째 자리가 3 또는 4여야 합니다.");
	}

	/* 티켓 가격 출력 */
	public void pricePrint(int priceResult) {
		System.out.printf("가격은 %d원 입니다.\n", priceResult);
		System.out.printf("감사합니다.\n\n");
	}

	/* 주문 내역 출력 */
	public void orderPrint(int totalPrice, ArrayList<SetData> orderData) throws FileNotFoundException, IOException {
		CalculatePrice price = new CalculatePrice();
		WriteFile write = new WriteFile();
		SetData data = null;

		// 콘솔에 프린트
		System.out.printf("티켓 발권을 종료합니다. 감사합니다\n");
		System.out.printf("=======================에버랜드=========================\n");

		for (int i = 0; i < orderData.size(); i++) {
			data = orderData.get(i);
			
			System.out.printf("%s\t%s X %d\t%8d    *우대적용%5s\n", data.getDayOrNight(), data.getAgeGroup(),
					data.getTicketCount(), data.getResultPrice(), data.getDcGroup());

			// 파일에 작성
			write.writeFile(data);
		}
		System.out.printf("\n");
		System.out.printf("입장료 총액은 %d원 입니다.\n", totalPrice);
		System.out.printf("========================================================\n");
		System.out.printf("\n");
	}

	/* 이어서 주문 또는 주문내역 출력 후 종료 */
	public int orderContinue() throws IOException {
		PrintOutput print = new PrintOutput();
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
				print.printErrorMsg();
			}
		}
		return continueSelect;
	}
}