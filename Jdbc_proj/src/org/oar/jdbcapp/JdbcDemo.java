package org.oar.jdbcapp;

public class JdbcDemo {

	public static void main(String[] args)
	{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver class loaded & registered");
	} catch (ClassNotFoundException e) 
	{
		e.printStackTrace();
	}	

	}

}
