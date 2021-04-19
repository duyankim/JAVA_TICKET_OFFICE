package ticket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WriteFile {
	File file = null;
	FileReader fr = null;
	BufferedReader br = null;
	BufferedWriter bw = null;

	/* 주문 내역 파일로 출력 */
	public void orderFilePrint(int totalPrice) throws IOException {
		CalculatePrice price = new CalculatePrice();

		file = new File(ConstValue.fileOutput);
		fr = new FileReader(file);
		br = new BufferedReader(fr);
		bw = new BufferedWriter(new FileWriter(file));

		/* 오늘 날짜 구하기 */

		for (int index = 0; index < RunTicketOffice.position; index++) {

			// 첫 줄일 경우 출력
			if (RunTicketOffice.filePosition == 0) {

				String line = "";
				// 파일에 문자가 존재하지 않으면 출력
				if ((line = br.readLine()) == null) {
					bw.write("날짜 ,권종 ,연령구분 ,수량 ,가격 ,우대사항\n");
				}
			}
			RunTicketOffice.filePosition++;

			Calendar cal = Calendar.getInstance();
			SimpleDateFormat date = new SimpleDateFormat("YYYYMMdd");
			String currentDate = date.format(cal.getTime());
			bw.write(currentDate);

			switch (RunTicketOffice.orderList[index][0]) {
			case 1: // 주간권
				System.out.printf("주간권,");
				break;
			case 2: // 야간권
				System.out.printf("야간권");
				break;
			default:
				break;
			}

			if (price.calcAgeGroup(RunTicketOffice.orderList[index][1]) == ConstValue.BABY) {
				bw.write("유아 ,");
			} else if (price.calcAgeGroup(RunTicketOffice.orderList[index][1]) == ConstValue.CHILD) {
				bw.write("어린이 ,");
			} else if (price.calcAgeGroup(RunTicketOffice.orderList[index][1]) == ConstValue.TEEN) {
				bw.write("청소년 ,");
			} else if (price.calcAgeGroup(RunTicketOffice.orderList[index][1]) == ConstValue.ADULT) {
				bw.write("어른 ,");
			} else {
				bw.write("노인 ,");
			}

			bw.write(RunTicketOffice.orderList[index][2]);
			bw.write(" ,");
			bw.write(RunTicketOffice.orderList[index][3]);

			switch (RunTicketOffice.orderList[index][4]) {
			case 1: // 해당사항 없음
				bw.write("없음\n");
				break;
			case 2: // 장애인
				bw.write("장애인 우대적용\n");
				break;
			case 3: // 국가유공자
				bw.write("국가유공자 우대적용\n");
				break;
			case 4: // 다자녀
				bw.write("다자녀 우대적용\n");
				break;
			case 5: // 임산부
				bw.write("임산부 우대적용\n");
				break;
			default:
				break;
			}
		}
		br.close();
	}

	

}
