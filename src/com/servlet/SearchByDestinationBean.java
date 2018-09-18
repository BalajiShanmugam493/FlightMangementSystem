//$Id$
package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchByDestinationBean 
{

	public static String search(String table, String field) 
	{
		String resultRead = "";
		try
		{
			resultRead = "flight id "+" "+"from"+"     "+"destination";
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
			if(con == null) System.out.print("not connected");
			Statement st = con.createStatement();
			String myStatement = "select * from " + table +" where `destination` = '" +field+"'";
			ResultSet rs = st.executeQuery(myStatement);
			while(rs.next())
			{
				System.out.println("entering result set");
				String flightid1 = rs.getString("flightid");
				String from = rs.getString("from");
				String to = rs.getString("destination");
				resultRead = resultRead+" \n"+flightid1+"  "+from+" "+to;
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
