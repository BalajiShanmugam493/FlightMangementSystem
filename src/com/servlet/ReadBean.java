//$Id$
package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadBean 
{

	public static String readDetails(String readtype) 
	{
		String resultRead = "";
		System.out.println("   "+readtype);
		if(readtype.equals( "passengers"))
		{
			try
			{
				resultRead = "passenger id "+" "+"passenger name"+" "+"flightid";
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
				if(con == null) System.out.print("not connected");
				Statement st = con.createStatement();
				String myStatement = "select * from " + readtype;
				ResultSet rs = st.executeQuery(myStatement);
				while(rs.next())
				{
					String passengerid = rs.getString("passengerid");
					String passengername = rs.getString("passengername");
					String flightid = rs.getString("flightid");
					resultRead = resultRead+" \n"+passengerid+" "+passengername+" "+flightid;
				}
				con.close();
				
			}
			catch(Exception e)
			{
				System.out.println(e);
				
			}
		}
		if(readtype.equals( "flight"))
		{
			try
			{
				resultRead = "flight id "+" "+"from"+"     "+"destination";
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
				if(con == null) System.out.print("not connected");
				Statement st = con.createStatement();
				String myStatement = "select * from " + readtype;
				ResultSet rs = st.executeQuery(myStatement);
				while(rs.next())
				{
					String flightid = rs.getString("flightid");
					String from = rs.getString("from");
					String to = rs.getString("destination");
					resultRead = resultRead+" \n"+flightid+"  "+from+" "+to;
				}
				con.close();
				
			}
			catch(Exception e)
			{
				System.out.println(e);
				
			}
		}
		if(readtype.equals( "country"))
		{
			try
			{
				resultRead = "country name ";
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
				if(con == null) System.out.print("not connected");
				Statement st = con.createStatement();
				String myStatement = "select * from " + "countries";
				ResultSet rs = st.executeQuery(myStatement);
				while(rs.next())
				{
					String countryname = rs.getString("countryname");
					resultRead = resultRead+" \n"+countryname;
				}
				con.close();
				
			}
			catch(Exception e)
			{
				System.out.println(e);
				
			}
		}
		if(readtype.equals( "terminals"))
		{
			try
			{
				resultRead = " terminal type    "+" "+"flightid"+"   "+"location";
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
				if(con == null) System.out.print("not connected");
				Statement st = con.createStatement();
				String myStatement = "select * from " + readtype;
				ResultSet rs = st.executeQuery(myStatement);
				while(rs.next())
				{
					String terminalname = rs.getString("terminalname");
					String flightid = rs.getString("flightid");
					String location = rs.getString("location");
					resultRead = resultRead+" \n"+terminalname+"  "+flightid+" "+location;
				}
				con.close();
				
			}
			catch(Exception e)
			{
				System.out.println(e);
				
			}
		}
		System.out.println(resultRead);
		return resultRead;
	}

}
