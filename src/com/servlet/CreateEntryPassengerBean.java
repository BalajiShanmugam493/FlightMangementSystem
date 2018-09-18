//$Id$
package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CreateEntryPassengerBean 
{
	public static  String insertPassengers(String passengerid,String passengername,String flightid)
	{
		
		
		int num = 0;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
			if(con == null) System.out.print("not connected");
			Statement st = con.createStatement();
			String myStatement = "select * from flight where `flightid` = '"+flightid+"'";
			ResultSet rs = st.executeQuery(myStatement);
			while(rs.next())
			{
				num = (rs.getInt("capacity"));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);	
		}
		
		if(num > 0)
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
				if(con == null) System.out.print("not connected");
				//System.out.println(passengerid+" "+passengername+" "+from+" "+destination);
				String myStatement = "insert into passengers(`passengerid`,`passengername`,`flightid`) values (?,?,?)";
				PreparedStatement statement= con.prepareStatement(myStatement );
				statement.setString(1,passengerid);
				statement.setString(2,passengername);
				statement.setString(3,flightid);
				statement.executeUpdate();
				con.close();
			
				//update the flight capacity
				num = num-1;
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
				if(con == null) System.out.print("not connected");
				String myStatement2 = "update flight set `capacity` = " + num + " where `flightid`='"+flightid+"'";
				Statement statement2= con2.createStatement();
				statement2.executeUpdate(myStatement2);
				con.close();
				
				return "true";
			}
			catch(Exception e)
			{
				System.out.println(e);
				return "error";
			}
		}
		else 
		{
			return "false";
		}
	}

	public static ArrayList<String> findSource(String flightid_passenger) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ArrayList<String> ar = new ArrayList<>();
		
		//getting the source from the flight
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
		if(con == null) System.out.print("not connected");
		Statement st = con.createStatement();
		String myStatement = "select * from flight where `flightid` = '"+flightid_passenger+"'";
		String source = null;
		String s_flightid = null;
		ResultSet rs = st.executeQuery(myStatement);
		while(rs.next())
		{
			source = (rs.getString("from"));
			s_flightid =  (rs.getString("flightid"));
		}
		con.close();
		ar.add(source+" "+s_flightid);
		
		//getting the number of destinations
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
		if(con2 == null) System.out.print("not connected");
		Statement st2 = con2.createStatement();
		String myStatement2 = "select * from flight where `from` = '"+source+"'";
		String dest = null;
		String flightid = null;
		ResultSet rs2 = st2.executeQuery(myStatement2);
		while(rs2.next())
		{
			dest = (rs2.getString("destination"));
			flightid = (rs2.getString("flightid"));
			ar.add(dest+" "+flightid);
		}
		con2.close();
		
		
		
		return ar;
	}

	public static ArrayList<String> findDestination(String flightid_passenger) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ArrayList<String> ar = new ArrayList<>();
		
		//getting the destination from the flight
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
		if(con == null) System.out.print("not connected");
		Statement st = con.createStatement();
		String myStatement = "select * from flight where `flightid` = '"+flightid_passenger+"'";
		String dest = null;
		String d_flightid = null;
		ResultSet rs = st.executeQuery(myStatement);
		while(rs.next())
		{
			dest = (rs.getString("destination"));
			d_flightid =  (rs.getString("flightid"));
		}
		con.close();
		ar.add(dest+" "+d_flightid);
		
		//getting the number of sources
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
		if(con2 == null) System.out.print("not connected");
		Statement st2 = con2.createStatement();
		String myStatement2 = "select * from flight where `destination` = '"+dest+"'";
		String source = null;
		String flightid = null;
		ResultSet rs2 = st2.executeQuery(myStatement2);
		while(rs2.next())
		{
			source = (rs2.getString("from"));
			flightid  = rs2.getString("flightid");
			ar.add(source+" "+flightid);
		}
		con2.close();
		
		
		return ar;
	}
}

