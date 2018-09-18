//$Id$
package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateTerminalBean
{

	public static boolean update(String flightid, String newterminaltype) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
			if(con == null) System.out.print("not connected");
			String myStatement = "update terminals set `terminalname` = '" + newterminaltype +"'" + " where `flightid`='"+flightid+"'";
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
