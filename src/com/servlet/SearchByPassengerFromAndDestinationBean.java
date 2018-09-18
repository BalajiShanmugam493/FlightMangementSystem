//$Id$
package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchByPassengerFromAndDestinationBean {

	public static String search(String table, String from, String destination)
	{
		String resultRead = "";
		try
		{
			resultRead = "flight id "+" "+"from"+"     "+"destination";
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
			if(con == null) System.out.print("not connected");
			Statement st = con.createStatement();
			String myStatement = "select * from " + table +" where `from` = '" +from+"' and `destination` = "+"'"+destination+"'";
			System.out.println(myStatement);
			ResultSet rs = st.executeQuery(myStatement);
			while(rs.next())
			{
				System.out.println("entering result set");
				String passengerid = rs.getString("passengerid");
				String passengername = rs.getString("passengername");
				String from1 = rs.getString("from");
				String to = rs.getString("destination");
				resultRead = resultRead+" \n"+passengerid+"  "+passengername+" "+from1+" "+to;
			}
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);	
		}
		return resultRead;
	}

}
