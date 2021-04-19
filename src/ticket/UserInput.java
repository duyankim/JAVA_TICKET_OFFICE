package ticket;

import java.util.Scanner;

/* 입력부 */

public class UserInput {
	
	//티켓 종류 입력
	public int inputTicketSelect() {
		PrintConsole print = new PrintConsole();

		Scanner sc = new Scanner(System.in);
		int ticketSelect = 0;
		
		System.out.printf("권종을 선택하세요.\n");
		System.out.printf("1. 주간권\n");
		System.out.printf("2. 야간권\n");
		System.out.printf("-> ");
		
		while(true) {
			ticketSelect = sc.nextInt();
			if (ticketSelect == 1 || ticketSelect == 2) {
				break;
			} else {
				print.errorMessagePrint();
			}
		}
		return ticketSelect;
	}
	
	//주민등록번호 입력
	public long inputCustomerIDNumber() {
		PrintConsole print = new PrintConsole();

		Scanner sc = new Scanner(System.in);
		long customerIDNumber = 0;
		
		System.out.printf("주민등록번호를 입력해주세요.\n");
		System.out.printf("->");
		
		while(true) {
			customerIDNumber = sc.nextLong();
			if ((customerIDNumber >= ConstValue.FULL_DIGIT_MIN) && (customerIDNumber < ConstValue.FULL_DIGIT)) {
				break;
			} else {
				print.errorMessagePrint();
			}
		}
		return customerIDNumber;
	}
	
	//주문 갯수 입력
	public int inputOrderCount() {
		PrintConsole print = new PrintConsole();

		Scanner sc = new Scanner(System.in);
		int orderCount = 0;
		
		System.out.printf("몇 개를 주문하시겠습니까?(최대 10개)\n");
		System.out.printf("->");
		
		while(true) {
			orderCount = sc.nextInt();
			
			if((orderCount <= ConstValue.MAX_COUNT) && (orderCount >= ConstValue.MIN_COUNT)) {
				break;
			} else {
				print.errorMessagePrint();
			}
		}
		return orderCount;
	}
	
	//우대사항 입력
	public int inputDiscountSelect() {
		PrintConsole print = new PrintConsole();

		Scanner sc = new Scanner(System.in);
		int discountSelect = 0;
		
		System.out.printf("우대사항을 선택하세요.\n");
		System.out.printf("1. 없음(나이 우대는 자동처리)\n");
		System.out.printf("2. 장애인\n");
		System.out.printf("3. 국가유공자\n");
		System.out.printf("4. 다자녀\n");
		System.out.printf("5. 임산부\n");
		
		while(true) {
			discountSelect = sc.nextInt();
			
			if ((discountSelect >= 1) && (discountSelect <= 5)) {
				break;
			} else {
				print.errorMessagePrint();
			}
		}
		return discountSelect;
	}
	
	//입력 함수 호출
	public void inputData(int ticketSelect, long customerIDNumber, int orderCount, int discountSelect) {
		//티켓 종류 입력
		ticketSelect = inputTicketSelect();
		//주민등록번호 입력
		customerIDNumber = inputCustomerIDNumber();
		//주문 갯수 입력
		orderCount = inputOrderCount();
		//우대사항 입력
		discountSelect = inputDiscountSelect();
	}

}
