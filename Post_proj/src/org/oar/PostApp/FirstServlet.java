package org.oar.PostApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/fs")
public class FirstServlet extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	String sid=req.getParameter("i");
	int id=Integer.parseInt(sid);
	String name=req.getParameter("nm");
	String dept=req.getParameter("dp");
	String sperc=req.getParameter("pr");
	double perc=Double.parseDouble(sperc);
	PrintWriter out=resp.getWriter();
	out.println("<html><body bgcolor='yellow'>"
			+ "<h1>Student Details Are"+" "+name+" "+dept+"</h1>"
			+"</body></html>");//Presentation Logic
    out.flush();
    out.close();
    Connection con=null;
	PreparedStatement pstmt=null;
	String qry="insert into ocea3.studentd values(?,?,?,?)";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=arghya");
        pstmt=con.prepareStatement(qry);
        pstmt.setInt(1,id);
        pstmt.setString(2,name);
        pstmt.setString(3,dept);
        pstmt.setDouble(4,perc);
        pstmt.executeUpdate();//Persistance Logic
	}
        catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}}}


 


