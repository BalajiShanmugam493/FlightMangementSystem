
package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateEntryFlightBean 
{
	public static boolean insertFlight(String flightid, String fromflight, String destinationflight) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
			if(con == null) System.out.print("not connected");
			String myStatement = "insert into flight(`flightid`,`from`,`destination`,`capacity`) values (?,?,?,?)";
			PreparedStatement statement= con.prepareStatement(myStatement );
			statement.setString(1,flightid);
			statement.setString(2,fromflight);
			statement.setString(3,destinationflight);
			statement.setInt(4, 5);
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
