//$Id$
package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateEntryTerminalBean 
{

	public static boolean insertTerminal(String terminaltype, String flightid, String location) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
			if(con == null) System.out.print("not connected");
			String myStatement = "insert into terminals(`terminalname`,`flightid`,`location`) values (?,?,?)";
			PreparedStatement statement= con.prepareStatement(myStatement );
			statement.setString(1,terminaltype);
			statement.setString(2,flightid);
			statement.setString(3,location);
			statement.executeUpdate();
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
