package org.ocea3.LogIn;
import java.sql.*;
import java.util.Scanner;
public class LogIn {

	public static void main(String[] args)
	{
				Connection con=null;
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				String qry="select usename from ocea3.user where name=? and password=?";
				Scanner scn=new Scanner(System.in);
				System.out.println("enter the name?");
				String name=scn.next();
				System.out.println("enter password?");
				String pwd=scn.next();
				scn.close();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					//System.out.println("Driver class loaded & registered");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=arghya");
		           // System.out.println("connection established with DB srver");
		            pstmt=con.prepareStatement(qry);
		           // System.out.println("platform created");
		            pstmt.setString(1,name);
		            pstmt.setString(2,pwd);
		            rs=pstmt.executeQuery();
		            if(rs.next())
		            {
		            String uname=rs.getString(1);
		            System.out.println("welcome  "+uname);
		            }
		            else {
		            System.err.println("Invalid Data");
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
		    		}

		

	}

}
