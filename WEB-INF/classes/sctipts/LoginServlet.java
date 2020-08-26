package sctipts;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	public static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String usertype="";
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.56.104/test","gslab\\gsc-30364","Gslab@123");
			Statement st=con.createStatement();
			String sql="select * from register where username=? and uspass=?";
			java.sql.PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				usertype=res.getString("usertype");
			}
			
			if(usertype.equalsIgnoreCase("admin")){
				response.sendRedirect("Home.jsp");
				session.setAttribute("status", 1);
				session.setAttribute("message", "Wrong credentials entered.");
			}
			else
				response.sendRedirect("login.html");
			//System.out.println(st);
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
