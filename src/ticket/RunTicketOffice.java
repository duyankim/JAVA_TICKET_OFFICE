package ticket;

import java.io.IOException;
import java.util.Scanner;

public class RunTicketOffice {
	static int totalPrice = 0; // 주문 총액
	static int position = 0; // 주문 내역 배열 탐색용
	static int filePosition = 0; // 파일 출력 첫줄 구분
	static int reportPosition = 0;
	static int[][] orderList = new int[10][5]; // 주문내역 저장
	static int isExit = 0;

	static long customerIDNumber = 0; // 주민번호

	static int ticketSelect = 0; // 티켓종류
	static int orderCount = 0; // 주문갯수
	static int discountSelect = 0; // 우대사항
	static int priceResult = 0; // 가격
	static int age = 0; // 나이
	static int continueSelect = 0; // 이어서 주문

	public static void main(String[] args) throws IOException {
		UserInput input = new UserInput();
		CalculatePrice calPrice = new CalculatePrice();
		PrintConsole print = new PrintConsole();
		WriteFile write = new WriteFile();
		Scanner sc = new Scanner(System.in);

		do {
			while (true) {

				// 입력함수 호출
				input.inputData(ticketSelect, customerIDNumber, orderCount, discountSelect);

				// 요금계산
				priceResult = calPrice.processIntegration(customerIDNumber, ticketSelect, discountSelect, orderCount,
						priceResult, age);

				// 주문내역 저장
				calPrice.saveOrderList(ticketSelect, age, orderCount, priceResult, discountSelect);

				// 요금 합계 계산
				totalPrice += priceResult;

				// 가격 출력
				print.pricePrint(RunTicketOffice.totalPrice);

				// 이어서 주문할지 입력
				continueSelect = print.orderContinue();

				if (continueSelect == 2) {
					break;
				}

			}
			// 주문 내역 출력
			print.orderPrint(RunTicketOffice.totalPrice);

			// 주문 내역 파일로 출력
			write.orderFilePrint(RunTicketOffice.totalPrice);

			System.out.printf("계속 진행 -> 1) 새로운 주문 2) 프로그램 종료 : ");
			isExit = sc.nextInt();
			if (isExit == 2) {
				break;
			}
			position = 0;
			totalPrice = 0;

		} while (isExit == 2);
	}
}
