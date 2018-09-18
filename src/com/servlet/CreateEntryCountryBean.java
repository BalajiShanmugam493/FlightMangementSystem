//$Id$
package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateEntryCountryBean 
{

	public static boolean insertCountry(String countryname) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
			if(con == null) System.out.print("not connected");
			String myStatement = "insert into countries(`countryname`) values (?)";
			PreparedStatement statement= con.prepareStatement(myStatement );
			statement.setString(1,countryname);
			statement.executeUpdate();
			con.close();
			return true;
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}
	}

}
