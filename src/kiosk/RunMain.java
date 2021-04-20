package kiosk;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		ArrayList<SetData> orderData = new ArrayList<SetData>();
		SetData data = null;
		Scanner sc = new Scanner(System.in);
		
		int isExit;
		// 1) do while문을 탈출하지 않는다 2) 탈출한다
		int totalPrice = 0;
		// 티켓의 총 가격을 뜻한다
		
		do {
			while(true) {
				
				data = new SetData();
				
				int continueOrNot = 0;
				// 1) 이어서 주문한다 2) 주문을 멈춘다
				
				/* 입력함수 호출 */
				GetInput input = new GetInput();
				int dayOrNight, ticketCount, dcSelect;
				long idNum;
				
				// 티켓 종류 입력
				dayOrNight = input.inputTicketSelect();
				data.setDayOrNight(dayOrNight);
				
				// 주민등록번호 입력
				idNum = input.inputIDNumber();
				data.setIdNum(idNum);
				
				// 주문 갯수 입력
				ticketCount = input.inputOrderCount();
				data.setTicketCount(ticketCount);
				
				// 우대사항 입력
				dcSelect = input.inputDiscountSelect();
				data.setDiscount(dcSelect);
				
				/* 요금 계산 */
				CalculatePrice price = new CalculatePrice();
				int priceResult = price.processIntegration(idNum, dayOrNight, dcSelect, ticketCount);
				data.setResultPrice(priceResult);

				/* 주문내역 저장 */
				SaveData save = new SaveData();
				save.saveOrder(data, orderData);
				
				/* 요금 합계 계산 */
				totalPrice += priceResult;
				
				/* 가격 출력 */
				PrintOutput print = new PrintOutput();
				print.pricePrint(priceResult);

				/* 이어서 주문할지 입력 */
				continueOrNot = print.orderContinue();
				
				if (continueOrNot == 2) {
					break;
				}
				
				// 주문 내역 출력
				print.orderPrint(totalPrice, orderData);
				
				// do - while 탈출? 다시 반복?
				System.out.printf("계속 진행 -> 1) 새로운 주문 2) 프로그램 종료 : ");
				
				/* setter 초기화 */
				data.setResultPrice(0);
			}
			
			isExit = sc.nextInt();
			
			if (isExit == 2) {
				break;
			}
			
			totalPrice = 0;
			
		} while (isExit == 2);

	}

}