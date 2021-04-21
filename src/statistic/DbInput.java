package statistic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbInput {
	private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public void getDBdata() {
    	try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
            // mysql과 커넥션 연결                
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "000000");
            // statement 생성
            stmt = conn.createStatement();
            // 쿼리실행하고 결과를 담기
            rs = stmt.executeQuery("select * from `report2`");
            
            while (rs.next()) { 
            	String date = rs.getString("date"); 
            	String type = rs.getString("type"); 
            	String age = rs.getString("age"); 
            	String count = rs.getString("count"); 
            	String price = rs.getString("price"); 
            	//rs.getString("email"); 
            	System.out.println(date + " " + type + " " + age + " " + count + " " + price); 
            	}
            } catch (SQLException e){
            	System.out.println("SQL Error : " + e.getMessage());
            } catch (ClassNotFoundException e1) {
            	System.out.println("[JDBC Connector Driver 오류 : " + e1.getMessage() + "]");
            }	
    }
}
