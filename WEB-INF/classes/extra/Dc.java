package extra;
import java.sql.*;
public class Dc {
public static void main(String args[]){
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.56.104/test","root","RootStrongPassword2!");
		Statement st=con.createStatement();
		System.out.println(st);
		con.close();
	}catch(Exception e){
		System.out.println(e);
	}
}
	
}
