package sctipts;
import java.io.IOException;
import java.sql.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fn = request.getParameter("first_name");
		String ln = request.getParameter("last_name");
		String dp = request.getParameter("department");
		String un = request.getParameter("user_name");
		String up = request.getParameter("user_password");
		String cup = request.getParameter("confirm_password");
		String em = request.getParameter("email");
		String cn = request.getParameter("contact_no");
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.56.104/test","root","RootStrongPassword2!");
			Statement st=con.createStatement();
			String sql="Insert into registeruser(first,last,dept,username,uspass,cuspass,ema,phone) values('"+fn+"','"+ln+"','"+dp+"','"+un+"','"+up+"','"+cup+"','"+em+"','"+cn+"')";
			st.executeUpdate(sql);
			response.sendRedirect("login.html");
			//System.out.println(st);
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
