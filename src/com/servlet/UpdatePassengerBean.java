//$Id$
package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class UpdatePassengerBean 
{

	public static boolean update(String passengerid, String newpassengername, String newflightid)
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
			if(con == null) System.out.print("not connected");
			
			String myStatement = "update passengers set `passengername` = '" + newpassengername +"',`flightid` = '"+newflightid+"'"+" where `passengerid`='"+passengerid+"'";
			System.out.println(myStatement);
			Statement statement= con.createStatement();
			statement.executeUpdate(myStatement);
			con.close();
			return true;
		}
		catch(Exception e)
		{
			
			System.out.println(e);
			return false;
		}
	}

}
