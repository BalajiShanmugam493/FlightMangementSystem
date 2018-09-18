//$Id$
package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchByFlightIdBean 
{
	public static String search(String table, String field)
	{
		String resultRead = "";
		try
		{
			resultRead = "passenger id "+" "+"passenger name"+" "+"flightid" +" "+"from"+" "+"destination |||||";
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
			if(con == null) System.out.print("not connected");
			Statement st = con.createStatement();
			String myStatement = "select t1.*,t2.* from passengers t1,flight t2 where t1.flightid = '" + field +"'" ;
			ResultSet rs = st.executeQuery(myStatement);
			while(rs.next())
			{
				String passengerid = rs.getString("passengerid");
				String passengername = rs.getString("passengername");
				String flightid = rs.getString("flightid");
				String from = rs.getString("from");
				String destination = rs.getString("destination");
				resultRead = resultRead+" \n"+passengerid+" "+passengername+" "+flightid+" "+from+" "+destination +" ||||||";
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
