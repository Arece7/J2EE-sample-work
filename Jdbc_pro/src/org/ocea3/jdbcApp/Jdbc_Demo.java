package org.ocea3.jdbcApp;
import java.sql.*;

public class Jdbc_Demo
{

	public static void main(String[] args)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into ocea3.student values(?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded & registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=arghya");
            System.out.println("connection established with DB srver");
            pstmt=con.prepareStatement(qry);
            System.out.println("platform created");
            //set the value for placeholder before execution//
            pstmt.setInt(1,1);
            pstmt.setString(2,"Arghya");
            pstmt.setDouble(3,35.01);
            pstmt.executeUpdate();
            pstmt.setInt(1,2);
            pstmt.setString(2,"jorya");
            pstmt.setDouble(3,37.01);
            pstmt.executeUpdate();
            pstmt.setInt(1,3);
            pstmt.setString(2,"joa");
            pstmt.setDouble(3,37.01);
            pstmt.executeUpdate();
            System.out.println("data inserted");
		
		} catch (ClassNotFoundException | SQLException e) 
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
		}

	}

}
