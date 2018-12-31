package org.ocea3.getApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	String sid=req.getParameter("i");
	int id=Integer.parseInt(sid);
	
	    Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from ocea3.studentd where id=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=arghya");
	        pstmt=con.prepareStatement(qry);
	        pstmt.setInt(1,id);
	        rs=pstmt.executeQuery();
	        if(rs.next()) 
	        {
	        String name=rs.getString(2);
	        String dept=rs.getString(3);
	        Double perc=rs.getDouble(4);
	        PrintWriter out=resp.getWriter();
	        out.println("<html><body bgcolor='yellow'>"
	    			+ "<h1>Student Details Are"+" "+name+" "+dept+"</h1>"
	    			+"</body></html>");
	    	    out.flush();
	    	    out.close();
	        }
	        else 
	        {    PrintWriter out=resp.getWriter();
	        	 out.println("<html><body bgcolor='red'>"
	 	    			+ "<h1>Student Details not found</h1>"
	 	    			+"</body></html>");
	 	    	    out.flush();
	 	    	    out.close();
	        }
		}
	        catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			finally {
				if(rs!=null)
    			{
    				try {
    					rs.close();
    				} catch (SQLException e) {
    					e.printStackTrace();
    				}
    			}
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
	        


