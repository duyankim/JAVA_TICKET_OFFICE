
# JAVA_TICKET_OFFICE

## 주제
놀이공원 티켓 발급 프로그램

## 클래스 구조
```
C:.
|   .classpath
|   .gitignore
|   .project
|   dailySales.csv                - 일간 매출 분석
|   discountSales.csv             - 우대할인권 매출 분석
|   LICENSE                       - MIT 라이센스
|   README.md                     - readme 파일
|   report.csv                    - 총 매출 데이터
|   typeSales.csv                 - 주간권 야간권 매출 분석
|
\---src
    +---kiosk                     - 티켓 발권 프로그램
    |       Calculation.java      - 티켓 매수와 종류에 따른 금액 계산 클래스 
    |       ConstValue.java       - 상수 변수 클래스
    |       Data.java             - 입력받는 데이터 Java Beans 클래스
    |       DataSave.java         - Java Beans로 ArrayList 구조를 만드는 클래스
    |       DbOutput.java         - DB에 총 매출 데이터 I/O 클래스
    |       FileWrite.java        - csv에 총 매출 데이터 I/O 클래스
    |       Input.java            - console에 user의 입력을 받는 클래스
    |       Main.java             - input클래스를 실행하는 클래스
    |       OutputPrint.java      - console에 발권 결과를 프린트하는 클래스
    |
    \---statistic                 - 매출 분석 프로그램
            Calculation.java      - 매출 현황 계산 클래스
            ConstValue.java       - 상수 변수 클래스
            DbInput.java          - DB에서 총 매출 데이터를 가져오는 I/O 클래스
            FileRead.java         - csv에서 데이터를 가져오는 I/O 클래스
            FileWrite.java        - csv에 매출 분석 데이터 출력하는 I/O 클래스
            Main.java             - fileWrite 실행하는 클래스
            OutputPrint.java      - console에 결과를 출력하는 클래스
            SalesData.java        - 매출 데이터 Java Beans클래스
```

## 기능
1. 입력1 : 주야간권 선택
2. 입력2 : 주민등록번호 입력
3. 입력3 : 티켓 매수 입력
4. 입력4 : 우대사항 선택
5. 출력1 : 티켓 가격 출력
6. 출력2 : 티켓 총 가격 출력

### 파일 변수 위치
- ConstValue의 `fileOutput`변수에 저장된 "report.csv"

### 실행화면
![슬라이드11](https://user-images.githubusercontent.com/46421950/115478645-8de4e000-a281-11eb-9787-d8e5ec2e67f1.JPG)

