package kiosk;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		ArrayList<DataOld> orderData = new ArrayList<DataOld>();
		GetInput input = new GetInput();
		CalculatePrice price = new CalculatePrice();
		PrintOutput print = new PrintOutput();
		Scanner sc = new Scanner(System.in);
		SetData data = null;
		
		int isExit;
		// 1) do while문을 탈출하지 않는다 2) 탈출한다
		int totalPrice = 0;
		// 티켓의 총 가격을 뜻한다
		
		do {
			while(true) {

				int continueOrNot = 0;
				// 1) 이어서 주문한다 2) 주문을 멈춘다
				
				/* 입력함수 호출 */
				int dayOrNight, ticketCount, dcSelect;
				long idNum;
				
				// 티켓 종류 입력
				dayOrNight = input.inputTicketSelect();

				
				// 주민등록번호 입력
				idNum = input.inputIDNumber();
				
				// 주문 갯수 입력
				ticketCount = input.inputOrderCount();
				
				// 우대사항 입력
				dcSelect = input.inputDiscountSelect();
				
				/* 요금 계산 */
				int priceResult = price.processIntegration(idNum, dayOrNight, ticketCount, dcSelect);
				
				data = new SetData(dayOrNight, idNum, ticketCount, dcSelect, priceResult);

				/* 주문내역 저장 */
				SaveData save = new SaveData();
				save.saveOrder(data, orderData);
				
				/* 요금 합계 계산 */
				totalPrice += priceResult;
				
				/* 가격 출력 */
				
				print.pricePrint(priceResult);

				/* 이어서 주문할지 입력 */
				continueOrNot = print.orderContinue();
				
				if (continueOrNot == 2) {
					break;
				}
			}

			/* 주문 내역 출력 */
			print.orderPrint(totalPrice, orderData);
			
			// do - while 탈출? 다시 반복?
			System.out.printf("계속 진행 -> 1) 새로운 주문 2) 프로그램 종료 : ");
			
			isExit = sc.nextInt();
			
			if (isExit == 2) {
				break;
			}
			
			totalPrice = 0;
			
		} while (isExit == 2);

	}

}