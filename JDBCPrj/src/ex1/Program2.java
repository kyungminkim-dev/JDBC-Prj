package ex1;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String title = "Test2";
		String writerId = "newlec";
		String content = "hahaha";
		String files = "";
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "insert into notice (" + 
				"    title," + 
				"    writer_id," + 
				"    content," + 
				"    files" + 
				") values (?,?,?,?)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,"NEWLEC","82495747");
		//Statement st = con.createStatement();
		//st.ex...(sql)
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,title);
		st.setString(2,writerId);
		st.setString(3,content);
		st.setString(4,files);
		
		int result = st.executeUpdate();
		
		System.out.println(result);
		System.out.println("Debugging");
		st.close();
		con.close();
	}

}
