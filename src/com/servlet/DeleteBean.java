//$Id$
package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DeleteBean
{
	public static boolean delete(String parameter, String tablename ,String type) 
	{
		try
		{
			
			if(tablename == "passengers")
			{
				
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				
				//get flightid from the table passengers
				String flightid = null;
				Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
				if(con2 == null) System.out.print("not connected");
				Statement st2 = con2.createStatement();
				String myStatement2 = "select * from passengers where `passengerid`='"+parameter+"'";
				ResultSet rs2 = st2.executeQuery(myStatement2);
				while(rs2.next())
				{
					flightid = (rs2.getString("flightid"));
				}
				con2.close();
				
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
				if(con == null) System.out.print("not connected");
				String myStatement = "delete from "+ tablename +" where `"+type+"`"+"="+"'"+parameter+"'";
				System.out.println(myStatement);
				Statement statement= con.createStatement();
				statement.executeUpdate(myStatement);
				con.close();
				
				//get capacity from flight id
				int capacity = 0;
				Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
				if(con3 == null) System.out.print("not connected");
				Statement st3 = con3.createStatement();
				String myStatement3 = "select * from flight where `flightid`='"+flightid+"'";
				ResultSet rs3 = st3.executeQuery(myStatement3);
				while(rs3.next())
				{
					capacity = (rs3.getInt("capacity"));
				}
				con3.close();
				System.out.println("the capacity is "+capacity+"  "+flightid);
				
				//update the table flight's capacity
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				Connection con4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
				if(con4 == null) System.out.print("not connected");
				String myStatement4 = "update flight set `capacity` = " + (capacity+1) + " where `flightid`='"+flightid+"'";
				Statement statement4= con4.createStatement();
				statement4.executeUpdate(myStatement4);
				con4.close();
				
			}
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
}
