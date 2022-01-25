package ex1;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int id = 48;
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "delete notice where id=?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,"NEWLEC","82495747");
		//Statement st = con.createStatement();
		//st.ex...(sql)
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1,id);
		
		int result = st.executeUpdate();
		
		System.out.println(result);
		System.out.println("Debugging");
		st.close();
		con.close();
	}

}
