package org.oar.ocea3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Fetch_Id {

	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from ocea3.student where id=?";
		Scanner scn=new Scanner(System.in);
		System.out.println("enter the id ?");
		int id=scn.nextInt();
		scn.close();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded & registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=arghya");
            System.out.println("connection established with DB srver");
            pstmt=con.prepareStatement(qry);
            System.out.println("platform created");
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
            int i=rs.getInt("id");
            String name=rs.getString(2);
            double perc=rs.getDouble(3);
            System.out.println(i+" "+name+" "+perc);
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
